/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosNegocio.Punto.Localizacion;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import java.util.Collection;
import java.util.HashSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.TypedValue;
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

    public Collection<Punto> buscarPuntoPorUsuario(Usuario usuario)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Punto.class);
        //DetachedCriteria buscarPorNombreDeIdioma = criterioDeBusqueda.createCriteria("BuscarIdiomaPorNombre");

        criterioDeBusqueda.add(Restrictions.eq("usuario", usuario));

        return BuscarConjuntoObjetos(criterioDeBusqueda);
    }

    public Punto buscarPuntoPorNombre(String nombrePunto)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Punto.class);

        criterioDeBusqueda.add(Restrictions.eq("nombre", nombrePunto));

        return BuscarObjeto(criterioDeBusqueda);
    }

    public Punto buscarPuntoPorLocalizacion(Localizacion localizacion)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Punto.class);

        criterioDeBusqueda.add(Restrictions.eq("localizacion", localizacion));

        return BuscarObjeto(criterioDeBusqueda);
    }

    public Collection<Punto> buscarPuntoPorCategoria(Categoria categoria)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Punto.class);
        //DetachedCriteria buscarPorNombreDeIdioma = criterioDeBusqueda.createCriteria("BuscarIdiomaPorNombre");

        criterioDeBusqueda.add(Restrictions.eq("categoria", categoria));

        return BuscarConjuntoObjetos(criterioDeBusqueda);
    }

    public Collection<Punto> buscarPuntoPorUsuarioCategoria(Categoria categoria, Usuario usuario)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Punto.class);
        //DetachedCriteria buscarPorNombreDeIdioma = criterioDeBusqueda.createCriteria("BuscarIdiomaPorNombre");

        criterioDeBusqueda.add(Restrictions.eq("categoria", categoria)).add(Restrictions.eq("usuario", usuario));

        return BuscarConjuntoObjetos(criterioDeBusqueda);
    }

    public Collection<Punto> buscarPuntoPorZona(Collection<Localizacion> localizaciones)
    {
//        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Punto.class);
        //DetachedCriteria buscarPorNombreDeIdioma = criterioDeBusqueda.createCriteria("BuscarIdiomaPorNombre");

        Collection<Punto> puntosEnZona = new HashSet<Punto>();

        for(Localizacion localizacion : localizaciones) {
            DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Punto.class);
            criterioDeBusqueda.add(Restrictions.eq("localizacion", localizacion));
            puntosEnZona.add((Punto)BuscarObjeto(criterioDeBusqueda));
        }

//        criterioDeBusqueda.add(Restrictions.gt("localizacion", desde)).add(Restrictions.lt("localizacion", hasta));

        return puntosEnZona;
    }

}
