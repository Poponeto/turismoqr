CREATE SCHEMA `turismoqr` ;

create table InformacionEnIdioma (idInformacionEnIdioma varchar(255) not null, texto varchar(255), nombre varchar(255), Idioma varchar(255) not null, Informacion varchar(255), primary key (idInformacionEnIdioma));
create table categoria (idCategoria varchar(255) not null, nombreCategoria varchar(255), primary key (idCategoria));
create table ciclo (idCiclo varchar(255) not null, primary key (idCiclo));
create table cliente (idCliente varchar(255) not null, cantidadDePuntosPermitidos integer, ciclo varchar(255) unique, primary key (idCliente));
create table contacto (idContacto varchar(255) not null, mail varchar(255), celular varchar(255), telefonoFijo varchar(255), primary key (idContacto));
create table contactoEmpresa (idContactoEmpresa varchar(255) not null, apellido varchar(255), nombre varchar(255), sexo varchar(255), empresa varchar(255), primary key (idContactoEmpresa));
create table empresa (idEmpresa varchar(255) not null, cuit varchar(255), razonSocial varchar(255), Rubro varchar(255) not null unique, primary key (idEmpresa));
create table estado (idEstado varchar(255) not null, nombreDeEstado varchar(255), fechaInicioPeriodo datetime, fechaFinPeriodo datetime, Ciclo varchar(255), primary key (idEstado));
create table idioma (idIdioma varchar(255) not null, nombreIdioma varchar(255), primary key (idIdioma));
create table imagen (idImagen varchar(255) not null, extension varchar(255), Informacion varchar(255) unique, Punto varchar(255), primary key (idImagen));
create table informacion (idInformacion varchar(255) not null, primary key (idInformacion));
create table link (idLink varchar(255) not null, Punto varchar(255), primary key (idLink));
create table localizacion (idLocalizacion varchar(255) not null, latitud varchar(255), longitud varchar(255), primary key (idLocalizacion));
create table periodo (idPeriodo varchar(255) not null, fechaInicioPeriodo datetime, fechaFinPeriodo datetime, primary key (idPeriodo));
create table permiso (idPermiso varchar(255) not null, nombre varchar(255), descripcion varchar(255), primary key (idPermiso));
create table permisoRol (idPermisoRol varchar(255) not null, permisosRol varchar(255), primary key (idPermisoRol));
create table permisoUsuario (idPermisoUsuario varchar(255) not null, permiso varchar(255), Usuario varchar(255), primary key (idPermisoUsuario));
create table persona (idPersona varchar(255) not null, apellido varchar(255), nombre varchar(255), sexo varchar(255), dni varchar(255), fechaDeNacimiento date, primary key (idPersona));
create table punto (idPunto varchar(255) not null, nombre varchar(255), Localizacion varchar(255) not null unique, Informacion varchar(255) unique, categoriaPunto varchar(255) unique, ciclo varchar(255) unique, primary key (idPunto));
create table puntoComercial (idpuntoComercial varchar(255) not null, cliente varchar(255), primary key (idpuntoComercial));
create table recurso (idRecurso varchar(255) not null, url varchar(255), primary key (idRecurso));
create table rol (idRol varchar(255) not null, primary key (idRol));
create table rubro (idRubro varchar(255) not null, categoriaRubro varchar(255) unique, nombreRubro varchar(255), primary key (idRubro));
create table usuario (idUsuario varchar(255) not null, nombreUsuario varchar(255), contrasenia varchar(255), primary key (idUsuario));
alter table InformacionEnIdioma add index idInformacion (Informacion), add constraint idInformacion foreign key (Informacion) references informacion (idInformacion);
alter table InformacionEnIdioma add index FK869F40BB9781D979 (Idioma), add constraint FK869F40BB9781D979 foreign key (Idioma) references idioma (idIdioma);
alter table cliente add index FK334B85FA7A3E6E41 (ciclo), add constraint FK334B85FA7A3E6E41 foreign key (ciclo) references ciclo (idCiclo);
alter table cliente add index FK334B85FA5E4C6279 (idCliente), add constraint FK334B85FA5E4C6279 foreign key (idCliente) references contacto (idContacto);
alter table contactoEmpresa add index FKC6F1513A5D5940D9 (idContactoEmpresa), add constraint FKC6F1513A5D5940D9 foreign key (idContactoEmpresa) references contacto (idContacto);
alter table contactoEmpresa add index idEmpresa (empresa), add constraint idEmpresa foreign key (empresa) references empresa (idEmpresa);
alter table empresa add index FK9F354089F5993F08 (Rubro), add constraint FK9F354089F5993F08 foreign key (Rubro) references rubro (idRubro);
alter table empresa add index FK9F354089DAF185FD (idEmpresa), add constraint FK9F354089DAF185FD foreign key (idEmpresa) references cliente (idCliente);
alter table estado add index idCiclo (Ciclo), add constraint idCiclo foreign key (Ciclo) references ciclo (idCiclo);
alter table imagen add index FKB95A8273EC58074B (Informacion), add constraint FKB95A8273EC58074B foreign key (Informacion) references informacion (idInformacion);
alter table imagen add index idPuntoImagenes (Punto), add constraint idPuntoImagenes foreign key (Punto) references punto (idPunto);
alter table imagen add index FKB95A8273659A5014 (idImagen), add constraint FKB95A8273659A5014 foreign key (idImagen) references recurso (idRecurso);
alter table link add index FK32AFFA1FD5F85B (idLink), add constraint FK32AFFA1FD5F85B foreign key (idLink) references recurso (idRecurso);
alter table link add index idPuntoLinks (Punto), add constraint idPuntoLinks foreign key (Punto) references punto (idPunto);
alter table permisoRol add index idPermisoRol (permisosRol), add constraint idPermisoRol foreign key (permisosRol) references rol (idRol);
alter table permisoUsuario add index idPermisoUsuario (Usuario), add constraint idPermisoUsuario foreign key (Usuario) references usuario (idUsuario);
alter table permisoUsuario add index idPermiso (permiso), add constraint idPermiso foreign key (permiso) references permiso (idPermiso);
alter table persona add index FKD78FCFAC134C1520 (idPersona), add constraint FKD78FCFAC134C1520 foreign key (idPersona) references cliente (idCliente);
alter table punto add index FK6612344EC58074B (Informacion), add constraint FK6612344EC58074B foreign key (Informacion) references informacion (idInformacion);
alter table punto add index FK6612344F143869C (Localizacion), add constraint FK6612344F143869C foreign key (Localizacion) references localizacion (idLocalizacion);
alter table punto add index FK66123447A3E6E41 (ciclo), add constraint FK66123447A3E6E41 foreign key (ciclo) references ciclo (idCiclo);
alter table punto add index FK66123446B4AD834 (categoriaPunto), add constraint FK66123446B4AD834 foreign key (categoriaPunto) references categoria (idCategoria);
alter table puntoComercial add index idCliente (cliente), add constraint idCliente foreign key (cliente) references cliente (idCliente);
alter table puntoComercial add index FK96198B1BBF7EDB52 (idpuntoComercial), add constraint FK96198B1BBF7EDB52 foreign key (idpuntoComercial) references punto (idPunto);
alter table rubro add index FK67D24FC6B66D9EC (categoriaRubro), add constraint FK67D24FC6B66D9EC foreign key (categoriaRubro) references categoria (idCategoria);

