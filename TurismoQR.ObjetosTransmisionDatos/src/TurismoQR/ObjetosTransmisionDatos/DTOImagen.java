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

    public DTOInformacionEnIdioma getInformacion()
    {
        return informacion;
    }

    public void setInformacion(DTOInformacionEnIdioma informacion)
    {
        this.informacion = informacion;
    }

    
}
