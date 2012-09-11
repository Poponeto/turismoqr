/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Usuario;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Usuario.ManejadorLogin.ManejadorLogin;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */

@Transactional
public class ServicioUsuario implements IServicioUsuario {

    ManejadorLogin manejadorLogin;

    public DTOUsuario cargarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException
    {
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);

        if(usuario == null)
        {
           throw new UsernameNotFoundException("No existe un usuario con este nombre y password");
        }

        DTOUsuario dtoUsuario = new DTOUsuario();


        dtoUsuario.setContraseña(usuario.getContraseña());
        dtoUsuario.setNombreUsuario(usuario.getContraseña());

    }


}
