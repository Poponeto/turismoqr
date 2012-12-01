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
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTORubro;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Servicios.Mail.IServicioEnvioMail;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
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
        
        for(Rubro rubro : rubros)
        {
            dtosRubro.add((DTORubro) getTraductor().traducir(rubro));
        }

        return dtosRubro;
    }


    @Override
    protected Contacto registrarContacto(IDTO dtoContacto)
    {
        Cliente cliente = (Cliente) super.registrarContacto(dtoContacto);

        cliente.setCantidadDePuntosPermitidos(((DTOCliente)dtoContacto).getCantidadDePuntosPermitidos());
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

        cliente.setUsuario(manejadorGuardado.crearUsuario(getNombreCliente(cliente)));

        getAccesoDatos().Guardar(cliente);
        
        servicioEnvioMail.enviarEmail(
                getMensajeAutorizacion(cliente),
                subjectAutorizacion,
                cliente.getMail());


        return cliente.getEstado().getNombreDeEstado().equals(Ciclo.HABILITADO);
    }

    public Boolean actualizarDatosCliente(IDTO dto)
    {
        DTOCliente dtoCliente = (DTOCliente)dto;

        Cliente cliente = getAccesoDatos().BuscarObjeto(Cliente.class, dtoCliente.getIdContacto());

        cliente.setMail(dtoCliente.getMail());
        cliente.setTelefonoFijo(dtoCliente.getTelefonoFijo());
        cliente.setCelular(dtoCliente.getCelular());
        cliente.setCantidadDePuntosPermitidos(dtoCliente.getCantidadDePuntosPermitidos());

        getAccesoDatos().Guardar(cliente);

        return cliente.getIdObjeto() != null;

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
    protected abstract String getMensajeRegistracion(Cliente cliente);
    protected abstract void completarCliente(Cliente cliente, IDTO dtoCliente);
    protected abstract String getNombreCliente(Cliente cliente);
}
