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
import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.ObjetosTransmisionDatos.DTOCodigoQR;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.Servicios.Idioma.IServicioIdioma;
import TurismoQR.Traductores.ITraductor;
import Utils.DetallesImagenResponse;
import Utils.UploadedFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Collection<DTOImagen> getImagenesPunto() {
        return imagenesPunto;
    }

    public void setImagenesPunto(Collection<DTOImagen> imagenesPunto) {
        this.imagenesPunto = imagenesPunto;
    }

    private static final String actualizarPuntoInteres = "actualizarPuntoInteres.htm";
    private static final String eliminarPuntoInteres = "eliminarPuntoInteres.htm";


    @Autowired
    public void LoginController(IServicioPunto servicioPunto, IServicioIdioma servicioIdioma, ManejadorIdiomas manejadorIdioma, ManejadorCategoria manejadorCategoria, ITraductor traductor)
    {
        this.servicioPunto = servicioPunto;
        this.servicioIdioma = servicioIdioma;
        this.manejadorIdioma = manejadorIdioma;
        this.manejadorCategoria = manejadorCategoria;
        this.traductor = traductor;
        this.imagenesPunto = new ArrayList<DTOImagen>();
    }

    public static String generarURLActualizarPunto(String idPunto)
    {
        return "administracion/crearPunto/" + idPunto + "/" + actualizarPuntoInteres;
    }

    public static String generarURLEliminarPunto(String idPunto)
    {
        return "administracion/crearPunto/" + idPunto + "/" + eliminarPuntoInteres;
    }

    @RequestMapping("/crearPuntoDeInteres.htm")
    public String redirigir(ModelMap model)
    {
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
            ModelMap modelo
        )
    {
        DTOIdioma idiomaPunto = new DTOIdioma();
        idiomaPunto.setNombreIdioma(idioma);

        DTOPunto dtoPunto = new DTOPunto();

        dtoPunto.setIdPunto(idPunto);
        
        dtoPunto.setNombrePunto(nombrePunto);

        DTOInformacionEnIdioma infoIdioma = new DTOInformacionEnIdioma();
        infoIdioma.setIdioma(idiomaPunto);
        infoIdioma.setNombre(nombrePunto);
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

        String idPuntoGuardado = servicioPunto.CrearPuntoInteres(dtoPunto, idioma);

        modelo.put("nombrePunto", nombrePunto);
        modelo.put("idPuntoGuardado", idPuntoGuardado);
        
        return "Administracion/Punto/ConfirmacionGuardarPunto";
    }

    @RequestMapping("/agregarImagen.htm")
    public String agregarImagen()
    {
        return "Administracion/Punto/AgregarImagen";
    }

@RequestMapping(value = "/{idPunto}/" + actualizarPuntoInteres)
    public String actualizarPuntoInteres(
            @PathVariable String idPunto,
            ModelMap modelo)
    {
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
                    method = RequestMethod.POST)
    public String eliminarPuntoInteres(
            @PathVariable String idPunto)
    {
        String idioma = "espanol";
        //TODO Obtener el idioma por default del usuario
        return "redirect:/informacionPunto/" + idioma + "/" + idPunto +"/obtenerInformacionPunto.htm";
    }
    
    @RequestMapping("/subirArchivo.htm")
    public @ResponseBody List<UploadedFile> handleRequest(@RequestParam("files") CommonsMultipartFile files,
            @RequestParam(value="idioma") String idioma, HttpServletRequest request,
            ModelMap modelo)
            throws ServletException, IOException, Exception {

        List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
        FileItem file = files.getFileItem();

        FileOutputStream os = null;
        String nombre = file.getName().replace(" ", "_");
        File archivoADisco = new File(nombre);
        String urlImagen = System.getProperty("user.home") + "/" + archivoADisco.getName();
        archivoADisco = new File(System.getProperty("user.home") + "/" + archivoADisco.getName());

        file.write(archivoADisco);

        UploadedFile archivoSubido = new UploadedFile(file.getName(),
                Long.valueOf(file.getSize()).intValue(),
                archivoADisco.getPath(), request.getContextPath()+"/imagenes/mostrarImagen?img="+archivoADisco.getPath(),
                request.getContextPath()+"/administracion/crearPunto/"+nombre+"/borrarArchivo.htm", "DELETE");
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
    public @ResponseBody DetallesImagenResponse handleRequestDelete(
            @PathVariable("archivo") String archivo,
            HttpServletResponse response) {

        Collection<DTOImagen> imagenes = getImagenesPunto();
        String pathArchivo = "";
        for(DTOImagen imagen : imagenes){
            if(imagen.getUrl().contains(archivo)) {
                pathArchivo = imagen.getUrl();
            }
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
    public @ResponseBody DetallesImagenResponse handleRequestComentario(
            @PathVariable("archivo") String archivo,
            @PathVariable("comentario") String comentario,
            HttpServletResponse response) {

        Collection<DTOImagen> imagenes = getImagenesPunto();

        DTOImagen imagenComentario = null;

        for(DTOImagen imagen : imagenes){
            if(imagen.getUrl().contains(archivo)) {
                imagenComentario = imagen;
            }
        }

        String decodedComment = comentario.replaceAll("_", " ");

        DetallesImagenResponse detallesOperacion = new DetallesImagenResponse();

        response.setContentType("application/json");

        if(imagenComentario != null) {
            DTOInformacionEnIdioma dtoInformacion = new DTOInformacionEnIdioma();
            DTOIdioma idioma = new DTOIdioma();
            idioma.setNombreIdioma("espanol");
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
    public @ResponseBody DetallesImagenResponse handleRequestCodigo(
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
}
