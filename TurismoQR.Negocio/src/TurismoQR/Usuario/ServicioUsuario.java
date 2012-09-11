/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Usuario;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Traductores.ITraductor;
import TurismoQR.Usuario.ManejadorLogin.ManejadorLogin;
import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */

@Transactional
public class ServicioUsuario implements IServicioUsuario {

    @Resource
    private ManejadorLogin manejadorLogin;
    @Resource
    private ITraductor traductor;

    public DTOUsuario cargarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException
    {
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);

        return (DTOUsuario)traductor.traducir(usuario);
    }


}
