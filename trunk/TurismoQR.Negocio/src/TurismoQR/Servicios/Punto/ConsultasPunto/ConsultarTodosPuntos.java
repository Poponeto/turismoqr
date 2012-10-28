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
public class ConsultarTodosPuntos implements IConsultaPunto{

    private IAccesoDatos accesoDatos;

    public ConsultarTodosPuntos(IAccesoDatos accesoDatos)
    {
        this.accesoDatos = accesoDatos;
    }

    public Collection<Punto> ejecutarConsulta()
    {
        return accesoDatos.BuscarConjuntoObjetos(Punto.class);
    }

}
