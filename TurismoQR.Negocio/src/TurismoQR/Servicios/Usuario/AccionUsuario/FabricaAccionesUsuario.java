/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario.AccionUsuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.Servicios.Usuario.IServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Federico
 */
@Service
public class FabricaAccionesUsuario
{

    public final static int REINICIAR_CONTRASENIA = 1;
    public final static int DESBLOQUEAR_USUARIO = 2;
    public final static int BLOQUEAR_USUARIO = 3;
    private IServicioCliente servicioCliente;
    private IAccesoDatos accesoDatos;
    private ManejadorUsuarios manejadorGuardado;

    @Autowired
    public FabricaAccionesUsuario(IServicioCliente servicioPersona, IAccesoDatos accesoDatos, ManejadorUsuarios manejadorGuardado)
    {
        this.servicioCliente = servicioPersona;
        this.accesoDatos = accesoDatos;
        this.manejadorGuardado = manejadorGuardado;
    }

    public IAccionUsuario crearAccionUsuario(int accion)
    {
        switch (accion)
        {

            case REINICIAR_CONTRASENIA:
                return new AccionReinicioContrasenia(servicioCliente, accesoDatos, manejadorGuardado);

            case DESBLOQUEAR_USUARIO:
                return new AccionDesbloquearUsuario(servicioCliente, accesoDatos, manejadorGuardado);

            case BLOQUEAR_USUARIO:
                return new AccionBloquearUsuario(servicioCliente, accesoDatos, manejadorGuardado);

            default:
                return null;
        }

    }
}
