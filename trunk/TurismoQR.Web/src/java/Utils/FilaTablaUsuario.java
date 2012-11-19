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
