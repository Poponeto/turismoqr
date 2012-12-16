<%-- 
    Document   : InformacionPersonalUsuario
    Created on : 09-dic-2012, 15:55:34
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Personal del Usuario</title>

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/DatosCambioContrasenia.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/ProcesamientoError.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/InformacionPersonal.js"></script>

        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
        <!--[if lt IE 7]><link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-ie6.min.css"><![endif]-->
        <link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosError.html" %>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Fieldset.css">

        <script type="text/javascript" >
            $(document).ready(function(){

                inicializarComponentes();
                inicializarDatosCambioContraseña();
                inicializarComponentesInformacionUsuario("${usuario}", "${pageContext.request.contextPath}");
            });

        </script>

        <style TYPE="text/css">
            #popUpFormularioCambioContrasenia input {
                width: 99%;
            }
        </style>

    </head>
    <body>

        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
        </div>

        <div id="Contenedor">
            <div id="Contenido">
                <div id="contenedorInformacionUsuario" style="padding: 20px;">


                    <div id="contenedorInformacionUsuario">

                        <label id="labelNombreUsuario" name="labelnombreUsuario">
                            Nombre de Usuario:
                            <input id="nombreUsuario" name="nombreUsuario" type="text">
                        </label>


                    </div>

                    <div id="contenedorAccionesInformacionPersonal" style="width: 25%">
                        <button id="botonGuardarNombreUsuario" style="width: 100%">Guardar</button>
                        <button id="botonCambiarNombreUsuario" style="width: 100%">Cambiar Nombre de Usuario</button>
                        <button id="botonCambiarContrasenia" style="width: 100%">Cambiar Contraseña</button>
                    </div>
                </div>
                <div id="popUpFormularioCambioContrasenia">
                    <%@ include  file="/WEB-INF/jsp/Utils/FormularioCambioContrasenia.jsp" %>
                </div>
            </div>
        </div>
    </body>
</html>
