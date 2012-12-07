/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

/**
 *
 * @author Federico
 */
public class FilaTablaUsuario implements IFila{

    private String contraseña;
    private String nombreUsuario;
    private String idUsuario;
    private Boolean expirado;
    private Boolean bloqueado;
    private Boolean habilitado;

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Boolean getExpirado() {
        return expirado;
    }

    public void setExpirado(Boolean expirado) {
        this.expirado = expirado;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario)
    {
        this.idUsuario = idUsuario;
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
