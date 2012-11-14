/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Manejadores.ManejadorEstados;
import TurismoQR.ObjetosNegocio.Estados.Estado;
import TurismoQR.ObjetosNegocio.Estados.IEstado;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author ftacchini
 */

@Service("manejadorEstados")
public class ManejadorEstados {

    public static final String BORRADO = "borrado";
    public static final String HABILITADO = "habilitado";


    public Boolean esEstadoValidoConsulta(IEstado estado)
    {
        if(estado.getNombreDeEstado().equalsIgnoreCase(HABILITADO))
        {
            return true;
        }

        return false;
    }

    public void deshabilitarEstado(Estado estado)
    {
        estado.setFechaFinPeriodo(Calendar.getInstance().getTime());
    }

    public Estado crearNuevoEstado(String nombreEstado)
    {
        Estado estado = new Estado();
        estado.setNombreDeEstado(nombreEstado);
        estado.setFechaInicioPeriodo(Calendar.getInstance().getTime());

        return estado;
    }


}
