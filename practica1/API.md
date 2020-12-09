# Practica 1

### Web

Frontal expuesto en [http://localhost:8080/](http://localhost:8080/):

* La página será capaz de manejar varios libros
* En la página principal aparecerán los titulos de los libros.
* Cada titulo tendrá un link para mostrar más información de este.
* En la página principal habrá un link para crear un nuevo libro.
* Cada comentario se podrá borrar.

### REST API

La api contendrá los siguientes endpoints:

| DESCRIPCIÓN                                                                                      | RUTA                                                          |
|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------|
| Obtener un listado con el identificador y el título de cada uno de los libros                    | ```GET /api/books```                                          |
| Obtener toda la información de un libro determinado (comentarios incluidos)                      | ```GET /api/books/{id}```                                     |
| Crear un libro                                                                                   | ```POST /api/books```                                         |
| Añadir comentario a un libro.                                                                    | ```POST /api/books/{id}/comments```                           |
| Borrar un comentario.                                                                            | ```DELETE /api/books/{id}/comments/{commentId}```             |

Para probar los servicios (Ejemplos de JSON entrada/salida):

* Usando el open-api autogenerado: [http://localhost:8080/api.html](http://localhost:8080/api.html).

Para testear con Postman:

* Usando la colección postman añadida en la carpeta postman (Los ID utilizados son aleatorios, usar el indicado).

## Autores

[David Parla(@g4lk)](https://github.com/g4lk)
[Francisco Robles(@franrobles8)](https://github.com/franrobles8)
