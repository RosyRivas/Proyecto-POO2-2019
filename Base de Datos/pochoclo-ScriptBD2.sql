
CREATE SEQUENCE public.moderador_idmoderador_seq_2;	

CREATE TABLE public.Moderador (	
                idModerador INTEGER NOT NULL DEFAULT nextval('public.moderador_idmoderador_seq_2'),	
                privilegio VARCHAR NOT NULL,	
                nombre VARCHAR NOT NULL,	
                apellido VARCHAR NOT NULL,	
                fechaNac VARCHAR NOT NULL,	
                correo VARCHAR NOT NULL,	
                alias VARCHAR NOT NULL,	
                contrasena VARCHAR NOT NULL,	
                CONSTRAINT moderador_pk PRIMARY KEY (idModerador)	
);	


ALTER SEQUENCE public.moderador_idmoderador_seq_2 OWNED BY public.Moderador.idModerador;	

CREATE SEQUENCE public.usuario_idusuario_seq_2;	

CREATE TABLE public.Usuario (	
                idUsuario INTEGER NOT NULL DEFAULT nextval('public.usuario_idusuario_seq_2'),	
                nombre VARCHAR NOT NULL,	
                apellido VARCHAR NOT NULL,	
                fechaNac VARCHAR NOT NULL,	
                correo VARCHAR NOT NULL,	
                alias VARCHAR NOT NULL,	
                contrasena VARCHAR NOT NULL,	
                CONSTRAINT usuario_pk PRIMARY KEY (idUsuario)	
);	


ALTER SEQUENCE public.usuario_idusuario_seq_2 OWNED BY public.Usuario.idUsuario;	

CREATE SEQUENCE public.preferencia_idpreferencia_seq;	

CREATE TABLE public.Preferencia (	
                idPreferencia INTEGER NOT NULL DEFAULT nextval('public.preferencia_idpreferencia_seq'),	
                idModerador INTEGER,	
                idUsuario INTEGER,	
                CONSTRAINT preferencia_pk PRIMARY KEY (idPreferencia)	
);	


ALTER SEQUENCE public.preferencia_idpreferencia_seq OWNED BY public.Preferencia.idPreferencia;	

CREATE SEQUENCE public.pelicula_idpelicula_seq;	

CREATE TABLE public.Pelicula (	
                idPelicula INTEGER NOT NULL DEFAULT nextval('public.pelicula_idpelicula_seq'),	
                titulo VARCHAR NOT NULL,	
                portada VARCHAR NOT NULL,	
                duracion VARCHAR NOT NULL,	
                sinopsis VARCHAR NOT NULL,	
                CONSTRAINT pelicula_pk PRIMARY KEY (idPelicula)	
);	


ALTER SEQUENCE public.pelicula_idpelicula_seq OWNED BY public.Pelicula.idPelicula;	

CREATE SEQUENCE public.resena_idresena_seq;	

CREATE TABLE public.Resena (	
                idResena INTEGER NOT NULL DEFAULT nextval('public.resena_idresena_seq'),	
                descripcion VARCHAR NOT NULL,	
                idPelicula INTEGER NOT NULL,	
                idUsuario INTEGER,	
                idModerador INTEGER,	
                CONSTRAINT resena_pk PRIMARY KEY (idResena)	
);	


ALTER SEQUENCE public.resena_idresena_seq OWNED BY public.Resena.idResena;	

CREATE SEQUENCE public.genero_idgenero_seq;	

CREATE TABLE public.Genero (	
                idGenero INTEGER NOT NULL DEFAULT nextval('public.genero_idgenero_seq'),	
                descripcion VARCHAR NOT NULL,	
                CONSTRAINT genero_pk PRIMARY KEY (idGenero)	
);	


ALTER SEQUENCE public.genero_idgenero_seq OWNED BY public.Genero.idGenero;	

CREATE SEQUENCE public.generos_preferencia_idgeneros_preferencia_seq;	

CREATE TABLE public.Generos_Preferencia (	
                idGeneros_preferencia INTEGER NOT NULL DEFAULT nextval('public.generos_preferencia_idgeneros_preferencia_seq'),	
                idGenero INTEGER NOT NULL,	
                idPreferencia INTEGER NOT NULL,	
                CONSTRAINT generos_preferencia_pk PRIMARY KEY (idGeneros_preferencia)	
);	


