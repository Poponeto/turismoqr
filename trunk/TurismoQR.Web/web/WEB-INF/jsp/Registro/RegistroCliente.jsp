<%-- 
    Document   : RegistroCliente
    Created on : Sep 13, 2012, 12:36:15 PM
    Author     : ftacchini
--%>

<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar ${tipoCliente}</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosError.html" %>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/DatosContacto.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/RegistrarCliente.js"></script>
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
        <!--[if lt IE 7]><link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-ie6.min.css"><![endif]-->
        <link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Fieldset.css">


        <script type="text/javascript">

            $(document).ready(function(){
                inicializarComponentes();

                $.get('${pageContext.request.contextPath}/${formularioCliente}', function(data) {
                    $('#contenedorFormularioCliente').html(data);
                    inicializarComponentes();
                    inicializarComponentesRegistrarCliente("${tipoCliente}", "${pageContext.request.contextPath}");
                    setTimeout('inicializarDatosContacto();', 1000);

                });

                
            });
        </script>

        <style TYPE="text/css">
            input {
                width: 99%;
            }
            #botonRegistrarse {
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

            <div id="Contenido" style="padding: 30px;">
                <div id="contenedorFormularioCliente">
                </div>

                <%@ include file = "/WEB-INF/jsp/Registro/FormularioCliente.jsp" %>

                <%@ include file = "/WEB-INF/jsp/Registro/FormularioContacto.jsp" %>
                <div>
                    <button id="botonRegistrarse">Registrarse</button>
                </div>
            </div>
        </div>
    </body>
</html>
