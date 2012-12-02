/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Validacion;

import java.util.HashMap;



/**
 *
 * @author Federico
 */
public class Errores extends HashMap<String,String>{

    public void agregarError(String nombreDePropiedad, String mensaje)
    {
        this.put(nombreDePropiedad, mensaje);
    }

    public boolean hayErrores()
    {
        return this.size() > 0;
    }

    public String parsearErrores()
    {
        String resultado = "";

        for (String valor : this.values())
        {
            resultado += valor + "<br/>";
        }

        return resultado;
    }
}
