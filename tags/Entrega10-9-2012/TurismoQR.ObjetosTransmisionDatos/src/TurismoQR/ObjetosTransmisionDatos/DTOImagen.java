/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Informacion.Imagen;

/**
 *
 * @author Federico
 */
public class DTOImagen implements IDTO<Imagen> {

    private DTOInformacionEnIdioma informacion;
    private String extension;
    private String url;
    
    public DTOInformacionEnIdioma getInformacion()
    {
        return informacion;
    }

    public void setInformacion(DTOInformacionEnIdioma informacion)
    {
        this.informacion = informacion;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        final DTOImagen other = (DTOImagen) obj;
        if ((this.extension == null) ? (other.extension != null) : !this.extension.equals(other.extension))
        {
            return false;
        }
        if ((this.url == null) ? (other.url != null) : !this.url.equals(other.url))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 11 * hash + (this.extension != null ? this.extension.hashCode() : 0);
        hash = 11 * hash + (this.url != null ? this.url.hashCode() : 0);
        return hash;
    }


    
}
