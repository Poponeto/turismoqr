/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.ObjetosNegocio.Estados;

import TurismoQR.ObjetosNegocio.Periodo.PeriodoVencimiento;

/**
 *
 * @author Federico
 */
public class Estado extends PeriodoVencimiento implements IEstado {

    public String nombreDeEstado;

    public Estado(){
        
    }

    public Estado(String nombre) {
        nombreDeEstado = nombre;
    }

    public String getNombreDeEstado() {
        return nombreDeEstado;
    }

    public void setNombreDeEstado(String nombre) {
        nombreDeEstado = nombre;
    }



}
