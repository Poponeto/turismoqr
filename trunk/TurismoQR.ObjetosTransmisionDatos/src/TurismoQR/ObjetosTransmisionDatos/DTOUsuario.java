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
public class DTOUsuario implements UserDetails{

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
    

}
