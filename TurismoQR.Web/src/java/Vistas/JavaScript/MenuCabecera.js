/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function inicializarComponentesMenuCabecera()
{
    $('[id*="menuDeOpciones"]').addClass('menu');
    $('[id*="imagenMenu"]').addClass('menu');

    $('[id*="contenedorDeMenus"]').buttonset();
//    setTimeout(function(){
    $('[id*="contenedorDeMenus"]').ptMenu();
//    },500); //http://www.codingwhiz.com/jqueryui/jquery-ui-themeroller-enabled-dropdown-menu.html
    //probar cambiar el orden
}

