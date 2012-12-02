/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function procesarErrores(errores, otroManejador)
{
    for(var propiedad in errores)
    {
        if (errores.hasOwnProperty(propiedad)) {
            debugger
            var querySelector = "[name = " + "'" + propiedad + "'" +"]";
            var parentSelector = "[name = " + "'label" + propiedad + "'" +"]";
            $(querySelector).parent(parentSelector).prepend('<p class="mensajeErrorEntrada" name="mansajeError'+propiedad+'">' + errores[propiedad] +'</p>');
            $(querySelector).attr("class", "errorEntrada");
        }
    }
    if(otroManejador)
    {
        otroManejador(errores);
    }
}

function hayErrores()
{
    if($(".mensajeErrorEntrada").attr("class") == "mensajeErrorEntrada" )
    {
        return true;
    }
    else
    {
        return false;;
    }
}

function removerErrorDeEntrada(entrada)
{
    if($(entrada).attr("class") == "errorEntrada")
    {
        $(entrada).attr("class", "none");
        var nombreError = "mansajeError" + $(entrada).attr("name");
        $("[name=" +nombreError +" ]" ).remove();
    }
}