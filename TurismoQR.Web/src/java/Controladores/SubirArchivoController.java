/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.Informacion;
import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOImagen;
import TurismoQR.Servicios.Punto.IServicioPunto;
import TurismoQR.Manejadores.ManejadorIdiomas.ManejadorIdiomas;
import Utils.UploadedFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Chelo
 */
@Controller("subirArchivoController")
@RequestMapping("administracion/crearPunto")
public class SubirArchivoController {

    IServicioPunto servicioPunto;
    ManejadorIdiomas manejadorIdiomas;

    @Autowired
    public void SubirArchivoController(IServicioPunto servicioPunto, ManejadorIdiomas manejadorIdiomas)
    {
        this.servicioPunto = servicioPunto;
        this.manejadorIdiomas = manejadorIdiomas;
    }
   
    @RequestMapping("/subirArchivo.htm")
    public @ResponseBody List<UploadedFile> handleRequest(@RequestParam("files") CommonsMultipartFile files, 
            @RequestParam(value="comentarioImagen", required=false) String comentarioImagen,
            @RequestParam(value="idioma", required=false) String idioma,
            ModelMap modelo)
            throws ServletException, IOException, Exception {

        Idioma idiomaSeleccionado = manejadorIdiomas.obtenerIdioma(idioma);

        List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
        FileItem file = files.getFileItem();

        FileOutputStream os = null;
        String nombre = file.getName();
        File archivoADisco = new File(nombre);
        String urlImagen = System.getProperty("user.home") + "/" + archivoADisco.getName();
        archivoADisco = new File(System.getProperty("user.home") + "/" + archivoADisco.getName());

        file.write(archivoADisco);

//        System.out.println(System.getProperty("user.home") + "/" + archivoADisco.getName());
        UploadedFile archivoSubido = new UploadedFile(file.getName(),
                Long.valueOf(file.getSize()).intValue(),
                archivoADisco.getPath(), archivoADisco.getPath(),
                "/borrarImagen", "DELETE");
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
        Collection<DTOImagen> DTOImagenes = servicioPunto.getImagenesPunto();
        //DTOImagenes.add(servicioPunto.crearDTOImagen(imagenParaDTO, idiomaSeleccionado));
        servicioPunto.setImagenesPunto(DTOImagenes);

        modelo.put("mensajeImagen", "Mensaje que permite saber el estado de la imagen");

        return uploadedFiles;
    }
}
