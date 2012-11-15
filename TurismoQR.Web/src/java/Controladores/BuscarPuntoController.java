/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import TurismoQR.Servicios.Idioma.IServicioIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.Servicios.Punto.IServicioPunto;
import Utils.FilaTablaPunto;
import Utils.IFila;
import Utils.Tabla;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ftacchini
 */
@Controller("buscarPunto")
@RequestMapping("/buscarPunto")
public class BuscarPuntoController
{

    private IServicioPunto servicioPunto;
    private IServicioIdioma servicioIdioma;

    @Autowired
    public void InformacionPuntoController(
            IServicioPunto servicioPunto,
            IServicioIdioma servicioIdioma)
    {
        this.servicioPunto = servicioPunto;
        this.servicioIdioma = servicioIdioma;
    }

    @RequestMapping(value = "/paginaBuscarPunto.htm", method = RequestMethod.GET)
    public String redirigir()
    {
        return "Punto/BuscarPunto";
    }

    @RequestMapping(value = "/obtenerMenuPunto.htm", method = RequestMethod.GET)
    public String obtenerMenuPunto(@RequestParam("idPunto") String idPunto, ModelMap model)
    {
        DTOPunto dtoPunto = servicioPunto.ConsultarPuntoInteres(idPunto, null);

        model.addAttribute("punto", dtoPunto);

        return "Punto/MenuMarcador";
    }

    @RequestMapping(value = "/obtenerInformacionTabla.htm", method = RequestMethod.GET)
    public 
    @ResponseBody
    Tabla obtenerInformacionTabla()
    {
        Collection<DTOPunto> puntos = servicioPunto.ConsultarPuntosDeInteres(null);

        Tabla tabla = new Tabla();
        Collection<IFila> filas = new HashSet<IFila>();

        for (DTOPunto punto : puntos)
        {
            FilaTablaPunto fila = new FilaTablaPunto();
            fila.setIdentificador(punto.getIdPunto());
            fila.setNombreIdentificador(punto.getNombrePunto());
            fila.setLatitud(punto.getLocalizacion().getLatitud());
            fila.setLongitud(punto.getLocalizacion().getLongitud());
            fila.setTieneImagenes(punto.getImagenes() != null ? punto.getImagenes().size() : 0);
           
            filas.add(fila);
        }

        tabla.setRows(filas);
        tabla.setPage(1);
        tabla.setRecords(filas.size());
        tabla.setTotal(1);

        return tabla;
    }
}
