<%-- 
    Document   : crearPuntoDeInteres
    Created on : 23/09/2012, 21:55:29
    Author     : Chelo
--%>

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
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/Mapas.css">
        <script>
            $(document).ready(function(){
                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.obtenerUbicacionUsuario(function(){
                    tqrmapas.crearMapa();
                    tqrmapas.crearNuevoMarcador("Posicion actual", function(){
                        var posicionInicialMarcador = tqrmapas.obtenerLocalizacionMarcador(tqrmapas.marcador);
                        $('#latitudPunto').attr('value', posicionInicialMarcador.lat());
                        $('#longitudPunto').attr('value', posicionInicialMarcador.lng());

                        google.maps.event.addListener(tqrmapas.marcador, 'position_changed', function(){
                            var posicionActualMarcador = tqrmapas.obtenerLocalizacionMarcador(this);
                            $('#latitudPunto').attr('value', posicionActualMarcador.lat());
                            $('#longitudPunto').attr('value', posicionActualMarcador.lng());
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
                <form name="crearPuntoDeInteres" action="<core:url value='/crearPunto/guardarPuntoDeInteres.htm'/>" method="GET">
                    <div>
                        <label for="nombrePunto">
                            Nombre del punto de interes:<br>
                            <input id="nombrePunto" type="text" placeholder="Ingrese el nombre del punto de interes"/>
                        </label>
                        <br>
                        <label for="informacionPunto">
                            Informacion relacionada con el punto de interes:<br>
                            <textarea id="informacionPunto" placeholder="Ingrese la informacion correspondiente al punto" rows="18"></textarea>
                        </label>
                        <br>
                        <label for="latitudPunto">
                            Latitud:<br>
                            <input id="latitudPunto" type="text" placeholder="Ingrese la latitud correspondiente al punto"/>
                        </label>
                        <br>
                        <label for="informacionPunto">
                            Longitud:<br>
                            <input id="longitudPunto" type="text" placeholder="Ingrese la longitud correspondiente al punto"/>
                        </label>
                        <br>
                        <div>
                            <input type="submit" value="Crear punto"/>
                        </div>
                    </div>
                </form>
            </div>
            <div id="contenedorMapa"></div>
        </div>
    </body>
</html>
