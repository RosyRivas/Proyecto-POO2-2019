# Reseñas del Sistema

## Listar todas las reseñas

Obtiene una lista con todas las reseñas registradas en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/reseñas>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
  { "idReseña": "1234", "descripcion": "Buenisima la peli"},
  { "idReseña": "1734", "descripcion": "Pesima"},
  ...
  { "idReseña": "1294", "descripcion": "Me encantó"}  
]
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que la solicitud de todas las reseñas son del sistema, no de una pelicula en particular

---

## Listar una reseña solicitada en el Sistema

Obtiene una reseña según su identificador (idReseña) registrada en el sistema.

### URL solicitud

> Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/reseñas/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
 {
   "idReseña": "1234",
   "descripcion": "Buenisima"
 }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> Tener en cuenta que la reseña no se solicito teniendo en cuenta una pelicula de referencia

---

## Crear una reseña

Alta de una reseña el en sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v1.0/reseñas>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{  
   "descripcion": "Buenisima"
 }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando la reseña creada:

```json
{  
   "idReseña": "1234",
   "descripcion": "Buenisima"
 }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente.
> 500 Internal Server Error => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idReseña reciente creada.

---

## Actualizar una reseña

Actualización de una reseña en el sistema

### URL solicitud

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v1.0/reseñas/1234>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{  
   "descripcion": "Buenisima la peli"
 }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando la reseña actualizada:

```json
  {  
   "idReseña": "1234",
   "descripcion": "The best movie in the world"
 }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente.
> 500 Internal Server Error => mensaje de error del lado del servidor.

#### Consideraciones

> Se indica el idReseña reciente actualizada.

---

## Eliminar una reseña

Elimina una reseña en el sistema

### URL solicitud

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v1.0/reseñas/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor
