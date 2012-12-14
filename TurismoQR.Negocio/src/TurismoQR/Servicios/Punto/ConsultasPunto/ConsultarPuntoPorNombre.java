/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto.ConsultasPunto;

import TurismoQR.AccesoDatos.AccesoDatosPunto;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Chelo
 */
public class ConsultarPuntoPorNombre implements IConsultaPunto {

    private String nombrePunto;
    private AccesoDatosPunto accesoDatos;

    public ConsultarPuntoPorNombre(String nombrePunto, AccesoDatosPunto accesoDatos) {
        this.nombrePunto = nombrePunto;
        this.accesoDatos = accesoDatos;
    }

    public Collection<Punto> ejecutarConsulta() {

        Collection<Punto> punto = new ArrayList<Punto>();
        punto.add(accesoDatos.buscarPuntoPorNombre(nombrePunto));

        return punto;
    }

}
