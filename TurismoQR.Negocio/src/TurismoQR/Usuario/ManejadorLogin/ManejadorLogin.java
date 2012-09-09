/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Usuario.ManejadorLogin;

import TurismoQR.AccesoDatos.AccesoDatosUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import javax.annotation.Resource;
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

    public Boolean esUsuarioDelSistema(DTOUsuario dtoUsuario)
    {

        Usuario usuario = accesoDatosUsuario.buscarUsuario(dtoUsuario.getNombreUsuario(), dtoUsuario.getContraseña());

        if (usuario != null)
        {
            return true;
        }

        return false;
    }
}
