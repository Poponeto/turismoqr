/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function inicializarComponentesRegistrarCliente(tipoCliente, urlBase)
{
    
    $("#botonRegistrarse").click(function(){
        registrarCliente(tipoCliente, urlBase);
        return false;
    });
}

function registrarCliente(tipoCliente, urlBase)
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
                procesarErrores(jQuery.parseJSON(errores), manejarErroresContactos);
            }
        });

    }
    
}

