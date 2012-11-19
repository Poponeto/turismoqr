/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Federico
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class FilaTablaCliente implements IFila {

    private String idCliente;
    private String tipoCliente;
    private String nombreCliente;
    private String mail;
    private String celular;
    private String telefonoFijo;
    private String estadoCliente;
    private int puntosPermitidos;
    private int puntosQuePosee;

    public String getEstadoCliente()
    {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente)
    {
        this.estadoCliente = estadoCliente;
    }
    
    public String getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(String idCliente)
    {
        this.idCliente = idCliente;
    }



    public String getNombreCliente()
    {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente)
    {
        this.nombreCliente = nombreCliente;
    }

    public String getTipoCliente()
    {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente)
    {
        this.tipoCliente = tipoCliente;
    }
    
    public int getPuntosPermitidos()
    {
        return puntosPermitidos;
    }

    public void setPuntosPermitidos(int puntosPermitidos)
    {
        this.puntosPermitidos = puntosPermitidos;
    }

    public int getPuntosQuePosee()
    {
        return puntosQuePosee;
    }

    public void setPuntosQuePosee(int puntosQuePosee)
    {
        this.puntosQuePosee = puntosQuePosee;
    }
    
    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getTelefonoFijo()
    {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo)
    {
        this.telefonoFijo = telefonoFijo;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

}
