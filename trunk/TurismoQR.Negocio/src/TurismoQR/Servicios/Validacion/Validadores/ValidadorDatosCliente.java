/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.Servicios.Validacion.Errores;

/**
 *
 * @author Federico
 */
public class ValidadorDatosCliente implements Validador{

    public boolean soportaObjeto(Object objeto)
    {
        return objeto instanceof DTOCliente;
    }

    public void validar(Object objeto, Errores errores)
    {
        DTOCliente dtoCliente = (DTOCliente)objeto;

        if(dtoCliente.getCantidadDePuntosPermitidos() < 0)
        {
            errores.agregarError("cantidadDePuntosPermitidos", "La cantidad de puntos solicitada no puede ser negativa.");
        }

        if(dtoCliente.getCantidadDePuntosPermitidos() > 15)
        {
            errores.agregarError("cantidadDePuntosPermitidos", "La cantidad de puntos solicitada no puede ser mayor a 15.");
        }


    }

}
