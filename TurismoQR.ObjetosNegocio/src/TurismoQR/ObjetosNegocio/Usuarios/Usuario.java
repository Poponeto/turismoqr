package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoUsuario;
import java.util.Collection;

public class Usuario implements IObjetoNegocio {

    private String contrasenia;
    private String nombreUsuario;
    private Collection<PermisoUsuario> permisosUsuario;
    private String idObjeto;

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Collection<PermisoUsuario> getPermisosUsuario() {
        return permisosUsuario;
    }

    public void setPermisosUsuario(Collection<PermisoUsuario> permisosUsuario) {
        this.permisosUsuario = permisosUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
