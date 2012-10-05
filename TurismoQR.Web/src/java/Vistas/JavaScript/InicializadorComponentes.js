/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function inicializarComponentes()
{
    $('#Contenedor').addClass('ui-widget');​
    $('#Cabecera').addClass('ui-widget-header');​
    $('#Menu , #Contenido , #Pie').addClass('ui-widget-content');
    $('[id*="boton"]').button();
    $('[id*="lineaDatos"]').addClass('ui-textfield');​
    $('[id*="acordion"]').accordion();

}