/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function inicializarComponentesRegistrarCliente(tipoCliente, urlBase)
{
    $(".contactoEmpresa").hide();

    $("#lineaDatosFechaNacimiento").datepicker({
        showOtherMonths: true,
        selectOtherMonths: true,
        dateFormat: "yy-mm-dd"
    });

    $("#botonRegistrarse").click(function(){
        registrarCliente(tipoCliente, urlBase);
        return false;
    });

    $("#botonAgregarContacto").click(function(){
        
        var boton = $('.contactoEmpresa:hidden:first #botonEliminarContactoEmpresa');
        var contenedor = $('.contactoEmpresa:hidden:first');
        contenedor.show(1000);
        boton.attr("contactnumber",contenedor.attr("contactNumber"));

        return false;
    });

    $('[id*="botonEliminarContactoEmpresa"]').click(function(){
        
        var contactNumber = this.attributes["contactnumber"].value;
        $("#contenedorFormularioContactoEmpresa" + contactNumber).hide(500);
        $("#contenedorFormularioContactoEmpresa" + contactNumber + " :input").val("");

        return false;
    });

}

function obtenerDatosContacto()
{
    var contactoJSON = {};

    contactoJSON[$('#lineaDatosMail').attr("name")] = $('#lineaDatosMail').val();
    contactoJSON[$('#lineaDatosCelular').attr("name")] = $('#lineaDatosCelular').val();
    contactoJSON[$('#lineaDatosTelefonoFijo').attr("name")] = $('#lineaDatosTelefonoFijo').val();

    return contactoJSON;
}

function obtenerDatosCliente()
{
    var clienteJSON = obtenerDatosContacto();

    clienteJSON[$('#lineaDatoscantidadDePuntosDeseados').attr("name")] = $('#lineaDatoscantidadDePuntosDeseados').val();

    return clienteJSON;
}

function obtenerDatosEmpresa()
{
    var empresaJSON = obtenerDatosCliente();
    var contactosEmpresaJSON = obtenerDatosContactoEmpresa();

    var rubro = {};
    rubro.nombreRubro = ($('#selectRubro').val())[0];

    empresaJSON[$('#lineaDatosCuit').attr("name")] = $('#lineaDatosCuit').val();
    empresaJSON[$('#lineaDatosRazonSocial').attr("name")] = $('#lineaDatosRazonSocial').val();
    empresaJSON[$('#selectRubro').attr("name")] = rubro;
    empresaJSON["contactos"] = contactosEmpresaJSON;

    return empresaJSON;
}

function obtenerDatosContactoEmpresa()
{
    var contactosEmpresaJSON = [];

    $('.contactoEmpresa:visible').each(function(id){
        
        var contactoEmpresaJSON = {};

        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosNombreContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosNombreContactoEmpresa').val();
        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosApellidoContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosApellidoContactoEmpresa').val();
        contactoEmpresaJSON[$('#' + this.id + ' #selectGeneroContactoEmpresa').attr("name")] = ($('#' + this.id + ' #selectGeneroContactoEmpresa').val())[0];

        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosMailContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosMailContactoEmpresa').val();
        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosCelularContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosCelularContactoEmpresa').val();
        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosTelefonoFijoContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosTelefonoFijoContactoEmpresa').val();

        contactosEmpresaJSON[id] = contactoEmpresaJSON;
    });

    return contactosEmpresaJSON;
}

function obtenerDatosPersona()
{
    var personaJSON = obtenerDatosCliente();

    personaJSON[$('#lineaDatosNombre').attr("name")] = $('#lineaDatosNombre').val();
    personaJSON[$('#lineaDatosApellido').attr("name")] = $('#lineaDatosApellido').val();
    personaJSON[$('#lineaDatosFechaNacimiento').attr("name")] = $('#lineaDatosFechaNacimiento').val();
    personaJSON[$('#lineaDatosdni').attr("name")] = $('#lineaDatosdni').val();
    personaJSON[$('#selectGenero').attr("name")] = ($('#selectGenero').val())[0];

    return personaJSON;
}

function registrarCliente(tipoCliente, urlBase)
{
    var datosCliente;

    if (tipoCliente === "Empresa")
    {
        datosCliente = obtenerDatosEmpresa();
    }
    if (tipoCliente === "Persona")
    {
        datosCliente = obtenerDatosPersona();
    }
    debugger
    var jsonCliente = JSON.stringify(datosCliente);
    var urlAccion = urlBase + "/cliente/registrar"+tipoCliente+".htm";

    $.ajax({
        url: urlAccion,
        dataType: "json",
        contentType: "application/json",
        data: jsonCliente,
        type: "POST",
        success: function(data){
            var urlRedirect = urlBase + "/" +data["urlConfirmacion"];
            var queryString = $.param({
                mail: data["mail"]
                });
            
            urlRedirect = urlRedirect + "?" + queryString;

            window.location.replace(urlRedirect);
        },
        error: function(jqXHR){
            debugger
            var errores = jqXHR["responseText"];
            procesarErrores(jQuery.parseJSON(errores));
        }
    });
   
}