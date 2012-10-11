/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ftacchini
 */

@Controller("buscarPunto")
@RequestMapping("/buscarPunto")
public class BuscarPuntoController {

    @RequestMapping(value = "/paginaBuscarPunto.htm",method = RequestMethod.GET)
    public String redirigir(ModelMap model)
    {
        return "Punto/BuscarPunto";
    }
}
