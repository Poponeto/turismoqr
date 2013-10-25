/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

/**
 *
 * @author Federico
 */
public abstract class DTOCliente extends DTOContacto {

    private String cantidadDePuntosPermitidos;
    private String cantidadDePuntosQuePosee;
    private String estadoCliente;
    private String usuario;

    public String getEstadoCliente()
    {
        return estadoCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEstadoCliente(String estadoCliente)
    {
        this.estadoCliente = estadoCliente;
    }

    public String getCantidadDePuntosPermitidos() {
        return cantidadDePuntosPermitidos;
    }

    public void setCantidadDePuntosPermitidos(String cantidadDePuntosPermitidos) {
        this.cantidadDePuntosPermitidos = cantidadDePuntosPermitidos;
    }

    public String getCantidadDePuntosQuePosee() {
        return cantidadDePuntosQuePosee;
    }

    public void setCantidadDePuntosQuePosee(String cantidadDePuntosQuePosee) {
        this.cantidadDePuntosQuePosee = cantidadDePuntosQuePosee;
    }

    

    public abstract String getNombreCliente();
    public abstract String getTipoCliente();
}
