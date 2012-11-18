/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Categorias.Categoria;
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
public class AccesoDatosCategoria extends AccesoDatos{
    
    @Autowired
    public AccesoDatosCategoria(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    public Categoria BuscarCategoriaPorNombre(String nombreCategoria)
    {

            DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Categoria.class);

            criterioDeBusqueda.add(Restrictions.eq("nombreCategoria", nombreCategoria));

            return BuscarObjeto(criterioDeBusqueda);

    }
}
