# Directores del Sistema

## Listar todos los directores

Obtiene una lista con todos los directores registrados en el sistema.

### URL de Solicitud

>Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/directores>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
[
  { "idDirector": 1234, "nombre": "Leonel", "apellido": "russo", "fecha_nacimiento": "15/12/1985", "biografia": "suminibiografia"},
  { "idDirector": 5674, "nombre": "Mariana", "apellido": "denver", "fecha_nacimiento": "15/12/1985", "biografia": "suminibiografia"},
  { "idDirector": 2321, "nombre": "Paola", "apellido": "cassi", "fecha_nacimiento": "15/12/1985", "biografia": "suminibiografia"}
]
```

De lo contrario se indicará los siguientes posibles errores:

>**400 Bad Request** => mensaje de error del lado del cliente

>**500 Internal Server Error** => mensaje de error del lado del servidor

---

## Obtener un director

Obtiene un Director segun su identificador(idDirector)

### URL de Solicitud

>Solicitud => GET <https://pochocloapps.pochoclocritics.com/api/v1.0/directores/1234>

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando:

```json
{
  "idDirector": 1234,
  "nombre": "Leonel",
  "apellido": "russo",
  "fecha_nacimiento": "15/12/1985",
  "biografia": "suminibiografia"
}
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor

---

## Crear un director

Alta de un director en el sistema

### URL de Solicitud

> Solicitud => POST <https://pochocloapps.pochoclocritics.com/api/v1.0/directores>

### Datos de solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{
  "nombre": "Leonel",
  "apellido": "russo",
  "fecha_nacimiento": "15/12/1985",
  "biografia": "suminibiografia"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje 200 OK retornando el usuario creado:

```json
{
  "idDirector": "1234",
  "nombre": "Leonel",
  "apellido": "russo",
  "fecha_nacimiento": "15/12/1985",
  "biografia": "suminibiografia"
}
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor.

#### Consideraciones

>Se indica el idDirector reciente creado.

---

## Actualizar un director

Actualizacion de un director en el sistema

### URL de Solicitud

>Solicitud => PUT <https://pochocloapps.pochoclocritics.com/api/v1.0/directores/1234>

### Datos de solicitud

Formato JSON => Content-Type: application/json; charset=utf-8

```json
{  
  "nombre": "Leonel",
  "apellido": "russo",
  "fecha_nacimiento": "15/12/1985",
  "biografia": "suminibiografia"
}
```

### Respuesta

Formato JSON => Content-Type: application/json; charset=utf-8

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando el usuario creado:

```json
{  
  "idDirector": "12345",
  "nombre": "Leonel",
  "apellido": "russo",
  "fecha_nacimiento": "15/12/1985",
  "biografia": "suminibiografia"
 }
```

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente.

> **500 Internal Server Error** => mensaje de error del lado del servidor.

#### Consideraciones

>Se indica el idDirector reciente actualizado.

---

## Eliminar un director

Elimina  un director del sistema

### URL Solicitud

>Solicitud => DELETE <https://pochocloapps.pochoclocritics.com/api/v1.0/directores/1234>

### Respuesta

>Si la solicitud se realizó con éxito: mensaje **200 OK** retornando exito en la eliminación.

De lo contrario se indicará los siguientes posibles errores:

> **400 Bad Request** => mensaje de error del lado del cliente

> **500 Internal Server Error** => mensaje de error del lado del servidor
