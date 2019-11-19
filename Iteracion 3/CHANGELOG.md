# Historial de cambios

## [No lanzado] 

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
- Se añadio al proyecto una clase ReseñaResositorio.

### Modificado
- Se modificó la clase Preferencias agregando un nuevo constructor vacio (sin parametros).
- Se modificó la clase Servidor agregando rutas y caminos para las operaciones HTTP dirigidas al controlador PreferenciasControlador.
- Se modificó la clase UsuariosControlador marcando comentario (omitiendo) la conversión del formulario recibido de solicitudes de Insomnia agregando procesamiento de solicitudes JSON con el método de Context *bodyAsClass*.
- Se modificó la clase Servidor agregando rutas para las operaciones HTTP dirigidas al controlador ReseñasControlador.



