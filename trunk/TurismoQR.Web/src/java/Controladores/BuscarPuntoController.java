/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ftacchini
 */

@Controller("buscarPunto")
public class BuscarPuntoController {

    @RequestMapping("/buscarPunto/paginaBuscarPunto.htm")
    public String redirigir()
    {
        return "Punto/BuscarPunto";
    }
}
