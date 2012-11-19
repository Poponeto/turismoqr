/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoUsuario;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author ftacchini
 */
public class EstrategiaTraduccionUsuario implements IEstrategiaTraduccion<Usuario>{

    public IDTO<Usuario> traducir(Usuario usuario) {

        DTOUsuario dtoUsuario = new DTOUsuario();

        dtoUsuario.setContraseña(usuario.getContraseña());
        dtoUsuario.setNombreUsuario(usuario.getNombreUsuario());
        dtoUsuario.setIdUsuario(usuario.getIdObjeto());
        
        if (usuario.getPermisosUsuario() != null)
        {
            for (PermisoUsuario permiso : usuario.getPermisosUsuario())
            {
                dtoUsuario.agregarPermiso(permiso.getPermiso().getNombre());
            }
        }
        
        return dtoUsuario;
    }

    public Usuario traducir(IDTO<Usuario> dto)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
