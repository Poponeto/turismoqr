package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.Estados.Estado;
import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
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

    
}
