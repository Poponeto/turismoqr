/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOLocalizacion;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import TurismoQR.Punto.IServicioPunto;
import Utils.FormularioArchivo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Chelo
 */
@Controller("crearPuntoController")
@RequestMapping("/crearPunto")
public class CrearPuntoController {

    IServicioPunto servicioPunto;

    @Autowired
    public void LoginController(IServicioPunto servicioPunto)
    {
        this.servicioPunto = servicioPunto;
    }

    @RequestMapping("/crearPuntoDeInteres.htm")
    public String redirigir()
    {
        return "Administracion/Punto/CrearPuntoDeInteres";
    }

    @RequestMapping("/guardarPuntoDeInteres.htm")
    public String guardarPuntoInteres(
            @RequestParam("nombrePunto") String nombrePunto,
            @RequestParam("informacionPunto") String informacionPunto,
            @RequestParam("latitudPunto") String latitudPunto,
            @RequestParam("longitudPunto") String longitudPunto,
            ModelMap modelo
        )
    {
        DTOPunto dtoPunto = new DTOPunto();
        dtoPunto.setNombrePunto(nombrePunto);
        DTOLocalizacion localizacionPunto = new DTOLocalizacion();
        localizacionPunto.setLatitud(latitudPunto);
        localizacionPunto.setLongitud(longitudPunto);
        dtoPunto.setLocalizacion(localizacionPunto);

        servicioPunto.CrearPuntoInteres(dtoPunto, "Español");

        modelo.put("nombrePunto", nombrePunto);
////        ModelAndView modeloVista = new ModelAndView("/Punto/ConfirmacionGuardarPunto", "modelo", modelo);
//        return modelo;
        return "Administracion/Punto/ConfirmacionGuardarPunto";
//        return modelo;
    }

    @RequestMapping("/agregarImagen.htm")
    public String agregarImagen()
    {
        return "Administracion/Punto/AgregarImagen";
    }

//    @RequestMapping("/crearPunto/agregarImagen.htm")
//    public @ModelAttribute("formularioArchivo") FormularioArchivo getInitialMessage() {
//        return new FormularioArchivo();
//    }

    @RequestMapping("/subirImagen.htm")
    public String guardaFichero(@ModelAttribute FormularioArchivo formularioArchivo, ModelMap modelo) {
        System.out.println("Entre al controller");
        String mensajeImagen = "";
        try {
            grabarFicheroALocal(formularioArchivo);
            mensajeImagen = "Fichero grabado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            mensajeImagen = "No se ha podido grabar el fichero";
        }
        modelo.put("mensajeImagen", mensajeImagen);
        return "Administracion/Punto/ConfirmacionImagen";
    }

    private void grabarFicheroALocal(FormularioArchivo formularioArchivo) throws Exception {

//        Collection<File> localFiles=null;
        for(CommonsMultipartFile upload : formularioArchivo.getFichero()){
//        CommonsMultipartFile uploaded = formularioArchivo.getFichero();
            File localFile = new File(System.getProperty("user.home") + "\\" +  upload.getOriginalFilename());
            FileOutputStream os = null;
//        }
//        if(localFiles != null && !localFiles.isEmpty()){
//            for(File file : localFiles) {
                try {
                    
                    os = new FileOutputStream(localFile);
                    os.write(upload.getBytes());

                } finally {
                    if (os != null) {
                        try {
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
//    }
}
