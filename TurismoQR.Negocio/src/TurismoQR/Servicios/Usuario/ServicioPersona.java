/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;
import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosNegocio.Usuarios.Persona;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Servicios.Mail.IServicioEnvioMail;
import TurismoQR.Traductores.ITraductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Federico
 */

@Transactional
@Service
public class ServicioPersona extends ServicioCliente{

    @Autowired
    public ServicioPersona(
            IAccesoDatos accesoDatos,
            ITraductor traductor,
            ManejadorUsuarios manejadorGuardado,
            IServicioEnvioMail servicioEnvioMail)
    {
        super(accesoDatos, traductor, manejadorGuardado, servicioEnvioMail);

    }

    @Override
    protected void completarCliente(Cliente cliente, IDTO dtoCliente)
    {
        //No hace falta hacer nada
    }

    @Override
    protected String getNombreCliente(Cliente cliente)
    {
        return ((Persona)cliente).getApellido() + ((Persona)cliente).getNombre();
    }

    @Override
    protected String getMensajeRegistracion(Cliente cliente)
    {
        String cabecera = "Gracias por registrarse en TurismoQR, "
                + "su solicitud está siendo atendida y "
                + "se responderá a la brevedad.";
        String cuerpo = "Sus datos son: " +
                "\nApellido: " + ((Persona)cliente).getApellido() +
                "\nNombre: " + ((Persona)cliente).getNombre() +
                "\nFecha de Nacimiento: " + ((Persona)cliente).getFechaDeNacimiento() +
                "\nTelefono Fijo: " + ((Persona)cliente).getTelefonoFijo() +
                "\nTelefono Movil: " + ((Persona)cliente).getCelular();

        return cabecera + "\n\n" + cuerpo;
    }

}
