<%-- 
    Document   : ComboIdiomas
    Created on : Oct 18, 2012, 5:39:09 PM
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

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/ComboIdiomas.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div style="display: inline-block;" >
            <label style="display: inline-block;">Idioma: </label>
            <select id="selectIdiomas" size="1" >
                <core:forEach var="idioma" items="${idiomas}">
                    <option value="<core:out value="${idioma.nombreIdioma}" />">
                        <core:out value="${idioma.nombreIdioma}" />
                    </option>
                </core:forEach>
            </select>
        </div>
    </body>
</html>
