# Moderadores del Sistema

## Listar todos los moderadores

Obtiene una lista con todos los moderadores registrados en el sistema.

### URL solicitud

>Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/moderadores>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje 200 OK retornando:

```json
[
  {  "privilegio": "SAL2555XD" },
  {  "privilegio": "MAR55XXD"},
  {  "privilegio": "FRIAR882"},
  
]
```

De lo contrario se indicará los siguientes posibles errores:

>400 Bad Request => mensaje de error del lado del cliente
>500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

>Es necesario que devuelva los atributos heredados de la clase Usuario

---

## Obtener un moderador

Obtiene un moderador gistrador en el sistema segun su identificador.

### URL solicitud

>Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/moderadores/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje 200 OK retornando:

```json
  {
  "privilegio": "FRIAR882"
  }
```

De lo contrario se indicará los siguientes posibles errores:

>400 Bad Request => mensaje de error del lado del cliente
>500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

>Es necesario que devuelva los atributos heredados de la clase Usuario

---

## Crear un moderador

Alta de un moderador en en sistema

### URL solicitud

>Solicitud => POST  <https://pochocloapps.pochoclocritics.com/api/v1.0/moderadores>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
  {
    "privilegios": "privi234"
  }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el moderador creado:

```json
  {
    "privilegios": "privi234"
  }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente.
> 500 Internal Server Error => mensaje de error del lado del servidor.

#### Consideraciones

> Es necesario que devuelva los atributos heredados de la clase persona.

---

## Actualizar un moderador

Actualización de los atributos de un moderador en en sistema.

### URL solicitud

>Solicitud => PUT  <https://pochocloapps.pochoclocritics.com/api/v1.0/moderador/3412>

### Datos de la solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
  {
    "privilegios": "nuevoprivilegio"
  }
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el moderador actualizado:

```json
  {
    "privilegios": "nuevoprivilegio"
  }
```

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor

#### Consideraciones

> Es necesario que devuelva los atributos heredados de la clase Persona

---

## Eliminar un moderador

Elimina un moderador del sistema

### URL solicitud

> Solicitud => DELETE  <https://pochocloapps.pochoclocritics.com/api/v1.0/moderadores/1234>

### Respuesta

> Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> 400 Bad Request => mensaje de error del lado del cliente
> 500 Internal Server Error => mensaje de error del lado del servidor
