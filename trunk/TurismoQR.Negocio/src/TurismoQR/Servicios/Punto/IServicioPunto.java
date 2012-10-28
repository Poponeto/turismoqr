/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto;

import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import java.util.Collection;

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
    public void CrearPuntoInteres(DTOPunto dtoPunto, String nombreIdioma);
    public DTOCodigoQR GenerarCodigoQR(String idPuntoInteres, int tamaño, String rutaImagen, String formatoImagen);
    public Collection<DTOImagen> getImagenesPunto();
    public void setImagenesPunto(Collection<DTOImagen> imagenesPunto);
    
}
