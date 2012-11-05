/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.AccesoDatosEmpresa;
import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Categorias.Rubro;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosNegocio.Usuarios.ContactoEmpresa;
import TurismoQR.ObjetosNegocio.Usuarios.Empresa;
import TurismoQR.ObjetosTransmisionDatos.DTOContactoEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Traductores.ITraductor;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */
@Transactional
@Service
public class ServicioEmpresa extends ServicioCliente
{

    ServicioContacto servicioContactoEmpresa;

    @Autowired
    public ServicioEmpresa(
            IAccesoDatos accesoDatosEmpresa,
            ITraductor traductor,
            ServicioContacto servicioContactoEmpresa)
    {
        super(accesoDatosEmpresa, traductor);
        this.servicioContactoEmpresa = servicioContactoEmpresa;
    }

    @Override
    protected void completarCliente(Cliente cliente, IDTO dtoCliente)
    {
        //Necesitamos agregarle el Rubro y contactos
        AccesoDatosEmpresa accesoDatos = (AccesoDatosEmpresa) getAccesoDatos();
        Rubro rubro = accesoDatos.buscarRubroPorNombre(((DTOEmpresa) dtoCliente).getRubro());

        Collection<ContactoEmpresa> contactosEmpresa = new HashSet<ContactoEmpresa>();
        ((Empresa) cliente).setContactos(contactosEmpresa);

        for (DTOContactoEmpresa dtoContactoEmpresa : ((DTOEmpresa) dtoCliente).getContactos())
        {
            contactosEmpresa.add((ContactoEmpresa) servicioContactoEmpresa.registrarContacto(dtoContactoEmpresa));
        }

        ((Empresa) cliente).setRubro(rubro);
    }
}
