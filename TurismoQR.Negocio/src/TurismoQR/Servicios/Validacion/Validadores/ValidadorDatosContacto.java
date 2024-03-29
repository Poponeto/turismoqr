/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.ObjetosTransmisionDatos.DTOContacto;
import TurismoQR.Servicios.Validacion.Errores;

/**
 *
 * @author Federico
 */
public class ValidadorDatosContacto implements Validador {

    public boolean soportaObjeto(Object objeto) {
        return objeto instanceof DTOContacto;
    }

    public void validar(Object objeto, Errores errores) {
        DTOContacto dtoContacto = (DTOContacto) objeto;

        if (dtoContacto.getMail() == null) {
            errores.agregarError("mail", "La direccion de Email no puede ser nula.");

        } else if (!dtoContacto.getMail().matches("[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$")) {
            errores.agregarError("mail", "La direccion de Email no tiene un formato valido.");
        }

    }
}
