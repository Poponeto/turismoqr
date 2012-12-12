/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import TurismoQR.Manejadores.ManejadorLogin.ManejadorLogin;
import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import TurismoQR.Servicios.Idioma.IServicioIdioma;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Punto.IServicioPunto;
import TurismoQR.Servicios.Usuario.IServicioUsuario;
import Utils.FilaTablaPunto;
import Utils.IFila;
import Utils.Tabla;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
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
    private IServicioUsuario servicioUsuario;

    @Autowired
    public void InformacionPuntoController(
            IServicioPunto servicioPunto,
            IServicioIdioma servicioIdioma,
            IServicioUsuario servicioUsuario)
    {
        this.servicioPunto = servicioPunto;
        this.servicioIdioma = servicioIdioma;
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(value = "/paginaBuscarPunto.htm", method = RequestMethod.GET)
    public String redirigir(ModelMap model)
    {
        Collection<DTOCategoria> dtoCategorias = servicioPunto.obtenerCategoriasPunto();
        model.put("categorias", dtoCategorias);

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
        Collection<DTOPunto> puntos = servicioPunto.ConsultarPuntosDeInteres("espanol");

        Tabla tablaResultados = crearTablaResultados(puntos);
        
        return tablaResultados;
    }

    @RequestMapping(value = "{categoria}/obtenerInformacionTablaCategoria.htm", method = RequestMethod.GET)
    public
    @ResponseBody
    Tabla obtenerInformacionTablaCategoria(@PathVariable("categoria") String categoria)
    {
        Collection<DTOPunto> puntos = servicioPunto.ConsultarPuntosDeInteresCategoria(categoria, "espanol");

        Tabla tablaResultados = crearTablaResultados(puntos);

        return tablaResultados;
    }

    @RequestMapping(value = "{usuario}/obtenerInformacionTablaUsuario.htm", method = RequestMethod.GET)
    public
    @ResponseBody
    Tabla obtenerInformacionTablaUsuario(@PathVariable("usuario") String usuario)
    {
        DTOUsuario usuarioActivo = (DTOUsuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<DTOPunto> puntos = servicioPunto.ConsultarPuntosDeInteresPorUsuario(usuarioActivo.getNombreUsuario(), "espanol");

        Tabla tablaResultados = crearTablaResultados(puntos);

        return tablaResultados;
    }

    @RequestMapping(value = "{categoria}/{usuario}/obtenerInformacionTablaCategoriaUsuario.htm", method = RequestMethod.GET)
    public
    @ResponseBody
    Tabla obtenerInformacionTablaCategoriaUsuario(@PathVariable("categoria") String categoria, @PathVariable("usuario") String usuario)
    {
        DTOUsuario usuarioActivo = (DTOUsuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Collection<DTOPunto> puntos = servicioPunto.ConsultarPuntosDeInteresPorUsuarioCategoria(usuarioActivo.getNombreUsuario(), categoria, "espanol");

        Tabla tablaResultados = crearTablaResultados(puntos);

        return tablaResultados;
    }

    @RequestMapping(value = "{idPunto}/{radio}/puntosCercanos.htm", method = RequestMethod.GET)
    public
    @ResponseBody
    Tabla obtenerInformacionTablaCercanos(@PathVariable("idPunto") String idPunto, @PathVariable("radio") double radio)
    {
        Collection<DTOPunto> puntos = servicioPunto.ConsultarPuntosDeInteresZona(servicioPunto.ConsultarPuntoInteres(idPunto, "espanol").getLocalizacion(), radio, "espanol");

        Tabla tablaResultados = crearTablaResultados(puntos);

        return tablaResultados;
    }

    private Tabla crearTablaResultados(Collection<DTOPunto> puntos) {
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
