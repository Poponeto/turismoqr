/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function inicializarComponentesInformacionUsuario(nombreUsuario, urlBase)
{
    inicializarComponentesInformacionPersonal(nombreUsuario, urlBase);
}


function inicializarComponentesInformacionPersonal(nombreUsuario, urlBase)
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

    $("#nombreUsuario").val(nombreUsuario);
    $("#nombreUsuario").attr('disabled','disabled');
    $("#botonGuardarNombreUsuario").hide();

    $("#botonCambiarContrasenia").click(function(){
        $("#popUpFormularioCambioContrasenia").dialog('open');

    });

    $("#botonCambiarNombreUsuario").click(function(){
        $("#nombreUsuario").removeAttr('disabled');
        $("#botonGuardarNombreUsuario").show();
    });

    $("#botonGuardarNombreUsuario").click(function(){
       //ajax function to save user name
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
        var urlAccion = urlBase + "/cliente/modificarCliente"+tipoCliente+".htm";

        $.ajax({
            url: urlAccion,
            dataType: "json",
            contentType: "application/json",
            data: jsonCliente,
            type: "POST",
            success: function(){
                location.reload(true);
            },
            error: function(jqXHR){
                var errores = jqXHR["responseText"];
                procesarErrores(jQuery.parseJSON(errores), manejarErroresContactos);
            }
        });

    }

}