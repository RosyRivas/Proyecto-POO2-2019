--insert into moderador (privilegio, nombre, apellido, fechanac, correo, alias, contrasena) values ('moderador del sistema','Fernando','Nahirnak','13/08/96','fer.nahirnak@gmail.com','compinche','1234')
--select *from preferencia
--select *from actor
--select *from director
--select *from genero
--select *from actores_preferencia
--select *from directores_preferencia
--select *from generos_preferencia

--Consultas a preferencias del usuario y moderador.

--Consultas a usuario.

--Seleccionar preferencias de usuario-actores
CREATE OR REPLACE FUNCTION listar_preferencia_usuario_actor(
    IN _idusuario integer,
    OUT idactor integer,
    OUT nombre character varying,
    OUT apellido character varying,
    OUT fechanac character varying,
    OUT biografia character varying)
  RETURNS SETOF record AS
$BODY$
BEGIN
	IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(select a.idactor, a.biografia, a.nombre, a.apellido, a.fechanac from actor a inner join actores_preferencia ap on a.idactor = ap.idactor
	where ap.idpreferencia IN (
	select p.idpreferencia from preferencia p inner join actores_preferencia ap on p.idpreferencia = ap.idpreferencia where p.idusuario = $1))THEN

	RETURN QUERY
	select a.idactor, a.nombre, a.apellido, a.fechanac, a.biografia from actor a inner join actores_preferencia ap on a.idactor = ap.idactor
	where ap.idpreferencia IN (
	select p.idpreferencia from preferencia p inner join actores_preferencia ap on p.idpreferencia = ap.idpreferencia where p.idusuario = $1) 
	ORDER BY a.idactor;
	RAISE NOTICE 'Lista de preferencias de actores del usuario';

	ELSE
		RAISE NOTICE 'El usuario especificado no contiene actores de preferencia';
	END IF;
	
	ELSE
	RAISE NOTICE 'El usuario especificado no existe para listar sus preferencias';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE


--Seleccionar preferencias de usuario-directores

CREATE OR REPLACE FUNCTION listar_preferencia_usuario_director(
    IN _idusuario integer,
    OUT iddirector integer,
    OUT biografia character varying,
    OUT nombre character varying,
    OUT apellido character varying,
    OUT fechanac character varying)
  RETURNS SETOF record AS
$BODY$
BEGIN
	IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(select d.iddirector, d.biografia, d.nombre, d.apellido, d.fechanac from director d inner join directores_preferencia dp on d.iddirector = dp.iddirector
	where dp.idpreferencia IN (
	select p.idpreferencia from preferencia p inner join directores_preferencia dp on p.idpreferencia = dp.idpreferencia where p.idusuario = $1))THEN

	RETURN QUERY
	select d.iddirector, d.biografia, d.nombre, d.apellido, d.fechanac from director d inner join directores_preferencia dp on d.iddirector = dp.iddirector
	where dp.idpreferencia IN (
	select p.idpreferencia from preferencia p inner join directores_preferencia dp on p.idpreferencia = dp.idpreferencia where p.idusuario = $1)
	ORDER BY d.iddirector;
	RAISE NOTICE 'Lista de preferencias de directores del usuario';

	ELSE
		RAISE NOTICE 'El usuario especificado no contiene directores de preferencia';
	END IF;
	
	ELSE
	RAISE NOTICE 'El usuario especificado no existe para listar sus preferencias';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE


--Seleccionar preferencias de usuario-generos
CREATE OR REPLACE FUNCTION listar_preferencia_usuario_genero(
    IN _idusuario integer,
    OUT idgenero integer,
    OUT descripcion character varying)
  RETURNS SETOF record AS
