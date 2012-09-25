/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Punto;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Estados.Estado;
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.Informacion;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Informacion.Link;
import TurismoQR.ObjetosNegocio.Punto.Localizacion;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosNegocio.Punto.PuntoDeInteres;
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
    public ServicioPunto(ManejadorIdiomas manejadorIdioma,
            ManejadorEstados manejadorEstado,
            IAccesoDatos accesoDatos, 
            ITraductor traductor,
            GeneradorCodigoQR generadorCodigo)
    {
        this.manejadorIdioma = manejadorIdioma;
        this.manejadorEstado = manejadorEstado;
        this.accesoDatos = accesoDatos;
        this.traductor = traductor;
        this.generadorCodigo = generadorCodigo;
    }

    public DTOPunto ConsultarPuntoInteres(String idPuntoInteres, String nombreIdioma)
    {
         Punto punto = accesoDatos.BuscarObjeto(Punto.class, idPuntoInteres);

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
     * Servicio que permite guardar un punto en base a los datos especificados por el usuario
     * @param datosPunto Un DTO que contiene todos los datos necesarios para crear el punto
     */
    public void CrearPuntoInteres(DTOPunto datosPunto, String nombreIdioma)
    {
        //Crea un nuevo punto de interes
        Punto nuevoPuntoDeInteres = new PuntoDeInteres();

        //Setea el estado del punto a habilitado
        nuevoPuntoDeInteres.setEstado(new Estado("Habilitado"));

        //Setea las imagenes correspondientes al punto, si las hubiera.
        Collection<Imagen> imagenes = null;
        for(DTOImagen dtoImagen : datosPunto.getImagenes()) {
            Imagen imagen = new Imagen();
            imagen.setExtension(dtoImagen.getExtension());
            Informacion informacion = new Informacion();
            Collection<InformacionEnIdioma> info = null;
            info.add(new InformacionEnIdioma(dtoImagen.getInformacion().getTexto(), null, new Idioma(nombreIdioma, null)));
            informacion.setInformacionEnIdiomas(info);
            imagen.setInformacion(informacion);

            imagenes.add(imagen);
        }
        nuevoPuntoDeInteres.setImagenes(imagenes);

        //Setea la informacion del punto
        Collection<InformacionEnIdioma> infoPunto = null;
        InformacionEnIdioma informacionEnIdioma = new InformacionEnIdioma(datosPunto.getInformacion().getTexto(), null, new Idioma(nombreIdioma, null));
        infoPunto.add(informacionEnIdioma);
        Informacion info = new Informacion();
        info.setInformacionEnIdiomas(infoPunto);
        nuevoPuntoDeInteres.setInformacion(info);

        //Setea los datos de localizacion del punto
        Localizacion localizacion = new Localizacion(datosPunto.getLocalizacion().getLatitud(), datosPunto.getLocalizacion().getLongitud(), null);
        nuevoPuntoDeInteres.setLocalizacion(localizacion);

        //Setea los links relacionados con el punto, si los hubiera
        Collection<Link> links = null;
        nuevoPuntoDeInteres.setLinks(links);

        //Persiste el punto creado previamente
        accesoDatos.Guardar(nuevoPuntoDeInteres);
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
