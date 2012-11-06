/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
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
        Contacto contacto = super.registrarContacto(dtoContacto);

        //Tareas necesarias para completar los datos de un cliente
        //Aca podria setearse el estado del cliente y el numero de
        completarCliente((Cliente) contacto, dtoContacto);
        
        getAccesoDatos().Guardar(contacto);

        return contacto;
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