$BODY$
BEGIN
	IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(select g.idgenero, g.descripcion from genero g inner join generos_preferencia gp on g.idgenero = gp.idgenero
	where gp.idpreferencia IN (
	select p.idpreferencia from preferencia p inner join generos_preferencia gp on p.idpreferencia = gp.idpreferencia where p.idusuario = $1))THEN

	RETURN QUERY
	select g.idgenero, g.descripcion from genero g inner join generos_preferencia gp on g.idgenero = gp.idgenero
	where gp.idpreferencia IN (
	select p.idpreferencia from preferencia p inner join generos_preferencia gp on p.idpreferencia = gp.idpreferencia where p.idusuario = $1)
	ORDER BY g.idgenero;
	RAISE NOTICE 'Lista de preferencias de generos del usuario';

	ELSE
		RAISE NOTICE 'El usuario especificado no contiene generos de preferencia';
	END IF;
	
	ELSE
	RAISE NOTICE 'El usuario especificado no existe para listar sus preferencias';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Las consultas a las preferencias del moderador hay que adaptarlas a funciones luego.
/*

--Consultas a moderador

--Seleccionar preferencias de moderador-actores
SELECT * FROM
(select p.idpreferencia, p.idmoderador from preferencia p inner join actores_preferencia a
on p.idpreferencia = a.idpreferencia) AS t1
INNER JOIN
(select a.idactor, a.nombre, a.apellido, a.biografia, b.idpreferencia from actor a, actores_preferencia b
where a.idactor = b.idactor) AS t2
ON t1.idpreferencia = t2.idpreferencia;

--Seleccionar preferencias de moderador-directores
SELECT * FROM 
(select p.idpreferencia, p.idmoderador from preferencia p inner join directores_preferencia d
on p.idpreferencia = d.idpreferencia) AS t1
INNER JOIN 
(select d.iddirector, d.nombre, d.apellido, d.biografia, b.idpreferencia from director d, directores_preferencia b
where d.iddirector = b.iddirector) AS t2 
ON t1.idpreferencia = t2.idpreferencia; 

--Seleccionar preferencias de moderador-generos
SELECT * FROM 
(select p.idpreferencia, p.idmoderador from preferencia p inner join generos_preferencia g 
on p.idpreferencia = g.idpreferencia) AS t1
INNER JOIN
(select g.idgenero, g.descripcion, b.idpreferencia from genero g, generos_preferencia b
where g.idgenero = b.idgenero) AS t2
ON t1.idpreferencia = t2.idpreferencia; 

*/

--Función para crear preferencia de usuario-actor con controles para evitar repeticiones:

CREATE OR REPLACE FUNCTION crear_preferencia_usuario_actor(
    idusuario integer,
    idactor integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(idpreferencia) from preferencia) + 1; 
IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(SELECT a.idactor FROM actor a WHERE (a.idactor = $2))THEN
		IF EXISTS (SELECT p.idusuario FROM preferencia p WHERE p.idusuario = $1) THEN
			IF EXISTS(SELECT ap.idpreferencia FROM actores_preferencia ap where ap.idpreferencia = (
			SELECT p.idpreferencia FROM preferencia p WHERE p.idusuario = $1) and (ap.idactor = $2))  THEN
			RAISE NOTICE 'El actor especificado ya está en la lista de preferencias de actores';

			ELSE

			insert into actores_preferencia(idactor, idpreferencia) values ($2, (select p.idpreferencia from preferencia p where p.idusuario = $1));
			RAISE NOTICE 'Se creo la preferencia satisfactoriamente';

			END IF;
		
		ELSE
			IF (myvar IS NOT NULL) THEN
				insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,null, $1);  
				insert into actores_preferencia(idactor, idpreferencia) values($2,myvar);
				RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
	
			ELSE 
				insert into preferencia(idpreferencia, idmoderador, idusuario) values(1,null, $1);  
				insert into actores_preferencia(idactor, idpreferencia) values($2,1);
				RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
			END IF;
		END IF;
		
	ELSE
		RAISE NOTICE 'El actor especificado no existe para crear la preferencia';
	END IF;
