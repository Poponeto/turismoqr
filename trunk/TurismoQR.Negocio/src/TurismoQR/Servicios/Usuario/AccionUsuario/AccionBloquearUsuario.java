/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario.AccionUsuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ConstantesDeNegocio;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.Servicios.Usuario.IServicioCliente;

/**
 *
 * @author Federico
 */
public class AccionBloquearUsuario extends AccionBase{

    public AccionBloquearUsuario(IServicioCliente servicioCliente, IAccesoDatos accesoDatos, ManejadorUsuarios manejadorGuardado)
    {
        this.servicioCliente = servicioCliente;
        this.accesoDatos = accesoDatos;
        this.manejadorGuardado = manejadorGuardado;
    }
    @Override
    protected void ejecutarAccionUsuario(Usuario usuario)
    {
        usuario.setBloqueado(true);
    }

    @Override
    protected boolean ejecutarAccionCliente(String idCliente)
    {
        return servicioCliente.eliminarCliente(idCliente);
    }

}
