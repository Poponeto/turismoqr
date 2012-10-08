<%-- 
    Document   : crearPuntoDeInteres
    Created on : 23/09/2012, 21:55:29
    Author     : Chelo
--%>
<%@taglib prefix="core" uri="http://java.sun.com/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Punto de Interes</title>
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true"></script>

        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        
        <script type="text/javascript" src="http://blueimp.github.com/JavaScript-Templates/tmpl.min.js"></script>
        <script type="text/javascript" src="http://blueimp.github.com/JavaScript-Load-Image/load-image.min.js"></script>
        <script type="text/javascript" src="http://blueimp.github.com/JavaScript-Canvas-to-Blob/canvas-to-blob.min.js"></script>
        <script type="text/javascript" src="http://blueimp.github.com/cdn/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://blueimp.github.com/Bootstrap-Image-Gallery/js/bootstrap-image-gallery.min.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/FileUploadPlugin/vendor/jquery.ui.widget.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/FileUploadPlugin/jquery.iframe-transport.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/FileUploadPlugin/jquery.fileupload.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/FileUploadPlugin/jquery.fileupload-fp.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/FileUploadPlugin/jquery.fileupload-ui.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/FileUploadPlugin/main.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../../Vistas/HojasDeEstilo/Mapas.css">
        <link rel="stylesheet" type="text/css" href="../../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../Vistas/HojasDeEstilo/style.css">
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
        <!--[if lt IE 7]><link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-ie6.min.css"><![endif]-->
        <link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">
        <link rel="stylesheet" href="../../Vistas/HojasDeEstilo/jquery.fileupload-ui.css">
        <link rel="stylesheet" href="../../Vistas/HojasDeEstilo/subirArchivoPopUp.css">

        <script type="text/javascript" src="../../Vistas/JavaScript/Mapa.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/InicializadorComponentes.js"></script>
        <script type="text/javascript" src="../../Vistas/JavaScript/IniciarPaginaCrearPunto.js"></script>

        <script type="text/javascript">
            $(document).ready(function(){
                tqrmapas.iniciarMapas();
                iniciarCrearPunto();
                inicializarComponentes();
            });
        </script>
    </head>
    <body style="padding: 0px;">
        <div id="Cabecera" style="padding: 15px 30px; height: 70px;">
            <img alt="" src="../../Vistas/Imagenes/TurismoQRLogo.jpg" style="display: inline-block; margin-right: 15px;  height: 70px;"/>
            <img alt="" src="../../Vistas/Imagenes/TurismoQRTitulo.png" style="display: inline-block;  height: 60px;"/>
        </div>
        <div style="position: relative; padding: 0px 30px;" class="ui-widget-header">
            <div style="display: inline-block;">
                <h3>Crear nuevo punto de interes</h3>
            </div>
            <div style="display: inline-block; position: absolute; right: 30px; margin-top: -9px; top: 50%;" align="right">
                <label style="display: inline-block;">Idioma: </label>
                <select NAME="idioma" SIZE=1 >
                    <option VALUE="Español">Español</option>
                </select>
            </div>
        </div>
        <div style="padding: 30px;" class="ui-widget-content">
            <div id="contenedorPrincipal">
                <table id="contenidoPrincipal" style="width: 100%;">
                    <tr>
                        <td>
                            <div id="contenedorFormulario">
                                <form name="crearPuntoDeInteres" action="<core:url value='/crearPunto/guardarPuntoDeInteres.htm'/>" method="POST">
                                    <fieldset>
                                        <legend>Datos punto de interes</legend>
                                        <div>
                                            <label for="nombrePunto">
                                                Nombre:<br>
                                                <input id="nombrePunto" name="nombrePunto" type="text" placeholder="Ingrese el nombre del punto de interes"/>
                                            </label>
                                            <br>
                                            <label for="informacionPunto">
                                                Informacion relacionada:<br>
                                                <textarea id="informacionPunto" name="informacionPunto" placeholder="Ingrese la informacion correspondiente al punto" rows="18"></textarea>
                                            </label>
                                            <br>
                                            <div style="position: relative;">
                                                <div style="display: inline-block;">
                                                    <label for="latitudPunto">
                                                        Latitud: <div id="latitudValue"></div><input type="text" id="latitudPunto" name="latitudPunto" style="display:none"/>
                                                    </label>
                                                    <label for="informacionPunto">
                                                        Longitud: <div id="longitudValue"></div><input type="text" id="longitudPunto" name="longitudPunto" style="display:none"/>
                                                    </label>
                                                </div>
                                                <div style="display: inline-block; position: absolute; top: 0px; right: 0px;">
                                                    <a id="dialog_link" class="btn btn-success" href="#">Agregar Imagen...</a>
                                                </div>
                                            </div>
                                            <br>
                                            <div>
                                                <input type="submit" value="Crear punto"/>
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </td>
                        <td style="width: 50%;">
                            <div id="contenedorMapa"></div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
                    
        <script id="template-upload" type="text/x-tmpl">
        {% for (var i=0, file; file=o.files[i]; i++) { %}
            <tr class="template-upload fade">
                <td class="preview" rowspan="2"><span class="fade"></span></td>
                <td class="name" rowspan="2"><span>{%=file.name%}</span></td>
                <td class="size" rowspan="2"><span>{%=o.formatFileSize(file.size)%}</span></td>
                {% if (file.error) { %}
                    <td class="error" colspan="2" rowspan="2"><span class="label label-important">Error</span> {%=file.error%}</td>
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
                    <td class="name"><span>{%=file.name%}</span></td>
                    <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
                    <td class="error" colspan="2"><span class="label label-important">Error</span> {%=file.error%}</td>
                {% } else { %}
                    <td class="preview">{% if (file.thumbnail_url) { %}
                        <a href="{%=file.url%}" title="{%=file.name%}" rel="gallery" download="{%=file.name%}"><img src="{%=file.thumbnail_url%}"></a>
                    {% } %}</td>
                    <td class="name">
                        <a href="{%=file.url%}" title="{%=file.name%}" rel="{%=file.thumbnail_url&&'gallery'%}" download="{%=file.name%}">{%=file.name%}</a>
                    </td>
                    <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
                    <td colspan="2"></td>
                {% } %}
                <td class="delete">
                    <button class="btn btn-danger" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}">
                        <i class="icon-trash icon-white"></i>
                        <span>Delete</span>
                    </button>
                    <input type="checkbox" name="delete" value="1">
                </td>
            </tr>
        {% } %}
        </script>

        <div id="dialog">
            <div>
                <form id="fileupload" action="<core:url value='/crearPunto/subirArchivo.htm'/>" method="POST" enctype="multipart/form-data">
                    <table role="presentation" class="table table-striped"><tbody class="files" data-toggle="modal-gallery" data-target="#modal-gallery"></tbody></table>
                    <div id="archivos">
                        <span class="btn btn-success fileinput-button">
                            <i class="icon-plus icon-white"></i>
                            <span>Seleccionar imagenes...</span>
                            <input type="file" name="files" id="files" commandName="formularioArchivo" multiple>
                        </span>
                        <input class="btn btn-primary start" value="Subir imagenes" onclick="subirArchivos()"/>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
