/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import TurismoQR.Manejadores.ManejadorCategoria.ManejadorCategoria;
import TurismoQR.Manejadores.ManejadorIdiomas.ManejadorIdiomas;
import TurismoQR.ObjetosTransmisionDatos.DTOCategoria;
import TurismoQR.ObjetosTransmisionDatos.DTOPunto;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Idioma.IServicioIdioma;
import TurismoQR.Servicios.Punto.IServicioPunto;
import TurismoQR.Servicios.Usuario.IServicioUsuario;
import TurismoQR.Traductores.ITraductor;
import Utils.Reportes.CantidadVisitasPorPunto;
import Utils.Reportes.PuntosCreadosPorMes;
import Utils.Reportes.PuntosModificadosPorMes;
import Utils.Reportes.PuntosPorCategoria;
import Utils.Reportes.PuntosPorUsuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chelo
 */
@Controller("reportesController")
@RequestMapping("administracion/verReporte")
public class ReportesController {
    IServicioPunto servicioPunto;
    private IServicioIdioma servicioIdioma;
    ManejadorIdiomas manejadorIdioma;
    ManejadorCategoria manejadorCategoria;
    IServicioUsuario servicioUsuario;
    ITraductor traductor;

    @Autowired
    public void ReportesController(IServicioPunto servicioPunto, IServicioIdioma servicioIdioma, ManejadorIdiomas manejadorIdioma, ManejadorCategoria manejadorCategoria, IServicioUsuario servicioUsuario, ITraductor traductor)
    {
        this.servicioPunto = servicioPunto;
        this.servicioIdioma = servicioIdioma;
        this.manejadorIdioma = manejadorIdioma;
        this.manejadorCategoria = manejadorCategoria;
        this.servicioUsuario = servicioUsuario;
        this.traductor = traductor;
    }

