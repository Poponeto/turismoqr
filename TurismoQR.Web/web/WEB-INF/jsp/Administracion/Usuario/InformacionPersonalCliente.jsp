<%-- 
    Document   : InformacionPersonal
    Created on : Dec 5, 2012, 3:25:16 PM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Personal</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosError.html" %>

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/DatosContacto.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/InformacionPersonal.js"></script>

        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
        <!--[if lt IE 7]><link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-ie6.min.css"><![endif]-->
        <link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Fieldset.css">


        <script type="text/javascript">

            $(document).ready(function(){
                $("#Contenedor").hide();

                $.get('${pageContext.request.contextPath}/${formularioCliente}', function(data) {
                    $('#contenedorFormularioCliente').html(data);
                    inicializarComponentes();
                    inicializarComponentesInformacionPersonal("${tipoCliente}", "${pageContext.request.contextPath}");
                    setTimeout('inicializarDatosContacto();$("#Contenedor").show();', 1000);

                });
                
            });
        </script>
    </head>
    <body>
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
        </div>

        <div id="Contenedor">

            <div>
                <button id="botonGuardar">Guardar</button>
            </div>

            <div id="Contenido" style="padding: 30px;">
                <div id="contenedorFormularioCliente">
                </div>

                <%@ include file = "/WEB-INF/jsp/Registro/FormularioCliente.jsp" %>

                <%@ include file = "/WEB-INF/jsp/Registro/FormularioContacto.jsp" %>

                <div>
                    <button id="botonActualizar">Actualizar Informacion Personal</button>
                    <button id="botonCambiarContrasenia">Cambiar Contraseña</button>
                </div>


            </div>
        </div>
    </body>
</html>
