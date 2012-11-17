/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

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
import TurismoQR.ObjetosNegocio.Informacion.Informacion;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.Servicios.Idioma.IServicioIdioma;
import TurismoQR.Traductores.ITraductor;
import Utils.UploadedFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
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
    public void LoginController(IServicioPunto servicioPunto, IServicioIdioma servicioIdioma, ManejadorIdiomas manejadorIdioma, ITraductor traductor)
    {
        this.servicioPunto = servicioPunto;
        this.servicioIdioma = servicioIdioma;
        this.manejadorIdioma = manejadorIdioma;
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
            ModelMap modelo
        )
    {
        DTOIdioma idiomaPunto = new DTOIdioma();
        idiomaPunto.setNombreIdioma(idioma);

        DTOPunto dtoPunto = new DTOPunto();
        
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

        servicioPunto.CrearPuntoInteres(dtoPunto, idioma);

        modelo.put("nombrePunto", nombrePunto);
        
        return "Administracion/Punto/ConfirmacionGuardarPunto";
    }

    @RequestMapping("/agregarImagen.htm")
    public String agregarImagen()
    {
        return "Administracion/Punto/AgregarImagen";
    }

@RequestMapping(value = "/{idPunto}/" + actualizarPuntoInteres,
                    method = RequestMethod.POST)
    public String actualizarPuntoInteres(
            @PathVariable String idPunto)
    {
        String idioma = "espanol";
        //TODO Obtener el idioma por default del usuario
        return "redirect:/informacionPunto/" + idioma + "/" + idPunto +"/obtenerInformacionPunto.htm";
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
            @RequestParam(value="comentarioImagen", required=false) String comentarioImagen,
            @RequestParam(value="idioma") String idioma, HttpServletRequest request,
            ModelMap modelo)
            throws ServletException, IOException, Exception {

        Idioma idiomaSeleccionado = manejadorIdioma.obtenerIdioma(idioma);

        List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
        FileItem file = files.getFileItem();

        FileOutputStream os = null;
        String nombre = file.getName();
        File archivoADisco = new File(nombre);
        String urlImagen = System.getProperty("user.home") + "/" + archivoADisco.getName();
        archivoADisco = new File(System.getProperty("user.home") + "/" + archivoADisco.getName());

        file.write(archivoADisco);

        UploadedFile archivoSubido = new UploadedFile(file.getName(),
                Long.valueOf(file.getSize()).intValue(),
                archivoADisco.getPath(), request.getContextPath()+"/imagenes/mostrarImagen?img="+archivoADisco.getPath(),
                "/borrarArchivo", "DELETE");
        uploadedFiles.add(archivoSubido);

        System.out.println(comentarioImagen);

        Imagen imagenParaDTO = new Imagen();
        imagenParaDTO.setUrl(urlImagen);
        imagenParaDTO.setExtension(file.getName().substring(file.getName().indexOf(".")));

        if(comentarioImagen != null && !comentarioImagen.isEmpty()) {
            List<InformacionEnIdioma> listaInfo = new ArrayList<InformacionEnIdioma>();
            InformacionEnIdioma contenidoInfo = new InformacionEnIdioma(comentarioImagen, null, idiomaSeleccionado);
            listaInfo.add(contenidoInfo);
            Informacion infoImagen = new Informacion();
            infoImagen.setInformacionEnIdiomas(listaInfo);
            imagenParaDTO.setInformacion(infoImagen);
        }
        Collection<DTOImagen> DTOImagenes = getImagenesPunto();
        DTOImagenes.add((DTOImagen) traductor.traducir(imagenParaDTO));
        setImagenesPunto(DTOImagenes);

        modelo.put("detallesImagen", uploadedFiles);

        return uploadedFiles;
    }

    @RequestMapping("/borrarArchivo.htm")
    public String handleRequestDelete(@RequestParam("archivo") String archivo) {
        File file = new File(archivo);
        if (file.delete())
           System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
           System.out.println("El fichero no puede ser borrado");
        return "done";
    }
}
