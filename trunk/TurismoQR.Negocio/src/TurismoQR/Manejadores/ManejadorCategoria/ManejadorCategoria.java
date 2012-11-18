/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Manejadores.ManejadorCategoria;

import TurismoQR.AccesoDatos.AccesoDatosCategoria;
import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chelo
 */
@Service("manejadorCategoria")
public class ManejadorCategoria {
    
    private AccesoDatosCategoria accesoDatosCategoria;

    @Autowired
    public ManejadorCategoria(AccesoDatosCategoria accesoDatosCategoria)
    {
        this.accesoDatosCategoria = accesoDatosCategoria;
    }

    public Collection<Categoria> obtenerPosiblesCategorias()
    {
        return accesoDatosCategoria.BuscarConjuntoObjetos(Categoria.class);
    }

    public Categoria obtenerCategoria(String nombreIdioma)
    {
        if(nombreIdioma != null)
        {
            return accesoDatosCategoria.BuscarCategoriaPorNombre(nombreIdioma);
        }

        //Si no se especifica el idioma, se retorna el idioma por default
        return accesoDatosCategoria.BuscarObjeto(Categoria.class, "default");

    }

}
