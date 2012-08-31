/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOInformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.IDTO;

/**
 *
 * @author Federico
 */
public class EstrategiaTraduccionInformacionEnIdioma implements IEstrategiaTraduccion<InformacionEnIdioma>{

    public IDTO<InformacionEnIdioma> traducir(InformacionEnIdioma objetoNegocio)
    {
        DTOInformacionEnIdioma dtoInformacionEnIdioma = new DTOInformacionEnIdioma();
        dtoInformacionEnIdioma.setTexto(objetoNegocio.getTexto());

        return dtoInformacionEnIdioma;
    }

}
