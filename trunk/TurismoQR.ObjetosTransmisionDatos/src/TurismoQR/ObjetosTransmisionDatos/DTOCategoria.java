/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosTransmisionDatos;

import TurismoQR.ObjetosNegocio.Categorias.Categoria;

/**
 *
 * @author Chelo
 */
public class DTOCategoria implements IDTO<Categoria> {

    private String idCategoria;

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
    private String nombreCategoria;

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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
        final DTOCategoria other = (DTOCategoria) obj;
        if ((this.nombreCategoria == null) ? (other.nombreCategoria != null) : !this.nombreCategoria.equals(other.nombreCategoria))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 19;
        hash = 29 * hash + (this.nombreCategoria != null ? this.nombreCategoria.hashCode() : 0);
        return hash;
    }
}
