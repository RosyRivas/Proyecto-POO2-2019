# Historial de cambios

## [No lanzado] 
### [0.0.11] - 2019-12-18
### Modificado
- Se modificaron los componentes de preferencia, pelicula y catalogo.
- Se modifico el script App.js
- Se modifico el estilo css.

### [0.0.10] - 2019-12-16
### Añadido
- Se añadio el componente para publicar pelicula.
- Se añadio funciones para listar peliculas por genero, director, actor.

### Modificado
- Se modificaron las funciones de Pelicula añadiendo controles.
- Se modificaron la clase  controlador y repositorio referido a pelicula.
- Se modifico el componente de preferencia.
- Se modifico la documentacion Javadoc.
- Se modifico el repositorio y controlador de pelicula.

### [0.0.9] - 2019-12-14
### Añadido
- Se añadieron las funciones para eliminar preferencias segun actor, director y genero.
- Se añadieron en la carpeta de recursos estilo css, componentes React de preferencia 
- Se añadio el Scrip App.js 
- Se anadio el archivo index.html 

### Modificado
- Se modfifico la funcion para listar preferencias segun actor.
- Se modificaron los controladores de actor, directo, genero y preferencias.
- Se modificaron las clases del repositorio.
- Se modificaron las rutas en la clase Servidor.

## [0.0.8] - 2019-12-11
### Modificado
- Se modifico la estructura de la base de datos.
- Se modificaron las funciones almacenadas en la base de datos añadiendo controles.
- se modificaron las clases de controlador y repositorio.

## [0.0.7] - 2019-11-28
### Añadido 
- Se añadio consultas y funciones sobre peliculas.
- Se añadio consultas y funciones sobre preferencias.
- Se añadio funciones de eliminacion de la relacion entre genero, director, actor respecto a preferencia del usuario.

## [0.0.6] - 2019-11-27
### Añadido
- Se añadio funciones de consultas sobre peliculas y preferencias.

## [0.0.5] -2019-11-25
### Añadido
- Se añadio el diagrama ER
- Se añadio el Scrip de la base de datos 
- Se añadio el scrip para carga de datos

## [0.0.4] - 2019-11-18
### Añadido
- Se añadió al proyecto una clase GenerosControlador en el paquete Controladores.
- Se añadió al proyecto una clase GenerosRepositorio en el paquete Repositorios.
- Se añadió al proyecto una clase Generos en el paquete Modelo.
- Se añadió al proyecto una clase GeneroNoEncontradoException.

### Modificado
- Se modificó la clase DirectoresRepositorio para corregir sintaxis de consulta.
- Se modificó la clase ActoresRepositorio para corregir sintaxis de consulta.
- Se modificaron los repositorios de Moderador, Peliculas, Reseñas modificando los nombres de las tablas a crearse en minúscula.
- Se modificó la clase Servidor contenida en el paquete Server para añadir respectivas rutas para operaciones HTTP a GenerosControlador.
- Se modificó la clase Servidor en la contraseña de la conexión para postgresql. 

## [0.0.3] - 2019-11-18
### Añadido
- Se añadió al proyecto una clase PeliculaControlador.
- Se añadió al proyecto una clase PeliculaRepositorio.
- Se añadió al proyecto una clase PeliculaNoEncontradaException.
- Se añadió al proyecto una clase DirecitoresControlador.
- Se añadió al proyecto una clase DirectoresRepositorio.
- Se añadió al proyecto una clase DirectorNoEncontradoException.
- Se añadió al proyecto una clase ModeradoresControlador.
- Se añadió al proyecto una clase ModeradorRepositorio.
- Se añadió al proyecto una clase ModeradorNoEncontradoException.

### Modificado
- Se modificó la clase servidor, añadiendo rutas (get, post, put, delete) a las operaciones de PelículaControlador.
- Se modificó la clase servidor, añadiendo rutas (get, post, put, delete) a las operaciones de DirectoresControlador.
- Se modificó la clase servidor, añadiendo rutas (get, post, put, delete) a las operaciones de ModeradoresControlador.

## [0.0.2] - 2019-11-18
### Añadido
- Se añadio al proyecto una clase ActoresControlador
- Se añadio al proyecto una clase ActoresRepositorio	
### Modificado
- Se modificó la clase Servidor agregando rutas para las operaciones HTTP dirigidas al controlador ActoresControlador

## [0.0.1] - 2019-11-17
### Añadido
- Se añadió al proyecto una clase PreferenciasControlador.
- Se añadió al proyecto una clase PreferenciasRepositorio. 
- Se añadio al proyecto una clase ReseñaControlador.
- Se añadio al proyecto una clase ReseñaRepositorio.

### Modificado
- Se modificó la clase Preferencias agregando un nuevo constructor vacio (sin parametros).
- Se modificó la clase Servidor agregando rutas y caminos para las operaciones HTTP dirigidas al controlador PreferenciasControlador.
- Se modificó la clase UsuariosControlador marcando comentario (omitiendo) la conversión del formulario recibido de solicitudes de Insomnia agregando procesamiento de solicitudes JSON con el método de Context *bodyAsClass*.
- Se modificó la clase Servidor agregando rutas para las operaciones HTTP dirigidas al controlador ReseñasControlador.



