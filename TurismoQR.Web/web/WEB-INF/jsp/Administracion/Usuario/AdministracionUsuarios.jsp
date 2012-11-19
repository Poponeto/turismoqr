<%-- 
    Document   : AdministracionUsuarios
    Created on : 06-nov-2012, 0:20:17
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

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/AdministracionUsuarios.js"></script>


        <script type="text/javascript" >
            $(document).ready(function(){
                
                inicializarComponentes();
                inicializarPaginaAdministracionUsuarios("${pageContext.request.contextPath}");
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

        <div style="width: 50%; margin-left: 1%; margin-top: 15px" align="left">
            <%@ include  file="/WEB-INF/jsp/Administracion/Usuario/TablaUsuarios.jsp" %>
        </div>
    </body>
</html>
