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
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQGrid.html" %>
    </head>
    <body>
        <div id="contenedorFormularioEmpresa">
            <fieldset>
                <legend> Datos de la Empresa </legend>
                <label for="lineaDatoscuit">
                    CUIT:<br>
                    <input id="lineaDatosCuit" name="cuit" type="text" required="true"/>
                </label>
                <br>
                <label for="lineaDatosRazonSocial">
                    Razon Social:<br>
                    <input id="lineaDatosRazonSocial" type="text" name="razonSocial" required="tru"/>
                </label>
                <br>
                <label for="selectRubro">Rubro:<br>
                    <select id="selectRubro" name="rubro" size="1" >
                        <core:forEach var="rubro" items="${rubros}">
                            <option value="<core:out value="${rubro.nombreRubro}" />">
                                <core:out value="${rubro.nombreRubro}" />
                            </option>
                        </core:forEach>
                    </select>
                </label>

                <button id="botonAgregarContacto">Agregar Contacto</button>

                <div id="contenedorFormularioContactoEmpresa1" class="contactoEmpresa" contactNumber="1">
                    <%@ include  file="/WEB-INF/jsp/Registro/FormularioContactoEmpresa.jsp" %>
                </div>

                <div id="contenedorFormularioContactoEmpresa2" class="contactoEmpresa" contactNumber="2">
                    <%@ include  file="/WEB-INF/jsp/Registro/FormularioContactoEmpresa.jsp" %>

                </div>

                <div id="contenedorFormularioContactoEmpresa3" class="contactoEmpresa" contactNumber="3">
                    <%@ include  file="/WEB-INF/jsp/Registro/FormularioContactoEmpresa.jsp" %>

                </div>

                <div id="contenedorFormularioContactoEmpresa4" class="contactoEmpresa" contactNumber="4">
                    <%@ include  file="/WEB-INF/jsp/Registro/FormularioContactoEmpresa.jsp" %>

                </div>

                <div id="contenedorFormularioContactoEmpresa5" class="contactoEmpresa" contactNumber="5">
                    <%@ include  file="/WEB-INF/jsp/Registro/FormularioContactoEmpresa.jsp" %>
                </div>

            </fieldset>



        </div>

    </body>
</html>
