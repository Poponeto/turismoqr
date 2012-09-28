/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import java.util.Collection;
import java.util.HashSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
/**
 *
 * @author Federico
 */
public class DTOUsuario implements UserDetails, IDTO{

    private String contraseña;
    private String nombreUsuario;
    private Collection<GrantedAuthority> autoridades = new HashSet<GrantedAuthority>();

    public void agregarPermiso(String permiso)
    {
        GrantedAuthority autoridad = new GrantedAuthorityImpl(permiso);
        autoridades.add(autoridad);
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

    public Collection<GrantedAuthority> getAuthorities()
    {
        return autoridades;
    }

    public String getPassword()
    {
        return getContraseña();
    }

    public String getUsername()
    {
        return getNombreUsuario();
    }

    public boolean isAccountNonExpired()
    {
        return true;
    }

    public boolean isAccountNonLocked()
    {
        return true;
    }

    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    public boolean isEnabled()
    {
        return true;
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
        final DTOUsuario other = (DTOUsuario) obj;
        if ((this.contraseña == null) ? (other.contraseña != null) : !this.contraseña.equals(other.contraseña))
        {
            return false;
        }
        if ((this.nombreUsuario == null) ? (other.nombreUsuario != null) : !this.nombreUsuario.equals(other.nombreUsuario))
        {
            return false;
        }
        if (this.autoridades != other.autoridades && (this.autoridades == null || !this.autoridades.equals(other.autoridades)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 29 * hash + (this.contraseña != null ? this.contraseña.hashCode() : 0);
        hash = 29 * hash + (this.nombreUsuario != null ? this.nombreUsuario.hashCode() : 0);
        hash = 29 * hash + (this.autoridades != null ? this.autoridades.hashCode() : 0);
        return hash;
    }

    

}
