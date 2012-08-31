/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DTOImagen other = (DTOImagen) obj;
        if (!Objects.equals(this.informacion, other.informacion)) {
            return false;
        }
        if (!Objects.equals(this.extension, other.extension)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.informacion);
        hash = 67 * hash + Objects.hashCode(this.extension);
        hash = 67 * hash + Objects.hashCode(this.url);
        return hash;
    }

    
}
