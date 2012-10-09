/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Punto.IServicioPunto;
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

    IServicioPunto servicioPunto;

    @Autowired
    public void InformacionPuntoController(IServicioPunto servicioPunto)
    {
        this.servicioPunto = servicioPunto;
    }

    @RequestMapping(value = "/{idioma}/{idPunto}/obtenerInformacionPunto.htm",
                    method = RequestMethod.GET)
    public String obtenerInformacionPunto(
            @PathVariable String idioma,
            @PathVariable String idPunto, ModelMap model)
    {
        DTOPunto dtoPunto = servicioPunto.ConsultarPuntoInteres(idPunto, idioma);
        model.put("punto", dtoPunto);

        return "Punto/InformacionPunto";
    }
    /*
    @RequestMapping(value = "/{idioma}/{idPunto}/obtenerInformacionPunto.htm",
                    method = RequestMethod.GET)
    public ModelAndView obtenerInformacionPunto(
            @PathVariable String idioma,
            @PathVariable String idPunto)
    {
        Map model = new HashMap();
        DTOPunto dtoPunto = servicioPunto.ConsultarPuntoInteres(idPunto, idioma);
        model.put("punto", dtoPunto);

        return new ModelAndView("Punto/InformacionPunto", model);
    }*/

    @RequestMapping(value = "/{idPunto}/obtenerInformacionPuntoIdiomaDefault.htm",
                    method = RequestMethod.POST)
    public String obtenerInformacionPuntoIdiomaDefault(
            @PathVariable String idPunto)
    {
        String idioma = "Español";
        //TODO Obtener el idioma por default del usuario
        return "redirect:/informacionPunto/" + idioma + "/" + idPunto +"/obtenerInformacionPunto.htm";
    }
}
