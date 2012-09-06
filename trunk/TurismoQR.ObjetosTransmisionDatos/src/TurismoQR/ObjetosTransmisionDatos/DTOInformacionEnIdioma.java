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
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 97 * hash + (this.texto != null ? this.texto.hashCode() : 0);
        return hash;
    }

    
}
