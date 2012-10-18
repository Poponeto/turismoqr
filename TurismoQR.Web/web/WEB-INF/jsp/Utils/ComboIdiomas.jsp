<%-- 
    Document   : ComboIdiomas
    Created on : Oct 18, 2012, 5:39:09 PM
    Author     : ftacchini
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="display: inline-block;" >
            <label style="display: inline-block;">Idioma: </label>
            <select id="idiomaSeleccionado" size="<core:out value="${idiomas.length}" />" >
                <core:forEach var="idioma" items="${idiomas}">
                    <option value="<core:out value="${idioma.nombreIdioma}" />">
                        <core:out value="${idioma.nombreIdioma}" />
                    </option>
                </core:forEach>
            </select>
        </div>
    </body>
</html>
