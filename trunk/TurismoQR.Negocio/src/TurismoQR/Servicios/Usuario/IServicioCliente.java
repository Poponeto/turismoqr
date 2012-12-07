/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;

import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTORubro;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import java.util.Collection;

/**
 *
 * @author ftacchini
 */


public interface IServicioCliente {

    public Boolean registrarCliente(IDTO dtoCliente);
    public Boolean autorizarCliente(String idCliente);
    public Boolean actualizarDatosCliente(IDTO dtoCliente);
    public Boolean eliminarCliente(String idCliente);
    public Collection<DTOCliente> consultarClientes();
    public Collection<DTORubro> obtenerRubrosPosibles();
    public Boolean reiniciarContraseñaCliente(String idCliente);
    public Boolean desbloquearCliente(String idCliente);
    public DTOCliente datosClienteActual(String nombreUsuaro);
}