/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import java.util.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Federico
 */
public interface IServicioUsuario  {

    public DTOUsuario cargarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException;
    public Boolean crearUsuario(IDTO<Usuario> dtoUsuario);
    public Boolean eliminarUsuaro(IDTO<Usuario> dtoUsuario);
    public Boolean modificarUsuario(IDTO<Usuario> dtoUsuario);
    public Collection<DTOUsuario> consultarUsuarios();
}