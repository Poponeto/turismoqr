package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoRol;
import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Collection;

public class Rol implements IObjetoNegocio
{

    private Collection<PermisoRol> permisosRol;
    private String idObjeto;

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public Collection<PermisoRol> getPermisosRol()
    {
        return permisosRol;
    }

    public void setPermisosRol(Collection<PermisoRol> permisosRol)
    {
        this.permisosRol = permisosRol;
    }
}
