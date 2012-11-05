package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.Estados.Estado;
import TurismoQR.ObjetosNegocio.Punto.PuntoComercial;
import java.util.Collection;

public abstract class Cliente extends Contacto
{
    
    private Usuario usuario;
    private Collection<Estado> estados;
    private Collection<PuntoComercial> puntosDeCliente;
    private int cantidadDePuntosPermitidos;

    public Collection<Estado> getEstados()
    {
        return estados;
    }

    public void setEstados(Collection<Estado> estados)
    {
        this.estados = estados;
    }

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

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
