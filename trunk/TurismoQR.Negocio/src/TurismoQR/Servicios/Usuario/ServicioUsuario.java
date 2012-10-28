/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TurismoQR.Servicios.Usuario;

import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.ObjetosTransmisionDatos.IDTO;
import TurismoQR.Traductores.ITraductor;
import TurismoQR.Manejadores.ManejadorUsuarios.ManejadorUsuarios;
import TurismoQR.Manejadores.ManejadorLogin.ManejadorLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Federico
 */

@Transactional
@Service("servicioUsuario")
public class ServicioUsuario implements IServicioUsuario {


    private ManejadorLogin manejadorLogin;
    private ManejadorUsuarios manejadorGuardado;

    private ITraductor traductor;

    @Autowired
    public ServicioUsuario(ManejadorLogin manejadorLogin, ManejadorUsuarios manejadorGuardado, ITraductor traductor)
    {
        this.manejadorLogin = manejadorLogin;
        this.manejadorGuardado = manejadorGuardado;
        this.traductor = traductor;

    }

    public DTOUsuario cargarUsuario(String nombreUsuario) throws UsernameNotFoundException, DataAccessException
    {
        Usuario usuario = manejadorLogin.cargarUsuario(nombreUsuario);

        return (DTOUsuario)traductor.traducir(usuario);
    }

    public boolean crearUsuario(IDTO<Usuario> dtoUsuario)
    {
        Usuario usuario = traductor.traducir(dtoUsuario);

        return manejadorGuardado.guardarUsuario(usuario);
    }


}
