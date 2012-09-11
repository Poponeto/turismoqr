/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Punto;

import TurismoQR.ObjetosTransmisionDatos.DTOPunto;

/**
 *
 * @author Federico
 */
public interface IServicioPunto {

    public DTOPunto ConsultarPuntoInteres(String idPuntoInteres, String nombreIdioma);
}
