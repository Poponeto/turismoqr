/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Informacion.Idioma;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Federico
 */
@Repository
public class AccesoDatosIdioma extends AccesoDatos{

    @Autowired
    public AccesoDatosIdioma(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    public Idioma BuscarIdiomaPorNombre(String nombreIdioma)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Idioma.class);
        //DetachedCriteria buscarPorNombreDeIdioma = criterioDeBusqueda.createCriteria("BuscarIdiomaPorNombre");

        criterioDeBusqueda.add(Restrictions.eq("nombreIdioma", nombreIdioma));

        return BuscarObjeto(criterioDeBusqueda);
    }
}
