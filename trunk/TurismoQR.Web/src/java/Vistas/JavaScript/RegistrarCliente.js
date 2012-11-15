/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function inicializarComponentesRegistrarCliente(tipoCliente, urlBase)
{
    $("#lineaDatosFechaNacimiento").datepicker({
        showOtherMonths: true,
        selectOtherMonths: true
    });

    $("#botonRegistrarse").click(function(){
        registrarCliente(tipoCliente, urlBase);
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

    empresaJSON[$('#lineaDatosCuit').attr("name")] = $('#lineaDatosCuit').val();
    empresaJSON[$('#lineaDatosRazonSocial').attr("name")] = $('#lineaDatosRazonSocial').val();
    empresaJSON[$('#selectRubro').attr("name")] = ($('#selectRubro').val())[0];

    return empresaJSON;
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
    debugger

    if (tipoCliente === "Empresa")
    {
        var datosEmpresa = obtenerDatosEmpresa();
    }
    if (tipoCliente === "Persona")
    {
        var datosPersona = obtenerDatosPersona();
debugger
        $.ajax({

        url: urlBase + "/cliente/registrarPersona.htm",
        data: datosPersona,
        type: "POST",
        contentType: "application/json",
        success: function(){
            alert("success");
        }
    });
    }
    

}