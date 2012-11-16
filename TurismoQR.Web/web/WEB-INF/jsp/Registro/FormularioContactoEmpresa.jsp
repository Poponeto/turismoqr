<%-- 
    Document   : FormularioContactoEmpresa
    Created on : Nov 15, 2012, 5:12:11 PM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Contacto Empresa</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <div id="contenedorFormularioContactoEmpresa">

            <fieldset>

                <label for="lineaDatosNombre">
                    Nombre<br>
                    <input id="lineaDatosNombreContactoEmpresa" name="nombre" type="text" required="true"/>
                </label>

                <label for="lineaDatosApellido">
                    Apellido:<br>
                    <input id="lineaDatosApellidoContactoEmpresa" name="apellido" type="text" required="true"/>
                </label>
                
                <label for="selectGenero">Genero:<br>
                    <select id="selectGeneroContactoEmpresa" name="sexo" size="1" >
                        <option value="Masculino" >
                            Masculino
                        </option>
                        <option value="Femenino" >
                            Femenino
                        </option>
                    </select>
                </label>

            </fieldset>

        </div>

        <%@ include file = "/WEB-INF/jsp/Registro/FormularioContacto.jsp" %>
    </body>
</html>
