/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Punto;

import TurismoQR.AccesoDatos.AccesoDatosLocalizacion;
import TurismoQR.AccesoDatos.AccesoDatosPunto;
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
import TurismoQR.Manejadores.ManejadorLogin.ManejadorLogin;
import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosNegocio.Estados.Ciclo;
import TurismoQR.ObjetosNegocio.Punto.Localizacion;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.ObjetosTransmisionDatos.DTOLocalizacion;
import TurismoQR.Servicios.Punto.ConsultasPunto.ConsultarPuntoPorLocalizacion;
import TurismoQR.Servicios.Punto.ConsultasPunto.ConsultarPuntoPorNombre;
import TurismoQR.Servicios.Punto.ConsultasPunto.ConsultarPuntoUsuario;
import TurismoQR.Servicios.Punto.ConsultasPunto.ConsultarPuntoUsuarioCategoria;
import TurismoQR.Servicios.Punto.ConsultasPunto.ConsultarPuntosCategoria;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

    private AccesoDatosPunto accesoDatos;
    private AccesoDatosLocalizacion accesoDatosLocalizacion;
    private GeneradorCodigoQR generadorCodigo;
    private ManejadorCategoria manejadorCategoria;
    private ManejadorLogin manejadorLogin;

    private final double longitudEcuador = 40075004;
    private final double longitudGreenwich =  40007000;
    private double distanciaCercania =  3000;

    @Autowired
    public ServicioPunto(ManejadorIdiomas manejadorIdioma,
            ManejadorEstados manejadorEstado,
            ManejadorCategoria manejadorCategoria,
            ManejadorLogin manejadorLogin,
            AccesoDatosPunto accesoDatos,
            AccesoDatosLocalizacion accesoDatosLocalizacion,
            ITraductor traductor,
            GeneradorCodigoQR generadorCodigo)
    {
        super(manejadorIdioma, traductor, manejadorEstado);

        this.accesoDatos = accesoDatos;
        this.accesoDatosLocalizacion = accesoDatosLocalizacion;
        this.generadorCodigo = generadorCodigo;
        this.manejadorLogin = manejadorLogin;
        this.manejadorCategoria = manejadorCategoria;
    }

    /**
     * Servicio que permite guardar un punto en base a los datos especificados por el usuario
     * @param datosPunto Un DTO que contiene todos los datos necesarios para crear el punto
     */
    @Transactional(readOnly = false)
    public String CrearPuntoInteres(DTOPunto datosPunto, String nombreIdioma, boolean merge)
    {
        //Crea un nuevo punto de interes
        Punto nuevoPuntoDeInteres = new Punto();

        if(datosPunto.getIdPunto() != null) {
            nuevoPuntoDeInteres.setIdObjeto(datosPunto.getIdPunto());
        }

        nuevoPuntoDeInteres.setNombre(datosPunto.getNombrePunto());

        nuevoPuntoDeInteres.setCiclo(new Ciclo());

        nuevoPuntoDeInteres.setUsuario(manejadorLogin.cargarUsuario(datosPunto.getUsuario().getNombreUsuario()));

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

        if(datosPunto.getFechaCreacion() != null) {
            nuevoPuntoDeInteres.setFechaCreacion(datosPunto.getFechaCreacion());
            nuevoPuntoDeInteres.setFechaModificacion(new Date());
        } else {
            nuevoPuntoDeInteres.setFechaCreacion(new Date());
        }

        nuevoPuntoDeInteres.setCantidadDeVisitas(datosPunto.getCantidadDeVisitas());

        //Persiste el punto creado previamente

        if(!merge) {
            accesoDatos.Guardar(nuevoPuntoDeInteres);
        } else {
            accesoDatos.Actualizar(nuevoPuntoDeInteres);
        }

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

//    public Collection<DTOPunto> ConsultarPuntosInteresZona(
//            String latitudDesde,
//            String latitudHasta,
//            String longitudDesde,
//            String longitudHasta,
//            String nombreIdioma)
//    {
//        IConsultaPunto consultaPunto = new ConsultarPuntoZona(latitudDesde, latitudHasta, longitudDesde, longitudHasta, accesoDatos);
//        return ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);
//    }

    public Collection<DTOPunto> ConsultarPuntosDeInteres(String nombreIdioma)
    {
        IConsultaPunto consultaPunto = new ConsultarTodosPuntos(accesoDatos);
        return ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);
    }

    public DTOPunto ConsultarPuntosDeInteresPorNombre(String nombrePunto, String nombreIdioma)
    {
        IConsultaPunto consultaPunto = new ConsultarPuntoPorNombre(nombrePunto, accesoDatos);
        HashSet<DTOPunto> punto = (HashSet<DTOPunto>) ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);

        DTOPunto puntoLista = new DTOPunto();

        if(punto.iterator().hasNext()){
            puntoLista = punto.iterator().next();
        }


        return puntoLista;
    }

    public DTOPunto ConsultarPuntosDeInteresPorLocalizacion(DTOLocalizacion dtoLocalizacion, String nombreIdioma)
    {

        Localizacion localizacion = accesoDatosLocalizacion.buscarLocalizacion(dtoLocalizacion.getLatitud(), dtoLocalizacion.getLongitud());

        if(localizacion != null) {
            IConsultaPunto consultaPunto = new ConsultarPuntoPorLocalizacion(localizacion, accesoDatos);
            HashSet<DTOPunto> punto = (HashSet<DTOPunto>) ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);

            DTOPunto puntoLista = punto.iterator().next();

            return puntoLista;
        }

        return new DTOPunto();
    }

    public Collection<DTOPunto> ConsultarPuntosDeInteresPorUsuario(String nombreUsuario, String nombreIdioma)
    {
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);
        IConsultaPunto consultaPunto = new ConsultarPuntoUsuario(accesoDatos, usuario);
        return ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);
    }

    public Collection<DTOPunto> ConsultarPuntosDeInteresPorUsuarioCategoria(String nombreUsuario, String nombreCategoria, String nombreIdioma)
    {
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);
        Categoria categoria = manejadorCategoria.obtenerCategoria(nombreCategoria);
        IConsultaPunto consultaPunto = new ConsultarPuntoUsuarioCategoria(accesoDatos, usuario, categoria);
        return ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);
    }

    public Collection<DTOPunto> ConsultarPuntosDeInteresCategoria(String categoria, String nombreIdioma)
    {
        Categoria categoriaObject = getTraductor().traducir(this.obtenerDTOCategoria(categoria));
        IConsultaPunto consultaPunto = new ConsultarPuntosCategoria(categoriaObject, accesoDatos);
        return ConsultarPuntoInteresBase(consultaPunto, nombreIdioma);
    }

    public Collection<DTOPunto> ConsultarPuntosDeInteresZona(DTOLocalizacion localizacion, double distanciaRadio, String nombreIdioma)
    {
        this.distanciaCercania = distanciaRadio;

        ArrayList<DTOLocalizacion> desdeHasta = (ArrayList<DTOLocalizacion>)obtenerDistanciaEnGrados(localizacion);

        Collection<Localizacion> localizaciones = accesoDatosLocalizacion
                .buscarRangoLocalizacion(
                getTraductor().traducir(desdeHasta.get(0)),
                getTraductor().traducir(desdeHasta.get(1)));

        IConsultaPunto consultaPunto = new ConsultarPuntoZona(
                localizaciones,
                accesoDatos);

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

    private Collection<DTOLocalizacion> obtenerDistanciaEnGrados(DTOLocalizacion localizacionLugar)
    {

        Collection<DTOLocalizacion> desdeHasta = new ArrayList<DTOLocalizacion>();

        double gradosEnLatitud = distanciaCercania/(longitudGreenwich/360);
        double gradosEnLongitud = distanciaCercania/(obtenerLongitudDelParalelo(Double.parseDouble(localizacionLugar.getLatitud())) / 360);

        //Obtiene la diferencia numérica en grados
//        double diferenciaLatitudGradual = Long.parseLong(localizacionLugar.getLatitud()) - Long.parseLong(localizacionLugarPosible.getLatitud());
//        double diferenciaLongitudGradual = Long.parseLong(localizacionLugar.getLongitud()) - Long.parseLong(localizacionLugarPosible.getLongitud());

        //Diferencias numéricas, se calcula la longitud de un grado como la longitud del paralelo/meridiano
        //sobre los 360 grados que tiene el círculo que lo contiene
//        double diferenciaLatitudNumerica = diferenciaLatitudGradual * longitudGreenwich / 360;
        
        //La longitud del paralelo varia con la latitud
//        double diferenciaLongitudNumerica = diferenciaLongitudGradual * obtenerLongitudDelParalelo(Long.parseLong(localizacionLugar.getLatitud())) / 360;

        //Calcula las distancia por pitagoras (en metros)
//        double distanciaEntrePuntos = Math.sqrt(Math.pow(diferenciaLatitudNumerica,2) + Math.pow(diferenciaLongitudNumerica,2));

        DTOLocalizacion desde = new DTOLocalizacion();
        desde.setLatitud(String.valueOf(Double.parseDouble(localizacionLugar.getLatitud()) - gradosEnLatitud));
        desde.setLongitud(String.valueOf(Double.parseDouble(localizacionLugar.getLongitud()) - gradosEnLongitud));
        desdeHasta.add(desde);

        DTOLocalizacion hasta = new DTOLocalizacion();
        hasta.setLatitud(String.valueOf(Double.parseDouble(localizacionLugar.getLatitud()) + gradosEnLatitud));
        hasta.setLongitud(String.valueOf(Double.parseDouble(localizacionLugar.getLongitud()) + gradosEnLongitud));
        desdeHasta.add(hasta);

        return desdeHasta;
    }

    /**
     * Calcula la longitud del paralelo de latitud especificada
     * @param latitud
     * @return Longitud del paralelo
     */
    private double obtenerLongitudDelParalelo(double latitud) {

        //Calcula la longitud del paralelo por medio de calculos trigonometricos respecto a la longitud del ecuador, y los angulos correspondientes
        double longitudParalelo = (Math.sin(Math.PI/2 - (Math.abs(latitud)* Math.PI/ 180)) * longitudEcuador) ;
        return longitudParalelo;

    }
    
}
