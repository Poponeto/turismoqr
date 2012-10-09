/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public class DTOPunto implements IDTO<Punto>{

    private String nombrePunto;
    private DTOInformacionEnIdioma informacion;
    private Collection<DTOImagen> imagenes;
    private DTOLocalizacion localizacion;
    private Collection<DTOLink> links;
    private String idPunto;

    public String getNombrePunto() {
        return nombrePunto;
    }

    public void setNombrePunto(String nombrePunto) {
        this.nombrePunto = nombrePunto;
    }

    public String getIdPunto()
    {
        return idPunto;
    }

    public void setIdPunto(String idPunto)
    {
        this.idPunto = idPunto;
    }

    public Collection<DTOLink> getLinks() {
        return links;
    }

    public void setLinks(Collection<DTOLink> links) {
        this.links = links;
    }

    public DTOLocalizacion getLocalizacion()
    {
        return localizacion;
    }

    public void setLocalizacion(DTOLocalizacion localizacion)
    {
        this.localizacion = localizacion;
    }
    
    public Collection<DTOImagen> getImagenes()
    {
        return imagenes;
    }

    public void setImagenes(Collection<DTOImagen> imagenes)
    {
        this.imagenes = imagenes;
    }

    public DTOInformacionEnIdioma getInformacion()
    {
        return informacion;
    }

    public void setInformacion(DTOInformacionEnIdioma informacion)
    {
        this.informacion = informacion;
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
        final DTOPunto other = (DTOPunto) obj;
        if (this.informacion != other.informacion && (this.informacion == null || !this.informacion.equals(other.informacion)))
        {
            return false;
        }
        if (this.imagenes != other.imagenes && (this.imagenes == null || !this.imagenes.equals(other.imagenes)))
        {
            return false;
        }
        if (this.localizacion != other.localizacion && (this.localizacion == null || !this.localizacion.equals(other.localizacion)))
        {
            return false;
        }
        if (this.links != other.links && (this.links == null || !this.links.equals(other.links)))
        {
            return false;
        }
        if ((this.idPunto == null) ? (other.idPunto != null) : !this.idPunto.equals(other.idPunto))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 71 * hash + (this.informacion != null ? this.informacion.hashCode() : 0);
        hash = 71 * hash + (this.imagenes != null ? this.imagenes.hashCode() : 0);
        hash = 71 * hash + (this.localizacion != null ? this.localizacion.hashCode() : 0);
        hash = 71 * hash + (this.links != null ? this.links.hashCode() : 0);
        hash = 71 * hash + (this.idPunto != null ? this.idPunto.hashCode() : 0);
        return hash;
    }

    

    
}
