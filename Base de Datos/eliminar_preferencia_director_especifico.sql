CREATE OR REPLACE FUNCTION sp_eliminar_preferencia_actores_especifico(_iddirector integer, _idpreferencia integer)
  RETURNS SETOF record AS
$BODY$
DECLARE 
	punteropreferencia  REFCURSOR;
	preferenciadirectores record; 
	
	punterodirector REFCURSOR;
	directores record ;

BEGIN
	OPEN punteropreferencia FOR SELECT  idactores_preferencia,idpreferencia, iddirector from directores_preferencia;
	LOOP 

		FETCH punteropreferencia INTO preferenciadirectores;
		IF (FOUND) THEN
		
			IF (preferenciadirectores.idpreferencia = $2 )  THEN
		
				OPEN punterodirector FOR SELECT iddirector from director;
				LOOP
					FETCH  punterodirector INTO directores;
					
					if(preferenciadirectores.iddirector= $1) THEN
						DELETE FROM directores_preferencia where (directores_preferencia.iddirector= $1 )and (directores_preferencia.idpreferencia=$2 );
						RAISE NOTICE 'Se elimino un director de la preferencia';
						exit;
					else 
							
							RAISE NOTICE 'no se encontro el director';
							exit;

					end if;

				end LOOP;
				close punterodirector;
			end if;
			end if;
		exit when not found;
		
		
	end LOOP;
	close punteropreferencia;
END;

$BODY$
  LANGUAGE plpgsql VOLATILE


  select sp_eliminar_preferencia_actores_especifico(2,2);

  select * from actores_preferencia;

  insert into actores_preferencia(idactor, idpreferencia) values(1,1);
insert into actores_preferencia(idactor, idpreferencia) values(2,3);
insert into actores_preferencia(idactor, idpreferencia) values(3,2);
insert into actores_preferencia(idactor, idpreferencia) values(2,1);
insert into actores_preferencia(idactor, idpreferencia) values(2,2);