ELSE
RAISE NOTICE 'El usuario especificado no existe para crear la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Se crea la preferencia para el usuario Osvaldo Zakowicz, actor Jhonn Rambo.
--SELECT FROM crear_preferencia_usuario_actor (1,2);
--Si intentamos crear nuevamente la misma preferencia para el usuario  Osvaldo Zakowicz del actor Jhonn Rambo, no funcionará, ya que fue anteriormente creada.

--Función para crear preferencia de usuario-director con controles para evitar repeticiones:
CREATE OR REPLACE FUNCTION crear_preferencia_usuario_director(
    idusuario integer,
    iddirector integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(idpreferencia) from preferencia) + 1; 
IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(SELECT d.iddirector FROM director d WHERE (d.iddirector = $2))THEN
		IF EXISTS (SELECT p.idusuario FROM preferencia p WHERE p.idusuario = $1) THEN
			IF EXISTS(SELECT dp.idpreferencia FROM directores_preferencia dp where dp.idpreferencia = (
			SELECT p.idpreferencia FROM preferencia p WHERE p.idusuario = $1) and (dp.iddirector = $2))  THEN
			RAISE NOTICE 'El director especificado ya está en la lista de preferencias de directores';

			ELSE

			insert into directores_preferencia(iddirector, idpreferencia) values ($2, (select p.idpreferencia from preferencia p where p.idusuario = $1));
			RAISE NOTICE 'Se creo la preferencia satisfactoriamente';

			END IF;
		
		ELSE
			IF (myvar IS NOT NULL) THEN
				insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,null, $1);  
				insert into directores_preferencia(iddirector, idpreferencia) values($2,myvar);
				RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
	
			ELSE 
				insert into preferencia(idpreferencia, idmoderador, idusuario) values(1,null, $1);  
				insert into directores_preferencia(iddirector, idpreferencia) values($2,1);
				RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
			END IF;
		END IF;
		
	ELSE
		RAISE NOTICE 'El director especificado no existe para crear la preferencia';
	END IF;
ELSE
RAISE NOTICE 'El usuario especificado no existe para crear la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Se crea la preferencia para Osvaldo Zakowicz, director George Lucas
--SELECT FROM crear_preferencia_usuario_director (1,1);
--Si intentamos crear nuevamente la misma preferencia para el usuario  Osvaldo Zakowicz del director George Lucas, no funcionará, ya que fue anteriormente creada. 

--Función para crear preferencia de usuario-genero:

CREATE OR REPLACE FUNCTION crear_preferencia_usuario_genero(
    idusuario integer,
    idgenero integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(idpreferencia) from preferencia) + 1; 
IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(SELECT g.idgenero FROM genero g WHERE (g.idgenero = $2))THEN
		IF EXISTS (SELECT p.idusuario FROM preferencia p WHERE p.idusuario = $1) THEN
			IF EXISTS(SELECT gp.idpreferencia FROM generos_preferencia gp where gp.idpreferencia = (
			SELECT p.idpreferencia FROM preferencia p WHERE p.idusuario = $1) and (gp.idgenero = $2))  THEN
			RAISE NOTICE 'El genero especificado ya está en la lista de preferencias de generos';

			ELSE

			insert into generos_preferencia(idgenero, idpreferencia) values ($2, (select p.idpreferencia from preferencia p where p.idusuario = $1));
			RAISE NOTICE 'Se creo la preferencia satisfactoriamente';

			END IF;
		
		ELSE
			IF (myvar IS NOT NULL) THEN
				insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,null, $1);  
				insert into generos_preferencia(idgenero, idpreferencia) values($2,myvar);
				RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
	
			ELSE 
				insert into preferencia(idpreferencia, idmoderador, idusuario) values(1,null, $1);  
				insert into generos_preferencia(idgenero, idpreferencia) values($2,1);
				RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
			END IF;
		END IF;
		
	ELSE
		RAISE NOTICE 'El genero especificado no existe para crear la preferencia';
	END IF;
