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

    private int cantidadDePuntosPermitidos;
    private int cantidadDePuntosQuePosee;
    private String estadoCliente;

    public String getEstadoCliente()
    {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente)
    {
        this.estadoCliente = estadoCliente;
    }

    public int getCantidadDePuntosQuePosee()
    {
        return cantidadDePuntosQuePosee;
    }

    public void setCantidadDePuntosQuePosee(int cantidadDePuntosQuePosee)
    {
        this.cantidadDePuntosQuePosee = cantidadDePuntosQuePosee;
    }

    
    public int getCantidadDePuntosPermitidos() {
        return cantidadDePuntosPermitidos;
    }

    public void setCantidadDePuntosPermitidos(int cantidadDePuntosPermitidos) {
        this.cantidadDePuntosPermitidos = cantidadDePuntosPermitidos;
    }

    public abstract String getNombreCliente();
    public abstract String getTipoCliente();
}
