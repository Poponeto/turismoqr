/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function inicializarDatosCambioContraseña()
{
    $("#contraseniaActual").change(function(){
       removerErrorDeEntrada(this);
    });

    $("#nuevaContrasenia").change(function(){
        removerErrorDeEntrada(this)
    });

    $("#repitaPassword").change(function(){
        removerErrorDeEntrada(this);
    });
}

function obtenerDatosCambioContraseña()
{
    var datosCambioContraseña = {};

    datosCambioContraseña[$("#contraseniaActual").attr("name")] = $("#contraseniaActual").val();
    datosCambioContraseña[$("#nuevaContrasenia").attr("name")] = $("#nuevaContrasenia").val();
    datosCambioContraseña[$("#repitaPassword").attr("name")] = $("#repitaPassword").val();

    return datosCambioContraseña;

}

function probarNuevaContraseña(datosCambioContraseña)
{
    debugger
    if(datosCambioContraseña[$("#nuevaContrasenia").attr("name")] === datosCambioContraseña[$("#repitaPassword").attr("name")])
    {
        $(".mensajeErrorEntrada").remove();
        return true;
    }
    
    $("#contenedorNuevoPassword").append('<p class="mensajeErrorEntrada">Las contraseñas no coinciden.</p>')
    return false;
}
