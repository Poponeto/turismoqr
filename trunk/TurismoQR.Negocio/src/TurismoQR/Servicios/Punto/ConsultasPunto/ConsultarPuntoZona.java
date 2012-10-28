/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto.ConsultasPunto;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public class ConsultarPuntoZona implements IConsultaPunto{

    private String latitudDesde;
    private String latitudHasta;
    private String longitudDesde;
    private String longitudHasta;
    private IAccesoDatos accesoDatos;

    public ConsultarPuntoZona(String latitudDesde, String latitudHasta, String longitudDesde, String longitudHasta, IAccesoDatos accesoDatos)
    {
        this.latitudDesde = latitudDesde;
        this.latitudHasta = latitudHasta;
        this.longitudDesde = longitudDesde;
        this.longitudHasta = longitudHasta;
        this.accesoDatos = accesoDatos;
    }
    

    public Collection<Punto> ejecutarConsulta()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
