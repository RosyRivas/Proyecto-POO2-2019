select * from actor;
select * from director;
select * from genero;
--peliculas
select * from pelicula;
select * from actores_pelicula;
select * from directores_pelicula;
select * from generos_pelicula;
select * from resena;
--preferencia
select * from preferencia;
select * from actores_preferencia;
select * from directores_preferencia;
select * from generos_preferencia;
select * from usuario;
select * from moderador;
--actor
insert into actor(biografia, nombre, apellido, fechanac) values('biografia', 'Leonardo Jose', 'Di Caprio', '22/04/87');
insert into actor(biografia, nombre, apellido, fechanac) values('biografia', 'Jhonn', 'Rambo', '06/11/85');
insert into actor(biografia, nombre, apellido, fechanac) values('biografia', 'Agente', 'Schmit', '12/01/2001');
--director
insert into director(biografia, apellido, fechanac, nombre) values('biografia', 'Lucas', '04/12/82', 'George');
insert into director(biografia, apellido, fechanac, nombre) values('biografia', 'Spielberg', '23/05/79', 'Steven');
insert into director(biografia, apellido, fechanac, nombre) values('Biografia', 'Kubrick', '07/10/72', 'Stanley');
--genero
insert into genero(descripcion) values('Ciencia Ficcion');
insert into genero(descripcion) values('Terror');
insert into genero(descripcion) values('Drama');
insert into genero(descripcion) values('Comedia');
insert into genero(descripcion) values('Accion');
--pelicula
insert into pelicula(titulo, portada, duracion, sinopsis)
values('Star Wars III', 'https://www.portadasdepelis.com', '180', 'sinopsis');
insert into pelicula(titulo, portada, duracion, sinopsis)
values('El Resplandor', 'https://www.portadasdepelis.com', '160', 'sinopsis');
insert into pelicula(titulo, portada, duracion, sinopsis)
values('Mas barato por Docena', 'https://www.portadasdepelis.com', '160', 'sinopsis');
--Actores_pelicula
insert into actores_pelicula(idactor, idpelicula) values(1,1);
insert into actores_pelicula(idactor, idpelicula) values(3,1);
insert into actores_pelicula(idactor, idpelicula) values(1,2);
insert into actores_pelicula(idactor, idpelicula) values(2,3);
--Directores_pelicula
insert into directores_pelicula(idpelicula, iddirector) values(1,2);
insert into directores_pelicula(idpelicula, iddirector) values(2,1);
insert into directores_pelicula(idpelicula, iddirector) values(3,3);
--Generos_pelicula
insert into generos_pelicula(idgenero, idpelicula) values(1, 1);
insert into generos_pelicula(idgenero, idpelicula) values(5, 1);
insert into generos_pelicula(idgenero, idpelicula) values(2, 2);
insert into generos_pelicula(idgenero, idpelicula) values(3, 3);
insert into generos_pelicula(idgenero, idpelicula) values(4, 3);
--usuario
insert into usuario(nombre, apellido, fechanac, correo, alias, contrasena)
values('Osvaldo', 'Zakowicz', '22/03/96', 'correo@correo', 'osval', 'contrasena');
insert into usuario(nombre, apellido, fechanac, correo, alias, contrasena)
values('Jose', 'Perez', '22/03/96', 'correo@correo', 'Jo', 'contrasena');
insert into usuario(nombre, apellido, fechanac, correo, alias, contrasena)
values('Juan', 'Lopez', '22/03/96', 'correo@correo', 'J', 'contrasena');
--moderador
insert into moderador(privilegio, nombre, apellido, fechanac, correo, alias, contrasena)
values('moderador del sistema','Osvaldo', 'Zakowicz', '22/03/96', 'correo@correo', 'osval', 'contrasena');
insert into moderador(privilegio, nombre, apellido, fechanac, correo, alias, contrasena)
values('moderador del sistema','Jose', 'Perez', '22/03/96', 'correo@correo', 'Jo', 'contrasena');
--resena
insert into resena(descripcion, idpelicula, idusuario, idmoderador) values('Una pelicula sin precedentes...', 1, 2, null);
insert into resena(descripcion, idpelicula, idusuario, idmoderador) values('Una pelicula de miedo sin igual...', 2, null,2);
insert into resena(descripcion, idpelicula, idusuario, idmoderador) values('Una pelicula comica hasta el fin...', 3, 1, null);
insert into resena(descripcion, idpelicula, idusuario, idmoderador) values('Una pelicula sin precedentes...', 1, 3, null);
insert into resena(descripcion, idpelicula, idusuario, idmoderador) values('Una pelicula de miedo sin igual...', 2, null, 1);
insert into resena(descripcion, idpelicula, idusuario, idmoderador) values('Una pelicula comica hasta el fin...', 3, 3, null);
--preferencia
insert into preferencia(idmoderador, idusuario) values(null, 1); --preferencias usuario 1
insert into preferencia(idmoderador, idusuario) values(null, 2); --preferencias usuario 2
insert into preferencia(idmoderador, idusuario) values(null, 3); --preferencias usuario 3
insert into preferencia(idmoderador, idusuario) values(1, null); --preferencias moderador 1
insert into preferencia(idmoderador, idusuario) values(2, null); --preferencias moderador 2

--actor_preferencias para usuarios
insert into actores_preferencia(idactor, idpreferencia) values(1,1);
insert into actores_preferencia(idactor, idpreferencia) values(2,3);
insert into actores_preferencia(idactor, idpreferencia) values(3,2);
insert into actores_preferencia(idactor, idpreferencia) values(2,1);
insert into actores_preferencia(idactor, idpreferencia) values(2,2);
--director_preferencias para usuarios
insert into directores_preferencia(iddirector, idpreferencia) values(3,1);
insert into directores_preferencia(iddirector, idpreferencia) values(1,2);
insert into directores_preferencia(iddirector, idpreferencia) values(2,1);
insert into directores_preferencia(iddirector, idpreferencia) values(2,3);
insert into directores_preferencia(iddirector, idpreferencia) values(1,3);
--genero_preferencias para usuarios
insert into generos_preferencia(idgenero, idpreferencia) values(1,1);
insert into generos_preferencia(idgenero, idpreferencia) values(4,2);
insert into generos_preferencia(idgenero, idpreferencia) values(5,3);


