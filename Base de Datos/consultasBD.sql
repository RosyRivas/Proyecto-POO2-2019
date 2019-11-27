select * from pelicula;
select * from actor;
select * from director;
select * from genero;
select * from actores_pelicula;
select * from directores_pelicula;
select * from generos_pelicula;
--Seleccionar peliculas y sus actores.
SELECT * FROM
(select p.idpelicula, count(p.idpelicula) as ejemplar, p.titulo, p.duracion, p.sinopsis from pelicula p inner join actores_pelicula
on actores_pelicula.idpelicula = p.idpelicula group by p.idpelicula) AS t1
INNER JOIN
(select a.idactor, a.biografia, a.nombre, a.apellido, b.idpelicula from actor a, actores_pelicula b
where a.idactor = b.idactor) AS t2
ON t1.idpelicula = t2.idpelicula;
-------------------------------------------
--Seleccionar peliculas y sus directores.
SELECT * FROM
(select p.idpelicula, count(p.idpelicula) as ejemplar, p.titulo, p.duracion, p.sinopsis from pelicula p inner join actores_pelicula
on actores_pelicula.idpelicula = p.idpelicula group by p.idpelicula) AS t1
INNER JOIN
(select d.iddirector, d.biografia, d.nombre, d.apellido, b.idpelicula from director d, directores_pelicula b
where d.iddirector = b.iddirector) AS t2
ON t1.idpelicula = t2.idpelicula;
-------------------------------------------
--Seleccionar peliculas y sus generos.
SELECT * FROM
(select p.idpelicula, count(p.idpelicula) as ejemplar, p.titulo, p.duracion, p.sinopsis from pelicula p inner join actores_pelicula
on actores_pelicula.idpelicula = p.idpelicula group by p.idpelicula) AS t1
inner JOIN
(select g.idgenero, g.descripcion, p.idpelicula from genero g, generos_pelicula p
where g.idgenero = p.idgenero) AS t2
ON t1.idpelicula = t2.idpelicula;
----------------------------------------------------------------------------------------------------------------------------
select * from preferencia;
select * from actor;
select * from director;
select * from genero;
select * from actores_preferencia;

--Seleccionar preferencias de usuario, actores
SELECT * FROM
(select p.idpreferencia, p.idusuario from preferencia p inner join actores_preferencia a
on p.idpreferencia = a.idpreferencia) AS t1
INNER JOIN
(select a.idactor, a.nombre, a.apellido, a.biografia, b.idpreferencia from actor a, actores_preferencia b
where a.idactor = b.idactor) AS t2
ON t1.idpreferencia = t2.idpreferencia;

