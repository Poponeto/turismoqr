/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;
import TurismoQR.AccesoDatos.IAccesoDatos;
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
public class ServicioContactoEmpresa extends ServicioContacto{

    @Autowired
    public ServicioContactoEmpresa(
            IAccesoDatos accesoDatos,
            ITraductor traductor)
    {
        super(accesoDatos, traductor);

    }

}
