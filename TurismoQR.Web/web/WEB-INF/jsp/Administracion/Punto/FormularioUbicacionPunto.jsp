<%-- 
    Document   : FormularioUbicacionPunto
    Created on : 03/11/2012, 20:34:44
    Author     : Chelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenedorPrincipalUbicacion">
            <table id="contenidoPrincipalUbicacion" style="width: 100%;">
                <tr>
                    <td>
                        <div id="contenedorFormulario">
                            <form name="ubicacionPuntoDeInteres" action="<core:url value='../crearPunto/guardarPuntoDeInteres.htm'/>" method="POST">-->
                                <fieldset id="camposLocalizacionPunto" style="display : none;">
                                    <legend>Localizacion del punto de interes</legend>
                                    <div>
                                        <label for="direccionPunto">
                                            Calle:<br>
                                            <input id="direccionPunto" name="direccionPunto" type="text" placeholder="Ingrese la direccion del punto de interes" required="true"/>
                                        </label>
                                        <br>
                                        <label for="alturaPunto">
                                            Número:<br>
                                            <input id="alturaPunto" name="alturaPunto" type="text" placeholder="Ingrese la altura del punto de interes" required="true"/>
                                        </label>
                                        <br>
                                        <div style="position: relative;">
                                            <div style="display: inline-block;">
                                                <label for="departamentoPunto">
                                                    Departamento:<br>
                                                    <select id="departamentoPunto" name="departamentoPunto" required="true">
                                                        <option value="Capital">Capital</option>
                                                        <option value="General Alvear">General Alvear</option>
                                                        <option value="Godoy Cruz">Godoy Cruz</option>
                                                        <option value="Guaymallen">Guaymallén</option>
                                                        <option value="Junin">Junin</option>
                                                        <option value="La Paz">La Paz</option>
                                                        <option value="Las Heras">Las Heras</option>
                                                        <option value="Lavalle">Lavalle</option>
                                                        <option value="Lujan de Cuyo">Luján de Cuyo</option>
                                                        <option value="Maipu">Maipú</option>
                                                        <option value="Malargue">Malargue</option>
                                                        <option value="Rivadavia">Rivadavia</option>
                                                        <option value="San Carlos">San Carlos</option>
                                                        <option value="San Martin">San Martin</option>
                                                        <option value="San Rafael">San Rafael</option>
                                                        <option value="Santa Rosa">Santa Rosa</option>
                                                        <option value="Tunuyan">Tunuyán</option>
                                                        <option value="Tupungato">Tupungayo</option>
                                                    </select>
                                                </label>
                                                <br>
                                            </div>
                                            <div style="display: inline-block;">
                                                <label for="codigoPostalPunto">
                                                    Código Postal:<br>
                                                    <input id="codigoPostalPunto" name="codigoPostalPunto" type="text" placeholder="Ingrese el codigo postal del punto de interes" required="true"/>
                                                </label>
                                            <br>
                                            </div>
                                        </div>
<!--                                            <label for="informacionPunto">
                                            Informacion relacionada:<br>
                                            <textarea id="informacionPunto" name="informacionPunto" placeholder="Ingrese la informacion correspondiente al punto" rows="18" required="true"></textarea>
                                        </label>
                                        <br>-->
                                        <div style="position: relative;">
                                            <div style="display: inline-block;">
                                                <label for="latitudPunto">
                                                    Latitud: <div id="latitudValue"></div><input type="text" id="latitudPunto" name="latitudPunto" style="display:none"/>
                                                </label>
                                                <label for="informacionPunto">
                                                    Longitud: <div id="longitudValue"></div><input type="text" id="longitudPunto" name="longitudPunto" style="display:none"/>
                                                </label>
                                            </div>
<!--                                                <div style="display: inline-block; position: absolute; top: 0px; right: 0px;">
                                                <a id="dialog_link" class="btn btn-success" style="color: white;" href="#">Agregar Imagen...</a>
                                            </div>-->
                                        </div>
                                        <br>
                                        <div>
<!--                                            <input type="button" id="buscarUbicacion" value="Buscar direccion" onclick="javascript:tqrmapas.geocodeDireccion();"/>-->
                                            <a id="buscarUbicacion" class="btn btn-success" href="javascript:tqrmapas.geocodeDireccion();">Buscar direccion</a>
                                        </div>
                                    </div>
                                </fieldset>
<!--                                <input id="idioma" name="idioma" type="text" style="display: none;"/>
                            </form>
                        </div>
                    </td>
                    <td style="width: 50%;">
                        <div id="contenedorMapa"></div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>-->
