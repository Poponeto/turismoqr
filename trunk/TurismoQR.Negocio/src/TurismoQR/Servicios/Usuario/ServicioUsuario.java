/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ConstantesDeNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Servicios.Validacion.Errores;
import TurismoQR.Traductores.ITraductor;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.Manejadores.ManejadorLogin.ManejadorLogin;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoRol;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Rol;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTORol;
import TurismoQR.Servicios.Usuario.AccionUsuario.FabricaAccionesUsuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */
@Transactional
@Service("servicioUsuario")
public class ServicioUsuario implements IServicioUsuario
{

    private ManejadorLogin manejadorLogin;
    private ManejadorUsuarios manejadorGuardado;
    private IAccesoDatos accesoDatos;
    private ITraductor traductor;
    private IServicioCliente servicioCliente;
    private FabricaAccionesUsuario fabricaAccionesUsuario;

    @Autowired
    public ServicioUsuario(
            ManejadorLogin manejadorLogin,
            ManejadorUsuarios manejadorGuardado,
            ITraductor traductor,
            IAccesoDatos accesoDatos,
            IServicioCliente servicioPersona,
            FabricaAccionesUsuario fabricaAccionesUsuario)
    {
        this.manejadorLogin = manejadorLogin;
        this.manejadorGuardado = manejadorGuardado;
        this.traductor = traductor;
        this.accesoDatos = accesoDatos;
        this.servicioCliente = servicioPersona;
        this.fabricaAccionesUsuario = fabricaAccionesUsuario;
    }

    public DTOUsuario cargarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException
    {
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);
        analizarExpiracionCuenta(usuario);
        return (DTOUsuario) traductor.traducir(usuario);
    }

    private void analizarExpiracionCuenta(Usuario usuario)
    {
        if (!usuario.isExpirado())
        {
            if (usuario.getFechaExpiracion() != null && usuario.getFechaExpiracion().before(Calendar.getInstance().getTime()))
            {
                usuario.setExpirado(true);
                accesoDatos.Guardar(usuario);
            }
        }

    }

    public Collection<DTOUsuario> consultarUsuarios()
    {
        Collection<Usuario> usuarios = manejadorGuardado.obtenerUsuarios();

        Collection<DTOUsuario> dtosUsuario = new HashSet<DTOUsuario>();

        for (Usuario usuario : usuarios)
        {
            dtosUsuario.add((DTOUsuario) traductor.traducir(usuario));
        }

        return dtosUsuario;
    }

    public Boolean crearUsuario(IDTO<Usuario> dtoUsuario)
    {

        Usuario usuario = traductor.traducir(dtoUsuario);
        usuario.setHabilitado(true);
        usuario.setExpirado(false);
        usuario.setBloqueado(false);
        usuario.setFechaExpiracion(Calendar.getInstance().getTime());

        Rol rol = accesoDatos.BuscarObjeto(Rol.class, ((DTOUsuario) dtoUsuario).getDtoRol().getNombreRol());
        agregarPermisosDeRol(usuario, rol);

        return manejadorGuardado.guardarUsuario(usuario);
    }

    private void agregarPermisosDeRol(Usuario usuario, Rol rol)
    {
        Collection<PermisoUsuario> permisosUsuario = new HashSet<PermisoUsuario>();

        for (PermisoRol permisoRol : rol.getPermisosRol())
        {
            PermisoUsuario permisoUsuario = new PermisoUsuario();
            permisoUsuario.setPermiso(permisoRol.getPermiso());

            permisosUsuario.add(permisoUsuario);

        }

        usuario.setPermisosUsuario(permisosUsuario);
    }

    public Collection<DTORol> obtenerRoles()
    {
        Collection<Rol> roles = accesoDatos.BuscarConjuntoObjetos(Rol.class);

        Collection<DTORol> dtosRol = new ArrayList<DTORol>();

        for (Rol rol : roles)
        {
            dtosRol.add((DTORol) traductor.traducir(rol));
        }

        return dtosRol;
    }

    public Errores cambiarContrasenia(String nombreUsuario, String contraseniaActual, String nuevaContrasenia)
    {
        Errores errores = new Errores();
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);

        if (nuevaContrasenia == null)
        {
            errores.agregarError("nuevaContrasenia", "Debe especificar una contraseña.");
        }
        else if (nuevaContrasenia.length() < ConstantesDeNegocio.MIN_LONGUITUD_PASS)
        {
            errores.agregarError("nuevaContrasenia", "La contraseña debe tener una longitud de " + ConstantesDeNegocio.MIN_LONGUITUD_PASS + " o mas caracteres.");
        }

        if (!errores.hayErrores() && contraseniaActual != null && usuario.getContraseña().equals(contraseniaActual))
        {
            usuario.setContraseña(nuevaContrasenia);
            usuario.setExpirado(false);

            Calendar fechaCalendario = Calendar.getInstance();
            fechaCalendario.add(Calendar.DATE, 30);
            usuario.setFechaExpiracion(fechaCalendario.getTime());

            accesoDatos.Guardar(usuario);
        }
        else
        {
            errores.agregarError("contraseniaActual", "La contraseña especificada no coincide con la contraseña actual.");
        }

        return errores;
    }

    public Boolean reiniciarContrasenia(String nombreUsuario)
    {
        return fabricaAccionesUsuario.crearAccionUsuario(FabricaAccionesUsuario.REINICIAR_CONTRASENIA).ejecutar(nombreUsuario);
    }

    public Boolean eliminarUsuario(String nombreUsuario)
    {
        return fabricaAccionesUsuario.crearAccionUsuario(FabricaAccionesUsuario.BLOQUEAR_USUARIO).ejecutar(nombreUsuario);

    }

    public Boolean desbloquearUsuario(String nombreUsuario)
    {
        return fabricaAccionesUsuario.crearAccionUsuario(FabricaAccionesUsuario.DESBLOQUEAR_USUARIO).ejecutar(nombreUsuario);
    }

    public Boolean cambiarNombreUsuario(String nombreUsuarioActual, String nuevoNombreUsuario)
    {
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuarioActual);
        usuario.setNombreUsuario(nuevoNombreUsuario);

        return manejadorGuardado.guardarUsuario(usuario);
    }
}
