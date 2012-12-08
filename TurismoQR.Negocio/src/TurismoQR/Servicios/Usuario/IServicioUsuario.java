/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTORol;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Servicios.Validacion.Errores;
import java.util.Collection;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Federico
 */
public interface IServicioUsuario  {

    public DTOUsuario cargarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException;
    public Boolean crearUsuario(IDTO<Usuario> dtoUsuario);
    public Boolean eliminarUsuario(String nombreUsuario);
    public Collection<DTOUsuario> consultarUsuarios();
    public Errores cambiarContrasenia(String nombreUsuario, String contraseniaActual, String nuevaContrasenia);
    public Collection<DTORol> obtenerRoles();
    public Boolean reiniciarContrasenia(String nombreUsuario);
    public Boolean desbloquearUsuario(String nombreUsuario);
}
