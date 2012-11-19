/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import Utils.FilaTablaUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Federico
 */

@Controller
@RequestMapping("/administracion/usuario")
public class CrearUsuarioController {

    @RequestMapping(value = "/editarUsuario.htm", method = RequestMethod.POST)
    public void editarUsuario(@RequestBody FilaTablaUsuario fila)
    {
        
    }


}
