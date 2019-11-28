
create or replace function sp_eliminar_preferencia_directores(_idpreferencia integer  )

RETURNS void 
AS
$BODY$
DECLARE 
	punterofila REFCURSOR;
	preferenciadirectores record; 

BEGIN
	OPEN punterofila FOR SELECT idpreferencia from directores_preferencia;
	LOOP 
		FETCH punterofila INTO preferenciadirectores;
		IF (FOUND) THEN
			IF (preferenciadirectores.idpreferencia = $1) THEN
				DELETE FROM directores_preferencia where idpreferencia=$1;
	
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

  