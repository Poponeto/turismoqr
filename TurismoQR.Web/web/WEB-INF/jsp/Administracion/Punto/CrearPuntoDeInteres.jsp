<%-- 
    Document   : crearPuntoDeInteres
    Created on : 23/09/2012, 21:55:29
    Author     : Chelo
--%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Punto de Interes</title>

        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        
        <script type="text/javascript" src="http://blueimp.github.com/JavaScript-Templates/tmpl.min.js"></script>
        <script type="text/javascript" src="http://blueimp.github.com/JavaScript-Load-Image/load-image.min.js"></script>
        <script type="text/javascript" src="http://blueimp.github.com/JavaScript-Canvas-to-Blob/canvas-to-blob.min.js"></script>
        <script type="text/javascript" src="http://blueimp.github.com/cdn/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://blueimp.github.com/Bootstrap-Image-Gallery/js/bootstrap-image-gallery.min.js"></script>
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/style.css">
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
        <!--[if lt IE 7]><link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-ie6.min.css"><![endif]-->
        <link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/subirArchivoPopUp.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/InicializadorComponentes.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/IniciarPaginaCrearPunto.js"></script>

        <%@ include  file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
<!--        Temporal-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Administracion.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/navegacionFormularios.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/GaleriaImagenes/jquery.jcoverflip.js"></script>
<!--        Temporal-->
        <%@ include  file="/WEB-INF/jsp/Utils/ArchivosTextEditor.html" %>
        <%@ include  file="/WEB-INF/jsp/Utils/ArchivosPotatoMenu.html" %>
        <%@ include  file="/WEB-INF/jsp/Utils/ArchivosMapa.html" %>
        
        <script type="text/javascript">
            $(document).ready(function(){
                tqrmapas.iniciarMapas();
                iniciarCrearPunto();
                inicializarComponentes();
                tqrformnav.init($('fieldset'));
                $($('fieldset')[0]).show();
                $('#informacionPunto').wysiwyg();
                $('#galeriaImagenes').jcoverflip({current: 0});
            });

            function initGaleria() {

                var itemsGaleriaInicial = $('ul.ui-jcoverflip img');

                $('#galeriaImagenes').on('click', function() {
                    var itemsGaleria = $('ul.ui-jcoverflip img');

                    $(itemsGaleria[0]).click(function(event){
                        event.preventDefault();
                        event.stopPropagation();
                        return false;
                    });

                    var elementoEnContenedor = $('#contenedorPreviewImagenes').find('img');
                    var idElementoEnContenedor = elementoEnContenedor.attr('id');
                    if(idElementoEnContenedor != undefined &&
                        $.ui.jcoverflip.defaults.current != idElementoEnContenedor.substring(3, idElementoEnContenedor.length)) {
                        elementoEnContenedor.fadeOut(1000, function() {
                            $(this).remove();
                            $('#contenedorPreviewImagenes')
                            .append('<img id ="img'
                                + $.ui.jcoverflip.defaults.current
                                + '" style="display: none;" src="'
                                + $(itemsGaleria[$.ui.jcoverflip.defaults.current]).attr('src')
                                + '">');
                            $('#img' + $.ui.jcoverflip.defaults.current).fadeIn(1000);
                        })
                    } else {
                        $('#contenedorMensaje').remove();
                        $('#contenedorPreviewImagenes')
                            .append('<img id ="img'
                                + $.ui.jcoverflip.defaults.current
                                + '" style="display: none;" src="'
                                + $(itemsGaleria[$.ui.jcoverflip.defaults.current]).attr('src')
                                + '">');
                            $('#img' + $.ui.jcoverflip.defaults.current).fadeIn(1000);
                    }
                });
                
                $(itemsGaleriaInicial[1]).click();
            }
        </script>
    </head>
    <body style="padding: 0px;">
        
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
        </div>

        <div style="position: relative; padding: 0px 30px;" class="ui-widget-header">
            <div style="display: inline-block;">
                <h3>Crear nuevo punto de interes</h3>
            </div>
            <div style="display: inline-block; position: absolute; right: 30px; margin-top: -9px; top: 50%;" align="right">
                <%@ include  file="/WEB-INF/jsp/Utils/ComboIdiomas.jsp" %>
            </div>
        </div>

        <div style="padding: 30px;" class="ui-widget-content">
            <div id="contenedorPrincipal">
                <table id="contenidoPrincipal" style="width: 100%;">
                    <tr>
                        <td>
                            <div id="contenedorFormulario">
                                <form id="nuevoPuntoDeInteres" name="nuevoPuntoDeInteres" action="<core:url value='../crearPunto/guardarPuntoDeInteres.htm'/>" method="POST">
                                    <%@ include  file="/WEB-INF/jsp/Administracion/Punto/FormularioUbicacionPunto.jsp" %>
                                    <%@ include  file="/WEB-INF/jsp/Administracion/Punto/FormularioInformacionPunto.jsp" %>
                                    <%@ include  file="/WEB-INF/jsp/Administracion/Punto/FormularioImagenesPunto.jsp" %>
                                </form>
                            </div>
                        </td>
                        <td style="width: 50%;">
                            <div id="contenedorMapa"></div>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="navBar">
                <a id="previous" class="btn btn-success disabled" href="javascript:tqrformnav.anterior($('fieldset:visible'))">Anterior</a>
                <a id="next" class="btn btn-success" style="float: right;" href="javascript:tqrformnav.siguiente($('fieldset:visible'))">Siguiente</a>
            </div>
        </div>
                    
        <script id="template-upload" type="text/x-tmpl">
        {% for (var i=0, file; file=o.files[i]; i++) { %}
            <tr class="template-upload fade">
                <td class="preview" rowspan="2"><span class="fade"></span></td>
                <td class="name" rowspan="2"><span>{%=file.name%}</span></td>
                <td class="size" rowspan="2"><span>{%=o.formatFileSize(file.size)%}</span></td>
                {% if (file.error) { %}
                    <td class="error" colspan="2" rowspan="2"><span class="label">Complete</span></td>
                {% } else if (o.files.valid && !i) { %}
                    <td rowspan="2">
                        <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>
                    </td>
                    <td class="start">{% if (!o.options.autoUpload) { %}
                        <button class="btn btn-primary" onclick="ocultarCampoComentario();">
                            <i class="icon-upload icon-white"></i>
                            <span>Subir</span>
                        </button>
                    {% } %}</td>
                {% } else { %}
                    <td colspan="2"></td>
                {% } %}
                <td class="cancel">{% if (!i) { %}
                    <button class="btn btn-warning">
                        <i class="icon-ban-circle icon-white"></i>
                        <span>Cancelar</span>
                    </button>
                {% } %}</td>
            </tr>
            <tr class="template-upload fade">
                <td colspan="2" align="center">
                    <input type="button" class="btn btn-success" value="Agregar Comentario..." onclick="agregarInputComentario()"/>
                </td>
            </tr>
        {% } %}
        </script>
        <script id="template-download" type="text/x-tmpl">
        {% for (var i=0, file; file=o.files[i]; i++) { %}
            <tr class="template-download fade">
                {% if (file.error) { %}
                    <td></td>
                    <td class="name" rowspan="2"><span>{%=file.name%}</span></td>
                    <td class="size" rowspan="2"><span>{%=o.formatFileSize(file.size)%}</span></td>
                    <td class="error" rowspan="2" colspan="2"><span class="label">Completo</span></td>
                {% } else { %}
                    <td class="preview" rowspan="2">{% if (file.thumbnail_url) { %}
                        <a href="{%=file.url%}" title="{%=file.name%}" rel="gallery" download="{%=file.name%}"><img src="{%=file.thumbnail_url%}"></a>
                    {% } %}</td>
                    <td class="name" rowspan="2">
                        <a href="{%=file.url%}" title="{%=file.name%}" rel="{%=file.thumbnail_url&&'gallery'%}" download="{%=file.name%}">{%=file.name%}</a>
                    </td>
                    <td class="size" rowspan="2"><span>{%=o.formatFileSize(file.size)%}</span></td>
                    <td colspan="2"></td>
                {% } %}
<!--                <td class="delete" rowspan="2">
                    <button class="btn btn-danger" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}">
                        <i class="icon-trash icon-white"></i>
                        <span>Delete</span>
                    </button>
                </td>-->
            </tr>
        {% } %}
        </script>

        <div id="dialog">
            <div>
                <form id="fileupload" action="<core:url value='../crearPunto/subirArchivo.htm'/>" method="POST" enctype="multipart/form-data">
                    <table role="presentation" class="table table-striped"><tbody class="files" data-toggle="modal-gallery" data-target="#modal-gallery"></tbody></table>
                    <div id="archivos">
                        <span class="btn btn-success fileinput-button">
                            <i class="icon-plus icon-white"></i>
                            <span>Seleccionar imagenes...</span>
                            <input type="file" name="files" id="files" commandName="formularioArchivo" multiple>
                        </span>
                        <input id="idioma" name="idioma" type="text" style="display: none;"/>
                        <input class="btn btn-primary start" value="Subir imagenes" onclick="subirArchivos()"/>
                    </div>
                </form>
            </div>
        </div>
        <div>
            <core:forEach var="detallesImagen" items="${detallesImagen}">
                <core:out value="${detallesImagen.url}" />
            </core:forEach>
        </div>
    </body>
    <%@ include  file="/WEB-INF/jsp/Utils/ArchivosFileUpload.html" %>
</html>
