# Preferencias del Sistema

## Listar todas las preferencias

Obtiene una lista con todas las preferencias registradas en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/preferencias>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
  { "idPreferencia": "1234", "genero": []},
  { "idPreferencia": "1734", "genero": []},
  ...
  { "idPreferencia": "1294", "genero": []}  
]
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que la solicitud de todas las preferencias son las registradas en el sistema y no de un usuario especificado con anterioridad.

---

## Listar una Preferencia

Obtiene una preferencia según su identificador (idPreferencia)  registrada en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/preferencias/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
 {
   "idPreferencia": "1234",
   "genero": []
 }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que se lista una preferencia y no una preferencia referenciando anteriormente al usuario.

---

## Crear una preferencia

Alta de una preferencia en el sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v1.0/preferencias>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{  
   "genero": []
 }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando la preferencia creada:

```json
{  
   "idPreferencia": "1234",
   "genero": []
 }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente.
> 500 Internal Server Error => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idPreferencia reciente creada.
> Se da un alta de una preferencia, sin indicar que usuario lo especificó.

---

## Actualizar una preferencia

Actualización de una preferencia en el sistema

### URL solicitud

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v1.0/preferencias/1234>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{  
   "genero": [ ]
 }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando la pelicula actualizada:

```json
  {  
   "idPreferencia": "1234",
   "genero": []
 }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente.
> 500 Internal Server Error => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idPreferencia reciente actualizada.
> Tener en cuenta que la actualización va dirigida a la preferencia, no especificando al usuario.

---

## Eliminar una preferencia

Elimina una preferencia del sistema

### URL solicitud

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v1.0/preferencias/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor
