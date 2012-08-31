/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author Federico
 */
public class DTOPunto implements IDTO<Punto>{

    private DTOInformacionEnIdioma informacion;
    private Collection<DTOImagen> imagenes;
    private DTOLocalizacion localizacion;

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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DTOPunto other = (DTOPunto) obj;
        if (!Objects.equals(this.informacion, other.informacion)) {
            return false;
        }
        if (!Objects.equals(this.imagenes, other.imagenes)) {
            return false;
        }
        if (!Objects.equals(this.localizacion, other.localizacion)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.informacion);
        hash = 53 * hash + Objects.hashCode(this.imagenes);
        hash = 53 * hash + Objects.hashCode(this.localizacion);
        return hash;
    }

    
}
