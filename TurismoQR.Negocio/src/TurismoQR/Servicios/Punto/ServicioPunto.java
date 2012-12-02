/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Punto;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.Informacion;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.Servicios.Punto.ConsultasPunto.ConsultarPuntoId;
import TurismoQR.Servicios.Punto.ConsultasPunto.ConsultarPuntoZona;
import TurismoQR.Servicios.Punto.ConsultasPunto.ConsultarTodosPuntos;
import TurismoQR.Servicios.Punto.ConsultasPunto.IConsultaPunto;
import TurismoQR.Manejadores.GeneradorCodigo.GeneradorCodigoQR;
import TurismoQR.Manejadores.ManejadorCategoria.ManejadorCategoria;
import TurismoQR.Manejadores.ManejadorEstados.ManejadorEstados;
import TurismoQR.Manejadores.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosNegocio.Estados.Ciclo;
import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */
@Transactional
@Service
public class ServicioPunto extends ServicioPuntoBase implements IServicioPunto
{

    private IAccesoDatos accesoDatos;
    private GeneradorCodigoQR generadorCodigo;
    private ManejadorCategoria manejadorCategoria;

    @Autowired
    public ServicioPunto(ManejadorIdiomas manejadorIdioma,
            ManejadorEstados manejadorEstado,
            ManejadorCategoria manejadorCategoria,
            IAccesoDatos accesoDatos,
            ITraductor traductor,
            GeneradorCodigoQR generadorCodigo)
    {
        super(manejadorIdioma, traductor, manejadorEstado);

        this.accesoDatos = accesoDatos;
        this.generadorCodigo = generadorCodigo;
        this.manejadorCategoria = manejadorCategoria;
    }

    /**
     * Servicio que permite guardar un punto en base a los datos especificados por el usuario
     * @param datosPunto Un DTO que contiene todos los datos necesarios para crear el punto
     */
    @Transactional(readOnly = false)
    public String CrearPuntoInteres(DTOPunto datosPunto, String nombreIdioma)
    {
        //Crea un nuevo punto de interes
        Punto nuevoPuntoDeInteres = new Punto();

        if(datosPunto.getIdPunto() != null) {
            nuevoPuntoDeInteres.setIdObjeto(datosPunto.getIdPunto());
        }

        nuevoPuntoDeInteres.setNombre(datosPunto.getNombrePunto());

        nuevoPuntoDeInteres.setCiclo(new Ciclo());

        //Setea el estado del punto a habilitado
        nuevoPuntoDeInteres.setEstado(Ciclo.crearEstado(Ciclo.HABILITADO));

        //Setea las imagenes correspondientes al punto, si las hubiera.
        Collection<DTOImagen> dtoImagenes = datosPunto.getImagenes();
        Collection<Imagen> imagenesPuntoGuardar = new HashSet<Imagen>();
        if (dtoImagenes != null && !dtoImagenes.isEmpty())
        {
            for (DTOImagen dtoImagen : datosPunto.getImagenes())
            {
                Imagen imagenPunto = getTraductor().traducir(dtoImagen);
                Informacion infoImagen = new Informacion();

                if(dtoImagen.getInformacion() != null) {
                    Collection<InformacionEnIdioma> infoEnIdiomaImagen = new HashSet<InformacionEnIdioma>();
                    InformacionEnIdioma infoImagenIdioma = getTraductor().traducir(dtoImagen.getInformacion());
                    infoImagenIdioma.setIdioma(getManejadorIdioma().obtenerIdioma("espanol"));
                    infoEnIdiomaImagen.add(infoImagenIdioma);
                    infoImagen.setInformacionEnIdiomas(infoEnIdiomaImagen);
                }
                imagenPunto.setInformacion(infoImagen);
                imagenesPuntoGuardar.add(imagenPunto);
            }
        }

        nuevoPuntoDeInteres.setImagenes(imagenesPuntoGuardar);

        nuevoPuntoDeInteres.setCategoria((Categoria)manejadorCategoria.obtenerCategoria(datosPunto.getCategoria().getNombreCategoria()));


        //Setea la informacion del punto
        if (datosPunto.getInformacion() != null)
        {
            Collection<InformacionEnIdioma> infoEnIdiomas = new HashSet<InformacionEnIdioma>();
            InformacionEnIdioma infoIdioma = getTraductor().traducir(datosPunto.getInformacion());
            infoIdioma.setIdioma(getManejadorIdioma().obtenerIdioma(datosPunto.getInformacion().getIdioma().getNombreIdioma()));
            infoEnIdiomas.add(infoIdioma);
            Informacion info = new Informacion();
            info.setInformacionEnIdiomas(infoEnIdiomas);
            nuevoPuntoDeInteres.setInformacion(info);
        }

        //Setea los datos de localizacion del punto
        nuevoPuntoDeInteres.setLocalizacion(getTraductor().traducir(datosPunto.getLocalizacion()));

        //Persiste el punto creado previamente
        accesoDatos.Guardar(nuevoPuntoDeInteres);

        return nuevoPuntoDeInteres.getIdObjeto();
    }

