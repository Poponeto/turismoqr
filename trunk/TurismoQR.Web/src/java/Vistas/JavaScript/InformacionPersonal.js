/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function inicializarComponentesInformacionPersonal(tipoCliente, urlBase)
{

    $("#botonActualizar").click(function(){
        actualizarInformacionPersonal(tipoCliente, urlBase);
        return false;
    });

}

function actualizarInformacionPersonal(tipoCliente, urlBase)
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