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

        <fieldset>
            <legend> Informacion de Contacto de Empresa </legend>

            <div style="display: inline-block; width: 45%">
                <label>
                    Nombre<br>
                    <input id="lineaDatosNombreContactoEmpresa" name="nombre" type="text" required="true"/>
                </label>

                <label>
                    Apellido:<br>
                    <input id="lineaDatosApellidoContactoEmpresa" name="apellido" type="text" required="true"/>
                </label>

                <label>Genero:<br>
                    <select id="selectGeneroContactoEmpresa" name="sexo" size="1" >
                        <option value="Masculino" >
                            Masculino
                        </option>
                        <option value="Femenino" >
                            Femenino
                        </option>
                    </select>
                </label>

            </div>
            <div style="display: inline-block; margin-left: 5px; padding: 3px; width: 45%">
                <label>
                    Direccion de Correo:<br>
                    <input id="lineaDatosMailContactoEmpresa" name="mail" type="text" required="true"/>
                </label>

                <label>
                    Telefono Movil:<br>
                    <input id="lineaDatosCelularContactoEmpresa" name="celular" type="text" required="false"/>
                </label>

                <label>
                    Telefono Fijo:<br>
                    <input id="lineaDatosTelefonoFijoContactoEmpresa" name="telefonoFijo" type="text" required="false"/>
                </label>

            </div>

            <button id="botonEliminarContactoEmpresa" style="display: table">Eliminar</button>

        </fieldset>




    </body>
</html>
