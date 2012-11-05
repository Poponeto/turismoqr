<%-- 
    Document   : FormularioImagenesPunto
    Created on : 03/11/2012, 20:35:06
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
        <div id="contenedorPrincipalImagenes">
            <table id="contenidoPrincipalImagenes" style="width: 100%;">
                <tr>
                    <td>
                        <div id="contenedorFormulario">
                            <form name="imagenesPuntoDeInteres" action="<core:url value='../crearPunto/guardarPuntoDeInteres.htm'/>" method="POST">-->
                                <fieldset id="camposImagenesPunto" style="display : none;">
                                    <legend>Agregar imagenes al punto de interes</legend>
                                    <div>
<!--                                        <label for="informacionPunto">
                                            Informacion relacionada:<br>
                                            <textarea id="informacionPunto" name="informacionPunto" placeholder="Ingrese la informacion correspondiente al punto" rows="18" required="true"></textarea>
                                        </label>
                                        <br>-->
                                        <div style="width: 100%; text-align: center;">
                                            <%@ include  file="/WEB-INF/jsp/Administracion/Punto/GaleriaImagenes.jsp" %>
<!--                                                <div style="display: inline-block;">
                                                <label for="latitudPunto" style="display: inline-block;">
                                                    Latitud: <div id="latitudValue"></div><input type="text" id="latitudPunto" name="latitudPunto" style="display:none"/>
                                                </label>
                                                <label for="informacionPunto" style="display: inline-block;">
                                                    Longitud: <div id="longitudValue"></div><input type="text" id="longitudPunto" name="longitudPunto" style="display:none"/>
                                                </label>-->
<!--                                                </div>-->
<!--                                                <div style="display: inline-block; position: absolute; top: 0px; right: 0px;">
-->                                                <a id="dialog_link" class="btn btn-success" style="color: white; float: left; margin-top: 20px;" href="#">Agregar Imagen...</a><!--
                                            </div>-->
                                        </div>
                                    </div>
                                </fieldset>
<!--                                <input id="idioma" name="idioma" type="text" style="display: none;"/>
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
