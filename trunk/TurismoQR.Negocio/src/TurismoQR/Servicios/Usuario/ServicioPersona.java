/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;
import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosNegocio.Usuarios.Cliente;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
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
            ITraductor traductor)
    {
        super(accesoDatos, traductor);

    }

    @Override
    protected void completarCliente(Cliente cliente, IDTO dtoCliente)
    {
        //No hace falta hacer nada
    }


}
