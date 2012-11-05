<%-- 
    Document   : RegistroContacto
    Created on : 03-nov-2012, 16:20:37
    Author     : Federico
--%>

<%@taglib prefix="core" uri="http://java.sun.com/jstl/core"%>

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
                <label for="mail">
                    Direccion de Correo:<br>
                    <input id="mail" name="mail" type="text" placeholder="Ingrese direccion de Correo Electronico" required="true"/>
                </label>

                <label for="celular">
                    Telefono Movil:<br>
                    <input id="celular" name="celular" type="text" placeholder="Ingrese numero de Telefono Movil" required="false"/>
                </label>

                <label for="telefonoFijo">
                    Telefono Fijo:<br>
                    <input id="telefonoFijo" name="telefonoFijo" type="text" placeholder="Ingrese numero de Telefono Fijo" required="false"/>
                </label>
            </fieldset>
        </div>
    </body>
</html>
