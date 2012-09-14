/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author ftacchini
 */

@Controller
public class InicioController {

    @RequestMapping
    public ModelAndView welcomeHandler(){
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }

}
