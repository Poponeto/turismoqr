/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Usuario.ManejadorLogin;

import TurismoQR.AccesoDatos.AccesoDatosUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */
@Service
public class ManejadorLogin
{

    @Resource
    private AccesoDatosUsuario accesoDatosUsuario;

    public DTOUsuario cargarUsuario(String nombreUsuario)  throws UsernameNotFoundException, DataAccessException
    {
        Usuario usuario = accesoDatosUsuario.buscarUsuario(nombreUsuario);

        if(usuario == null)
        {
           throw new UsernameNotFoundException("No existe un usuario con este nombre y password");
        }

        DTOUsuario dtoUsuario = new DTOUsuario();

        dtoUsuario.setContraseña(usuario.getContraseña());
        dtoUsuario.setNombreUsuario(usuario.getContraseña());

        for (PermisoUsuario permiso : usuario.getPermisosUsuario())
        {
            dtoUsuario.agregarPermiso(permiso.getPermiso().getNombre());
        }
        
        return dtoUsuario;
    }
}
