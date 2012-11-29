/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.Servicios.Validacion.Errores;

/**
 *
 * @author Federico
 */
public class ValidadorDatosEmpresa implements Validador{

    public boolean soportaObjeto(Object objeto)
    {
        return objeto instanceof DTOEmpresa;
    }

    public void validar(Object objeto, Errores errores)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
