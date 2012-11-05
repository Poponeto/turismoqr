<%-- 
    Document   : RegistroPersona
    Created on : 03-nov-2012, 16:19:08
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="contenedorFormularioPersona">
            
            <fieldset>

                <label for="nombre">
                    Nombre<br>
                    <input id="nombre" name="nombre" type="text" placeholder="Ingrese Nombre Persona" required="true"/>
                </label>

                <label for="apellido">
                    Apellido:<br>
                    <input id="apellido" name="apellido" type="text" placeholder="Ingrese Apellido Persona" required="true"/>
                </label>

                <label for="dni">
                    DNI:<br>
                    <input id="dni" name="dni" type="text" placeholder="Ingrese DNI Persona" required="true"/>
                </label>

                <label for="fechaNacimiento">
                    Fecha De Nacimiento:<br>
                    <input id="fechaNacimiento" name="fechaNacimiento" type="text" placeholder="Ingrese Fecha de Nacimiento Persona" required="true"/>
                </label>

                <label for="selectGenero">Genero:<br>
                    <select id="selectGenero" size="1" >
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

    </body>
</html>
