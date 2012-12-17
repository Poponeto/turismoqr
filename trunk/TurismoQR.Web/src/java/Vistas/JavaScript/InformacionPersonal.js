/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function inicializarComponentesInformacionUsuario(nombreUsuario, urlBase)
{
    $("#nombreUsuario").val(nombreUsuario);

    $("#nombreUsuario").change(function(){
        removerErrorDeEntrada(this);
    });

    $("#nombreUsuario").attr('disabled','disabled');
    $("#botonGuardarNombreUsuario").hide();

    $("#botonCambiarNombreUsuario").click(function(){
        $("#nombreUsuario").removeAttr('disabled');
        $(this).hide();
        $("#botonGuardarNombreUsuario").show();
    });

    $("#botonGuardarNombreUsuario").click(function(){

        if (hayErrores())
        {
            alert("Hay errores, solucionelos antes de continuar.");
        }
        {
            var datosEnvio = {
                nuevoNombreUsuario: $("#nombreUsuario").val()
            };
            var urlAccion = urlBase + "/administracion/usuario/cambiarNombre.htm";

            $.ajax({
                url: urlAccion,
                dataType: "json",
                data: datosEnvio,
                type: "POST",
                success: function(){
                    debugger
                    var urlRedirect = urlBase + "/j_myApplication_logout";
                    window.location.replace(urlRedirect);
                },
                error: function(jqXHR){
                    debugger
                    var errores = jqXHR["responseText"];
                    procesarErrores(jQuery.parseJSON(errores));
                }
            });
        }
    });

    inicializarComponentesInformacionPersonal( urlBase);
}

function inicializarComponentesInformacionCliente(tipoCliente, urlBase)
{
    debugger
    $("#botonGuardar").hide();
    $(":input").attr('disabled','disabled');

    $("#botonActualizar").click(function(){
        $(":input").removeAttr('disabled');
        $(this).hide();
        $("#botonGuardar").show();
    });

    $("#botonGuardar").click(function(){
        actualizarInformacionPersonalCliente(tipoCliente, urlBase);
    });

    $.ajax({
        url: urlBase + "/administracion/cliente/obtenerDatosClienteActual.htm",
        dataType: "json",
        type: "GET",
        success: function(data){
            debugger
            setearDatosInformacionPersonalCliente(data, tipoCliente);
        }
    });

    $("#popUpFormularioCambioContrasenia :input").removeAttr('disabled');
    $(":button").removeAttr('disabled');
    
    inicializarComponentesInformacionPersonal( urlBase);
}

function inicializarComponentesInformacionPersonal( urlBase)
{

    $("#popUpFormularioCambioContrasenia").dialog({
        autoOpen: false,
        width: '50%',
        buttons: {
            "Cancelar": function() {
                $('#Contenedor').css('opacity','1');
                $(this).dialog("close");
            },
            "Confirmar": function() {

                actualizarContraseña(urlBase);
            }
        },
        title: 'Cambiar Contraseña.'
    });

    $("#botonCambiarContrasenia").click(function(){
        $("#popUpFormularioCambioContrasenia").dialog('open');

    });
}

function actualizarInformacionPersonalCliente(tipoCliente, urlBase)
{
    if (hayErrores())
    {
        alert("Hay errores, solucionelos antes de continuar.");
    }
    else
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
        var urlAccion = urlBase + "/administracion/cliente/modificar"+tipoCliente+".htm";

        $.ajax({
            url: urlAccion,
            dataType: "json",
            contentType: "application/json",
            data: jsonCliente,
            type: "POST",
            success: function(){
                var urlRedirect = urlBase + "/j_myApplication_logout";
                window.location.replace(urlRedirect);
            },
            error: function(jqXHR){
                var errores = jqXHR["responseText"];
                procesarErrores(jQuery.parseJSON(errores), manejarErroresContactos);
            }
        });

    }

}

function setearDatosInformacionPersonalCliente(data, tipoCliente)
{
    if (tipoCliente === "Empresa")
    {
        datosCliente = setearDatosEmpresa(data);
    }
    if (tipoCliente === "Persona")
    {
        datosCliente = setearDatosPersona(data);
    }

        
}