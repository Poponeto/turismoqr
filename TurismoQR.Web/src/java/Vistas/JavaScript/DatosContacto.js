/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function inicializarDatosContacto()
{
    $(".contactoEmpresa").hide();

    $(":input").change(function(){
        removerErrorDeEntrada(this);
    });

    $('.contactoEmpresa :input').change(function(){
        $("#erroresDeContactosDeEmpresa").empty();
    });

    $("#lineaDatosFechaNacimiento").datepicker({
        showOtherMonths: true,
        selectOtherMonths: true,
        dateFormat: "yy-mm-dd"
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

function setearDatosContacto(datosClienteJSON)
{
    $('#lineaDatosMail').val(datosClienteJSON[$('#lineaDatosMail').attr("name")]);
    $('#lineaDatosCelular').val(datosClienteJSON[$('#lineaDatosCelular').attr("name")]);
    $('#lineaDatosTelefonoFijo').val(datosClienteJSON[$('#lineaDatosTelefonoFijo').attr("name")]);

}

function obtenerDatosCliente()
{
    var clienteJSON = obtenerDatosContacto();

    clienteJSON[$('#lineaDatoscantidadDePuntosDeseados').attr("name")] = $('#lineaDatoscantidadDePuntosDeseados').val();

    return clienteJSON;
}

function setearDatosCliente(datosClienteJSON)
{
    $('#lineaDatoscantidadDePuntosDeseados').val(datosClienteJSON[$('#lineaDatoscantidadDePuntosDeseados').attr("name")]);

    setearDatosContacto(datosClienteJSON);
}

function obtenerDatosEmpresa()
{
    var empresaJSON = obtenerDatosCliente();
    var contactosEmpresaJSON = obtenerDatosContactoEmpresa();

    var rubro = {};
    rubro.nombreRubro = $('#selectRubro').val();

    empresaJSON[$('#lineaDatosCuit').attr("name")] = $('#lineaDatosCuit').val();
    empresaJSON[$('#lineaDatosRazonSocial').attr("name")] = $('#lineaDatosRazonSocial').val();
    empresaJSON[$('#selectRubro').attr("name")] = rubro;
    empresaJSON["contactos"] = contactosEmpresaJSON;

    return empresaJSON;
}

function setearDatosEmpresa(datosClienteJSON)
{
    $('#lineaDatosCuit').val(datosClienteJSON[$('#lineaDatosCuit').attr("name")] );
    $('#lineaDatosRazonSocial').val(datosClienteJSON[$('#lineaDatosRazonSocial').attr("name")]);
    $('#selectRubro').val(datosClienteJSON.rubro.nombreRubro);

    setearDatosContactoEmpresa(datosClienteJSON)
    setearDatosCliente(datosClienteJSON);
}

function obtenerDatosContactoEmpresa()
{
    var contactosEmpresaJSON = [];

    $('.contactoEmpresa:visible').each(function(id){

        var contactoEmpresaJSON = {};

        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosNombreContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosNombreContactoEmpresa').val();
        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosApellidoContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosApellidoContactoEmpresa').val();
        contactoEmpresaJSON[$('#' + this.id + ' #selectGeneroContactoEmpresa').attr("name")] = $('#' + this.id + ' #selectGeneroContactoEmpresa').val();

        contactoEmpresaJSON["mail"] = $('#' + this.id + ' #lineaDatosMailContactoEmpresa').val();
        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosCelularContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosCelularContactoEmpresa').val();
        contactoEmpresaJSON[$('#' + this.id + ' #lineaDatosTelefonoFijoContactoEmpresa').attr("name")] = $('#' + this.id + ' #lineaDatosTelefonoFijoContactoEmpresa').val();

        contactosEmpresaJSON[id] = contactoEmpresaJSON;
    });

    return contactosEmpresaJSON;
}

function setearDatosContactoEmpresa(datosClienteJSON)
{
    $(datosClienteJSON.contactos).each(function(id){

            $('.contactoEmpresa:hidden:first #lineaDatosNombreContactoEmpresa').val(datosClienteJSON.contactos[id][$('.contactoEmpresa:hidden:first #lineaDatosNombreContactoEmpresa').attr("name")]);
            $('.contactoEmpresa:hidden:first #lineaDatosApellidoContactoEmpresa').val(datosClienteJSON.contactos[id][$('.contactoEmpresa:hidden:first #lineaDatosApellidoContactoEmpresa').attr("name")]);
            $('.contactoEmpresa:hidden:first #selectGeneroContactoEmpresa').val(datosClienteJSON.contactos[id][$('.contactoEmpresa:hidden:first #selectGeneroContactoEmpresa').attr("name")]);

            $('.contactoEmpresa:hidden:first #lineaDatosMailContactoEmpresa').val(datosClienteJSON.contactos[id]['mail']);
            $('.contactoEmpresa:hidden:first #lineaDatosCelularContactoEmpresa').val(datosClienteJSON.contactos[id][$('.contactoEmpresa:hidden:first #lineaDatosCelularContactoEmpresa').attr("name")]);
            $('.contactoEmpresa:hidden:first #lineaDatosTelefonoFijoContactoEmpresa').val(datosClienteJSON.contactos[id][$('.contactoEmpresa:hidden:first #lineaDatosTelefonoFijoContactoEmpresa').attr("name")]);

            $("#botonAgregarContacto").click();

        });
}

function obtenerDatosPersona()
{
    var personaJSON = obtenerDatosCliente();

    personaJSON[$('#lineaDatosNombre').attr("name")] = $('#lineaDatosNombre').val();
    personaJSON[$('#lineaDatosApellido').attr("name")] = $('#lineaDatosApellido').val();
    personaJSON[$('#lineaDatosFechaNacimiento').attr("name")] = $('#lineaDatosFechaNacimiento').val();
    personaJSON[$('#lineaDatosdni').attr("name")] = $('#lineaDatosdni').val();
    personaJSON[$('#selectGenero').attr("name")] = $('#selectGenero').val();

    return personaJSON;
}

function setearDatosPersona(datosClienteJSON)
{

    $('#lineaDatosNombre').val(datosClienteJSON[$('#lineaDatosNombre').attr("name")]);
    $('#lineaDatosApellido').val(datosClienteJSON[$('#lineaDatosApellido').attr("name")]);
    $('#lineaDatosFechaNacimiento').val(datosClienteJSON[$('#lineaDatosFechaNacimiento').attr("name")]);
    $('#lineaDatosdni').val(datosClienteJSON[$('#lineaDatosdni').attr("name")]);
    $('#selectGenero').val(datosClienteJSON[$('#selectGenero').attr("name")]);

    setearDatosCliente(datosClienteJSON);

}

function manejarErroresContactos(errores)
{
    if(errores["contactos"])
    {
        $("#erroresDeContactosDeEmpresa").append('<p class="mensajeErrorEntrada" name="mansajeErrorContactos">' + errores["contactos"] +'</p>');
    }
}