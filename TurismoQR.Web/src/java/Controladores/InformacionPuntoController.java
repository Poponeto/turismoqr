/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import TurismoQR.Servicios.Idioma.IServicioIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Servicios.Punto.IServicioPunto;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Federico
 */

@Controller
@RequestMapping("/informacionPunto")
public class InformacionPuntoController {

    private IServicioPunto servicioPunto;
    private IServicioIdioma servicioIdioma;

    private static final String obtenerInformacionPuntoIdiomaDefault = "obtenerInformacionPuntoIdiomaDefault.htm";
    private static final String obtenerInformacionPunto = "obtenerInformacionPunto.htm";

    @Autowired
    public void InformacionPuntoController(
            IServicioPunto servicioPunto,
            IServicioIdioma servicioIdioma)
    {
        this.servicioPunto = servicioPunto;
        this.servicioIdioma = servicioIdioma;
    }

    public static String generarURLInformacionPunto(String idPunto)
    {
        return "informacionPunto/" + idPunto + "/" + obtenerInformacionPuntoIdiomaDefault;
    }
    
    private static String a;

    @RequestMapping(value = "/{idioma}/{idPunto}/" + obtenerInformacionPunto,
                    method = RequestMethod.GET)
    public String obtenerInformacionPunto(
            @PathVariable String idioma,
            @PathVariable String idPunto, ModelMap model)
    {
        DTOPunto dtoPunto = servicioPunto.ConsultarPuntoInteres(idPunto, idioma);
        Collection<DTOIdioma> dtoIdiomas = servicioIdioma.consultarPosiblesIdiomas(idPunto);
        model.put("punto", dtoPunto);
        model.put("idiomas", dtoIdiomas);

        return "Punto/InformacionPunto";
    }

    @RequestMapping(value = "/{idPunto}/" + obtenerInformacionPuntoIdiomaDefault,
                    method = RequestMethod.POST)
    public String obtenerInformacionPuntoIdiomaDefault(
            @PathVariable String idPunto)
    {
        String idioma = "espanol";
        //TODO Obtener el idioma por default del usuario
        return "redirect:/informacionPunto/" + idioma + "/" + idPunto +"/obtenerInformacionPunto.htm";
    }
}
