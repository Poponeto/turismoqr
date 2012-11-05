/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.ObjetosNegocio.Estados;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Federico
 */
public class Ciclo implements IObjetoNegocio
{

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

    private void setEstados(Collection<Estado> estados)
    {
        this.estados = estados;
    }

    public Estado getEstadoActual()
    {
        for(Estado estado : estados)
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
        this.estados = new HashSet();
        estados.add(estado);
    }
}
