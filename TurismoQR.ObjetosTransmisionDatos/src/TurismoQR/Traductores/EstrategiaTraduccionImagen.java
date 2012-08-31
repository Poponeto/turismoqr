/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionImagen implements IEstrategiaTraduccion<Imagen>{

    public IDTO<Imagen> traducir(Imagen objetoNegocio)
    {
        DTOImagen dtoImagen = new DTOImagen();
        dtoImagen.setExtension(objetoNegocio.getExtension());
        dtoImagen.setUrl(objetoNegocio.getUrl());

        return dtoImagen;
    }

}
