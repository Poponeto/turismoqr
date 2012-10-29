/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Categorias;

/**
 *
 * @author ftacchini
 */
public class Rubro {

    private String nombreRubro;
    private Categoria categoriaPorDefault;

    private String idObjeto;

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Categoria getCategoriaPorDefault() {
        return categoriaPorDefault;
    }

    public void setCategoriaPorDefault(Categoria categoriaPorDefault) {
        this.categoriaPorDefault = categoriaPorDefault;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    
}