ELSE
RAISE NOTICE 'El usuario especificado no existe para crear la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Se crea la preferencia para Osvaldo Zakowicz, genero Comedia
--SELECT FROM crear_preferencia_usuario_genero(1,4);
--Si intentamos crear nuevamente la misma preferencia para el usuario  Osvaldo Zakowicz del genero Comedia, no funcionará, ya que fue anteriormente creada. 


--Se deben de adaptar luego las funciones para crear preferencias del moderador con los controles asociados a las funciones del usuario.
/*

--Función para crear preferencia de moderador-actor:

CREATE OR REPLACE FUNCTION crear_preferencia_moderador_actor(
    idmoderador integer,
    idactor integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(idpreferencia) from preferencia) + 1; 
IF  EXISTS(SELECT m.idmoderador FROM moderador m WHERE (m.idmoderador = $1)) THEN
	IF EXISTS(SELECT a.idactor FROM actor a WHERE (a.idactor = $2))THEN
	insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,$1, null);  
	insert into actores_preferencia(idactor, idpreferencia) values($2,myvar);
	RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
	ELSE
		RAISE NOTICE 'El actor especificado no existe para crear la preferencia';
	END IF;
ELSE
	RAISE NOTICE 'El moderador especificado no existe para crear la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Se crea la preferencia para el moderador Nahirnak Fernando, actor Jhonn Rambo.
--SELECT FROM crear_preferencia_moderador_actor (3,2);

--Función para crear preferencia de moderador-director:

CREATE OR REPLACE FUNCTION crear_preferencia_moderador_director(
    idmoderador integer,
    iddirector integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(idpreferencia) from preferencia) + 1; 
IF  EXISTS(SELECT m.idmoderador FROM moderador m WHERE (m.idmoderador = $1)) THEN
	IF EXISTS(SELECT d.iddirector FROM director d WHERE (d.iddirector = $2))THEN
	insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,$1, null);  
	insert into directores_preferencia(iddirector, idpreferencia) values($2,myvar);
	RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
	ELSE
		RAISE NOTICE 'El director especificado no existe para crear la preferencia';
	END IF;
ELSE
	RAISE NOTICE 'El moderador especificado no existe para crear la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Se crea la preferencia para el moderador Nahirnak Fernando, director Steven Spielberg.
--SELECT FROM crear_preferencia_moderador_director (3,2);

--Función para crear preferencia de moderador-genero:

CREATE OR REPLACE FUNCTION crear_preferencia_moderador_genero(
    idmoderador integer,
    idgenero integer)
  RETURNS void AS
$BODY$
DECLARE myvar integer;
BEGIN
myvar:= (select max(idpreferencia) from preferencia) + 1; 
IF  EXISTS(SELECT m.idmoderador FROM moderador m WHERE (m.idmoderador = $1)) THEN
	IF EXISTS(SELECT g.idgenero FROM genero g WHERE (g.idgenero= $2))THEN
	insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,$1, null);  
	insert into generos_preferencia(idgenero, idpreferencia) values($2,myvar);
	RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
	ELSE
		RAISE NOTICE 'El genero especificado no existe para crear la preferencia';
	END IF;
ELSE
	RAISE NOTICE 'El moderador especificado no existe para crear la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Se crea la preferencia para el moderador Nahirnak Fernando, genero Ciencia Ficcion.
--SELECT FROM crear_preferencia_moderador_genero (3,1);

*/

--Funcion para eliminar un actor de las preferencias del usuario.

CREATE OR REPLACE FUNCTION eliminar_preferencia_usuario_actor(
    idusuario integer,
    idactor integer)
  RETURNS void AS
