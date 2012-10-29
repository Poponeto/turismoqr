/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Categorias;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;

/**
 *
 * @author ftacchini
 */
public class Categoria implements IObjetoNegocio{
    private String nombreCategoria;
    private String idObjeto;

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }


}
