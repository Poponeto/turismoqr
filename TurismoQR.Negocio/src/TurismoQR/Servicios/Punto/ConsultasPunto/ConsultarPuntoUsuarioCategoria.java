/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Punto.ConsultasPunto;

import TurismoQR.AccesoDatos.AccesoDatosPunto;
import TurismoQR.ObjetosNegocio.Categorias.Categoria;
import TurismoQR.ObjetosNegocio.Punto.Punto;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import java.util.Collection;

/**
 *
 * @author Chelo
 */
public class ConsultarPuntoUsuarioCategoria implements IConsultaPunto {

    private AccesoDatosPunto accesoDatos;
    private Usuario usuario;
    private Categoria categoria;

    public ConsultarPuntoUsuarioCategoria(AccesoDatosPunto accesoDatosPunto, Usuario usuario, Categoria categoria) {
        this.accesoDatos = accesoDatosPunto;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public Collection<Punto> ejecutarConsulta() {
        return accesoDatos.buscarPuntoPorUsuarioCategoria(categoria, usuario);
    }
}
