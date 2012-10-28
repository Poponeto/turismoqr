/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Manejadores.ManejadorEstados;
import TurismoQR.ObjetosNegocio.Estados.IEstado;
import org.springframework.stereotype.Service;

/**
 *
 * @author ftacchini
 */

@Service("manejadorEstados")
public class ManejadorEstados {

    public Boolean esEstadoValidoConsulta(IEstado estado)
    {
        if(estado.getNombreDeEstado().equalsIgnoreCase("habilitado"))
        {
            return true;
        }
        return false;
    }
}
