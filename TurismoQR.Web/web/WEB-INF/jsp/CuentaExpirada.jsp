<%-- 
    Document   : CuentaExpirada
    Created on : Dec 6, 2012, 11:31:17 AM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuenta Expirada</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosError.html" %>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/DatosCambioContrasenia.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/ProcesamientoError.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/CuentaExpirada.js"></script>

        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
        <!--[if lt IE 7]><link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-ie6.min.css"><![endif]-->
        <link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Fieldset.css">


        <script type="text/javascript">

            $(document).ready(function(){
                inicializarComponentes();
                inicializarDatosCuentaExpirada('${pageContext.request.contextPath}');
            });
        </script>

            <style TYPE="text/css">
            input {
                width: 99%;
            }
            #botonActualizarContraseña {
                width: 25%;
                display: block;
                margin-left: auto;
                margin-right: auto;
            }
        </style>
    </head>
    <body>
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="Contenedor">
            <div id="Contenido">
                <div style="padding:10px; margin-left:10px">
                    <h4>Su cuenta a expirado, necesita reiniciar la contraseña para continuar.</h4>
                </div>
                <%@ include  file="/WEB-INF/jsp/Utils/FormularioCambioContrasenia.jsp" %>

                <button id="botonActualizarContraseña">
                    Actualizar Contraseña
                </button>
            </div>
        </div>
    </body>
</html>
