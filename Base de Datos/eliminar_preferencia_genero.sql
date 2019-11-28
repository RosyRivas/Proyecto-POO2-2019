
create or replace function sp_eliminar_preferencia_genero(_idpreferencia integer  )

RETURNS void 
AS
$BODY$
DECLARE 
	punterofila REFCURSOR;
	preferenciagenero record; 

BEGIN
	OPEN punterofila FOR SELECT idpreferencia from generos_preferencia;
	LOOP 
		FETCH punterofila INTO preferenciagenero;
		IF (FOUND) THEN
			IF (preferenciagenero.idpreferencia = $1) THEN
				DELETE FROM generos_preferencia where idpreferencia=$1;
	
			end if;
		exit when not found;
		end if;
	end LOOP;
	CLOSE punterofila;
end;

$BODY$
  LANGUAGE plpgsql VOLATILE
  
select sp_eliminar_preferencia_genero(1);

select * from actores_preferencia; 

  