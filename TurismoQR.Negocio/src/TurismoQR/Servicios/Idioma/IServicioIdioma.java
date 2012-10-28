/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Idioma;

import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public interface IServicioIdioma {

    public Collection<DTOIdioma> consultarPosiblesIdiomas(String idPuntoInteres);
    public Collection<DTOIdioma> consultarPosiblesIdiomas();
}
