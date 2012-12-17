/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.Servicios.Idioma.IServicioIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Servicios.Punto.IServicioPunto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private static final String obtenerInformacionPuntoMobile = "infoPuntoMobile.htm";

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
                    method = RequestMethod.GET)
    public String obtenerInformacionPuntoIdiomaDefault(
            @PathVariable String idPunto)
    {
        String idioma = "espanol";
        //TODO Obtener el idioma por default del usuario
        return "redirect:/informacionPunto/" + idioma + "/" + idPunto +"/obtenerInformacionPunto.htm";
    }

    @RequestMapping(value = "/categorias/",
                    method = RequestMethod.GET)
    public @ResponseBody List<DTOCategoria> obtenerCategoriasPunto (
            ModelMap model)
    {
        List<DTOCategoria> categorias = new ArrayList<DTOCategoria>();

        categorias = servicioPunto.obtenerCategoriasPunto();
        
        return categorias;
    }

    @RequestMapping(value = "/{idPunto}/" + obtenerInformacionPuntoMobile,
                    method = RequestMethod.GET)
    public String obtenerInformacionPuntoMobileDefault (
            @PathVariable String idPunto,
            ModelMap model)
    {
        String idioma = "espanol";

        return "redirect:/informacionPunto/"+idioma+"/"+idPunto+"/"+obtenerInformacionPuntoMobile;
    }

    @RequestMapping(value = "/{idioma}/{idPunto}/" + obtenerInformacionPuntoMobile,
                    method = RequestMethod.GET)
    public String obtenerInformacionPuntoMobile (
            @PathVariable String idioma,
            @PathVariable String idPunto,
            ModelMap model)
    {
        DTOPunto dtoPunto = servicioPunto.ConsultarPuntoInteres(idPunto, idioma);
        Collection<DTOIdioma> dtoIdiomas = servicioIdioma.consultarPosiblesIdiomas(idPunto);

        DTOPunto puntoActualizado = dtoPunto;

        int increaseCantidadVisitas = dtoPunto.getCantidadDeVisitas() + 1;
        puntoActualizado.setCantidadDeVisitas(increaseCantidadVisitas);

        servicioPunto.CrearPuntoInteres(puntoActualizado, idioma, true);

        model.put("punto", dtoPunto);
        model.put("idiomas", dtoIdiomas);

        return "Mobile/index";
    }
}
