package TurismoQR.ObjetosNegocio.Punto;

import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosNegocio.Estados.Ciclo;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.Link;
import TurismoQR.ObjetosNegocio.Informacion.Informacion;
import TurismoQR.ObjetosNegocio.Estados.Estado;
import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import java.util.Collection;
import java.util.HashSet;

public class Punto implements IObjetoNegocio
{

    private String nombre;
    private Localizacion localizacion;
    private Informacion informacion;
    private Collection<Imagen> imagenes;
    private Collection<Link> links;
    private Ciclo ciclo;

    public Ciclo getCiclo()
    {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo)
    {
        this.ciclo = ciclo;
    }

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    private String idObjeto;

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public Collection<Imagen> getImagenes()
    {
        return imagenes;
    }

    public void setImagenes(Collection<Imagen> imagenes)
    {
        this.imagenes = imagenes;
    }

    public Collection<Link> getLinks()
    {
        return links;
    }

    public void setLinks(Collection<Link> links)
    {
        this.links = links;
    }

    public Estado getEstado()
    {
        return ciclo.getEstadoActual();
    }

    public void setEstado(Estado estado)
    {
        ciclo.setEstadoActual(estado);
    }

    public Informacion getInformacion()
    {
        return informacion;
    }

    public void setInformacion(Informacion informacion)
    {
        this.informacion = informacion;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Localizacion getLocalizacion()
    {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion)
    {
        this.localizacion = localizacion;
    }
}
