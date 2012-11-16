package TurismoQR.ObjetosNegocio.Usuarios;

import TurismoQR.ObjetosNegocio.Estados.Ciclo;
import TurismoQR.ObjetosNegocio.Estados.Estado;
import TurismoQR.ObjetosNegocio.Punto.PuntoComercial;
import java.util.Collection;

public abstract class Cliente extends Contacto
{
    
    private Usuario usuario;
    private Ciclo ciclo;
    private Collection<PuntoComercial> puntosDeCliente;
    private int cantidadDePuntosPermitidos;

    public Ciclo getCiclo()
    {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo)
    {
        this.ciclo = ciclo;
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

    public void setEstado(Estado estadoActual)
    {
        if(ciclo == null)
        {
            ciclo = new Ciclo();
        }
        getCiclo().setEstadoActual(estadoActual);
    }

    public Estado getEstado()
    {
        return getCiclo().getEstadoActual();
    }

}
