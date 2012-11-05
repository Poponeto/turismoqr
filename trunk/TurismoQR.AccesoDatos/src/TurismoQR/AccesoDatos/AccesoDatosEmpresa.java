/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.Categorias.Rubro;
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
public class AccesoDatosEmpresa extends AccesoDatos
{

    @Autowired
    public AccesoDatosEmpresa(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    public Rubro buscarRubroPorNombre(String nombreRubro)
    {
        DetachedCriteria criterioDeBusqueda = DetachedCriteria.forClass(Rubro.class);
        //DetachedCriteria buscarPorNombreDeIdioma = criterioDeBusqueda.createCriteria("BuscarIdiomaPorNombre");

        criterioDeBusqueda.add(Restrictions.eq("nombreRubro", nombreRubro));

        return BuscarObjeto(criterioDeBusqueda);
    }
}
