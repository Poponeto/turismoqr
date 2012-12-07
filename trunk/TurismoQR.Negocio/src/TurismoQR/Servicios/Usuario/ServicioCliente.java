/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.ObjetosNegocio.Categorias.Rubro;
import TurismoQR.ObjetosNegocio.Estados.Ciclo;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoRol;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Rol;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTORubro;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Servicios.Mail.IServicioEnvioMail;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ftacchini
 */
@Transactional
public abstract class ServicioCliente extends ServicioContacto implements IServicioCliente
{

    private ManejadorUsuarios manejadorGuardado;
    private IServicioEnvioMail servicioEnvioMail;
    private final String subjectRegistracion = "Gracias por registrarse en TurismoQR!";
    private final String subjectAutorizacion = "Su cuenta en TurismoQR fue autorizada!";
    private final String subjectReinicioContrasenia = "Se ha reiniciado su contasenia en TurismoQR!";
    private final String subjectActualizacion = "Se han actualizado sus datos en TurismoQR!";

    public ServicioCliente(
            IAccesoDatos accesoDatos,
            ITraductor traductor,
            ManejadorUsuarios manejadorGuardado,
            IServicioEnvioMail servicioEnvioMail)
    {
        super(accesoDatos, traductor);
        this.manejadorGuardado = manejadorGuardado;
        this.servicioEnvioMail = servicioEnvioMail;
    }

    public Boolean registrarCliente(IDTO dtoCliente)
    {
        return registrarContacto(dtoCliente).getIdObjeto() != null;
    }

    public Collection<DTORubro> obtenerRubrosPosibles()
    {
        Collection<Rubro> rubros = getAccesoDatos().BuscarConjuntoObjetos(Rubro.class);
        Collection<DTORubro> dtosRubro = new ArrayList<DTORubro>();

        for (Rubro rubro : rubros)
        {
            dtosRubro.add((DTORubro) getTraductor().traducir(rubro));
        }

        return dtosRubro;
    }

    @Override
    protected Contacto registrarContacto(IDTO dtoContacto)
    {
        Cliente cliente = (Cliente) super.registrarContacto(dtoContacto);

        cliente.setUsuario(manejadorGuardado.crearUsuario(getNombreUsuarioParaCliente(cliente)));
        cliente.getUsuario().setHabilitado(false);
        cliente.getUsuario().setExpirado(true);
        cliente.getUsuario().setBloqueado(false);
        cliente.getUsuario().setFechaExpiracion(Calendar.getInstance().getTime());

        agregarPermisosACliente(cliente);

        cliente.setCantidadDePuntosPermitidos(((DTOCliente) dtoContacto).getCantidadDePuntosPermitidos());
        cliente.setEstado(Ciclo.crearEstado(Ciclo.AUTORIZACION_PENDIENTE));

        completarCliente(cliente, dtoContacto);


        getAccesoDatos().Guardar(cliente);

        servicioEnvioMail.enviarEmail(
                getMensajeRegistracion(cliente),
                subjectRegistracion,
                cliente.getMail());

        return cliente;
    }

    public Collection<DTOCliente> consultarClientes()
    {
        Collection<Cliente> clientes = getAccesoDatos().BuscarConjuntoObjetos(Cliente.class);

        Collection<DTOCliente> dtosCliente = new HashSet<DTOCliente>();

        for (Cliente cliente : clientes)
        {
            dtosCliente.add((DTOCliente) getTraductor().traducir(cliente));
        }

        return dtosCliente;
    }

    public Boolean autorizarCliente(String idCliente)
    {
        Cliente cliente = getAccesoDatos().BuscarObjeto(Cliente.class, idCliente);
        cliente.setEstado(Ciclo.crearEstado(Ciclo.HABILITADO));
        cliente.getUsuario().setHabilitado(true);

        getAccesoDatos().Guardar(cliente);

        servicioEnvioMail.enviarEmail(
                getMensajeAutorizacion(cliente),
                subjectAutorizacion,
                cliente.getMail());


        return cliente.getEstado().getNombreDeEstado().equals(Ciclo.HABILITADO);
    }

