/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto.ConsultasPunto;

import TurismoQR.AccesoDatos.AccesoDatosPunto;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import java.util.Collection;

/**
 *
 * @author Chelo
 */
public class ConsultarPuntoUsuario implements IConsultaPunto {

    private AccesoDatosPunto accesoDatos;
    private Usuario usuario;

    public ConsultarPuntoUsuario(AccesoDatosPunto accesoDatos, Usuario usuario)
    {
        this.accesoDatos = accesoDatos;
        this.usuario = usuario;
    }

    public Collection<Punto> ejecutarConsulta() {
        return accesoDatos.buscarPuntoPorUsuario(usuario);
    }

}
