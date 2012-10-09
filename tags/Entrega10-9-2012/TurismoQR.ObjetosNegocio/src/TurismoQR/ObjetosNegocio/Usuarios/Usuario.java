package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoUsuario;
import java.util.Collection;

public class Usuario implements IObjetoNegocio
{

    private String contraseña;
    private String nombreUsuario;
    private Collection<PermisoUsuario> permisosUsuario;
    private String idObjeto;
    private Idioma idioma;

    public Idioma getIdioma()
    {
        return idioma;
    }

    public void setIdioma(Idioma idioma)
    {
        this.idioma = idioma;
    }

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }
    public Collection<PermisoUsuario> getPermisosUsuario()
    {
        return permisosUsuario;
    }

    public void setPermisosUsuario(Collection<PermisoUsuario> permisosUsuario)
    {
        this.permisosUsuario = permisosUsuario;
    }

    public String getContraseña()
    {
        return contraseña;
    }

    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }

    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }
}
