/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils.Reportes;

/**
 *
 * @author Chelo
 */
public class PuntosPorUsuario {
    private String nombreUsuario;
    private int cantidadPuntos;

    public PuntosPorUsuario(String nombreUsuario, int cantidadPunto) {
        this.nombreUsuario = nombreUsuario;
        this.cantidadPuntos = cantidadPunto;
    }

    public int getCantidadPuntos() {
        return cantidadPuntos;
    }

    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
