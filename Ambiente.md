# Introduction #

Bueno, para empezar a trabajar en el proyecto tenemos que instalar un par de cosas. Las principales son: TortoiseSVN, NetBeans y JBoss.


# Details #

NetBeans:

La idea sería tener instalada la versión 6.9.1, el instalador está en dropbox en la carpeta "Instaladores".

TortoiseSVN:

La versión 1.7.6 también está en dropbox, instalar esta preferiblemente.

JBoss:

Descomprimir el archivo que se encuentra en la carpeta de Instaladores dentro de archivos de programa.

**¿Cómo conectarse al repositorio?**

Bastante fácil. Una vez instalado el TortoiseSVN, apretar el botón derecho dentro de la ubicación sobre la que queremos tener el repositorio. Una vez hecho esto, seleccionar la opción SVN Checkout. Se nos va a abrir una ventanita preguntando por el URL del repositorio, ahí ponemos:

https://turismoqr.googlecode.com/svn

Cuando le demos ok, probablemente nos pregunte por nuestro usuario y password.  Los datos son los siguientes:

Usuario: mail de google.
Password: http://code.google.com/hosting/settings (Lo obtienen en ese link)

Una vez hecho esto les debería bajar todo el código.

**¿Qué más tengo que hacer?**

Abrir NetBeans, irse al tab de Services/Servicios. Darle click con el botón derecho a Servers/Servidores y poner Add Server/Agregar Servidor. Una vez hecho esto debe aparecer una opción que dice JBoss Application Server o algo así. La seleccionamos y nos aparece un cambo para poner la URL, buscamos la URL de la carpeta donde descomprimimos el JBoss y la seleccionamos, luego aceptamos. Después de hacer esto deberíamos ver dentro de Servidores a JBoss como una opción.

Abrir los proyectos del repositorio (dentro del trunk), probablemente les diga que falta una referencia a derbyclient.jar en algún proyecto. Si esto pasa, click sobre el proyecto --> Resolver References y busquen la referencia que está faltando dentro de la carpeta Libraries en el Trunk.