/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Manejadores.ManejadorUsuarios;

import TurismoQR.AccesoDatos.AccesoDatosUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ftacchini
 */
@Service("manejadorGuardado")
public class ManejadorUsuarios {

    private AccesoDatosUsuario accesoDatosUsuario;

    @Autowired
    public ManejadorUsuarios(AccesoDatosUsuario accesoDatosUsuario)
    {
        this.accesoDatosUsuario = accesoDatosUsuario;
    }

    public boolean guardarUsuario(Usuario usuario)
    {
        try
        {
            accesoDatosUsuario.Guardar(usuario);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
