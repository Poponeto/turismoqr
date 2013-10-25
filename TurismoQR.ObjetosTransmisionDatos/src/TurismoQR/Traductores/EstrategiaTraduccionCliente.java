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

        dtoCliente.setCantidadDePuntosPermitidos(String.valueOf(objetoNegocio.getCantidadDePuntosPermitidos()));
        dtoCliente.setCantidadDePuntosQuePosee(String.valueOf(objetoNegocio.getPuntosDeCliente().size()));
        dtoCliente.setEstadoCliente(objetoNegocio.getEstado().getNombreDeEstado());
        dtoCliente.setUsuario(objetoNegocio.getUsuario().getIdObjeto());
        

        return dtoCliente;
    }

    protected Cliente iniciarCliente(DTOCliente dto)
    {
        Cliente cliente = (Cliente)iniciarContacto(dto);

        cliente.setCantidadDePuntosPermitidos(Integer.parseInt(dto.getCantidadDePuntosPermitidos()));

        return cliente;
    }
}
