/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Informacion;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public class Informacion implements IObjetoNegocio {
    
    private Collection<InformacionEnIdioma> informacionEnIdiomas;
    private String idObjeto;

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public Collection<InformacionEnIdioma> getInformacionEnIdiomas()
    {
        return informacionEnIdiomas;
    }

    public void setInformacionEnIdiomas(Collection<InformacionEnIdioma> informacionEnIdiomas)
    {
        this.informacionEnIdiomas = informacionEnIdiomas;
    }


}
