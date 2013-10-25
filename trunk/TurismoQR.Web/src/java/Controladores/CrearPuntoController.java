/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import TurismoQR.Manejadores.ManejadorCategoria.ManejadorCategoria;
import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOInformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOLocalizacion;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import TurismoQR.Servicios.Punto.IServicioPunto;
import TurismoQR.Manejadores.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Idioma.IServicioIdioma;
import TurismoQR.Traductores.ITraductor;
import Utils.DetallesImagenResponse;
import Utils.UploadedFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Chelo
 */
@Controller("crearPuntoController")
@RequestMapping("administracion/crearPunto")
public class CrearPuntoController {
    
    IServicioPunto servicioPunto;
    private IServicioIdioma servicioIdioma;
    ManejadorIdiomas manejadorIdioma;
    ManejadorCategoria manejadorCategoria;
    ITraductor traductor;
    private Collection<DTOImagen> imagenesPunto;
    private String IdiomaSeleccionado;
    
    public Collection<DTOImagen> getImagenesPunto() {
        return imagenesPunto;
    }
    
    public String getIdiomaSeleccionado() {
        return IdiomaSeleccionado;
    }
    
    public void setIdiomaSeleccionado(String IdiomaSeleccionado) {
        this.IdiomaSeleccionado = IdiomaSeleccionado;
    }
    
    public void setImagenesPunto(Collection<DTOImagen> imagenesPunto) {
        this.imagenesPunto = imagenesPunto;
    }
    private static final String actualizarPuntoInteres = "actualizarPuntoInteres.htm";
    private static final String eliminarPuntoInteres = "eliminarPuntoInteres.htm";
    private static final String verCodigoQRPuntoInteres = "mostrarCodigoQR.htm";
    
    @Autowired
    public void CrearPuntoController(IServicioPunto servicioPunto, IServicioIdioma servicioIdioma, ManejadorIdiomas manejadorIdioma, ManejadorCategoria manejadorCategoria, ITraductor traductor) {
        this.servicioPunto = servicioPunto;
        this.servicioIdioma = servicioIdioma;
        this.manejadorIdioma = manejadorIdioma;
        this.manejadorCategoria = manejadorCategoria;
        this.traductor = traductor;
        this.imagenesPunto = new ArrayList<DTOImagen>();
    }
    
    public static String generarURLActualizarPunto(String idPunto) {
        return "administracion/crearPunto/" + idPunto + "/" + actualizarPuntoInteres;
    }
    
    public static String generarURLEliminarPunto(String idPunto) {
        return "administracion/crearPunto/" + idPunto + "/" + eliminarPuntoInteres;
    }
    
    @RequestMapping("/crearPuntoDeInteres.htm")
    public String redirigir(ModelMap model) {
        Collection<DTOIdioma> dtoIdiomas = servicioIdioma.consultarPosiblesIdiomas();
        Collection<DTOCategoria> dtoCategorias = servicioPunto.obtenerCategoriasPunto();
        Collection<DTOImagen> imagenesPuntoReset = new ArrayList<DTOImagen>();
        setImagenesPunto(imagenesPuntoReset);
        model.put("idiomas", dtoIdiomas);
        model.put("categorias", dtoCategorias);
        return "Administracion/Punto/CrearPuntoDeInteres";
    }
    
