/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Traductores;

import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;

/**
 *
 * @author Federico
 */
public abstract class EstrategiaTraduccionCliente extends EstrategiaTraduccionContacto {

    protected DTOCliente iniciarCliente(Cliente objetoNegocio)
    {
        DTOCliente dtoCliente = (DTOCliente)iniciarContacto(objetoNegocio);

        dtoCliente.setCantidadDePuntosPermitidos(objetoNegocio.getCantidadDePuntosPermitidos());
        dtoCliente.setCantidadDePuntosQuePosee(objetoNegocio.getPuntosDeCliente().size());
        dtoCliente.setEstadoCliente(objetoNegocio.getEstado().getNombreDeEstado());

        return dtoCliente;
    }

    protected Cliente iniciarCliente(DTOCliente dto)
    {
        Cliente cliente = (Cliente)iniciarContacto(dto);

        cliente.setCantidadDePuntosPermitidos(dto.getCantidadDePuntosPermitidos());

        return cliente;
    }
}
