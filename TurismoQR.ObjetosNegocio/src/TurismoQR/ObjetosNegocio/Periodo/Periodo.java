/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.ObjetosNegocio.Periodo;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Date;

/**
 *
 * @author Federico
 */
public abstract class Periodo implements IObjetoNegocio, IPeriodo
{

    private Date fechaInicioPeriodo;
    private Date fechaFinPeriodo;
    private String idObjeto;

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public Date getFechaInicioPeriodo()
    {
        return fechaInicioPeriodo;
    }

    public void setFechaInicioPeriodo(Date fechaInicioPeriodo)
    {
        this.fechaInicioPeriodo = fechaInicioPeriodo;
    }

    public Date getFechaFinPeriodo()
    {
        return fechaFinPeriodo;
    }

    public void setFechaFinPeriodo(Date fechafinPeriodo)
    {
        this.fechaFinPeriodo = fechafinPeriodo;
    }
}
