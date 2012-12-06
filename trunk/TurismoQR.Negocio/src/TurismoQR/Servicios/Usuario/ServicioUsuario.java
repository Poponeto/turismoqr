/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Servicios.Validacion.Errores;
import TurismoQR.Traductores.ITraductor;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.Manejadores.ManejadorLogin.ManejadorLogin;
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
public class ServicioUsuario implements IServicioUsuario {


    private ManejadorLogin manejadorLogin;
    private ManejadorUsuarios manejadorGuardado;
    private IAccesoDatos accesoDatos;
    private ITraductor traductor;

    @Autowired
    public ServicioUsuario(
            ManejadorLogin manejadorLogin,
            ManejadorUsuarios manejadorGuardado,
            ITraductor traductor,
            IAccesoDatos accesoDatos)
    {
        this.manejadorLogin = manejadorLogin;
        this.manejadorGuardado = manejadorGuardado;
        this.traductor = traductor;
        this.accesoDatos = accesoDatos;

    }

    public DTOUsuario cargarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException
    {
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);
        analizarExpiracionCuenta(usuario);
        return (DTOUsuario)traductor.traducir(usuario);
    }

    private void analizarExpiracionCuenta(Usuario usuario)
    {
        if (!usuario.isExpirado())
        {
            if (usuario.getFechaExpiracion()!= null && usuario.getFechaExpiracion().before(Calendar.getInstance().getTime()))
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

    public Boolean crearUsuario(IDTO<Usuario> dtoUsuario) {

        Usuario usuario = traductor.traducir(dtoUsuario);
        usuario.setHabilitado(true);
        usuario.setExpirado(false);
        usuario.setBloqueado(false);
        usuario.setFechaExpiracion(Calendar.getInstance().getTime());

        return manejadorGuardado.guardarUsuario(usuario);
    }

    public Boolean eliminarUsuaro(String idUsuario) {
        Usuario usuario = accesoDatos.BuscarObjeto(Usuario.class, idUsuario);
        usuario.setBloqueado(true);
        return manejadorGuardado.guardarUsuario(usuario);
    }

    public Boolean modificarUsuario(IDTO<Usuario> dtoUsuario) {
        Usuario usuario = accesoDatos.BuscarObjeto(Usuario.class, ((DTOUsuario)dtoUsuario).getIdUsuario());
        usuario.setContraseña(((DTOUsuario)dtoUsuario).getContraseña());
        usuario.setNombreUsuario(((DTOUsuario)dtoUsuario).getNombreUsuario());
        
        return manejadorGuardado.guardarUsuario(usuario);
    }

    public Errores cambiarContrasenia(String nombreUsuario, String contraseniaActual, String nuevaContrasenia)
    {
        Errores errores = new Errores();
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);

        if(nuevaContrasenia == null)
        {
            errores.agregarError("nuevaContrasenia", "Debe especificar una contraseña.");
        }
        else if(nuevaContrasenia.length() < 12)
        {
            errores.agregarError("nuevaContrasenia", "La contraseña debe tener una longitud de 12 o mas caracteres.");
        }

        if(!errores.hayErrores() && contraseniaActual != null && usuario.getContraseña().equals(contraseniaActual))
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


}
