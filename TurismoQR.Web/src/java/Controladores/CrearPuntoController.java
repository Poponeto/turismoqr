/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Chelo
 */
@Controller("crearPuntoController")
public class CrearPuntoController {
    @RequestMapping("/crearPunto/crearPuntoDeInteres.htm")
    public String redirigir()
    {
        return "Punto/CrearPuntoDeInteres";
    }

    @RequestMapping("/crearPunto/guardarPuntoDeInteres.htm")
    public String guardarPuntoInteres()
    {
        return "Punto/ConfirmacionGuardarPunto";
    }
}
