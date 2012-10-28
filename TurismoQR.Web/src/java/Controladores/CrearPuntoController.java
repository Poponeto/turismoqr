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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chelo
 */
@Controller("crearPuntoController")
@RequestMapping("administracion/crearPunto")
public class CrearPuntoController {

    IServicioPunto servicioPunto;
    ManejadorIdiomas manejadorIdioma;

    @Autowired
    public void LoginController(IServicioPunto servicioPunto, ManejadorIdiomas manejadorIdioma)
    {
        this.servicioPunto = servicioPunto;
        this.manejadorIdioma = manejadorIdioma;
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
            @RequestParam("idioma") String idioma,
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
        DTOLocalizacion localizacionPunto = new DTOLocalizacion();
        localizacionPunto.setLatitud(latitudPunto);
        localizacionPunto.setLongitud(longitudPunto);
        dtoPunto.setLocalizacion(localizacionPunto);
        dtoPunto.setImagenes(servicioPunto.getImagenesPunto());

        servicioPunto.CrearPuntoInteres(dtoPunto, idioma);

        modelo.put("nombrePunto", nombrePunto);
        
        return "Administracion/Punto/ConfirmacionGuardarPunto";
    }

    @RequestMapping("/agregarImagen.htm")
    public String agregarImagen()
    {
        return "Administracion/Punto/AgregarImagen";
    }
}
