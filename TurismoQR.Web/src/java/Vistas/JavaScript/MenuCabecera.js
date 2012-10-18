/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function inicializarComponentesMenuCabecera()
{
    $('[id*="menuDeOpciones"]').addClass('menu');
    $('[id*="imagenMenu"]').addClass('menu');

    $('[id*="contenedorDeMenus"]').buttonset();
    $('[id*="contenedorDeMenus"]').ptMenu(); //http://www.codingwhiz.com/jqueryui/jquery-ui-themeroller-enabled-dropdown-menu.html

}

