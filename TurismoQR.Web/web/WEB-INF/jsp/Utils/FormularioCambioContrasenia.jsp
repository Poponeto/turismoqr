<%-- 
    Document   : FormularioCambioCuenta
    Created on : Dec 6, 2012, 2:52:46 PM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Cambio Cuenta</title>
        
    </head>
    <body>
        <fieldset id="contenedorDatosActuales">
            <legend> Datos Actuales </legend>
            <p>
                Nombre de Usuario: ${usuario}
            </p>
            <label id="lineaDatosPasswordActual" name="labelcontraseniaActual">
                Contraseña Actual
                <input name="contraseniaActual" id="contraseniaActual" type="password">
            </label>
        </fieldset>

        <fieldset id="contenedorNuevoPassword">
            <legend> Nueva Contraseña </legend>
            <label id="lineaDatosNuevoPassword" name="labelnuevaContrasenia">
                Nueva Contraseña
                <input name="nuevaContrasenia" id="nuevaContrasenia" type="password">
            </label>
            <label id="lineaDatosRepitaNuevoPassword">
                Repita Nueva Contraseña
                <input name="repitaPassword" id="repitaPassword" type="password">
            </label>
        </fieldset>
    </body>
</html>
