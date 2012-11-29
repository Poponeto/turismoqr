/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function procesarErrores(errores)
{
    for(var propiedad in errores)
    {
        if (errores.hasOwnProperty(propiedad)) {
            debugger
            var querySelector = "[name = " + "'" + propiedad + "'" +"]";
            $(querySelector).attr("class", "errorEntrada");
        }
    }

}