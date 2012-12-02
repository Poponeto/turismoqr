<%-- 
    Document   : ComboCategoria
    Created on : 15/11/2012, 22:08:44
    Author     : Chelo
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<div style="display: inline-block;" >
    <select id="categoria" name="categoria" size="1" >
        <option>
            Seleccione una categoria
        </option>
        <core:forEach var="categoria" items="${categorias}">
            <option value="<core:out value="${categoria.nombreCategoria}" />" id="${categoria.idCategoria}">
                <core:out value="${categoria.nombreCategoria}" />
            </option>
        </core:forEach>
    </select>
</div>

