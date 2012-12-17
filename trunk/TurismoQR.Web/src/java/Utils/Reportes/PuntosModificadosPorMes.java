/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils.Reportes;

/**
 *
 * @author Chelo
 */
public class PuntosModificadosPorMes {
    private String mes;
    private int cantidadPuntos;

    public PuntosModificadosPorMes(String mes, int cantidadPuntos) {
        this.mes = mes;
        this.cantidadPuntos = cantidadPuntos;
    }

    public int getCantidadPuntos() {
        return cantidadPuntos;
    }

    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
