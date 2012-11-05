<%-- 
    Document   : RegistroCliente
    Created on : Sep 13, 2012, 12:36:15 PM
    Author     : ftacchini
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <script type="text/javascript">

            $(document).ready(function(){
                inicializarComponentes();
            });
        </script>
        
    </head>
    <body>
        <div>

            <core:import url="${pageContext.request.contextPath}/${formularioCliente}"/>

            <fieldset>
                <label for="cantidadDePuntosDeseados">
                    Cantidad de Puntos:<br>
                    <input id="cantidadDePuntosDeseados" name="cantidadDePuntosDeseados" type="text" placeholder="Ingrese cantidad de Puntos Comerciales que desea manejar" required="false"/>
                </label>

            </fieldset>

            <%@ include file = "/WEB-INF/jsp/FormularioContacto.jsp" %>

            <div>
                <button name="Registrarse!"/>
            </div>


        </div>
    </body>
</html>
