/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.ObjetosNegocio.Recurso;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;

/**
 *
 * @author Federico
 */
public class Recurso implements IObjetoNegocio
{

    private String url;
   private String idObjeto;

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
