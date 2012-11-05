<%-- 
    Document   : FormularioInformacionPunto
    Created on : 03/11/2012, 20:34:53
    Author     : Chelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenedorPrincipalInformacion">
            <table id="contenidoPrincipalInformacion" style="width: 100%;">
                <tr>
                    <td>
                        <div id="contenedorFormulario">
                            <form name="informacionPuntoDeInteres" action="<core:url value='../crearPunto/guardarPuntoDeInteres.htm'/>" method="POST">-->
                                <fieldset id="camposInformacionPunto" style="display : none;">
                                    <legend>Informacion del punto de interes</legend>
                                    <div>
                                        <label for="informacionPunto">
                                            Informacion relacionada:<br>
                                            <textarea id="informacionPunto" name="informacionPunto" placeholder="Ingrese la informacion correspondiente al punto" rows="18" required="true"></textarea>
                                        </label>
                                    </div>
                                </fieldset>
                                <input id="idioma" name="idioma" type="text" style="display: none;"/>
                                <!--
                            </form>
                        </div>
                    </td>
                    <td style="width: 50%;">
                        <div id="contenedorMapa"></div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>-->
