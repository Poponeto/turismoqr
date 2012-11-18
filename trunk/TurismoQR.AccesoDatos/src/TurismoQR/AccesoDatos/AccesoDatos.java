package TurismoQR.AccesoDatos;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Collection;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
class AccesoDatos extends HibernateDaoSupport implements IAccesoDatos
{

    @Autowired
    public AccesoDatos(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
        getHibernateTemplate().setAllowCreate(false);
    }

    public <E extends IObjetoNegocio> E BuscarObjeto(E objeto)
    {

        return (E) getHibernateTemplate().findByExample(objeto).get(0);
    }

    public <E extends IObjetoNegocio> E BuscarObjeto(Class<E> clase, String idObjeto)
    {
        return getHibernateTemplate().get(clase, idObjeto);
    }

    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos(E Objeto)
    {
        return getHibernateTemplate().findByExample(Objeto);
    }

    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos(Class<E> clase)
    {
        return getHibernateTemplate().loadAll(clase);
    }

    public <E extends IObjetoNegocio> E BuscarObjeto(Class<E> clase)
    {
        return (E) getHibernateTemplate().loadAll(clase).get(0);
    }

    public <E extends IObjetoNegocio> E BuscarObjeto(DetachedCriteria criteria)
    {
        E objeto = (E) getHibernateTemplate().findByCriteria(criteria, 0, 1).get(0);
        getHibernateTemplate().initialize(objeto);
        return objeto;
    }

    public <E extends IObjetoNegocio> Collection<E> BuscarConjuntoObjetos(DetachedCriteria criteria)
    {
        return (Collection<E>) getHibernateTemplate().findByCriteria(criteria);
    }

    public void Guardar(IObjetoNegocio objetoNegocio)
    {
        getHibernateTemplate().saveOrUpdate(objetoNegocio);
    }

    public void Guardar(Collection<IObjetoNegocio> objetosNegocio)
    {
        for (IObjetoNegocio objetoNegocio : objetosNegocio)
        {
            getHibernateTemplate().saveOrUpdate(objetoNegocio);
        }
    }

}
