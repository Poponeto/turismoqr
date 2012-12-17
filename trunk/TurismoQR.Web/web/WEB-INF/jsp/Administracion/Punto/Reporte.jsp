<%-- 
    Document   : Reporte
    Created on : 16/12/2012, 22:49:41
    Author     : Chelo
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
            <div id="reportePuntosPorUsuario" style="background: white; border: 2px solid brown !important; border-radius: 20px;">
                <h3>Cantidad de puntos por usuario</h3><br>
                <div id="tableUsuario"></div>
                <div id="chartUsuario"></div>
            </div>
            <br>
            <div id="reportePuntosPorCategoria" style="background: white; border: 2px solid brown !important; border-radius: 20px;">
                <h3>Cantidad de puntos por categoria</h3><br>
                <div id="tableCategoria"></div>
                <div id="chartCategoria"></div>
            </div>
            <br>
            <div id="reportePuntosCreadosPorMes" style="background: white; border: 2px solid brown !important; border-radius: 20px;">
                <h3>Cantidad de puntos creados por mes</h3>
                <h3>(Últimos cuatro meses)</h3><br>
                <div id="tableCreados"></div>
                <div id="chartCreados"></div>
            </div>
            <br>
            <div id="reportePuntosModificadosPorMes" style="background: white; border: 2px solid brown !important; border-radius: 20px;">
                <h3>Cantidad de puntos modificados por mes</h3>
                <h3>(Últimos cuatro meses)</h3><br>
                <div id="tableModificados"></div>
                <div id="chartModificados"></div>
            </div>
            <br>
            <div id="reporteVisitasPorPunto" style="background: white; border: 2px solid brown !important; border-radius: 20px;">
                <h3>Cantidad de visitas por punto</h3>
                <div id="tableVisitas"></div>
                <div id="chartVisitas"></div>
            </div>
        </div>
    </body>
</html>
