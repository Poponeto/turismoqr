/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosNegocio.Usuarios.Contacto;
import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOPersona;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Traductores.ITraductor;

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

    protected abstract void completarCliente(Cliente cliente, IDTO dtoCliente);
}
