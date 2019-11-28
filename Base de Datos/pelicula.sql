select * from pelicula;
select * from actor;
select * from director;
select * from genero;
select * from actores_pelicula;
select * from directores_pelicula;
select * from generos_pelicula;
--PELICULA
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
(select p.idpelicula, count(p.idpelicula), p.titulo, p.duracion, p.sinopsis from pelicula p inner join actores_pelicula
on actores_pelicula.idpelicula = p.idpelicula group by p.idpelicula) AS t1
INNER JOIN
(select d.iddirector, d.biografia, d.nombre, d.apellido, b.idpelicula from director d, directores_pelicula b
where d.iddirector = b.iddirector) AS t2
ON t1.idpelicula = t2.idpelicula;
-------------------------------------------
--Seleccionar peliculas y sus generos.
SELECT * FROM
(select p.idpelicula, count(p.idpelicula), p.titulo, p.duracion, p.sinopsis from pelicula p inner join actores_pelicula
on actores_pelicula.idpelicula = p.idpelicula group by p.idpelicula) AS t1
inner JOIN
(select g.idgenero, g.descripcion, p.idPelicula from genero g, generos_pelicula p
where g.idgenero = p.idgenero) AS t2
ON t1.idpelicula = t2.idpelicula;

--FUNCION INSERTAR PELICULA
CREATE OR REPLACE FUNCTION insertar_pelicula(
	_titulo character varying,
	_portada character varying,
	_duracion character varying,
	_sinopsis character varying
)
RETURNS text AS
$BODY$
declare mensaje text;
	begin
		insert into pelicula(titulo, portada, duracion, sinopsis) values($1,$2,$3,$4);
		mensaje = 'OK';
		return mensaje;
	end;
$BODY$
LANGUAGE plpgsql VOLATILE
select insertar_pelicula('Casa Embrujada', 'https://www.altaportada.com', '160', 'Sinopsis');

--FUNCIÓN ACTUALIZAR PELICULA
CREATE OR REPLACE FUNCTION actualizar_pelicula(
	_idPelicula integer,
	_titulo character varying,
	_portada character varying,
	_duracion character varying,
	_sinopsis character varying
)
RETURNS text AS
$BODY$
declare mensaje text;
	begin
		if(select count(idPelicula) from pelicula where idPelicula = _idPelicula) = 1 then
			update pelicula set titulo = _titulo, portada = _portada, duracion = _duracion, sinopsis = _sinopsis where idpelicula = _idPelicula;
			mensaje = 'OK';
		else
			mensaje = '404';
		end if;
		return mensaje;
	end;
$BODY$
LANGUAGE plpgsql VOLATILE
select actualizar_pelicula(7, 'Star Wars IV', 'https://www.altaportada.com', '190', 'sinopsis');

--FUNCION ELIMINAR PELICULA
CREATE OR REPLACE FUNCTION eliminar_pelicula(
	_idPelicula integer
)
RETURNS text AS
$BODY$
declare mensaje text;
	begin
		if(select count(idPelicula) from pelicula where idPelicula = _idPelicula) = 1 then
			delete from pelicula where idPelicula = _idPelicula;
			mensaje = 'OK';
		else
			mensaje = '404';
		end if;
		return mensaje;
	end;
$BODY$
LANGUAGE plpgsql VOLATILE
select eliminar_pelicula(7);

--FUNCIÓN ASOCIAR ACTOR A PELICULA
CREATE OR REPLACE FUNCTION actor_pelicula(
	_idPelicula integer,
	_idActor integer
)
RETURNS text AS
$BODY$
declare mensaje text;
	begin
		if(select count(idPelicula) from pelicula where idPelicula = _idPelicula) = 1 then
			if(select count(idActor) from actor where idActor = _idActor) = 1 then
				insert into actores_pelicula(idPelicula, idActor) values($1, $2);
				mensaje = 'OK';
			else
				mensaje = '404';
			end if;
		else
			mensaje = '404';
		end if;
		return mensaje;
	end;
$BODY$
LANGUAGE plpgsql VOLATILE

--FUNCION ASOCIAR DIRECTOR A PELICULA
CREATE OR REPLACE FUNCTION director_pelicula(
	_idPelicula integer,
	_idDirector integer
)
RETURNS text AS
$BODY$
declare mensaje text;
	begin
		if(select count(idPelicula) from pelicula where idPelicula = _idPelicula) = 1 then
			if(select count(idDirector) from director where idDirector = _idDirector) = 1 then
				insert into directores_pelicula(idPelicula, idDirector) values($1, $2);
				mensaje = 'OK';
			else
				mensaje = '404';
			end if;
		else
			mensaje = '404';
		end if;
		return mensaje;
	end;
$BODY$
LANGUAGE plpgsql VOLATILE

--FUNCION ASOCIAR GENERO A PELICULA
CREATE OR REPLACE FUNCTION genero_pelicula(
	_idGenero integer,
	_idPelicula integer
)
RETURNS text AS
$BODY$
declare mensaje text;
	begin
		if(select count(idPelicula) from pelicula where idPelicula = _idPelicula) = 1 then
			if(select count(idGenero) from genero where idGenero = _idGenero) = 1 then
				insert into generos_pelicula(idGenero, idPelicula) values($1, $2);
				mensaje = 'OK';
			else
				mensaje = '404';
			end if;
		else
			mensaje = '404';
		end if;
		return mensaje;
	end;
$BODY$
LANGUAGE plpgsql VOLATILE
----------------------------------------------------------------------------------------------------------------------------

