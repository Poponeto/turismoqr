/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Punto;

import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOInformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOLocalizacion;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Servicios.Punto.ConsultasPunto.IConsultaPunto;
import TurismoQR.Manejadores.ManejadorEstados.ManejadorEstados;
import TurismoQR.Manejadores.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Federico
 */
public abstract class ServicioPuntoBase
{

    private ManejadorIdiomas manejadorIdioma;
    private ITraductor traductor;
    private ManejadorEstados manejadorEstado;

    public ServicioPuntoBase(ManejadorIdiomas manejadorIdioma, ITraductor traductor,  ManejadorEstados manejadorEstado)
    {
        this.manejadorIdioma = manejadorIdioma;
        this.traductor = traductor;
        this.manejadorEstado = manejadorEstado;
    }

    protected ManejadorEstados getManejadorEstado() {
        return manejadorEstado;
    }

    protected ManejadorIdiomas getManejadorIdioma()
    {
        return manejadorIdioma;
    }

    protected ITraductor getTraductor()
    {
        return traductor;
    }

    protected Collection<DTOPunto> ConsultarPuntoInteresBase(IConsultaPunto consultaPunto, String idioma)
    {
        Collection<Punto> puntos = consultaPunto.ejecutarConsulta();
        return traducirResultado(puntos, idioma);
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
        InformacionEnIdioma informacionImagen = null;

        if(imagen.getInformacion() != null) {
            informacionImagen = manejadorIdioma.seleccionarInformacionDeImagenEnIdioma(imagen, idioma);
        }

        DTOImagen dtoImagen = (DTOImagen) traductor.traducir(imagen);

        if (informacionImagen != null)
        {
            DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionImagen);
            dtoImagen.setInformacion(dtoInformacion);
        }

        return dtoImagen;
    }

    protected void completarDTOPunto(Punto punto, DTOPunto dtoPunto, String nombreIdioma)
    {
        Idioma idioma = manejadorIdioma.obtenerIdioma(nombreIdioma);

        InformacionEnIdioma informacionPunto = manejadorIdioma.seleccionarInformacionDePuntoEnIdioma(punto, idioma);

        if (informacionPunto != null)
        {
            DTOInformacionEnIdioma dtoInformacion = (DTOInformacionEnIdioma) traductor.traducir(informacionPunto);
            DTOIdioma dtoIdioma = (DTOIdioma) traductor.traducir(informacionPunto.getIdioma());
            dtoPunto.setInformacion(dtoInformacion);
            dtoInformacion.setIdioma(dtoIdioma);
        }

        if(punto.getImagenes() != null && !punto.getImagenes().isEmpty()) {
            dtoPunto.setImagenes(crearDTOImagenes(punto.getImagenes(), idioma));
        }
        
        DTOLocalizacion dtoLocalizacion = (DTOLocalizacion) traductor.traducir(punto.getLocalizacion());
        dtoPunto.setLocalizacion(dtoLocalizacion);

        //TODO set links
    }

    private Collection<DTOPunto> traducirResultado(Collection<Punto> puntos, String nombreIdioma)
    {
        Collection<DTOPunto> dtosPunto = new HashSet<DTOPunto>();

        for (Punto punto  : puntos)
        {
            if (punto != null && manejadorEstado.esEstadoValidoConsulta(punto.getEstado()))
            {
                DTOPunto dtoPunto = (DTOPunto) getTraductor().traducir(punto);

                completarDTOPunto(punto, dtoPunto, nombreIdioma);

                dtosPunto.add(dtoPunto) ;
            }
        }

        return dtosPunto;
    }
}
