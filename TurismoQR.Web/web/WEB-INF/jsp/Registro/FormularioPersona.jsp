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
                <legend> Datos personales </legend>
                <label for="lineaDatosNombre" name="labelnombre">
                    Nombre<br>
                    <input id="lineaDatosNombre" name="nombre" type="text" required="true"/>
                </label>

                <label for="lineaDatosApellido" name="labelapellido">
                    Apellido:<br>
                    <input id="lineaDatosApellido" name="apellido" type="text" required="true"/>
                </label>

                <label for="lineaDatosdni" name="labeldni">
                    DNI:<br>
                    <input id="lineaDatosdni" name="dni" type="text" required="true"/>
                </label>

                <label for="lineaDatosFechaNacimiento" name="labelfechaDeNacimiento">
                    Fecha De Nacimiento:<br>
                    <input id="lineaDatosFechaNacimiento" name="fechaDeNacimiento" type="text" required="true"/>
                </label>


                <label for="selectGenero" name="labelsexo">Genero:<br>
                    <select id="selectGenero" name="sexo" size="1" >
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
