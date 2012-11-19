/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Periodo;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Federico
 */
public abstract class PeriodoVencimiento extends Periodo{

    public Boolean esActual()
    {
          return this.getFechaFinPeriodo() == null || !(this.getFechaFinPeriodo().before(
                  Calendar.getInstance().getTime()));
    }
}
