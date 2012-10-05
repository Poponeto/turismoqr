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
        <script type="text/javascript" src="../Vistas/JavaScript/Mapa.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/Mapas.css">
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
        </script>
    </head>
    <body>
        <div id="Contenedor">
            <div id="Cabecera">
                <h1>Turismo QR</h1>
                <%@ include  file="../Utils/MenuCabecera.jsp" %>
            </div>
            
            <div id="contenedorMapa"></div>

            <div id="BannerPaginaInicio">
                Banner
            </div>
        </div>
        <div id="Pie">
            <h1>Pie</h1>
        </div>
    </body>
</html>
