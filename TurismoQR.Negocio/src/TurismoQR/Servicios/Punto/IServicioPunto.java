/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto;

import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.ObjetosTransmisionDatos.DTOLocalizacion;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Federico
 */
public interface IServicioPunto {
    public Collection<DTOPunto> ConsultarPuntosDeInteres(String nombreIdioma);
    public DTOPunto ConsultarPuntoInteres(String idPuntoInteres, String nombreIdioma);
    public String CrearPuntoInteres(DTOPunto dtoPunto, String nombreIdioma);
    public DTOCodigoQR GenerarCodigoQR(String idPuntoInteres, int tamaño, String requestContext, String formatoImagen);
    public boolean eliminarPuntoInteres(String idPunto);
    public List<DTOCategoria> obtenerCategoriasPunto();
    public DTOCategoria obtenerDTOCategoria(String nombreCategoria);
    public Collection<DTOPunto> ConsultarPuntosDeInteresCategoria(String idCategoria, String nombreIdioma);
    public Collection<DTOPunto> ConsultarPuntosDeInteresZona(DTOLocalizacion localizacion, double distanciaRadio, String nombreIdioma);
    public Collection<DTOPunto> ConsultarPuntosDeInteresPorUsuario(String nombreUsuario, String nombreIdioma);
    public Collection<DTOPunto> ConsultarPuntosDeInteresPorUsuarioCategoria(String nombreUsuario, String nombreCategoria, String nombreIdioma);
    public DTOPunto ConsultarPuntosDeInteresPorNombre(String nombrePunto, String nombreIdioma);
    public DTOPunto ConsultarPuntosDeInteresPorLocalizacion(DTOLocalizacion dtoLocalizacion, String nombreIdioma);
}
