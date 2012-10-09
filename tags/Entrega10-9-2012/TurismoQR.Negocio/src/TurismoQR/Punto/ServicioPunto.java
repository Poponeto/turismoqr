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
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOInformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOLocalizacion;
import TurismoQR.Punto.GeneradorCodigo.GeneradorCodigoQR;
import TurismoQR.Punto.ManejadorEstados.ManejadorEstados;
import TurismoQR.Punto.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */
@Transactional
@Service
public class ServicioPunto implements IServicioPunto
{

    private ManejadorIdiomas manejadorIdioma;
    private ManejadorEstados manejadorEstado;
    private IAccesoDatos accesoDatos;
    private ITraductor traductor;
    private GeneradorCodigoQR generadorCodigo;

    private Collection<DTOImagen> imagenesPunto;

    public Collection<DTOImagen> getImagenesPunto() {
        return imagenesPunto;
    }

    public void setImagenesPunto(Collection<DTOImagen> imagenesPunto) {
        this.imagenesPunto = imagenesPunto;
    }

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
        this.imagenesPunto = new ArrayList<DTOImagen>();
    }

    /*
     * Servicio que permite buscar la informacion de un punto de interes en base a
     * su id, y al idioma en que la informacion quiere obtenerse
     */
    public DTOPunto ConsultarPuntoInteres(String idPuntoInteres, String nombreIdioma)
    {
        Punto punto = accesoDatos.BuscarObjeto(Punto.class, idPuntoInteres);

        if (punto != null && manejadorEstado.esEstadoValidoConsulta(punto.getEstado()))
        {
            Idioma idioma = manejadorIdioma.obtenerIdioma(nombreIdioma);
            InformacionEnIdioma informacionPunto = manejadorIdioma.seleccionarInformacionDePuntoEnIdioma(punto, idioma);

            DTOPunto dtoPunto = (DTOPunto) traductor.traducir(punto);
            DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionPunto);
            DTOLocalizacion dtoLocalizacion = (DTOLocalizacion) traductor.traducir(punto.getLocalizacion());
            DTOIdioma dtoIdioma = (DTOIdioma) traductor.traducir(informacionPunto.getIdioma());

            dtoInformacion.setIdioma(dtoIdioma);

            dtoPunto.setImagenes(crearDTOImagenes(punto.getImagenes(), idioma));
            dtoPunto.setInformacion(dtoInformacion);
            dtoPunto.setLocalizacion(dtoLocalizacion);
            //TODO set links
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
        Punto nuevoPuntoDeInteres = new Punto();

        nuevoPuntoDeInteres.setNombre(datosPunto.getNombrePunto());

        //Setea el estado del punto a habilitado
        nuevoPuntoDeInteres.setEstado(new Estado("Habilitado"));

        //Setea las imagenes correspondientes al punto, si las hubiera.
        Collection<DTOImagen> dtoImagenes = datosPunto.getImagenes();
        Collection<Imagen> imagenesPuntoGuardar = new HashSet<Imagen>();
        if (dtoImagenes != null && !dtoImagenes.isEmpty())
        {
            for (DTOImagen dtoImagen : datosPunto.getImagenes())
            {
                imagenesPuntoGuardar.add(traductor.traducir(dtoImagen));
            }
        } else if (imagenesPunto != null && !imagenesPunto.isEmpty()) {
            for (DTOImagen dtoImagenPunto : this.imagenesPunto) {
                imagenesPuntoGuardar.add(traductor.traducir(dtoImagenPunto));
            }
        }
        nuevoPuntoDeInteres.setImagenes(imagenesPuntoGuardar);


        //Setea la informacion del punto
        if (datosPunto.getInformacion() != null)
        {
            Collection<InformacionEnIdioma> infoEnIdiomas = new HashSet<InformacionEnIdioma>();
            InformacionEnIdioma infoIdioma = traductor.traducir(datosPunto.getInformacion());
            infoIdioma.setIdioma(manejadorIdioma.obtenerIdioma(datosPunto.getInformacion().getIdioma().getNombreIdioma()));
            infoEnIdiomas.add(infoIdioma);
            Informacion info = new Informacion();
            info.setInformacionEnIdiomas(infoEnIdiomas);
            nuevoPuntoDeInteres.setInformacion(info);
        }

        //Setea los datos de localizacion del punto
        nuevoPuntoDeInteres.setLocalizacion(traductor.traducir(datosPunto.getLocalizacion()));

        //Setea los links relacionados con el punto, si los hubiera
        Collection<Link> links = new HashSet<Link>();
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

    public Collection<DTOImagen> crearDTOImagenes(Collection<Imagen> imagenes, final Idioma idioma)
    {
        Collection<DTOImagen> dtoImagenes = new ArrayList<DTOImagen>();

        for (Imagen imagen : imagenes)
        {
            dtoImagenes.add(crearDTOImagen(imagen, idioma));
        }

        return dtoImagenes;
    }

    public DTOImagen crearDTOImagen(Imagen imagen, final Idioma idioma)
    {
        InformacionEnIdioma informacionImagen = manejadorIdioma.seleccionarInformacionDeImagenEnIdioma(imagen, idioma);

        DTOImagen dtoImagen = (DTOImagen) traductor.traducir(imagen);
        DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionImagen);

        dtoImagen.setInformacion(dtoInformacion);

        return dtoImagen;
    }
}
