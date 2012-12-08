/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Manejadores.ManejadorUsuarios;

import TurismoQR.AccesoDatos.AccesoDatosUsuario;
import TurismoQR.ConstantesDeNegocio;
import TurismoQR.ObjetosNegocio.Usuarios.Usuario;
import java.util.Collection;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ftacchini
 */
@Service("manejadorGuardado")
public class ManejadorUsuarios
{

    private AccesoDatosUsuario accesoDatosUsuario;

    @Autowired
    public ManejadorUsuarios(AccesoDatosUsuario accesoDatosUsuario)
    {
        this.accesoDatosUsuario = accesoDatosUsuario;
    }

    public boolean guardarUsuario(Usuario usuario)
    {
        try
        {
            accesoDatosUsuario.Guardar(usuario);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public Usuario crearUsuario(String nombreUsuario)
    {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContraseña(generarContraseniaAleatoria(ConstantesDeNegocio.MIN_LONGUITUD_PASS));
        return usuario;
    }

    public String generarContraseniaAleatoria(int longitud)
    {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud)
        {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'))
            {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public Collection<Usuario> obtenerUsuarios()
    {
        return accesoDatosUsuario.BuscarConjuntoObjetos(Usuario.class);
    }
}
