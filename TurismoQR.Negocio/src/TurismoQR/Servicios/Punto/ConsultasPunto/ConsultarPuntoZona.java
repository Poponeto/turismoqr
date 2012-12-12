/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto.ConsultasPunto;

import TurismoQR.AccesoDatos.AccesoDatosPunto;
import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Punto.Localizacion;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public class ConsultarPuntoZona implements IConsultaPunto{

    private Collection<Localizacion> localizaciones;
    private AccesoDatosPunto accesoDatos;

    public ConsultarPuntoZona(Collection<Localizacion> localizaciones, AccesoDatosPunto accesoDatos)
    {
        this.localizaciones = localizaciones;
        this.accesoDatos = accesoDatos;
    }
    

    public Collection<Punto> ejecutarConsulta()
    {
        return accesoDatos.buscarPuntoPorZona(this.localizaciones);
    }

}
