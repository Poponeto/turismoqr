/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Punto.Localizacion;
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
public class AccesoDatosLocalizacion extends AccesoDatos {

    @Autowired
    public AccesoDatosLocalizacion(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    public Collection<Localizacion> buscarRangoLocalizacion(Localizacion desde, Localizacion hasta)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Localizacion.class);
        //DetachedCriteria buscarPorNombreDeIdioma = criterioDeBusqueda.createCriteria("BuscarIdiomaPorNombre");

        criterioDeBusqueda
                .add(Restrictions.lt("latitud", desde.getLatitud()))
                .add(Restrictions.gt("latitud", hasta.getLatitud()))
                .add(Restrictions.lt("longitud", desde.getLongitud()))
                .add(Restrictions.gt("longitud", hasta.getLongitud()));

        return BuscarConjuntoObjetos(criterioDeBusqueda);
    }

}
