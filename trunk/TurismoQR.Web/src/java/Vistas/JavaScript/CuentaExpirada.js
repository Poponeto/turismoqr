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

