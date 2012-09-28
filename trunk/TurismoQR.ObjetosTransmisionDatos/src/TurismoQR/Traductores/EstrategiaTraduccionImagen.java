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
        DTOImagen imagen = new DTOImagen();
        imagen.setExtension(objetoNegocio.getExtension());
        imagen.setUrl(objetoNegocio.getUrl());

        return imagen;
    }

    public Imagen traducir(IDTO<Imagen> dto)
    {
        Imagen imagen = new Imagen();
        imagen.setExtension(((DTOImagen)dto).getExtension());
        imagen.setUrl(((DTOImagen)dto).getUrl());

        return imagen;
    }

}
