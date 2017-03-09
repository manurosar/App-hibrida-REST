# Cliente REST

El presente proyecto de cliente REST forma parte de una de las tareas de 
la asignatura de Acceso a Datos del Ciclo Formativo de Grado Superior de 
Desarrollo de Aplicaciones Multiplataforma. 

## Introducción a la tarea

Básicamente se trata de crear un CRUD para clientes, otro CRUD para productos, otro CRUD para pedidos-desglose y un maestro-detalle para ver pedidos-desglose

Para implementarlo, deberemos tener un servicio REST programado como un servlet Java en un contenedor Tomcat (cuidado, Tomcat no es un contenedor de EJB luego no soportará correctamente la inyección del EntityManagerFactory en las clases de los servicios), TomEE o GlashFish, contra una base de datos relacional Oracle o MySQL.

En cuanto al cliente, deberá ser en HTML5+JS (concretamente jQuery) y comunicarse con el servicio anterior en XML o en JSON.

El código de ejemplo para crear el servicio así como la base de datos lo 
puedes encontrar ](https://github.com/manurosar/GP-JPA).

 Tomcat no es un contenedor EJB, luego no van a funcionar todas las inyeccciones y tedremos que tocar el código generado por Netbeans.


## Documentación

Nos basta con una escueta documentación, aunque sí vamos a necesitar varios diagramas que detallamos a continuación. 
Veamos unos ejemplos con el proyecto que hemos estado usando en clase (Gestión Pedidos).

### Casos de uso

Un caso de uso no es más que plasmar ejemplos de cómo los actores (usuarios 
de nuestro sistema) interactúan con nuestra aplicación. Esto nos ayudará a dividir el problema en cada una de sus partes.

archvio: Diagrama de casos

### Diagrama entidad/relación

El diagrama entidad/relación es el paso previo al diseño de tablas de la base de datos y nunca debe faltar en la fase de diseño.
Archivo diagrama entidad realacion

### Diagrama de clases

Otro diagrama fundamental en UML es el diagrama de clases. En el vemos los objetos que habrá en nuestra aplicación y cómo 
interactuarán entre ellos. 
Archivo diagrama clases

### Manual de instalación y configuración

La instalación automatizada es realizara mediante clonación desde GitHub,

### Breve manual de usuario
Para explicar las funcionalidades del sistema.
Ver los 4 videos
!(https://youtu.be/WqmkXLD2AXo)
https://youtu.be/TaOUi0BDeaM
https://youtu.be/UBZlf73rt54
https://youtu.be/PhIpXGiPsAY

## Generando servicios REST con el IDE

#### Creación de la base de datos, usuarios y las tablas

Creación de la base de datos y carga inicial:  
Poner en marcha el servico de Nysql bien en culauier apache, xamp, Wamp etc.
Abrir netbean conectarse al root a la conexion Mysql y ejecuta el script usuarios .sql
SE instalara el usuario y se creara la base de datos.
despues nos conectamos en Mysql con el nombre de usuario y la contrseña damuser05 y password damuser

Conectadoscomo usuario damuser05 ejecutamos el script 
gestio_pedido.sql


Para terminar con el servidor abrimos el proyecto  GP_JPA con netbean y arrancamos con el tomcat, ya tenemos en marcha el servidor
```
##Instalacion Cliente

Abrimol la carpeta CRUDRestClient-master con el xdc intel y con los simuladore ya podemos ver la aplicación hibrida


## Descripción detallada

### Opción 1: Gestión de pedidos

En nuestra aplicación un operario es el único agente que interactúa con el sistema.

El operario puede dar de alta, modificar o borrar los productos del almacén. **<span style="text-decoration: underline;">Para cada producto hay que guardar la cantidad que hay.</span>**

El operario puede dar de alta, modificar o borrar los clientes de la tienda.

El operario recibe llamadas telefónicas de los clientes y crea los pedidos en el sistema.

Un pedido es para un cliente.

Los pedidos tienen un detalle de pedido donde está la lista de productos y la cantidad de cada uno. Antes de procesar un pedido hay que ver si hay productos suficientes para poder hacerlo. En caso de no haberlos, no se podrá hacer el pedido (lo puedes controlar con transacciones, disparadores, software -cliente- o software -servidor-).

Una vez grabado, se pueden añadir nuevos productos o borrar existentes al mismo.

Se permite eliminar pedidos.

La consulta de pedidos se hace por cliente. Selecciono un cliente y me muestra sus pedidos. Selecciono un pedido y me muestra los productos del mismo.




```



