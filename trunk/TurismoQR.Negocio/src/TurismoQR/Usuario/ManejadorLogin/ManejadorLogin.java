/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Usuario.ManejadorLogin;

import TurismoQR.AccesoDatos.AccesoDatosUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */
@Service("manejadorLogin")
public class ManejadorLogin
{

    private AccesoDatosUsuario accesoDatosUsuario;

    @Autowired
    public ManejadorLogin(AccesoDatosUsuario accesoDatosUsuario)
    {
        this.accesoDatosUsuario = accesoDatosUsuario;
    }
    public Usuario cargarUsuario(String nombreUsuario)  throws UsernameNotFoundException, DataAccessException
    {
       return accesoDatosUsuario.buscarUsuario(nombreUsuario);
    }
}
