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
public class InformacionEnIdioma implements IObjetoNegocio {

    private String texto;
    private String nombre;
    private String idObjeto;
    private Idioma idioma;

    public InformacionEnIdioma(){
        
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public InformacionEnIdioma(String textoInformacion, String idObjeto, Idioma idioma) {
        texto = textoInformacion;
        this.idObjeto = idObjeto;
        this.idioma = idioma;
    }

    public Idioma getIdioma()
    {
        return idioma;
    }

    public void setIdioma(Idioma idioma)
    {
        this.idioma = idioma;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }
    
    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
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
        final InformacionEnIdioma other = (InformacionEnIdioma) obj;
        if ((this.idObjeto == null) ? (other.idObjeto != null) : !this.idObjeto.equals(other.idObjeto))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 11 * hash + (this.idObjeto != null ? this.idObjeto.hashCode() : 0);
        return hash;
    }

    
}
