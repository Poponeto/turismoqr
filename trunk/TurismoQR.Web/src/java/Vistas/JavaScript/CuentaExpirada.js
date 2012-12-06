/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function inicializarDatosCuentaExpirada(urlBase)
{
    inicializarDatosCambioContraseña();

    $("#botonActualizarContraseña").click(function()
    {
        actualizarContraseña(urlBase);
    });
}

function actualizarContraseña(urlBase)
{
    if (hayErrores())
    {
        alert("Hay errores, solucionelos antes de continuar.");
    }
    else
    {
        var datosCambioContraseña = obtenerDatosCambioContraseña();
        var urlAccion = urlBase + "/administracion/usuario/cambiarContrasenia.htm";

        if (probarNuevaContraseña(datosCambioContraseña))
        {

            delete datosCambioContraseña[$("#repitaPassword").attr("name")];

            $.ajax({
                url: urlAccion,
                dataType: "json",
                data: datosCambioContraseña,
                type: "POST",
                success: function(data){
                    var urlRedirect = urlBase + "/" +data["urlRedirigir"];
                    window.location.replace(urlRedirect);
                },
                error: function(jqXHR){
                    var errores = jqXHR["responseText"];
                    procesarErrores(jQuery.parseJSON(errores));
                }
            });
        }
        

    }
}