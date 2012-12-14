/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto.ConsultasPunto;

import TurismoQR.AccesoDatos.AccesoDatosPunto;
import TurismoQR.ObjetosNegocio.Punto.Localizacion;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Chelo
 */
public class ConsultarPuntoPorLocalizacion implements IConsultaPunto {

    private Localizacion localizacion;
    private AccesoDatosPunto accesoDatos;

    public ConsultarPuntoPorLocalizacion(Localizacion localizacion, AccesoDatosPunto accesoDatos) {
        this.localizacion = localizacion;
        this.accesoDatos = accesoDatos;
    }

    public Collection<Punto> ejecutarConsulta() {
        Collection<Punto> punto = new ArrayList<Punto>();
        punto.add(accesoDatos.buscarPuntoPorLocalizacion(localizacion));

        return punto;
    }

}
