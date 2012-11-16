/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Estados.Ciclo;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Traductores.ITraductor;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author ftacchini
 */
public abstract class ServicioCliente extends ServicioContacto implements IServicioCliente
{

    public ServicioCliente(
            IAccesoDatos accesoDatos,
            ITraductor traductor)
    {
        super(accesoDatos, traductor);

    }

    public Boolean registrarCliente(IDTO dtoCliente)
    {
        return registrarContacto(dtoCliente).getIdObjeto() != null;
    }


    @Override
    protected Contacto registrarContacto(IDTO dtoContacto)
    {
        Cliente cliente = (Cliente) super.registrarContacto(dtoContacto);

        cliente.setCantidadDePuntosPermitidos(((DTOCliente)dtoContacto).getCantidadDePuntosPermitidos());
        cliente.setEstado(Ciclo.crearEstado(Ciclo.AUTORIZACION_PENDIENTE));

        completarCliente(cliente, dtoContacto);
        
        getAccesoDatos().Guardar(cliente);

        return cliente;
    }

    public Collection<DTOCliente> consultarClientes()
    {
        Collection<Cliente> clientes = getAccesoDatos().BuscarConjuntoObjetos(Cliente.class);

        Collection<DTOCliente> dtosCliente = new HashSet<DTOCliente>();

        for (Cliente cliente : clientes)
        {
            dtosCliente.add((DTOCliente) getTraductor().traducir(cliente));
        }

        return dtosCliente;
    }

    protected abstract void completarCliente(Cliente cliente, IDTO dtoCliente);
}
