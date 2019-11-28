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
SELECT * FROM
(select p.idpreferencia, p.idusuario from preferencia p inner join actores_preferencia a
on p.idpreferencia = a.idpreferencia) AS t1
INNER JOIN
(select a.idactor, a.nombre, a.apellido, a.biografia, b.idpreferencia from actor a, actores_preferencia b
where a.idactor = b.idactor) AS t2
ON t1.idpreferencia = t2.idpreferencia; 

--Seleccionar preferencias de usuario-directores
SELECT * FROM
(select p.idpreferencia, p.idusuario from preferencia p inner join directores_preferencia d
on p.idpreferencia = d.idpreferencia) AS t1
INNER JOIN
(select d.iddirector, d.nombre, d.apellido, d.biografia, b.idpreferencia from director d, directores_preferencia b
where d.iddirector = b.iddirector) AS t2
ON t1.idpreferencia = t2.idpreferencia;

--Seleccionar preferencias de usuario-generos
SELECT * FROM
(select p.idpreferencia, p.idusuario from preferencia p inner join generos_preferencia g
on p.idpreferencia = g.idpreferencia) AS t1
INNER JOIN 
(select g.idgenero, g.descripcion, b.idpreferencia from genero g, generos_preferencia b 
where g.idgenero = b.idgenero) AS t2 
ON t1.idpreferencia = t2.idpreferencia;

/*En este caso, para que tengamos resulados en la columna idmoderador debe de haber al menos una asociacion de la preferencia 
--respecto a un actor, director o genero. */ 

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

--Función para crear preferencia de usuario-actor:

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
	insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,null, $1);  
	insert into actores_preferencia(idactor, idpreferencia) values($2,myvar);
	RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
	ELSE
		RAISE NOTICE 'El actor especificado no existe para crear la preferencia';
	END IF;
ELSE
	RAISE NOTICE 'No el usuario especificado no existe para crear la preferencia';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE

--Se crea la preferencia para el usuario Osvaldo Zakowicz, actor Jhonn Rambo.
--SELECT FROM crear_preferencia_usuario_actor (1,2);

--Función para crear preferencia de usuario-director:

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
	insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,null, $1);  
	insert into directores_preferencia(iddirector, idpreferencia) values($2,myvar);
	RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
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
	insert into preferencia(idpreferencia, idmoderador, idusuario) values(myvar,null, $1);  
	insert into generos_preferencia(idgenero, idpreferencia) values($2,myvar);
	RAISE NOTICE 'Se creo la preferencia satisfactoriamente';
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