    /**
     * Genera un codigo QR en base al Id de un punto de interes
     * @param idPuntoInteres Id del punto de interes para el cual se creara el codigo QR.
     * @return DTOCodigoQR DTO con datos correspondientes al codigo QR generado.
     */
    public DTOCodigoQR GenerarCodigoQR(String idPuntoInteres, int tamaño, String requestContext, String formatoImagen)
    {
        String rutaCodigoQR = generadorCodigo.generarCodigoQR(idPuntoInteres, tamaño, requestContext, formatoImagen);

        DTOCodigoQR dtoCodigoQR = new DTOCodigoQR();
        dtoCodigoQR.setRutaImagenCodigo(rutaCodigoQR);

        return dtoCodigoQR;
    }

    public Collection<DTOPunto> ConsultarPuntosInteresZona(
            String latitudDesde,
            String latitudHasta,
            String longitudDesde,
            String longitudHasta,
            String nombreIdioma)
    {
        IConsultaPunto consultaPunto = new ConsultarPuntoZona(latitudDesde, latitudHasta, longitudDesde, longitudHasta, accesoDatos);
        return ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);
    }

    public Collection<DTOPunto> ConsultarPuntosDeInteres(String nombreIdioma)
    {
        IConsultaPunto consultaPunto = new ConsultarTodosPuntos(accesoDatos);
        return ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);
    }

    /*
     * Servicio que permite buscar la informacion de un punto de interes en base a
     * su id, y al idioma en que la informacion quiere obtenerse
     */
    public DTOPunto ConsultarPuntoInteres(String idPuntoInteres, String nombreIdioma)
    {
        IConsultaPunto consultaPunto = new ConsultarPuntoId(idPuntoInteres, accesoDatos);
        return (DTOPunto) ConsultarPuntoInteresBase(consultaPunto, nombreIdioma).toArray()[0];
    }

    public boolean eliminarPuntoInteres(String idPunto) 
    {

       Punto punto = accesoDatos.BuscarObjeto(Punto.class, idPunto);
       punto.setEstado(Ciclo.crearEstado(Ciclo.BORRADO));

       accesoDatos.Guardar(punto);

       return true;
    }

    public List<DTOCategoria> obtenerCategoriasPunto()
    {

       List<Categoria> categorias = (List<Categoria>)manejadorCategoria.obtenerPosiblesCategorias();
       List<DTOCategoria> dtoCategorias = new ArrayList<DTOCategoria>();

       for(Categoria categoria : categorias) {
           DTOCategoria dtoCategoria = (DTOCategoria) getTraductor().traducir(categoria);
           dtoCategorias.add(dtoCategoria);
       }

       return dtoCategorias;
    }

    public DTOCategoria obtenerDTOCategoria(String nombreCategoria)
    {

       Categoria categoria = (Categoria)manejadorCategoria.obtenerCategoria(nombreCategoria);

       DTOCategoria dtoCategoria = (DTOCategoria) getTraductor().traducir(categoria);

       return dtoCategoria;
    }
    
}
