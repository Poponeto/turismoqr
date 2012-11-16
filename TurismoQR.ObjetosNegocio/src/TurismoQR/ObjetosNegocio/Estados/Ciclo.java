/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.ObjetosNegocio.Estados;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author Federico
 */
public class Ciclo implements IObjetoNegocio
{
    public static final String BORRADO = "borrado";
    public static final String HABILITADO = "habilitado";
    public static final String AUTORIZACION_PENDIENTE = "autorizacionPerndiente";

    private Collection<Estado> estados;
    private String idObjeto;

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public Collection<Estado> getEstados()
    {
        return estados;
    }

    public void setEstados(Collection<Estado> estados)
    {
        this.estados = estados;
    }

    public Estado getEstadoActual()
    {
        for (Estado estado : estados)
        {
            if (estado.esActual())
            {
                return estado;
            }
        }
        return null;
    }

    public void setEstadoActual(Estado estado)
    {
        Date fechaInicioNuevoEstado = Calendar.getInstance().getTime();
        estado.setFechaFinPeriodo(fechaInicioNuevoEstado);

        if (this.estados == null)
        {
            this.estados = new HashSet();
        }
        else
        {
            for(Estado estadoAnterior : getEstados())
            {

                estadoAnterior.setFechaFinPeriodo(fechaInicioNuevoEstado);
            }
        }
        
        estados.add(estado);
    }

    public static Estado crearEstado(String nombreEstado)
    {
        return new Estado(nombreEstado);
    }
}
