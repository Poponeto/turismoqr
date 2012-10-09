/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Punto.Localizacion;

/**
 *
 * @author Federico
 */
public class DTOLocalizacion implements IDTO<Localizacion> {

    private String latitud;
    private String longitud;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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
        final DTOLocalizacion other = (DTOLocalizacion) obj;
        if ((this.latitud == null) ? (other.latitud != null) : !this.latitud.equals(other.latitud))
        {
            return false;
        }
        if ((this.longitud == null) ? (other.longitud != null) : !this.longitud.equals(other.longitud))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 41 * hash + (this.latitud != null ? this.latitud.hashCode() : 0);
        hash = 41 * hash + (this.longitud != null ? this.longitud.hashCode() : 0);
        return hash;
    }


}
