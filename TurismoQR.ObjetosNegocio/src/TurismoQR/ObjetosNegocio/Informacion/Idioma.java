/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Informacion;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;

/**
 *
 * @author Federico
 */
public class Idioma implements IObjetoNegocio{

    private String nombreIdioma;
    private String idObjeto;

    public Idioma(){}

    public Idioma(String nombreIdioma, String idObjeto) {
        this.nombreIdioma = nombreIdioma;
        this.idObjeto = idObjeto;
    }

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public String getNombreIdioma()
    {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma)
    {
        this.nombreIdioma = nombreIdioma;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Idioma other = (Idioma) obj;
        if ((this.idObjeto == null) ? (other.idObjeto != null) : !this.idObjeto.equals(other.idObjeto))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 89 * hash + (this.idObjeto != null ? this.idObjeto.hashCode() : 0);
        return hash;
    }

    
}