    @RequestMapping("/reporte.htm")
    public String verReporte(ModelMap modelo)
    {
        HashMap meses = new HashMap();
        meses.put(1, "Enero");
        meses.put(2, "Febrero");
        meses.put(3, "Marzo");
        meses.put(4, "Abril");
        meses.put(5, "Mayo");
        meses.put(6, "Junio");
        meses.put(7, "Julio");
        meses.put(8, "Agosto");
        meses.put(9, "Septiembre");
        meses.put(10, "Octubre");
        meses.put(11, "Noviembre");
        meses.put(12, "Diciembre");

        Date fechaInicialDate = new Date();
        Date fechaFinalDate = new Date();

        Calendar fechaInicial = Calendar.getInstance();
        Calendar fechaFinal = Calendar.getInstance();

        fechaInicial.setTime(fechaInicialDate);
        fechaInicial.add(Calendar.MONTH, -3);

        fechaFinal.setTime(fechaFinalDate);

        fechaInicialDate = fechaInicial.getTime();
        fechaFinalDate = fechaFinal.getTime();

        SimpleDateFormat formatDate = new SimpleDateFormat("MM");
        int mesFechaInicial = Integer.parseInt(formatDate.format(fechaInicialDate));
        int mesFechaFinal = Integer.parseInt(formatDate.format(fechaFinalDate));

        Collection<DTOPunto> puntos = servicioPunto.ConsultarPuntosDeInteres("espanol");

        Collection<DTOUsuario> usuarios = servicioUsuario.consultarUsuarios();

        Collection<DTOCategoria> categorias = servicioPunto.obtenerCategoriasPunto();
        
        Collection<PuntosPorUsuario> puntosPorUsuario = new HashSet<PuntosPorUsuario>();
        Collection<PuntosCreadosPorMes> puntosCreadosPorMes = new HashSet<PuntosCreadosPorMes>();
        Collection<PuntosModificadosPorMes> puntosModificadosPorMes = new HashSet<PuntosModificadosPorMes>();
        Collection<CantidadVisitasPorPunto> cantidadVisitasPorPunto = new HashSet<CantidadVisitasPorPunto>();
        Collection<PuntosPorCategoria> puntosPorCategoria = new HashSet<PuntosPorCategoria>();

        for(DTOUsuario usuario : usuarios) {
            String nombreUsuario = usuario.getNombreUsuario();
            PuntosPorUsuario puntosUsuario = new PuntosPorUsuario(nombreUsuario, 0);
            for(DTOPunto punto : puntos){
                if(punto.getUsuario().getNombreUsuario().equals(nombreUsuario)){
                    int cantidadPuntos = puntosUsuario.getCantidadPuntos();
                    puntosUsuario.setCantidadPuntos(cantidadPuntos + 1);
                }
            }
            puntosPorUsuario.add(puntosUsuario);
        }

        for(DTOCategoria categoria : categorias) {
            String nombreCategoria = categoria.getNombreCategoria();
            PuntosPorCategoria puntosCategoria = new PuntosPorCategoria(nombreCategoria, 0);
            for(DTOPunto punto : puntos) {
                if(punto.getCategoria().getNombreCategoria().equals(nombreCategoria)){
                    int cantidadPuntos = puntosCategoria.getCantidadPuntos();
                    puntosCategoria.setCantidadPuntos(cantidadPuntos + 1);
                }
            }
            puntosPorCategoria.add(puntosCategoria);
        }

        int mesActualCreados = mesFechaInicial;

        for(int i = 0; i < 4; i++) {

            if (mesActualCreados > 12) {
                mesActualCreados = 1;
            }

            PuntosCreadosPorMes puntosPorMes = new PuntosCreadosPorMes((String)meses.get(mesActualCreados), 0);

            for(DTOPunto punto : puntos) {
            Date fechaCreacion = punto.getFechaCreacion();
            if(fechaCreacion != null && fechaCreacion.after(fechaInicialDate) && fechaCreacion.before(fechaFinalDate)) {
                int mesPunto = Integer.parseInt(formatDate.format(fechaCreacion));

                if(mesPunto == mesActualCreados) {
                    int cantidadPuntos = puntosPorMes.getCantidadPuntos();
                    puntosPorMes.setCantidadPuntos(cantidadPuntos + 1);
                }
            }
            }
            puntosCreadosPorMes.add(puntosPorMes);

            mesActualCreados += 1;
        }

        int mesActualModificados = mesFechaInicial;

        for(int i = 0; i < 4; i++) {

            if (mesActualModificados > 12) {
                mesActualModificados = 1;
            }

            PuntosModificadosPorMes puntosModPorMes = new PuntosModificadosPorMes((String)meses.get(mesActualModificados), 0);

            for(DTOPunto punto : puntos) {
               Date fechaModificacion = punto.getFechaModificacion();
               if(fechaModificacion != null && fechaModificacion.after(fechaInicialDate) && fechaModificacion.before(fechaFinalDate)) {
                   int mesPunto = Integer.parseInt(formatDate.format(fechaModificacion));

                   if(mesPunto == mesActualModificados) {
                       int cantidadPuntos = puntosModPorMes.getCantidadPuntos();
                       puntosModPorMes.setCantidadPuntos(cantidadPuntos + 1);
                   }
               }
            }
            puntosModificadosPorMes.add(puntosModPorMes);

            mesActualModificados += 1;
        }

        for(DTOPunto punto : puntos) {
            CantidadVisitasPorPunto visitasPunto = new CantidadVisitasPorPunto(punto.getNombrePunto(), punto.getCantidadDeVisitas());
            cantidadVisitasPorPunto.add(visitasPunto);
        }
        
        modelo.put("puntosPorUsuario", puntosPorUsuario);
        modelo.put("puntosCreadosPorMes", puntosCreadosPorMes);
        modelo.put("puntosModificadosPorMes", puntosModificadosPorMes);
        modelo.put("cantidadVisitasPorPunto", cantidadVisitasPorPunto);
        modelo.put("puntosPorCategoria", puntosPorCategoria);

        return "Administracion/Punto/Reporte";
    }
}
