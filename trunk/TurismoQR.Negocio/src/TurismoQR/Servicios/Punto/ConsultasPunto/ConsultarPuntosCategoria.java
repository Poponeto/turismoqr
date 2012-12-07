/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto.ConsultasPunto;

import TurismoQR.AccesoDatos.AccesoDatosPunto;
import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.Collection;

/**
 *
 * @author Chelo
 */
public class ConsultarPuntosCategoria implements IConsultaPunto{
    private Categoria categoria;
    private AccesoDatosPunto accesoDatos;

    public ConsultarPuntosCategoria(Categoria categoria, AccesoDatosPunto accesoDatos)
    {
        this.categoria = categoria;
        this.accesoDatos = accesoDatos;
    }


    public Collection<Punto> ejecutarConsulta()
    {
        Collection<Punto> punto = accesoDatos.buscarPuntoPorCategoria(categoria);

        return punto;
    }
}
