<%-- 
    Document   : PaginaAdministracion
    Created on : Sep 13, 2012, 10:37:56 AM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion TurismoQR</title>
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/Mapa.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/Mapas.css">
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/Administracion.css">
        
        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();

                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.obtenerUbicacionUsuario(function(){
                    tqrmapas.crearMapa();
                    tqrmapas.crearNuevoMarcador("Posicion actual", function(){
                        var posicionInicialMarcador = tqrmapas.obtenerLocalizacionMarcador(tqrmapas.marcador);
                        $('#latitudValue').text(posicionInicialMarcador.lat());
                        $('#longitudValue').text(posicionInicialMarcador.lng());
                    });
                });
            });
            
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
        </script>
    </head>
    <body style="margin: 0px;">
        <div id="Cabecera" style="padding: 15px 30px; height: 70px;">
            <img alt="" src="../Vistas/Imagenes/TurismoQRLogo.jpg" style="display: inline-block; margin-right: 15px;  height: 70px;"/>
            <img alt="" src="../Vistas/Imagenes/TurismoQRTitulo.png" style="display: inline-block;  height: 60px;"/>
        </div>
        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="../Utils/MenuCabecera.jsp" %>
        </div>
        <div id="Contenedor">
            <table id="contenidoPrincipal" style="width: 100%;">
                <tr>
                    <td style="width: 50%;">
                        <div id="contenedorMapa"></div>
                    </td>
                    <td>
                        <div id="Contenido">
                            <div class="slider-wrapper theme-default" style="background-color: black;">
                                <div id="slider" class="nivoSlider" style="height: 500px;">
                                        <img src="../Vistas/Imagenes/TQR5.jpg" data-thumb="../Vistas/Imagenes/TQR5.jpg" alt="" />
                                        <img src="../Vistas/Imagenes/TQR6.jpg" data-thumb="../Vistas/Imagenes/TQR6.jpg" alt="" />
                                        <img src="../Vistas/Imagenes/TQR7.jpg" data-thumb="../Vistas/Imagenes/TQR7.jpg" alt="" />
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>

        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/nivo-slider.css">
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/default.css">
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery.nivo.slider.js"></script>

    </body>
</html>
