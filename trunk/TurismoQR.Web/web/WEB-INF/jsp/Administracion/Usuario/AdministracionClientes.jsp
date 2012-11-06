<%-- 
    Document   : AdministracionClientes
    Created on : 06-nov-2012, 1:37:43
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/AdministracionClientes.js"></script>



        <script type="text/javascript" >
            $(document).ready(function(){

                inicializarComponentes();
                inicializarPaginaAdministracionClientes("${pageContext.request.contextPath}");
            });

        </script>

        <style TYPE="text/css">
            .ui-jqgrid {
                margin-left: auto;
                margin-right: auto;
            }
        </style>
    </head>
    <body>
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>
        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
        </div>
        <%@ include  file="/WEB-INF/jsp/Administracion/Usuario/TablaClientes.jsp" %>
</html>
