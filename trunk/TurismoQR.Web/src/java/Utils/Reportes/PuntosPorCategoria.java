/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils.Reportes;

/**
 *
 * @author Chelo
 */
public class PuntosPorCategoria {
    private String categoria;
    private int cantidadPuntos;

    public PuntosPorCategoria(String categoria, int cantidadPuntos) {
        this.categoria = categoria;
        this.cantidadPuntos = cantidadPuntos;
    }

    public int getCantidadPuntos() {
        return cantidadPuntos;
    }

    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
