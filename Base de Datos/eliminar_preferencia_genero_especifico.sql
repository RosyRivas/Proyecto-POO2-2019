CREATE OR REPLACE FUNCTION sp_eliminar_preferencia_genero_especifico(_idgenero integer, _idpreferencia integer)
  RETURNS SETOF record AS
$BODY$
DECLARE 
	punteropreferencia  REFCURSOR;
	preferenciageneros record; 
	
	punterogenero REFCURSOR;
	generos record ;

BEGIN
	OPEN punteropreferencia FOR SELECT  idgeneros_preferencia,idpreferencia, idgenero from generos_preferencia;
	LOOP 

		FETCH punteropreferencia INTO preferenciageneros;
		IF (FOUND) THEN
		
			IF (preferenciagenero.idpreferencia = $2 )  THEN
		
				OPEN punterogenero FOR SELECT idgenero from genero;
				LOOP
					FETCH  punterogenero INTO generos;
					
					if(preferenciageneros.idgenero= $1) THEN
						DELETE FROM generos_preferencia where (generos_preferencia.idgenero= $1 )and (generos_preferencia.idpreferencia=$2 );
						RAISE NOTICE 'Se elimino un genero de la preferencia';
						exit;
					else 
							
							RAISE NOTICE 'no se encontro el genero';
							exit;

					end if;

				end LOOP;
				close punterogenero;
			end if;
			end if;
		exit when not found;
		
		
	end LOOP;
	close punteropreferencia;
END;

$BODY$
  LANGUAGE plpgsql VOLATILE


  select sp_eliminar_preferencia_genero_especifico(5,3);

  select sp_eliminar_preferencia_actores_especifico(2,2);

  select * from actores_preferencia;

  insert into actores_preferencia(idactor, idpreferencia) values(1,1);
insert into actores_preferencia(idactor, idpreferencia) values(2,3);
insert into actores_preferencia(idactor, idpreferencia) values(3,2);
insert into actores_preferencia(idactor, idpreferencia) values(2,1);
insert into actores_preferencia(idactor, idpreferencia) values(2,2);