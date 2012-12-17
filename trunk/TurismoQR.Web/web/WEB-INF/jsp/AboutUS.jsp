<%-- 
    Document   : AboutUS
    Created on : 06-oct-2012, 16:20:06
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/FileUploadPlugin/vendor/jquery.ui.widget.js"></script>
<!--        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">-->
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery.PrintArea.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/InicializadorComponentes.js"></script>

        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript">

            $(document).ready(function(){
                inicializarComponentes();
            });
            
          // Load the Visualization API and the piechart package.
          google.load('visualization', '1.0', {'packages':['corechart','table']});

          // Set a callback to run when the Google Visualization API is loaded.
          google.setOnLoadCallback(drawVisualization);

          function drawVisualization() {
              drawVisualizationUsuarios();
              drawVisualizationCategoria();
              drawVisualizationCreados();
              drawVisualizationModificados();
              drawVisualizationVisitas();
          }

            function drawVisualizationUsuarios() {
              var dataTable = google.visualization.arrayToDataTable([
                ['Nombre de usuario',   'Cantidad de puntos']
                <c:forEach var="usuario" items="${puntosPorUsuario}">
                    ,['${usuario.nombreUsuario}',   ${usuario.cantidadPuntos}]
                  </c:forEach>
              ]);

              var table = new google.visualization.Table(document.getElementById('tableUsuario'));
              table.draw(dataTable, null);

              var dataView = new google.visualization.DataView(dataTable);
              dataView.setColumns([0, 1]);

              var chart = new google.visualization.ColumnChart(document.getElementById('chartUsuario'));
              chart.draw(dataView, {width: 400, height: 200});
            }
            
            function drawVisualizationCategoria() {
              var dataTable = google.visualization.arrayToDataTable([
                ['Nombre categoria',   'Cantidad de puntos']
                <c:forEach var="categoria" items="${puntosPorCategoria}">
                    ,['${categoria.categoria}',   ${categoria.cantidadPuntos}]
                  </c:forEach>
              ]);

              var table = new google.visualization.Table(document.getElementById('tableCategoria'));
              table.draw(dataTable, null);

              var dataView = new google.visualization.DataView(dataTable);
              dataView.setColumns([0, 1]);

              var chart = new google.visualization.ColumnChart(document.getElementById('chartCategoria'));
              chart.draw(dataView, {width: 400, height: 200});
            }

            function drawVisualizationCreados() {
              var dataTable = google.visualization.arrayToDataTable([
                ['Mes',   'Cantidad de puntos']
                <c:forEach var="creados" items="${puntosCreadosPorMes}">
                    ,['${creados.mes}',   ${creados.cantidadPuntos}]
                  </c:forEach>
              ]);

              var table = new google.visualization.Table(document.getElementById('tableCreados'));
              table.draw(dataTable, null);

              var dataView = new google.visualization.DataView(dataTable);
              dataView.setColumns([0, 1]);

              var chart = new google.visualization.ColumnChart(document.getElementById('chartCreados'));
              chart.draw(dataView, {width: 400, height: 200});
            }

            function drawVisualizationModificados() {
              var dataTable = google.visualization.arrayToDataTable([
                ['Mes',   'Cantidad de puntos']
                <c:forEach var="modificados" items="${puntosModificadosPorMes}">
                    ,['${modificados.mes}',   ${modificados.cantidadPuntos}]
                  </c:forEach>
              ]);

              var table = new google.visualization.Table(document.getElementById('tableModificados'));
              table.draw(dataTable, null);

              var dataView = new google.visualization.DataView(dataTable);
              dataView.setColumns([0, 1]);

              var chart = new google.visualization.ColumnChart(document.getElementById('chartModificados'));
              chart.draw(dataView, {width: 400, height: 200});
            }

            function drawVisualizationVisitas() {
              var dataTable = google.visualization.arrayToDataTable([
                ['Nombre punto',   'Cantidad de visitas']
                <c:forEach var="visitas" items="${cantidadVisitasPorPunto}">
                    ,['${visitas.nombrePunto}',   ${visitas.cantidadVisitas}]
                  </c:forEach>
              ]);

              var table = new google.visualization.Table(document.getElementById('tableVisitas'));
              table.draw(dataTable, null);

              var dataView = new google.visualization.DataView(dataTable);
              dataView.setColumns([0, 1]);

              var chart = new google.visualization.ColumnChart(document.getElementById('chartVisitas'));
              chart.draw(dataView, {width: 400, height: 200});
            }
        </script>
        <style type="text/css">
            h1, h3 {
                text-align: center;
            }
            div[id*="table"], div[id*="chart"] {
                padding: 10px;
            }
            div[id*="chart"] div {
                margin-left: auto;
                margin-right: auto;
            }
	</style>
    </head>
    <body>
        <div id="Cabecera" style="padding: 15px 30px; height: 70px;">
            <img alt="" src="${pageContext.request.contextPath}/Vistas/Imagenes/TurismoQRLogo.jpg" style="display: inline-block; margin-right: 15px;  height: 70px;"/>
            <img alt="" src="${pageContext.request.contextPath}/Vistas/Imagenes/TurismoQRTitulo.png" style="display: inline-block;  height: 60px;"/>
        </div>
        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
        </div>
        <div id="Contenido" style="padding: 15px 30px;" class="ui-widget-content">
            <div id="reportePuntosPorUsuario" style="background: white; border: 2px solid brown !important; border-radius: 20px; margin-left: 60px; margin-right: 60px">
                <div style="margin-left: 10px; margin-right: 10px">
                <h3>¿Quiénes somos?</h3><br>
                <p align=justify>&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0 Somos una empresa dedicada a brindar asistencia al turista mediante información sobre los distintos puntos, ya sean turísticos como comerciales, la cual, se podrá obtener a través de la consulta de un código QR con el uso de un Smarphones.
                </p>
                <p align=justify>&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0 El proyecto consiste en la distribución de códigos QR en puntos de interés de la ciudad, para luego ser utilizados como fuente de información sobre dichos puntos. Esto se conseguirá por medio de la lectura del código con un dispositivo móvil.
                </p>
                <p align=justify>&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0 Los puntos de interés deseados se encuentran cargados en esta misma página web. A estos puntos de interés se les asociará una posición en un mapa, así como también información adicional. Tras cargar los datos, el sistema generará el código deseado con la información necesaria para realizar luego una consulta a la web, tras la lectura del código por medio de un dispositivo móvil. Esta consulta nos proveerá de la información del sitio en que el turista se ubica (y desde donde leyó el código). También se contará con la posibilidad de realizar búsquedas relacionadas al punto de interés, como así también puntos de interés cercanos, filtrados por categorías, distancias, etc.
                </p>
                <p align=justify>&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0 Además de esto, el sistema provee de diferentes niveles y privilegios de acceso así como también de una interfaz amigable e interactiva. El sistema será configurable de acuerdo a las preferencias de usuario, la configuración de idioma es la que más se destacará en esta categoría. Para cumplir con este objetivo se proveerá además de una aplicación móvil encargada de la presentación de la información, pero de la cual el usuario no será dependiente, ya que la información también será accesible por medio del buscador del teléfono.
                </p>
                <p align=justify>&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0&#x00A0 Como último punto, pero no menos importante, podemos mencionar la generación de reportes y estadísticas que el sistema realizará, como por ejemplo lugares más visitados, relaciones entre los puntos de interés.
                </p>
                </div>
            </div>
        </div>
    </body>
</html>