INSERT INTO `turismoqr`.`usuario` (`idUsuario`, `nombreUsuario`, `contrasenia`) VALUES ('1', 'admin', 'admin');
INSERT INTO `turismoqr`.`permiso` (`idPermiso`, `nombre`, `descripcion`) VALUES ('1', 'PERMISO_ADMINISTRADOR', 'Permiso de administrador');
INSERT INTO `turismoqr`.`permisousuario` (`idPermisoUsuario`, `permiso`, `Usuario`) VALUES ('1', '1', '1');

INSERT INTO `turismoqr`.`localizacion` (`idLocalizacion`, `latitud`, `longitud`) VALUES ('1', '0', '0');
INSERT INTO `turismoqr`.`idioma` (`idIdioma`, `nombreIdioma`) VALUES ('1', 'espanol');
INSERT INTO `turismoqr`.`idioma` (`idIdioma`, `nombreIdioma`) VALUES ('2', 'ingles');
INSERT INTO `turismoqr`.`informacion` (`idInformacion`) VALUES ('1');
INSERT INTO `turismoqr`.`informacion` (`idInformacion`) VALUES ('2');

INSERT INTO `turismoqr`.`informacionenidioma` (`idInformacionEnIdioma`, `texto`, `Idioma`, `Informacion`) VALUES ('1', 'Informacion en idioma para el punto', '1', '1');
INSERT INTO `turismoqr`.`informacionenidioma` (`idInformacionEnIdioma`, `texto`, `Idioma`, `Informacion`) VALUES ('2', 'Informacion en idioma para la imagen', '1', '2');

INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('1', 'Hotel');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('2', 'Farmacia');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('3', 'Restaurant');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('4', 'Monumento');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('5', 'Plaza');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('6', 'Hostel');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('7', 'Polideportivo');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('8', 'Almacen');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('9', 'Ferreteria');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('10', 'Universidad');
INSERT INTO `turismoqr`.`categoria` (`idCategoria`, `nombreCategoria`) VALUES ('11', 'Software Factory');

INSERT INTO `turismoqr`.`punto` (`idPunto`, `nombre`, `Localizacion`, `Informacion`) VALUES ('1', 'Punto de Interes', '1', '1','1','1');
INSERT INTO `turismoqr`.`recurso` (`idRecurso`, `url`) VALUES ('1', 'imagen');
INSERT INTO `turismoqr`.`imagen` (`idImagen`, `extension`, `Informacion`, `Punto`) VALUES ('1', 'jpg', '2', '1');
INSERT INTO `turismoqr`.`recurso` (`idRecurso`, `url`) VALUES ('2', 'link');
INSERT INTO `turismoqr`.`link` (`idLink`, `Punto`) VALUES ('2', '1');
INSERT INTO `turismoqr`.`ciclo` (`idCiclo`) VALUES ('1');
UPDATE `turismoqr`.`punto` SET `ciclo`='1' WHERE `idPunto`='1';
INSERT INTO `turismoqr`.`estado` (`idEstado`, `nombreDeEstado`, `Ciclo`) VALUES ('1', 'Habilitado', '1');
UPDATE `turismoqr`.`informacionenidioma` SET `nombre`='Punto1' WHERE `idInformacionEnIdioma`='1';
UPDATE `turismoqr`.`informacionenidioma` SET `nombre`='Imagen1' WHERE `idInformacionEnIdioma`='2';
INSERT INTO `turismoqr`.`usuario` (`idUsuario`, `nombreUsuario`, `contrasenia`) VALUES ('2', 'cliente', 'cliente');
INSERT INTO `turismoqr`.`permisousuario` (`idPermisoUsuario`, `permiso`, `Usuario`) VALUES ('2', '1', '2');
INSERT INTO `turismoqr`.`ciclo` (`idCiclo`) VALUES ('2');
INSERT INTO `turismoqr`.`estado` (`idEstado`, `nombreDeEstado`, `Ciclo`) VALUES ('2', 'Habilitado', '2');
INSERT INTO `turismoqr`.`contacto` (`idContacto`, `mail`, `celular`, `telefonoFijo`) VALUES ('1', 'email@email.com', '12312312', '1231231');
INSERT INTO `turismoqr`.`cliente` (`idCliente`, `cantidadDePuntosPermitidos`, `ciclo`) VALUES ('1', 5, '2');
INSERT INTO `turismoqr`.`persona` (`idPersona`, `apellido`, `nombre`, `sexo`, `dni`, `fechaDeNacimiento`) VALUES ('1', 'Juan', 'Perez', 'Masculino', '34123456', NOW());
INSERT INTO `turismoqr`.`puntocomercial` (`idpuntoComercial`, `cliente`) VALUES ('1', '1');


