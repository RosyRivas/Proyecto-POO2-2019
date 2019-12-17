CREATE OR REPLACE FUNCTION listar_peliculas_director(IN _iddirector integer, OUT idpelicula integer, OUT titulo character varying, OUT portada character varying, OUT duracion character varying, OUT sinopsis character varying)
  RETURNS SETOF record AS
$BODY$
BEGIN
	IF  EXISTS(SELECT d.iddirector, biografia , apellido, fechanac,nombre  FROM director d WHERE (d.iddirector = $1)) THEN
	
	IF EXISTS(select p.idpelicula, p.titulo, p.portada, p.duracion, p.sinopsis from pelicula p inner join directores_pelicula dp on dp.idpelicula = p.idpelicula 
	where dp.iddirector IN (SELECT d.iddirector FROM director d  inner join directores_pelicula dp on dp.iddirector = d.iddirector) )then

	RETURN QUERY
	select p.idpelicula, p.titulo, p.portada, p.duracion, p.sinopsis from pelicula p inner join directores_pelicula dp on p.idpelicula = dp.idpelicula 
	where dp.iddirector IN(
	select d.iddirector from director d inner join directores_pelicula dp on d.iddirector = dp.iddirector where d.iddirector = $1
	ORDER BY d.iddirector) ;

	
	
	RAISE NOTICE 'Lista de peliculas por director ';

	ELSE
		RAISE NOTICE 'El director especificado no contiene peliculas para listar';
	END IF;
	
	ELSE
	RAISE NOTICE 'El director especificado no existe para listar peliculas';
END IF;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE