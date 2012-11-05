<%-- 
    Document   : RegistroEmpresa
    Created on : 03-nov-2012, 16:19:21
    Author     : Federico
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
    </head>
    <body>
        <div id="contenedorFormularioEmpresa">
            <fieldset>

                <label for="cuit">
                    CUIT:<br>
                    <input id="cuit" name="cuit" type="text" placeholder="Ingrese CUIT de la Empresa" required="true"/>
                </label>

                <label for="razonSocial">
                    Razon Social:<br>
                    <input id="razonSocial" name="razonSocial" type="text" placeholder="Ingrese Razon Social de la Empresa" required="tru"/>
                </label>

                <label for="selectRubro">Rubro:<br>
                    <select id="selectRubro" size="1" >
                        <core:forEach var="rubro" items="${rubros}">
                            <option value="<core:out value="${rubro.nombreRubro}" />">
                                <core:out value="${rubro.nombreRubro}" />
                            </option>
                        </core:forEach>
                    </select>
                </label>

            </fieldset>

        </div>

    </body>
</html>
