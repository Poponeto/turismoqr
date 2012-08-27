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

    
}
