/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.Servicios.Validacion.Errores;

/**
 *
 * @author Federico
 */
public interface Validador {

    public boolean soportaObjeto(Object objeto);
    public void validar(Object objeto, Errores errores);
}