    @RequestMapping("/guardarPuntoDeInteres.htm")
    public String guardarPuntoInteres(
            @RequestParam("nombrePunto") String nombrePunto,
            @RequestParam("informacionPunto") String informacionPunto,
            @RequestParam("latitudPunto") String latitudPunto,
            @RequestParam("longitudPunto") String longitudPunto,
            @RequestParam("idioma") String idioma,
            @RequestParam("categoria") String categoria,
            @RequestParam("idPunto") String idPunto,
            @RequestParam("fechaCreacion") String fechaCreacion,
            @RequestParam("cantidadDeVisitas") String cantidadDeVisitas,
            ModelMap modelo) {
        DTOUsuario usuario = (DTOUsuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        DTOIdioma idiomaPunto = new DTOIdioma();
        idiomaPunto.setNombreIdioma(idioma);
        
        DTOPunto dtoPunto = new DTOPunto();
        
        dtoPunto.setUsuario(usuario);
        
        if (idPunto.equals("") || idPunto.isEmpty()) {
            idPunto = null;
        }
        
        dtoPunto.setIdPunto(idPunto);

        ////////////Elimino caracteres raros del Nombre del punto
        String miNombrePunto = eliminarCaracteresEspeciales(nombrePunto);
        
        nombrePunto = miNombrePunto;

        //////////7

        dtoPunto.setNombrePunto(miNombrePunto);
        
        
        DTOInformacionEnIdioma infoIdioma = new DTOInformacionEnIdioma();
        infoIdioma.setIdioma(idiomaPunto);
        infoIdioma.setNombre(nombrePunto);
        /////Elimino caracteres raros de La informacion del Punto
        String miTexto = eliminarCaracteresEspeciales(informacionPunto);
        informacionPunto = miTexto;
        ///////////////
        infoIdioma.setTexto(informacionPunto);
        
        dtoPunto.setInformacion(infoIdioma);
        
        DTOCategoria dtoCategoria = new DTOCategoria();
        dtoCategoria.setNombreCategoria(categoria);
        dtoPunto.setCategoria(dtoCategoria);
        
        DTOLocalizacion localizacionPunto = new DTOLocalizacion();
        localizacionPunto.setLatitud(latitudPunto);
        localizacionPunto.setLongitud(longitudPunto);
        
        dtoPunto.setLocalizacion(localizacionPunto);
        dtoPunto.setImagenes(getImagenesPunto());
        
        if (fechaCreacion.equals("") || fechaCreacion.isEmpty()) {
            dtoPunto.setFechaCreacion(null);
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            try {
                Date date = dateFormat.parse(fechaCreacion);
                dtoPunto.setFechaCreacion(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        if (cantidadDeVisitas.equals("") || cantidadDeVisitas.isEmpty()) {
            dtoPunto.setCantidadDeVisitas(0);
        } else {
            dtoPunto.setCantidadDeVisitas(Integer.parseInt(cantidadDeVisitas));
        }
        
        String idPuntoGuardado = servicioPunto.CrearPuntoInteres(dtoPunto, idioma, false);
        
        modelo.put("nombrePunto", nombrePunto);
        modelo.put("idPuntoGuardado", idPuntoGuardado);
        
        return "Administracion/Punto/ConfirmacionGuardarPunto";
    }
    
    @RequestMapping("/agregarImagen.htm")
    public String agregarImagen() {
        return "Administracion/Punto/AgregarImagen";
    }
    
    @RequestMapping(value = "/{idPunto}/" + actualizarPuntoInteres)
    public String actualizarPuntoInteres(
            @PathVariable String idPunto,
            ModelMap modelo) {
        String idioma = "espanol";
        
        Collection<DTOIdioma> dtoIdiomas = servicioIdioma.consultarPosiblesIdiomas();
        Collection<DTOCategoria> dtoCategorias = servicioPunto.obtenerCategoriasPunto();
        DTOPunto dtoPunto = servicioPunto.ConsultarPuntoInteres(idPunto, idioma);
        
        this.imagenesPunto = dtoPunto.getImagenes();
        
        modelo.put("punto", dtoPunto);
        modelo.put("idiomas", dtoIdiomas);
        modelo.put("categorias", dtoCategorias);

        //TODO Obtener el idioma por default del usuario
        return "Administracion/Punto/CrearPuntoDeInteres";
    }
    
    @RequestMapping(value = "/{idPunto}/" + eliminarPuntoInteres,
    method = RequestMethod.GET)
    public String eliminarPuntoInteres(
            @PathVariable String idPunto) {
        servicioPunto.eliminarPuntoInteres(idPunto);
        return "Administracion/Administracion";
    }
    
    @RequestMapping(value = "/{idPunto}/" + verCodigoQRPuntoInteres,
    method = RequestMethod.GET)
    public String verCodigoQRPuntoInteres(
            @PathVariable String idPunto,
            ModelMap model) {
        String idioma = "espanol";
        
        DTOPunto punto = servicioPunto.ConsultarPuntoInteres(idPunto, idioma);
        
        model.put("punto", punto);
        
        return "Administracion/Punto/MostrarCodigoQR";
    }
    
    @RequestMapping("/subirArchivo.htm")
    public @ResponseBody
    List<UploadedFile> handleRequest(@RequestParam("files") CommonsMultipartFile files,
            @RequestParam(value = "idioma") String idioma, HttpServletRequest request,
            ModelMap modelo)
            throws ServletException, IOException, Exception {
        
        List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
        FileItem file = files.getFileItem();
        setIdiomaSeleccionado(idioma);
        FileOutputStream os = null;
        String nombre = file.getName().replace(" ", "_");
        File archivoADisco = new File(nombre);
        String urlImagen = System.getProperty("user.home") + "/" + archivoADisco.getName();
        archivoADisco = new File(System.getProperty("user.home") + "/" + archivoADisco.getName());
        
        file.write(archivoADisco);
        
        UploadedFile archivoSubido = new UploadedFile(file.getName(),
                Long.valueOf(file.getSize()).intValue(),
                archivoADisco.getPath(), request.getContextPath() + "/imagenes/mostrarImagen?img=" + archivoADisco.getPath(),
                request.getContextPath() + "/administracion/crearPunto/" + nombre + "/borrarArchivo.htm", "DELETE");
        uploadedFiles.add(archivoSubido);
        
        Imagen imagenParaDTO = new Imagen();
        imagenParaDTO.setUrl(urlImagen);
        imagenParaDTO.setExtension(file.getName().substring(file.getName().indexOf(".")));
        
        Collection<DTOImagen> DTOImagenes = getImagenesPunto();
        DTOImagenes.add((DTOImagen) traductor.traducir(imagenParaDTO));
        setImagenesPunto(DTOImagenes);
        
        modelo.put("detallesImagen", uploadedFiles);
        
        return uploadedFiles;
    }
    
    @RequestMapping("/{archivo}/borrarArchivo.htm")
    public @ResponseBody
    DetallesImagenResponse handleRequestDelete(
            @PathVariable("archivo") String archivo,
            HttpServletResponse response) {
        
        Collection<DTOImagen> imagenes = getImagenesPunto();
        String pathArchivo = "";
        
        DTOImagen imagenABorrar = null;
        
        for (DTOImagen imagen : imagenes) {
            imagenABorrar = imagen;
            if (imagen.getUrl().contains(archivo)) {
                pathArchivo = imagen.getUrl();
            }
        }
        
        if (imagenABorrar != null) {
            imagenes.remove(imagenABorrar);
        }
        
        response.setContentType("application/json");
        
        DetallesImagenResponse detallesOperacion = new DetallesImagenResponse();
        File file = new File(pathArchivo);
        if (file.delete()) {
            detallesOperacion.setEstadoOperacion("SUCCESS");
            response.setStatus(200);
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            detallesOperacion.setEstadoOperacion("ERROR");
            response.setStatus(500);
            System.out.println("El fichero no puede ser borrado");
        }
        
        return detallesOperacion;
    }
    
    @RequestMapping("/{comentario}/{archivo}/agregarComentario.htm")
    public @ResponseBody
    DetallesImagenResponse handleRequestComentario(
            @PathVariable("archivo") String archivo,
            @PathVariable("comentario") String comentario,
            HttpServletResponse response) {
        
        Collection<DTOImagen> imagenes = getImagenesPunto();
        
        DTOImagen imagenComentario = null;
        
        
        
        for (DTOImagen imagen : imagenes) {
            if (imagen.getUrl().contains(archivo)) {
                imagenComentario = imagen;
            }
        }
        
        String decodedComment = comentario.replaceAll("_", " ");
        
        DetallesImagenResponse detallesOperacion = new DetallesImagenResponse();
        
        response.setContentType("application/json");
        
        if (imagenComentario != null) {
            DTOInformacionEnIdioma dtoInformacion = new DTOInformacionEnIdioma();
            DTOIdioma idioma = new DTOIdioma();
            idioma.setNombreIdioma(getIdiomaSeleccionado());
            dtoInformacion.setIdioma(idioma);
            
            dtoInformacion.setTexto(decodedComment);
            dtoInformacion.setNombre(comentario);
            
            imagenComentario.setInformacion(dtoInformacion);
            
            detallesOperacion.setEstadoOperacion("SUCCESS");
            detallesOperacion.setMensaje(decodedComment);
            response.setStatus(200);
        } else {
            response.setStatus(500);
        }
        
        return detallesOperacion;
    }
    
    @RequestMapping("/{idPunto}/{requestContext}/obtenerCodigo.htm")
    public @ResponseBody
    DetallesImagenResponse handleRequestCodigo(
            @PathVariable("idPunto") String idPunto,
            @PathVariable("requestContext") String requestContext,
            HttpServletResponse response) {
        
        DetallesImagenResponse detallesOperacion = new DetallesImagenResponse();
        
        DTOCodigoQR codigoQR = servicioPunto.GenerarCodigoQR(idPunto, 500, requestContext, "jpg");
        
        detallesOperacion.setEstadoOperacion("SUCCESS");
        
        detallesOperacion.setMensaje(codigoQR.getrutaImagenCodigo());
        
        response.setContentType("application/json");
        response.setStatus(200);
        
        return detallesOperacion;
    }
    
    @RequestMapping("/{nombrePunto}/verificarPuntoPorNombre.htm")
    public @ResponseBody
    DetallesImagenResponse handleRequestVerificarPuntoNombre(
            @PathVariable("nombrePunto") String nombrePunto,
            HttpServletResponse response) {
        
        DetallesImagenResponse detallesOperacion = new DetallesImagenResponse();
        
        DTOPunto punto = servicioPunto.ConsultarPuntosDeInteresPorNombre(nombrePunto, "espanol");
        
        if (punto.getIdPunto() != null) {
            detallesOperacion.setEstadoOperacion("ERROR");
           
            detallesOperacion.setMensaje("Ya existe un punto registrado con este nombre");
            
            response.setStatus(200);
        }
        
        response.setContentType("application/json");
        
        return detallesOperacion;
    }
    
    @RequestMapping(value = "/verificarPuntoPorLocalizacion.htm", method = RequestMethod.POST)
    public @ResponseBody
    DetallesImagenResponse handleRequestVerificarPuntoLocalizacion(
            @RequestParam("latitud") String latitudPunto,
            @RequestParam("longitud") String longitudPunto,
            HttpServletResponse response) {
        
        DetallesImagenResponse detallesOperacion = new DetallesImagenResponse();
        
        DTOLocalizacion localizacion = new DTOLocalizacion();
        
        localizacion.setLatitud(latitudPunto);
        localizacion.setLongitud(longitudPunto);
        
        DTOPunto punto = servicioPunto.ConsultarPuntosDeInteresPorLocalizacion(localizacion, "espanol");
        
        if (punto.getIdPunto() != null) {
            detallesOperacion.setEstadoOperacion("ERROR");
            detallesOperacion.setMensaje("Ya existe un punto registrado en esta localizacion");
            
            response.setStatus(200);
        }
        
        response.setContentType("application/json");
        
        return detallesOperacion;
    }
    
    private String eliminarCaracteresEspeciales(String texto) {
        String miTexto = StringUtils.replace(texto, Matcher.quoteReplacement("Ã±"), "ñ");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("Ã©"), "é");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("Ã"), "Ñ");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("Ã¡"), "á");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("Ã­"), "í");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("Ã³"), "ó");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("Ãº"), "ú");
        
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("â€™"), "'");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("â€“"), "-");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("Â¿"), "¿");
        miTexto = StringUtils.replace(miTexto, Matcher.quoteReplacement("Ã¼"), "ü");
        
        
        return miTexto;
    }
}
