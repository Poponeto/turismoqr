/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario.AccionUsuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ConstantesDeNegocio;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.Servicios.Usuario.IServicioCliente;
import java.util.Collection;

/**
 *
 * @author Federico
 */
public abstract class AccionBase implements IAccionUsuario{

    protected IServicioCliente servicioCliente;
    protected IAccesoDatos accesoDatos;
    protected ManejadorUsuarios manejadorGuardado;

    public boolean ejecutar(String nombreUsuario)
    {
        DTOCliente dtoCliente = servicioCliente.obtenerDatosClienteDeUsuario(nombreUsuario);

        if (dtoCliente == null)
        {
            Collection<Usuario> usuarios = accesoDatos.BuscarObjetosPorCaracteristica(Usuario.class, "nombreUsuario", nombreUsuario);

            for (Usuario usuario : usuarios)
            {
                ejecutarAccionUsuario(usuario);
                
                accesoDatos.Guardar(usuario);

                return true;
            }

            return false;

        }
        else
        {
            return ejecutarAccionCliente(dtoCliente.getIdContacto());
            
        }
    }

    protected abstract void ejecutarAccionUsuario(Usuario usuario);
    protected abstract boolean ejecutarAccionCliente(String idCliente);

}
