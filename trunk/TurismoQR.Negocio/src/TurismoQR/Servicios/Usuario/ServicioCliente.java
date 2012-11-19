/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.ObjetosNegocio.Estados.Ciclo;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Traductores.ITraductor;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ftacchini
 */

@Transactional
public abstract class ServicioCliente extends ServicioContacto implements IServicioCliente
{

    private ManejadorUsuarios manejadorGuardado;

    public ServicioCliente(
            IAccesoDatos accesoDatos,
            ITraductor traductor,
            ManejadorUsuarios manejadorGuardado)
    {
        super(accesoDatos, traductor);
        this.manejadorGuardado = manejadorGuardado;
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

    public Boolean autorizarCliente(String idCliente)
    {
        Cliente cliente = getAccesoDatos().BuscarObjeto(Cliente.class, idCliente);
        cliente.setEstado(Ciclo.crearEstado(Ciclo.HABILITADO));

        cliente.setUsuario(manejadorGuardado.crearUsuario(getNombreCliente(cliente)));

        getAccesoDatos().Guardar(cliente);
        
        return cliente.getEstado().getNombreDeEstado().equals(Ciclo.HABILITADO);
    }

    public Boolean actualizarDatosCliente(IDTO dto)
    {
        DTOCliente dtoCliente = (DTOCliente)dto;

        Cliente cliente = getAccesoDatos().BuscarObjeto(Cliente.class, dtoCliente.getIdContacto());

        cliente.setMail(dtoCliente.getMail());
        cliente.setTelefonoFijo(dtoCliente.getTelefonoFijo());
        cliente.setCelular(dtoCliente.getCelular());
        cliente.setCantidadDePuntosPermitidos(dtoCliente.getCantidadDePuntosPermitidos());

        getAccesoDatos().Guardar(cliente);

        return cliente.getIdObjeto() != null;

    }


    protected abstract void completarCliente(Cliente cliente, IDTO dtoCliente);
    protected abstract String getNombreCliente(Cliente cliente);
}