    public Boolean actualizarDatosCliente(IDTO dto)
    {
        DTOCliente dtoCliente = (DTOCliente) dto;

        Cliente cliente = getAccesoDatos().BuscarObjeto(Cliente.class, dtoCliente.getIdContacto());

        cliente.setMail(dtoCliente.getMail());
        cliente.setTelefonoFijo(dtoCliente.getTelefonoFijo());
        cliente.setCelular(dtoCliente.getCelular());
        cliente.setCantidadDePuntosPermitidos(dtoCliente.getCantidadDePuntosPermitidos());

        completarCliente(cliente, dto);
        
        servicioEnvioMail.enviarEmail(
               getMensajeActualizacion(cliente),
               subjectActualizacion,
               cliente.getMail());

        getAccesoDatos().Guardar(cliente);

        return cliente.getIdObjeto() != null;

    }

    public Boolean reiniciarContraseñaCliente(String idCliente)
    {
        Cliente cliente = getAccesoDatos().BuscarObjeto(Cliente.class, idCliente);
        cliente.getUsuario().setContraseña(manejadorGuardado.generarContraseniaAleatoria(12));
        cliente.getUsuario().setExpirado(true);
        cliente.getUsuario().setFechaExpiracion(Calendar.getInstance().getTime());

        getAccesoDatos().Guardar(cliente);
        servicioEnvioMail.enviarEmail(getMensajeReinicioContrasenia(cliente), subjectReinicioContrasenia, cliente.getMail());

        return true;
    }

    public Boolean eliminarCliente(String idCliente)
    {
        Cliente cliente = getAccesoDatos().BuscarObjeto(Cliente.class, idCliente);
        cliente.getUsuario().setBloqueado(true);
        cliente.setEstado(Ciclo.crearEstado(Ciclo.BORRADO));

        getAccesoDatos().Guardar(cliente);

        //servicioEnvioMail.enviarEmail(getMensajeReinicioContrasenia(cliente), "Reinicio Contrasenia TurismoQR", cliente.getMail());

        return true;
    }
    
    private String getMensajeReinicioContrasenia(Cliente cliente)
    {
        String cabecera = "Se ha reiniciado su contraseña en TurismoQR, "
                + "se le ha asignado una nueva contraseña.";
        String cuerpo = "Los datos de su cuenta son:"
                + "\nNombre de Usuario: " + cliente.getUsuario().getNombreUsuario()
                + "\nContraseña: " + cliente.getUsuario().getContraseña();

        return cabecera + "\n\n" + cuerpo;
    }

    private String getMensajeAutorizacion(Cliente cliente)
    {
        String cabecera = "Se ha aprobado su solicitud en TurismoQR, "
                + "se le ha asignado una cuenta de usuario.";
        String cuerpo = "Los datos de su cuenta son:"
                + "\nNombre de Usuario: " + cliente.getUsuario().getNombreUsuario()
                + "\nContraseña: " + cliente.getUsuario().getContraseña();

        return cabecera + "\n\n" + cuerpo;

    }

    private String getMensajeActualizacion(Cliente cliente)
    {
        String cabecera = "Se han actualizado sus datos en TurismoQR.";
        String cuerpo = "\nLos datos de su cuenta son:"
                + "\nNombre de Usuario: " + cliente.getUsuario().getNombreUsuario()
                + "\nContraseña: " + cliente.getUsuario().getContraseña()
                + "\n" +parsearDatosCliente(cliente);

        return cabecera + "\n\n" + cuerpo;

    }

    private void agregarPermisosACliente(Cliente cliente)
    {

        Rol rol = getAccesoDatos().BuscarObjeto(Rol.class, "Cliente");
        Collection<PermisoUsuario> permisosUsuario = new HashSet<PermisoUsuario>();

        for (PermisoRol permisoRol : rol.getPermisosRol())
        {
            PermisoUsuario permisoUsuaro = new PermisoUsuario();
            permisoUsuaro.setPermiso(permisoRol.getPermiso());
            permisosUsuario.add(permisoUsuaro);
        }


        cliente.getUsuario().setPermisosUsuario(permisosUsuario);
    }

    protected String getMensajeRegistracion(Cliente cliente)
    {
        String cabecera = "Gracias por registrarse en TurismoQR, "
                + "su solicitud está siendo atendida y "
                + "se responderá a la brevedad.";
        String cuerpo = "Sus datos son: " +
                parsearDatosCliente(cliente);

        return cabecera + cuerpo;
    }

    protected abstract void completarCliente(Cliente cliente, IDTO dtoCliente);

    protected abstract String getNombreUsuarioParaCliente(Cliente cliente);

    protected abstract String parsearDatosCliente(Cliente cliente);
}
