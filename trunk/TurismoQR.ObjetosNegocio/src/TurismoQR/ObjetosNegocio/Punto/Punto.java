package TurismoQR.ObjetosNegocio.Punto;

import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosNegocio.Estados.Ciclo;
import TurismoQR.ObjetosNegocio.Informacion.Imagen;
import TurismoQR.ObjetosNegocio.Informacion.Informacion;
import TurismoQR.ObjetosNegocio.Estados.Estado;
import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import java.util.Collection;
import java.util.Date;

public class Punto implements IObjetoNegocio
{

    private String nombre;
    private Localizacion localizacion;
    private Informacion informacion;
    private Collection<Imagen> imagenes;
    private Ciclo ciclo;
    private Usuario usuario;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private int cantidadDeVisitas;

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getCantidadDeVisitas() {
        return cantidadDeVisitas;
    }

    public void setCantidadDeVisitas(int cantidadDeVisitas) {
        this.cantidadDeVisitas = cantidadDeVisitas;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

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


    public Estado getEstado()
    {
        return ciclo.getEstadoActual();
    }

    public void setEstado(Estado estado)
    {
        if(ciclo == null)
        {
            ciclo = new Ciclo();
        }
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