ALTER SEQUENCE public.generos_preferencia_idgeneros_preferencia_seq OWNED BY public.Generos_Preferencia.idGeneros_preferencia;	

CREATE SEQUENCE public.generos_pelicula_idgeneros_pelicula_seq;	

CREATE TABLE public.Generos_Pelicula (	
                idGeneros_pelicula INTEGER NOT NULL DEFAULT nextval('public.generos_pelicula_idgeneros_pelicula_seq'),	
                idGenero INTEGER NOT NULL,	
                idPelicula INTEGER NOT NULL	
);	


ALTER SEQUENCE public.generos_pelicula_idgeneros_pelicula_seq OWNED BY public.Generos_Pelicula.idGeneros_pelicula;	

CREATE SEQUENCE public.director_iddirector_seq;	

CREATE TABLE public.Director (	
                idDirector INTEGER NOT NULL DEFAULT nextval('public.director_iddirector_seq'),	
                biografia VARCHAR NOT NULL,	
                apellido VARCHAR NOT NULL,	
                fechaNac VARCHAR NOT NULL,	
                nombre VARCHAR NOT NULL,	
                CONSTRAINT director_pk PRIMARY KEY (idDirector)	
);	


ALTER SEQUENCE public.director_iddirector_seq OWNED BY public.Director.idDirector;	

CREATE SEQUENCE public.directores_preferencia_iddirectores_preferencia_seq;	

CREATE TABLE public.Directores_Preferencia (	
                idDirectores_preferencia INTEGER NOT NULL DEFAULT nextval('public.directores_preferencia_iddirectores_preferencia_seq'),	
                idDirector INTEGER NOT NULL,	
                idPreferencia INTEGER NOT NULL,	
                CONSTRAINT directores_preferencia_pk PRIMARY KEY (idDirectores_preferencia)	
);	


ALTER SEQUENCE public.directores_preferencia_iddirectores_preferencia_seq OWNED BY public.Directores_Preferencia.idDirectores_preferencia;	

CREATE SEQUENCE public.directores_pelicula_iddirectores_pelicula_seq;	

CREATE TABLE public.Directores_Pelicula (	
                idDirectores_pelicula INTEGER NOT NULL DEFAULT nextval('public.directores_pelicula_iddirectores_pelicula_seq'),	
                idPelicula INTEGER NOT NULL,	
                idDirector INTEGER NOT NULL,	
                CONSTRAINT directores_pelicula_pk PRIMARY KEY (idDirectores_pelicula)	
);	


ALTER SEQUENCE public.directores_pelicula_iddirectores_pelicula_seq OWNED BY public.Directores_Pelicula.idDirectores_pelicula;	

CREATE SEQUENCE public.actor_idactor_seq;	

CREATE TABLE public.Actor (	
                idActor INTEGER NOT NULL DEFAULT nextval('public.actor_idactor_seq'),	
                biografia VARCHAR NOT NULL,	
                nombre VARCHAR NOT NULL,	
                apellido VARCHAR NOT NULL,	
                fechaNac VARCHAR NOT NULL,	
                CONSTRAINT actor_pk PRIMARY KEY (idActor)	
);	


ALTER SEQUENCE public.actor_idactor_seq OWNED BY public.Actor.idActor;	

CREATE SEQUENCE public.actores_preferencia_idactores_preferencia_seq;	

CREATE TABLE public.Actores_Preferencia (	
                idActores_preferencia INTEGER NOT NULL DEFAULT nextval('public.actores_preferencia_idactores_preferencia_seq'),	
                idActor INTEGER NOT NULL,	
                idPreferencia INTEGER NOT NULL,	
                CONSTRAINT actores_preferencia_pk PRIMARY KEY (idActores_preferencia)	
);	


ALTER SEQUENCE public.actores_preferencia_idactores_preferencia_seq OWNED BY public.Actores_Preferencia.idActores_preferencia;	

CREATE SEQUENCE public.actores_pelicula_idactores_pelicula_seq;	

