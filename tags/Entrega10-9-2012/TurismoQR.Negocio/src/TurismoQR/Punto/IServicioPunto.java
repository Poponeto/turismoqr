/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Punto;

import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public interface IServicioPunto {

    public DTOPunto ConsultarPuntoInteres(String idPuntoInteres, String nombreIdioma);
    public void CrearPuntoInteres(DTOPunto dtoPunto, String nombreIdioma);
    public DTOCodigoQR GenerarCodigoQR(String idPuntoInteres, int tamaño, String rutaImagen, String formatoImagen);
    public Collection<DTOImagen> getImagenesPunto();
    public void setImagenesPunto(Collection<DTOImagen> imagenesPunto);
    public Collection<DTOImagen> crearDTOImagenes(Collection<Imagen> imagenes, final Idioma idioma);
    public DTOImagen crearDTOImagen(Imagen imagen, final Idioma idioma);

}
