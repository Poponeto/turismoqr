/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;

import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import java.util.Collection;

/**
 *
 * @author ftacchini
 */


public interface IServicioCliente {

    public Boolean registrarCliente(IDTO dtoCliente);
    public Collection<DTOCliente> consultarClientes();
}