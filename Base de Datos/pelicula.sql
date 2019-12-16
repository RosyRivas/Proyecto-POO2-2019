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
    _idpelicula integer,
    _idactor integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(idactores_pelicula) from actores_pelicula) + 1; 
IF  EXISTS(SELECT a.idactor FROM actor a WHERE (a.idactor = $2)) THEN
		IF EXISTS(SELECT p.idpelicula FROM pelicula p WHERE (p.idpelicula = $1))THEN
				IF EXISTS(SELECT ap.idpelicula FROM actores_pelicula ap where (ap.idpelicula = $1) and (ap.idactor = $2))  THEN
							RAISE NOTICE 'El actor especificado ya esta relacionado con la pelicula';

				ELSE
					IF (myvar IS NOT NULL) THEN
							insert into actores_pelicula(idactores_pelicula, idactor, idpelicula) values(myvar,$2, $1);  
							RAISE NOTICE 'Se creo la  relacion satisfactoriamente';
					ELSE 
							insert into actores_pelicula(idactores_pelicula, idactor, idpelicula) values(1,$2, $1);
							RAISE NOTICE 'Se creo la relacion satisfactoriamente';
					END IF;
			      END IF;
		ELSE
				RAISE NOTICE 'La pelicula especificada no existe para crear la relacion';
				END IF;
ELSE
RAISE NOTICE 'El actor especificado no existe para crear la relacion';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE



--FUNCION ASOCIAR DIRECTOR A PELICULA
CREATE OR REPLACE FUNCTION director_pelicula(
    _idpelicula integer,
    _iddirector integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(iddirectores_pelicula) from directores_pelicula) + 1; 
IF  EXISTS(SELECT d.iddirector FROM director d WHERE (d.iddirector = $2)) THEN
		IF EXISTS(SELECT p.idpelicula FROM pelicula p WHERE (p.idpelicula = $1))THEN
				IF EXISTS(SELECT dp.idpelicula FROM directores_pelicula dp where (dp.idpelicula = $1) and (dp.iddirector = $2))  THEN
							RAISE NOTICE 'El director especificado ya esta relacionado con la pelicula';

				ELSE
					IF (myvar IS NOT NULL) THEN
							insert into directores_pelicula(iddirectores_pelicula, iddirector, idpelicula) values(myvar,$2, $1);  
							RAISE NOTICE 'Se creo la  relacion satisfactoriamente';
					ELSE 
							insert into directores_pelicula(iddirectores_pelicula, iddirector, idpelicula) values(1,$2, $1);
							RAISE NOTICE 'Se creo la relacion satisfactoriamente';
					END IF;
			      END IF;
		ELSE
				RAISE NOTICE 'La pelicula especificada no existe para crear la relacion';
				END IF;
ELSE
RAISE NOTICE 'El director especificado no existe para crear la relacion';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--FUNCION ASOCIAR GENERO A PELICULA
CREATE OR REPLACE FUNCTION genero_pelicula(
    _idpelicula integer,
    _idgenero integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(idgeneros_pelicula) from generos_pelicula) + 1; 
IF  EXISTS(SELECT g.idgenero FROM genero g WHERE (g.idgenero = $2)) THEN
		IF EXISTS(SELECT p.idpelicula FROM pelicula p WHERE (p.idpelicula = $1))THEN
				IF EXISTS(SELECT gp.idpelicula FROM generos_pelicula gp where (gp.idpelicula = $1) and (gp.idgenero = $2))  THEN
							RAISE NOTICE 'El genero especificado ya esta relacionado con la pelicula';

				ELSE
					IF (myvar IS NOT NULL) THEN
							insert into generos_pelicula(idgeneros_pelicula, idgenero, idpelicula) values(myvar,$2, $1);  
							RAISE NOTICE 'Se creo la  relacion satisfactoriamente';
					ELSE 
							insert into generos_pelicula(idgeneros_pelicula, idgenero, idpelicula) values(1,$2, $1);
							RAISE NOTICE 'Se creo la relacion satisfactoriamente';
					END IF;
			      END IF;
		ELSE
				RAISE NOTICE 'La pelicula especificada no existe para crear la relacion';
				END IF;
ELSE
RAISE NOTICE 'El genero especificado no existe para crear la relacion';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
----------------------------------------------------------------------------------------------------------------------------

