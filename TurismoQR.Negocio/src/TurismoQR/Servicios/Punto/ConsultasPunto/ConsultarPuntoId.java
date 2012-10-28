/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto.ConsultasPunto;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Federico
 */
public class ConsultarPuntoId implements IConsultaPunto{

    private String idPunto;
    private IAccesoDatos accesoDatos;

    public ConsultarPuntoId(String idPunto, IAccesoDatos accesoDatos)
    {
        this.idPunto = idPunto;
        this.accesoDatos = accesoDatos;
    }
    

    public Collection<Punto> ejecutarConsulta()
    {
        Collection<Punto> punto = new HashSet<Punto>();
        punto.add(accesoDatos.BuscarObjeto(Punto.class, idPunto));

        return punto;
    }

}
