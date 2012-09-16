/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Punto;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOInformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.Punto.GeneradorCodigo.GeneradorCodigoQR;
import TurismoQR.Punto.ManejadorEstados.ManejadorEstados;
import TurismoQR.Punto.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */
@Transactional
@Service
public class ServicioPunto implements IServicioPunto {

    
    private ManejadorIdiomas manejadorIdioma;
    
    private ManejadorEstados manejadorEstado;
    
    private IAccesoDatos accesoDatos;
    
    private ITraductor traductor;

    private GeneradorCodigoQR generadorCodigo;
    @Autowired
    public ServicioPunto(ManejadorIdiomas manejadorIdioma, ManejadorEstados manejadorEstado,
            IAccesoDatos accesoDatos, ITraductor traductor, GeneradorCodigoQR generadorCodigo)
    {
        this.manejadorIdioma = manejadorIdioma;
        this.manejadorEstado = manejadorEstado;
        this.accesoDatos = accesoDatos;
        this.traductor = traductor;
        this.generadorCodigo = generadorCodigo;
    }

    public DTOPunto ConsultarPuntoInteres(String idPuntoInteres, String nombreIdioma)
    {
         Punto punto = accesoDatos.BuscarObjeto(idPuntoInteres);

        if (punto != null && manejadorEstado.esEstadoValidoConsulta(punto.getEstado()))
        {
            Idioma idioma = manejadorIdioma.obtenerIdioma(nombreIdioma);
            InformacionEnIdioma informacionPunto = manejadorIdioma.seleccionarInformacionDePuntoEnIdioma(punto, idioma);

            DTOPunto dtoPunto = (DTOPunto) traductor.traducir(punto);
            DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionPunto);

            dtoPunto.setImagenes(crearDTOImagenes(punto.getImagenes(), idioma));
            dtoPunto.setInformacion(dtoInformacion);

            return dtoPunto;
        }

        return null;
    }
    
    /**
     * Genera un codigo QR en base al Id de un punto de interes
     * @param idPuntoInteres Id del punto de interes para el cual se creara el codigo QR.
     * @return DTOCodigoQR DTO con datos correspondientes al codigo QR generado.
     */
    public DTOCodigoQR GenerarCodigoQR(String idPuntoInteres, int tamaño, String rutaImagen, String formatoImagen)
    {
        String rutaCodigoQR = generadorCodigo.generarCodigoQR(idPuntoInteres, tamaño, rutaImagen, formatoImagen);
        
        DTOCodigoQR dtoCodigoQR = new DTOCodigoQR();
        dtoCodigoQR.setRutaImagenCodigo(rutaCodigoQR);
        
        return dtoCodigoQR;
    }

    private Collection<DTOImagen> crearDTOImagenes(Collection<Imagen> imagenes, final Idioma idioma)
    {
        Collection<DTOImagen> dtoImagenes = new ArrayList<DTOImagen>();

        for (Imagen imagen : imagenes)
        {
            dtoImagenes.add(crearDTOImagen(imagen, idioma));
        }

        return dtoImagenes;
    }

    private DTOImagen crearDTOImagen(Imagen imagen, final Idioma idioma)
    {
        InformacionEnIdioma informacionImagen = manejadorIdioma.seleccionarInformacionDeImagenEnIdioma(imagen, idioma);

        DTOImagen dtoImagen = (DTOImagen) traductor.traducir(imagen);
        DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionImagen);

        dtoImagen.setInformacion(dtoInformacion);

        return dtoImagen;
    }

}
