create table InformacionEnIdioma (idInformacionEnIdioma varchar(255) not null, texto varchar(255), primary key (idInformacionEnIdioma));
create table cliente (idCliente varchar(255) not null, apellido varchar(255), nombre varchar(255), mail varchar(255), dni varchar(255), celular varchar(255), telefonoFijo varchar(255), primary key (idCliente));
create table idioma (idIdioma varchar(255) not null, nombreIdioma varchar(255), primary key (idIdioma));
create table imagen (idImagen varchar(255) not null, extension varchar(255), informacion varchar(255), primary key (idImagen));
create table informacion (idInformacion varchar(255) not null, primary key (idInformacion));
create table link (idLink varchar(255) not null, primary key (idLink));
create table localizacion (idLocalizacion varchar(255) not null, latitud varchar(255), longitud varchar(255), primary key (idLocalizacion));
create table periodo (idPeriodo varchar(255) not null, fechaInicioPeriodo datetime, fechaFinPeriodo datetime, primary key (idPeriodo));
create table permiso (idPermiso varchar(255) not null, nombre varchar(255), descripcion varchar(255), primary key (idPermiso));
create table permisoRol (idPermisoRol varchar(255) not null, permisosRol varchar(255), primary key (idPermisoRol));
create table permisoUsuario (idPermisoUsuario varchar(255) not null, permiso varchar(255), permisosUsuario varchar(255), primary key (idPermisoUsuario));
create table punto (idPunto varchar(255) not null, nombre varchar(255), localizacion varchar(255), informacion varchar(255), primary key (idPunto));
create table recurso (idRecurso varchar(255) not null, url varchar(255), primary key (idRecurso));
create table rol (idRol varchar(255) not null, primary key (idRol));
create table usuario (idUsuario varchar(255) not null, nombreUsuario varchar(255), contrasenia varchar(255), primary key (idUsuario));
alter table InformacionEnIdioma add index idInformacionEnIdioma (idInformacionEnIdioma), add constraint idInformacionEnIdioma foreign key (idInformacionEnIdioma) references informacion (idInformacion);
alter table imagen add index idInformacion (informacion), add constraint idInformacion foreign key (informacion) references informacion (idInformacion);
alter table imagen add index idImagen (idImagen), add constraint idImagen foreign key (idImagen) references punto (idPunto);
alter table imagen add index FKB95A8273659A5014 (idImagen), add constraint FKB95A8273659A5014 foreign key (idImagen) references recurso (idRecurso);
alter table link add index idLink (idLink), add constraint idLink foreign key (idLink) references punto (idPunto);
alter table link add index FK32AFFA1FD5F85B (idLink), add constraint FK32AFFA1FD5F85B foreign key (idLink) references recurso (idRecurso);
alter table permisoRol add index idPermisoRol (permisosRol), add constraint idPermisoRol foreign key (permisosRol) references rol (idRol);
alter table permisoUsuario add index idPermiso (permiso), add constraint idPermiso foreign key (permiso) references permiso (idPermiso);
alter table permisoUsuario add index idPermisoUsuario (permisosUsuario), add constraint idPermisoUsuario foreign key (permisosUsuario) references usuario (idUsuario);
alter table punto add index idInformacion (informacion), add constraint idInformacion foreign key (informacion) references informacion (idInformacion);
alter table punto add index idLocalizacion (localizacion), add constraint idLocalizacion foreign key (localizacion) references localizacion (idLocalizacion);
