/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Usuario;

import TurismoQR.AccesoDatos.AccesoDatosEmpresa;
import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.ObjetosNegocio.Categorias.Rubro;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosNegocio.Usuarios.ContactoEmpresa;
import TurismoQR.ObjetosNegocio.Usuarios.Empresa;
import TurismoQR.ObjetosTransmisionDatos.DTOCliente;
import TurismoQR.ObjetosTransmisionDatos.DTOContactoEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTOEmpresa;
import TurismoQR.ObjetosTransmisionDatos.DTORubro;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Servicios.Mail.IServicioEnvioMail;
import TurismoQR.Traductores.ITraductor;
import java.util.ArrayList;
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
public class ServicioEmpresa extends ServicioCliente {

    ServicioContacto servicioContactoEmpresa;

    @Autowired
    public ServicioEmpresa(
            IAccesoDatos accesoDatosEmpresa,
            ITraductor traductor,
            ServicioContacto servicioContactoEmpresa,
            ManejadorUsuarios manejadorGuardado,
            IServicioEnvioMail servicioEnvioMail) {
        super(accesoDatosEmpresa, traductor, manejadorGuardado, servicioEnvioMail);
        this.servicioContactoEmpresa = servicioContactoEmpresa;
    }

    @Override
    protected void completarCliente(Cliente cliente, IDTO dtoCliente) {
        //Necesitamos agregarle el Rubro y contactos
        AccesoDatosEmpresa accesoDatos = (AccesoDatosEmpresa) getAccesoDatos();
        Rubro rubro = accesoDatos.buscarRubroPorNombre(((DTOEmpresa) dtoCliente).getRubro().getNombreRubro());

        Collection<ContactoEmpresa> contactosEmpresa = new HashSet<ContactoEmpresa>();
        ((Empresa) cliente).setContactos(contactosEmpresa);

        for (DTOContactoEmpresa dtoContactoEmpresa : ((DTOEmpresa) dtoCliente).getContactos()) {
            contactosEmpresa.add((ContactoEmpresa) servicioContactoEmpresa.registrarContacto(dtoContactoEmpresa));
        }

        ((Empresa) cliente).setRubro(rubro);
    }

    @Override
    protected String getNombreUsuarioParaCliente(Cliente cliente) {
        return ((Empresa) cliente).getCuit().replaceAll("-", "");
    }

    @Override
    protected String parsearDatosCliente(Cliente cliente) {
        String cuerpo =
                "\nRazon Social: " + ((Empresa) cliente).getRazonSocial()
                + "\nCUIT: " + ((Empresa) cliente).getCuit()
                + "\nTelefono Fijo: " + ((Empresa) cliente).getTelefonoFijo()
                + "\nTelefono Movil: " + ((Empresa) cliente).getCelular();

        return cuerpo;
    }

    @Override
    protected void actualizarCliente(Cliente cliente, IDTO dtoCliente) {
        Empresa empresa = (Empresa) cliente;

        DTOEmpresa dtoEmpresa = (DTOEmpresa) dtoCliente;

        empresa.setCuit(dtoEmpresa.getCuit());
        empresa.setRazonSocial(dtoEmpresa.getRazonSocial());

        AccesoDatosEmpresa accesoDatos = (AccesoDatosEmpresa) getAccesoDatos();
        Rubro rubro = accesoDatos.buscarRubroPorNombre(((DTOEmpresa) dtoCliente).getRubro().getNombreRubro());

        ((Empresa) cliente).getContactos().clear();

        for (DTOContactoEmpresa dtoContactoEmpresa : ((DTOEmpresa) dtoCliente).getContactos()) {
            ((Empresa) cliente).getContactos().add((ContactoEmpresa) servicioContactoEmpresa.registrarContacto(dtoContactoEmpresa));
        }

        ((Empresa) cliente).setRubro(rubro);
    }

    @Override
    protected void completarDatosInterfazCliente(Cliente cliente, DTOCliente dtoCliente) {
        if (dtoCliente instanceof DTOEmpresa) {
            DTOEmpresa dtoClienteActual = (DTOEmpresa) dtoCliente;

            dtoClienteActual.setRubro((DTORubro) getTraductor().traducir(((Empresa) cliente).getRubro()));

            Collection<DTOContactoEmpresa> dtoContactoEmpresa = new ArrayList<DTOContactoEmpresa>();

            for (ContactoEmpresa contactoEmpresa : ((Empresa) cliente).getContactos()) {
                dtoContactoEmpresa.add((DTOContactoEmpresa) getTraductor().traducir(contactoEmpresa));
            }

            dtoClienteActual.setContactos(dtoContactoEmpresa);

        }
    }
}
