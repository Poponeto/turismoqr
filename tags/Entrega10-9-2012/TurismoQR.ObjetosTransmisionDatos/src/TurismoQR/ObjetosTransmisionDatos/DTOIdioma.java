/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Informacion.Idioma;

/**
 *
 * @author Federico
 */
public class DTOIdioma implements IDTO<Idioma> {

    private String nombreIdioma;

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
        final DTOIdioma other = (DTOIdioma) obj;
        if ((this.nombreIdioma == null) ? (other.nombreIdioma != null) : !this.nombreIdioma.equals(other.nombreIdioma))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 83 * hash + (this.nombreIdioma != null ? this.nombreIdioma.hashCode() : 0);
        return hash;
    }

    
}
