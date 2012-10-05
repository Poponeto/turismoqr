/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function inicializarComponentes()
{
    jQuery('[id*="acordion"]').accordion();
    jQuery('[id*="boton"]').button();
    jQuery('[id*="lineaDatos"]').button().addClass('ui-textfield');​
}
