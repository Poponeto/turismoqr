/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Informacion.InformacionEnIdioma;

/**
 *
 * @author Federico
 */
public class DTOInformacionEnIdioma implements IDTO<InformacionEnIdioma>{

    private String texto;
    private String nombre;
    private DTOIdioma idioma;

    public DTOIdioma getIdioma()
    {
        return idioma;
    }

    public void setIdioma(DTOIdioma idioma)
    {
        this.idioma = idioma;
    }


    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        final DTOInformacionEnIdioma other = (DTOInformacionEnIdioma) obj;
        if ((this.texto == null) ? (other.texto != null) : !this.texto.equals(other.texto))
        {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre))
        {
            return false;
        }
        if (this.idioma != other.idioma && (this.idioma == null || !this.idioma.equals(other.idioma)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 41 * hash + (this.texto != null ? this.texto.hashCode() : 0);
        hash = 41 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 41 * hash + (this.idioma != null ? this.idioma.hashCode() : 0);
        return hash;
    }



    
}
