/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Periodo;

import java.util.Date;

/**
 *
 * @author Federico
 */
public interface IPeriodo {

    public Date getFechaInicioPeriodo();
    public void setFechaInicioPeriodo(Date fechaInicioPeriodo);
    public Date getFechafinPeriodo();
    public void setFechafinPeriodo(Date fechafinPeriodo);

}
