/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import java.util.Collection;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chelo
 */
@Repository
public class AccesoDatosPunto extends AccesoDatos {

    @Autowired
    public AccesoDatosPunto(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    public Collection<Punto> buscarPuntoPorCategoria(Categoria categoria)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Punto.class);
        //DetachedCriteria buscarPorNombreDeIdioma = criterioDeBusqueda.createCriteria("BuscarIdiomaPorNombre");

        criterioDeBusqueda.add(Restrictions.eq("categoria", categoria));

        return BuscarConjuntoObjetos(criterioDeBusqueda);
    }

}
