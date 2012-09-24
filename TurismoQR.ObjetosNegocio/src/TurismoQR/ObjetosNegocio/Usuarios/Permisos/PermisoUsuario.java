/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.ObjetosNegocio.Usuarios.Permisos;

import TurismoQR.ObjetosNegocio.Periodo.PeriodoVencimiento;

/**
 *
 * @author Federico
 */
public class PermisoUsuario extends PeriodoVencimiento
{

    private Permiso permiso;

    public Permiso getPermiso()
    {
        return permiso;
    }

    public void setPermiso(Permiso permiso)
    {
        this.permiso = permiso;
    }
}
