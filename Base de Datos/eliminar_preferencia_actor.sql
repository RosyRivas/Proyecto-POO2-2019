create or replace function sp_eliminar_preferencia_actor(_idpreferencia integer  )

RETURNS void 
AS
$BODY$
DECLARE 
	punterofila REFCURSOR;
	preferenciaactor record; 

BEGIN
	OPEN punterofila FOR SELECT idpreferencia from actores_preferencia;
	LOOP 
		FETCH punterofila INTO preferenciaactor;
		IF (FOUND) THEN
			IF (preferenciaactor.idpreferencia = $1) THEN
				DELETE FROM actores_preferencia where idpreferencia=$1;
	
			end if;
		exit when not found;
		end if;
	end LOOP;
	CLOSE punterofila;
end;

$BODY$
  LANGUAGE plpgsql VOLATILE

  
select sp_eliminar_preferencia_actor(1);
select * from actores_preferencia; 

  