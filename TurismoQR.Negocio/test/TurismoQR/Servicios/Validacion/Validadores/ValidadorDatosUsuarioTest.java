/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TurismoQR.Servicios.Validacion.Validadores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Validacion.Errores;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author MARIANO
 */
public class ValidadorDatosUsuarioTest {
    
    public ValidadorDatosUsuarioTest() {
    }

    /**
     * Test of soportaObjeto method, of class ValidadorDatosUsuario.
     */
    @Test
    public void testSoportaObjeto()
    {        
        DTOUsuario dtoUsuario = mock(DTOUsuario.class);
        IAccesoDatos accesoDatos = mock(IAccesoDatos.class);

        ValidadorDatosUsuario validadorDatosUsuario = new ValidadorDatosUsuario();
        boolean resultadoDTOUsuario = validadorDatosUsuario.soportaObjeto(dtoUsuario);

        assertTrue(resultadoDTOUsuario);
    }

    /**
     * Test of validar method, of class ValidadorDatosCliente.
     */
    @Test
    public void testValidarExito() {
        //Errores errores1 = mock(Errores.class);
        //Errores errores2 = mock(Errores.class);

        DTOUsuario dtoUsuario = mock(DTOUsuario.class);
        IAccesoDatos accesoDatos = mock(IAccesoDatos.class);

        when(dtoUsuario.getNombreUsuario()).thenReturn("pablogonzalez");
        when(dtoUsuario.getContraseña()).thenReturn("Con!123");
        when(dtoUsuario.getUsername()).thenReturn("pablogonzalez");
        when(dtoUsuario.getPassword()).thenReturn("Con!123");
        
        //ValidadorDatosUsuario validadorDatosUsuario = new ValidadorDatosUsuario(accesoDatos);
        //validadorDatosUsuario.validar(dtoUsuario, errores1);
        //validadorDatosUsuario.validar(dtoUsuario, errores2);

        //verify(errores1, times(0)).agregarError(eq("fechaDeNacimiento"), eq("La fecha de nacimiento no puede ser posterior a la fecha actual."));
        //verify(errores2, times(0)).agregarError(eq("cantidadDePuntosPermitidos"), eq("La cantidad de puntos solicitada no puede ser mayor a 15."));

    }

    @Test
    public void testValidarFracaso() {
        Errores errores1 = mock(Errores.class);
        Errores errores2 = mock(Errores.class);
        Errores errores3 = mock(Errores.class);
        Errores errores4 = mock(Errores.class);

        DTOUsuario dtoUsuario = mock(DTOUsuario.class);
        IAccesoDatos accesoDatos = mock(IAccesoDatos.class);
        
        when(dtoUsuario.getNombreUsuario()).thenReturn(null).thenReturn("").thenReturn("pablo23").thenReturn("pablo!");
        when(dtoUsuario.getContraseña()).thenReturn(null).thenReturn("").thenReturn("1234").thenReturn("012345678901234567890");
        when(dtoUsuario.getUsername()).thenReturn(null).thenReturn("").thenReturn("pablogonzalez");
        when(dtoUsuario.getPassword()).thenReturn(null).thenReturn("").thenReturn("123456");

        ValidadorDatosUsuario validadorDatosUsuario = new ValidadorDatosUsuario(accesoDatos);
        validadorDatosUsuario.validar(dtoUsuario, errores1);
        validadorDatosUsuario.validar(dtoUsuario, errores2);
        validadorDatosUsuario.validar(dtoUsuario, errores3);
        validadorDatosUsuario.validar(dtoUsuario, errores4);



        verify(errores1, times(1)).agregarError(eq("nombreUsuario"), eq("Debe especificar un nombre de usuario."));
        verify(errores2, times(1)).agregarError(eq("nombreUsuario"), eq("Debe especificar un nombre de usuario."));
        verify(errores3, times(1)).agregarError(eq("nombreUsuario"), eq("El nombre de usuario es inválido. Debe contener sólo letras."));
        verify(errores4, times(1)).agregarError(eq("nombreUsuario"), eq("El nombre de usuario es inválido. Debe contener sólo letras."));
        
        verify(errores1, times(1)).agregarError(eq("contraseña"), eq("Debe especificar una contraseña."));
        verify(errores2, times(1)).agregarError(eq("contraseña"), eq("Debe especificar una contraseña."));
        verify(errores3, times(1)).agregarError(eq("contraseña"), eq("Debe contener al menos 6 caracteres."));
        verify(errores4, times(1)).agregarError(eq("contraseña"), eq("Debe contener no más de 20 caracteres."));
        
        verify(errores1, times(1)).agregarError(eq("username"), eq("Debe especificar un username."));
        verify(errores2, times(1)).agregarError(eq("username"), eq("Debe especificar un username."));
        verify(errores3, times(1)).agregarError(eq("username"), eq("El username debe ser igual que el nombre de usuario."));
                
        verify(errores1, times(1)).agregarError(eq("password"), eq("Debe especificar un password."));
        verify(errores2, times(1)).agregarError(eq("password"), eq("Debe especificar un password."));
        verify(errores3, times(1)).agregarError(eq("password"), eq("El password debe ser igual que la contraseña."));

        /*
        verify(errores1, times(1)).agregarError(eq("nombreUsuario"), eq("Debe especificar un nombre de usuario."));
        verify(errores1, times(1)).agregarError(eq("contraseña"), eq("Debe especificar una contraseña."));
        verify(errores1, times(1)).agregarError(eq("username"), eq("Debe especificar un username."));
        verify(errores1, times(1)).agregarError(eq("password"), eq("Debe especificar un password."));
        
        verify(errores2, times(1)).agregarError(eq("nombreUsuario"), eq("Debe especificar un nombre de usuario."));
        verify(errores2, times(1)).agregarError(eq("contraseña"), eq("Debe especificar una contraseña."));
        verify(errores2, times(1)).agregarError(eq("username"), eq("Debe especificar un username."));
        verify(errores2, times(1)).agregarError(eq("password"), eq("Debe especificar un password."));

        verify(errores3, times(1)).agregarError(eq("nombreUsuario"), eq("El nombre de usuario es inválido. Debe contener sólo letras."));
        verify(errores3, times(1)).agregarError(eq("contraseña"), eq("Debe contener al menos 6 caracteres."));
        verify(errores3, times(1)).agregarError(eq("username"), eq("El username debe ser igual que el nombre de usuario."));
        verify(errores3, times(1)).agregarError(eq("password"), eq("El password debe ser igual que la contraseña."));

        verify(errores4, times(1)).agregarError(eq("nombreUsuario"), eq("El nombre de usuario es inválido. Debe contener sólo letras."));
        verify(errores4, times(1)).agregarError(eq("contraseña"), eq("Debe contener no más de 20 caracteres."));
        */
    }
    
}
