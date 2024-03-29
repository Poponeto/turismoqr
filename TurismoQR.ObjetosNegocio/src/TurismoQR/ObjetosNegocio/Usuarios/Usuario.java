package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Permisos.PermisoUsuario;
import java.util.Collection;
import java.util.Date;

public class Usuario implements IObjetoNegocio
{
    private String contraseña;
    private String nombreUsuario;
    private Date fechaExpiracion;
    private Collection<PermisoUsuario> permisosUsuario;
    private String idObjeto;
    private boolean expirado;
    private boolean bloqueado;
    private boolean habilitado;

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
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

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public boolean isExpirado() {
        return expirado;
    }

    public void setExpirado(boolean expirado) {
        this.expirado = expirado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if ((this.idObjeto == null) ? (other.idObjeto != null) : !this.idObjeto.equals(other.idObjeto))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + (this.idObjeto != null ? this.idObjeto.hashCode() : 0);
        return hash;
    }

  
    
}
