/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Usuario;

import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Federico
 */
public interface IServicioUsuario  {

    public DTOUsuario cargarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException;
}