$BODY$
BEGIN
IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(SELECT a.idactor FROM actor a WHERE (a.idactor = $2))THEN
		IF EXISTS (SELECT p.idusuario FROM preferencia p WHERE p.idusuario = $1) THEN
			IF EXISTS(SELECT ap.idpreferencia FROM actores_preferencia ap where ap.idpreferencia = (
			SELECT p.idpreferencia FROM preferencia p WHERE p.idusuario = $1) and (ap.idactor = $2))  THEN

			delete from actores_preferencia ap where ap.idpreferencia = (select p.idpreferencia from preferencia p where p.idUsuario = $1) and ap.idactor = $2;  
			RAISE NOTICE 'El actor especificado  se elimino de preferencias de actores';

			ELSE

			RAISE NOTICE 'No existe la relacion entre el usuario y el actor especificado';

			END IF;
		ELSE
		RAISE NOTICE 'El usuario especificado no tiene una preferencia asignada';
	
		END IF;
		
	ELSE
		RAISE NOTICE 'El actor especificado no existe para eliminar la preferencia';
	END IF;
ELSE
RAISE NOTICE 'El usuario especificado no existe para eliminar la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Funcion para eliminar un director de las preferencias del usuario.

CREATE OR REPLACE FUNCTION eliminar_preferencia_usuario_director(
    idusuario integer,
    iddirector integer)
  RETURNS void AS
$BODY$
BEGIN
IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(SELECT d.iddirector FROM director d WHERE (d.iddirector = $2))THEN
		IF EXISTS (SELECT p.idusuario FROM preferencia p WHERE p.idusuario = $1) THEN
			IF EXISTS(SELECT dp.idpreferencia FROM directores_preferencia dp where dp.idpreferencia = (
			SELECT p.idpreferencia FROM preferencia p WHERE p.idusuario = $1) and (dp.iddirector = $2))  THEN

			delete from directores_preferencia dp where dp.idpreferencia = (select p.idpreferencia from preferencia p where p.idUsuario = $1) and dp.iddirector = $2;  
			RAISE NOTICE 'El director especificado  se elimino de preferencias de actores';

			ELSE

			RAISE NOTICE 'No existe la relacion entre el usuario y el director especificado';

			END IF;
		ELSE
		RAISE NOTICE 'El usuario especificado no tiene una preferencia asignada';
	
		END IF;
		
	ELSE
		RAISE NOTICE 'El director especificado no existe para eliminar la preferencia';
	END IF;
ELSE
RAISE NOTICE 'El usuario especificado no existe para eliminar la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Funcion para eliminar un genero de las preferencias del usuario.

CREATE OR REPLACE FUNCTION eliminar_preferencia_usuario_genero(
    idusuario integer,
    idgenero integer)
  RETURNS void AS
$BODY$
BEGIN
IF  EXISTS(SELECT u.idusuario FROM usuario u WHERE (u.idusuario = $1)) THEN
	IF EXISTS(SELECT g.idgenero FROM genero g WHERE (g.idgenero = $2))THEN
		IF EXISTS (SELECT p.idusuario FROM preferencia p WHERE p.idusuario = $1) THEN
			IF EXISTS(SELECT gp.idpreferencia FROM generos_preferencia gp where gp.idpreferencia = (
			SELECT p.idpreferencia FROM preferencia p WHERE p.idusuario = $1) and (gp.idgenero = $2))  THEN

			delete from generos_preferencia gp where gp.idpreferencia = (select p.idpreferencia from preferencia p where p.idUsuario = $1) and gp.idgenero = $2;  
			RAISE NOTICE 'El genero especificado  se elimino de preferencias de generos';

			ELSE

			RAISE NOTICE 'No existe la relacion entre el usuario y el genero especificado';

			END IF;
		ELSE
		RAISE NOTICE 'El usuario especificado no tiene una preferencia asignada';
	
		END IF;
		
	ELSE
		RAISE NOTICE 'El genero especificado no existe para eliminar la preferencia';
	END IF;
ELSE
RAISE NOTICE 'El usuario especificado no existe para eliminar la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE