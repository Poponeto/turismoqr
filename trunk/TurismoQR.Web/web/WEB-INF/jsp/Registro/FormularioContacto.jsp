<%-- 
    Document   : RegistroContacto
    Created on : 03-nov-2012, 16:20:37
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Contacto</title>
    </head>
    <body>
        <div id="contenedorFormularioContacto">
            <fieldset>
                <legend> Informacion contacto </legend>
                <label for="lineaDatosMail" name="labelmail">
                    Direccion de Correo:<br>
                    <input id="lineaDatosMail" name="mail" type="text" required="true"/>
                </label>
                <label for="lineaDatosCelular" name="labelcelular">
                    Telefono Movil:<br>
                    <input id="lineaDatosCelular" name="celular" type="text" required="false"/>
                </label>
                <label for="lineaDatosTelefonoFijo" name="labeltelefonoFijo">
                    Telefono Fijo:<br>
                    <input id="lineaDatosTelefonoFijo" name="telefonoFijo" type="text" required="false"/>
                </label>
            </fieldset>
        </div>
    </body>
</html>
