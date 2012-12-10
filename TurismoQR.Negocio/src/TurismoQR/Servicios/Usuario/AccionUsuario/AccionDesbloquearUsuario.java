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
public class AccionDesbloquearUsuario extends AccionBase{

    public AccionDesbloquearUsuario(IServicioCliente servicioCliente, IAccesoDatos accesoDatos, ManejadorUsuarios manejadorGuardado)
    {
        this.servicioCliente = servicioCliente;
        this.accesoDatos = accesoDatos;
        this.manejadorGuardado = manejadorGuardado;
    }

    @Override
    protected void ejecutarAccionUsuario(Usuario usuario)
    {
        usuario.setBloqueado(false);
    }

    @Override
    protected boolean ejecutarAccionCliente(String idCliente)
    {
        return servicioCliente.desbloquearCliente(idCliente);
    }



}
