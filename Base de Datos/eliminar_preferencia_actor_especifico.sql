CREATE OR REPLACE FUNCTION sp_eliminar_preferencia_actores_especifico(_idactor integer, _idpreferencia integer)
  RETURNS SETOF record AS
$BODY$
DECLARE 
	punteropreferencia  REFCURSOR;
	preferenciaactores record; 
	
	punteroactor REFCURSOR;
	actores record ;

BEGIN
	OPEN punteropreferencia FOR SELECT  idactores_preferencia,idpreferencia, idactor from actores_preferencia;
	LOOP 

		FETCH punteropreferencia INTO preferenciaactores;
		IF (FOUND) THEN
		
			IF (preferenciaactores.idpreferencia = $2 )  THEN
		
				OPEN punteroactor FOR SELECT idactor from actor;
				LOOP
					FETCH  punteroactor INTO actores;
					
					if(preferenciaactores.idactor= $1) THEN
						DELETE FROM actores_preferencia where (actores_preferencia.idactor= $1 )and (actores_preferencia.idpreferencia=$2 );
						RAISE NOTICE 'Se elimino un actor de la preferencia';
						exit;
					else 
							
							RAISE NOTICE 'no se encontro el actor';
							exit;

					end if;

				end LOOP;
				close punteroactor;
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