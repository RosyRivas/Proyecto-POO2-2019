CREATE OR REPLACE FUNCTION listar_peliculas_genero(IN _idgenero integer, OUT idpelicula integer, OUT titulo character varying, OUT portada character varying, OUT duracion character varying, OUT sinopsis character varying)
  RETURNS SETOF record AS
$BODY$
BEGIN
	IF  EXISTS(SELECT g.idgenero, g.descripcion FROM genero g WHERE (g.idgenero = $1)) THEN
	
	IF EXISTS(select p.idpelicula, p.titulo, p.portada, p.duracion, p.sinopsis from pelicula p inner join generos_pelicula gp on p.idpelicula = gp.idpelicula 
	where gp.idgenero IN (SELECT g.idgenero FROM genero g  inner join generos_pelicula gp on gp.idgenero = g.idgenero) )then

	RETURN QUERY
	select p.idpelicula, p.titulo, p.portada, p.duracion, p.sinopsis from pelicula p inner join generos_pelicula gp on p.idpelicula = gp.idpelicula 
	where gp.idgenero IN(
	select g.idgenero from genero g inner join generos_pelicula gp on g.idgenero = gp.idgenero where g.idgenero = $1
	ORDER BY g.idgenero) ;

	
	
	RAISE NOTICE 'Lista de peliculas por generos ';

	ELSE
		RAISE NOTICE 'El genero especificado no contiene peliculas para listar';
	END IF;
	
	ELSE
	RAISE NOTICE 'El genero especificado no existe para listar peliculas';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE