<%-- 
    Document   : crearPuntoDeInteres
    Created on : 23/09/2012, 21:55:29
    Author     : Chelo
--%>
<%@taglib prefix="core" uri="http://java.sun.com/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Punto de Interes</title>
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/Mapa.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="<core:url value="/resources/dojo/dojo.js" />"> </script>
        <script type="text/javascript" src="<core:url value="/resources/spring/Spring.js" />"> </script>
        <script type="text/javascript" src="<core:url value="/resources/spring/Spring-Dojo.js" />"> </script>
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/Mapas.css">
        <script type="text/javascript">
            $(document).ready(function(){
                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.obtenerUbicacionUsuario(function(){
                    tqrmapas.crearMapa();
                    tqrmapas.crearNuevoMarcador("Posicion actual", function(){
                        var posicionInicialMarcador = tqrmapas.obtenerLocalizacionMarcador(tqrmapas.marcador);
                        $('#latitudValue').text(posicionInicialMarcador.lat());
                        $('#longitudValue').text(posicionInicialMarcador.lng());

                        google.maps.event.addListener(tqrmapas.marcador, 'position_changed', function(){
                            var posicionActualMarcador = tqrmapas.obtenerLocalizacionMarcador(this);
                            $('#latitudValue').text(posicionActualMarcador.lat());
                            $('#longitudValue').text(posicionActualMarcador.lng());
                        });
                    });
                });
            });
        </script>
    </head>
    <body>
        <h1>Crear nuevo punto de interes</h1>
        <div id="contenedorPrincipal">
            <div id="contenedorFormulario">
                <form name="crearPuntoDeInteres" action="<core:url value='/crearPunto/guardarPuntoDeInteres.htm'/>" method="POST">
                    <fieldset>
                        <legend>Datos punto de interes</legend>
                        <div>
                            <label for="nombrePunto">
                                Nombre:<br>
                                <input id="nombrePunto" name="nombrePunto" type="text" placeholder="Ingrese el nombre del punto de interes"/>
                            </label>
                            <br>
                            <label for="informacionPunto">
                                Informacion relacionada:<br>
                                <textarea id="informacionPunto" name="informacionPunto" placeholder="Ingrese la informacion correspondiente al punto" rows="18"></textarea>
                            </label>
                            <br>
                            <div style="display: inline-block;">
                                <label for="latitudPunto">
                                    Latitud: <div id="latitudValue"></div>
                                </label>
                                <label for="informacionPunto">
                                    Longitud: <div id="longitudValue"></div>
                                </label>
                            </div>
                            <div style="display: inline-block;">
                                <a href="<core:url value='/crearPunto/agregarImagen.htm'/>">Agregar Imagen...</a>
                            </div>
                            <br>
                            <div>
                                <input type="submit" value="Crear punto"/>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div id="contenedorMapa"></div>
        </div>
    </body>
</html>
