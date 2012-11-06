<%-- 
    Document   : FormularioUbicacionPunto
    Created on : 03/11/2012, 20:34:44
    Author     : Chelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<fieldset id="camposLocalizacionPunto" style="display : none;">
    <legend>Localizacion del punto de interes</legend>
    <div>
        <label for="direccionPunto">
            Calle:<br>
            <input id="direccionPunto" name="direccionPunto" type="text" placeholder="Ingrese la direccion del punto de interes"/>
        </label>
        <br>
        <label for="alturaPunto">
            Número:<br>
            <input id="alturaPunto" name="alturaPunto" type="text" placeholder="Ingrese la altura del punto de interes"/>
        </label>
        <br>
        <label for="codigoPostalPunto">
            Código Postal:<br>
            <input id="codigoPostalPunto" name="codigoPostalPunto" type="text" placeholder="Ingrese el codigo postal del punto de interes"/>
        </label>
        <br>
        <label for="departamentoPunto">
            Departamento:<br>
            <select id="departamentoPunto" name="departamentoPunto">
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
        <label for="latitudPunto">
            Latitud: <div id="latitudValue"></div><input type="text" id="latitudPunto" name="latitudPunto" style="display:none" required="true"/>
        </label>
        <br>
        <label for="informacionPunto">
            Longitud: <div id="longitudValue"></div><input type="text" id="longitudPunto" name="longitudPunto" style="display:none" required="true"/>
        </label>
        <br>
    </div>
    <div>
        <a id="buscarUbicacion" class="btn btn-success" href="javascript:tqrmapas.geocodeDireccion();">Buscar direccion</a>
    </div>
</fieldset>
