/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto;

import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Federico
 */
public interface IServicioPunto {

    public Collection<DTOPunto> ConsultarPuntosInteresZona(
            String latitudDesde,
            String latitudHasta,
            String longitudDesde,
            String longitudHasta,
            String nombreIdioma);
    public Collection<DTOPunto> ConsultarPuntosDeInteres(String nombreIdioma);
    public DTOPunto ConsultarPuntoInteres(String idPuntoInteres, String nombreIdioma);
    public String CrearPuntoInteres(DTOPunto dtoPunto, String nombreIdioma);
    public DTOCodigoQR GenerarCodigoQR(String idPuntoInteres, int tamaño, String requestContext, String formatoImagen);
    public boolean eliminarPuntoInteres(String idPunto);
    public List<DTOCategoria> obtenerCategoriasPunto();
    public DTOCategoria obtenerDTOCategoria(String nombreCategoria);
    public Collection<DTOPunto> ConsultarPuntosDeInteresCategoria(String idCategoria, String nombreIdioma);
}
