/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Punto.Localizacion;
import TurismoQR.ObjetosTransmisionDatos.DTOLocalizacion;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionLocalizacion implements IEstrategiaTraduccion<Localizacion> {

    public IDTO<Localizacion> traducir(Localizacion objetoNegocio)
    {
        DTOLocalizacion dtoLocalizacion = new DTOLocalizacion();
        dtoLocalizacion.setLatitud(objetoNegocio.getLatitud());
        dtoLocalizacion.setLongitud(objetoNegocio.getLongitud());

        return dtoLocalizacion;
    }

}
