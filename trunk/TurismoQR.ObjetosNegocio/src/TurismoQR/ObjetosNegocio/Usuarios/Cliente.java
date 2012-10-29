package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.IObjetoNegocio;
import TurismoQR.ObjetosNegocio.Punto.PuntoComercial;
import java.util.Collection;

public abstract class Cliente implements IObjetoNegocio
{
    
    private String mail;
    private String celular;
    private String telefonoFijo;
    private Usuario usuario;
    private String idObjeto;
    private Collection<PuntoComercial> puntosDeCliente;
    private int cantidadDePuntosPermitidos;

    public int getCantidadDePuntosPermitidos() {
        return cantidadDePuntosPermitidos;
    }

    public void setCantidadDePuntosPermitidos(int cantidadDePuntosPermitidos) {
        this.cantidadDePuntosPermitidos = cantidadDePuntosPermitidos;
    }

    public Collection<PuntoComercial> getPuntosDeCliente() {
        return puntosDeCliente;
    }

    public void setPuntosDeCliente(Collection<PuntoComercial> puntosDeCliente) {
        this.puntosDeCliente = puntosDeCliente;
    }

    public String getIdObjeto()
    {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto)
    {
        this.idObjeto = idObjeto;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getTelefonoFijo()
    {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo)
    {
        this.telefonoFijo = telefonoFijo;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

}
