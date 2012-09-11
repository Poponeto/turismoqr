/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 *
 * @author Federico
 */
public class DTOUsuario implements UserDetails{

    private String contraseña;
    private String nombreUsuario;

    private void agregarPermiso(String permiso)
    {

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
        throw new UnsupportedOperationException("Not supported yet.");
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
