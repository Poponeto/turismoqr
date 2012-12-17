/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils.Reportes;

/**
 *
 * @author Chelo
 */
public class CantidadVisitasPorPunto {
    private String nombrePunto;
    private int cantidadVisitas;

    public CantidadVisitasPorPunto(String nombrePunto, int cantidadVisitas) {
        this.nombrePunto = nombrePunto;
        this.cantidadVisitas = cantidadVisitas;
    }

    public int getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(int cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    public String getNombrePunto() {
        return nombrePunto;
    }

    public void setNombrePunto(String nombrePunto) {
        this.nombrePunto = nombrePunto;
    }
}
