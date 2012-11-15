/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

/**
 *
 * @author Federico
 */
public class FilaTablaPunto implements IFila{

    private String identificador;
    private String nombreIdentificador;
    private String latitud;
    private String longitud;
    private int tieneImagenes;

    public int getTieneImagenes()
    {
        return tieneImagenes;
    }

    public void setTieneImagenes(int tieneImagenes)
    {
        this.tieneImagenes = tieneImagenes;
    }

    public String getIdentificador()
    {
        return identificador;
    }

    public void setIdentificador(String identificador)
    {
        this.identificador = identificador;
    }

    public String getLatitud()
    {
        return latitud;
    }

    public void setLatitud(String latitud)
    {
        this.latitud = latitud;
    }

    public String getLongitud()
    {
        return longitud;
    }

    public void setLongitud(String longitud)
    {
        this.longitud = longitud;
    }

    public String getNombreIdentificador()
    {
        return nombreIdentificador;
    }

    public void setNombreIdentificador(String nombreIdentificador)
    {
        this.nombreIdentificador = nombreIdentificador;
    }


    
}