CREATE TABLE public.Actores_Pelicula (	
                idActores_pelicula INTEGER NOT NULL DEFAULT nextval('public.actores_pelicula_idactores_pelicula_seq'),	
                idActor INTEGER NOT NULL,	
                idPelicula INTEGER NOT NULL,	
                CONSTRAINT actores_pelicula_pk PRIMARY KEY (idActores_pelicula)	
);	


ALTER SEQUENCE public.actores_pelicula_idactores_pelicula_seq OWNED BY public.Actores_Pelicula.idActores_pelicula;	

ALTER TABLE public.Resena ADD CONSTRAINT moderador_resena_fk	
FOREIGN KEY (idModerador)	
REFERENCES public.Moderador (idModerador)	
ON DELETE NO ACTION	
ON UPDATE NO ACTION	
NOT DEFERRABLE;	

ALTER TABLE public.Preferencia ADD CONSTRAINT moderador_preferencia_fk	
FOREIGN KEY (idModerador)	
REFERENCES public.Moderador (idModerador)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Resena ADD CONSTRAINT usuario_resena_fk	
FOREIGN KEY (idUsuario)	
REFERENCES public.Usuario (idUsuario)	
ON DELETE NO ACTION	
ON UPDATE NO ACTION	
NOT DEFERRABLE;	

ALTER TABLE public.Preferencia ADD CONSTRAINT usuario_preferencia_fk	
FOREIGN KEY (idUsuario)	
REFERENCES public.Usuario (idUsuario)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Directores_Preferencia ADD CONSTRAINT preferencia_directores_preferencia_fk	
FOREIGN KEY (idPreferencia)	
REFERENCES public.Preferencia (idPreferencia)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Actores_Preferencia ADD CONSTRAINT preferencia_actores_preferencia_fk	
FOREIGN KEY (idPreferencia)	
REFERENCES public.Preferencia (idPreferencia)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Generos_Preferencia ADD CONSTRAINT preferencia_generos_preferencia_fk	
FOREIGN KEY (idPreferencia)	
REFERENCES public.Preferencia (idPreferencia)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Resena ADD CONSTRAINT pelicula_resena_fk	
FOREIGN KEY (idPelicula)	
REFERENCES public.Pelicula (idPelicula)	
ON DELETE NO ACTION	
ON UPDATE NO ACTION	
NOT DEFERRABLE;	

ALTER TABLE public.Directores_Pelicula ADD CONSTRAINT pelicula_directores_pelicula_fk	
FOREIGN KEY (idPelicula)	
REFERENCES public.Pelicula (idPelicula)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Actores_Pelicula ADD CONSTRAINT pelicula_actores_pelicula_fk	
FOREIGN KEY (idPelicula)	
REFERENCES public.Pelicula (idPelicula)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Generos_Pelicula ADD CONSTRAINT pelicula_generos_pelicula_fk	
FOREIGN KEY (idPelicula)	
REFERENCES public.Pelicula (idPelicula)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Generos_Pelicula ADD CONSTRAINT genero_generos_pelicula_fk	
FOREIGN KEY (idGenero)	
REFERENCES public.Genero (idGenero)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Generos_Preferencia ADD CONSTRAINT genero_generos_preferencia_fk	
FOREIGN KEY (idGenero)	
REFERENCES public.Genero (idGenero)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Directores_Pelicula ADD CONSTRAINT director_directores_pelicula_fk	
FOREIGN KEY (idDirector)	
REFERENCES public.Director (idDirector)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Directores_Preferencia ADD CONSTRAINT director_directores_preferencia_fk	
FOREIGN KEY (idDirector)	
REFERENCES public.Director (idDirector)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Actores_Pelicula ADD CONSTRAINT actor_actores_pelicula_fk	
FOREIGN KEY (idActor)	
REFERENCES public.Actor (idActor)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE;	

ALTER TABLE public.Actores_Preferencia ADD CONSTRAINT actor_actores_preferencia_fk	
FOREIGN KEY (idActor)	
REFERENCES public.Actor (idActor)	
ON DELETE NO ACTION	
ON UPDATE CASCADE	
NOT DEFERRABLE; 