# StlProyect
Stocktaking load 

# STOCKTACKING LOAD

### Problemática a resolver
Con este software se intenta automatizar el registro de préstamo que es realizado a mano. Siendo este fácil de manipular y algo propenso a cometer errores.
 ​Como objetivo se proyecta un ahorro significativo en este proceso, además de tener tus elementos o productos registrados para hacer más simple su búsqueda en la bodega.​

### Modelo de Dominio anémico

Para el modelo de domino lo primero que tenemos es una empresa que es la entidad a la cual pertenece un inventario que contiene otros inventarios por áreas; un administrador que es quien maneja toda la información y permisos de la aplicación ya que es capaz de crear diferentes áreas y monitores. Adicional a esto puede realizar préstamos dentro de las diferentes áreas. Por lo tanto, en una empresa puede haber uno o muchos administradores.

Tenemos un inventario que es el contiene los diferentes productos, estos se pueden agregar, actualizar, consultar. Hay unos productos que son aquellos elementos que hay dentro del área para en nuestro caso ser prestado; seguido a esto tenemos un monitor que es aquella persona con menos permisos dentro del área pero que puede realizar préstamos, el préstamo que es la acción de brindarle un producto a otra persona por un determinado tiempo. Hay una observación que es la que lleva el detalle del préstamo a la hora de ser entregado y devuelto; por último, pero no menos importante está el prestador que es aquella persona que solicita un préstamo de un producto. En cuanto a las dependencias tenemos que en una empresa puede existir uno o muchos administradores, al igual que pueden existir una o muchas áreas. A cada área pertenecen uno o muchos monitores y tiene uno o muchos inventarios; los inventarios contienen, uno o muchos productos, los cuales van a pertenecer a cero o muchos préstamos, estos préstamos se pueden realizar por un monitor quién puede crear cero o muchos préstamos. Este último es realizado por un prestador que puede solicitar cero o muchos préstamos, por último, este préstamo tiene muchas observaciones.

![](https://cdn.discordapp.com/attachments/1010673900398587974/1039674395750301747/image.png)


### Event Storming
Tenemos como elemento principal e tener un administrador el cual se puede crear, modificar y consultar para que pueda a su vez crear la empresa la cual se podrá crear, consultar y modificar;  las áreas que son las siguientes en el flujo se pueden crear y consultar, luego tenemos a un monitor con las mismas funcionalidades que el administrador quien puede crear el inventario actualizarlo, activarlo, consultarlo; seguido a al inventario se encuentra el producto que se podrá crear, consultar, actualizar, eliminar, prestar u agotar. Luego tenemos el préstamo que es donde va la información de éste y que por sus características se podrá crear, actualizar, consultar, vencer (En este caso para cuando el prestador se pasa del límite de tiempo establecido para el préstamo) y cerrar (Esto es para cuando se devuelven todos los elementos prestados y se finaliza el préstamo), por último está la observación que se crea cuando se realiza la devolución de un producto o se va a extender el tiempo del préstamo entonces se deja una anotación.
<https://miro.com/app/board/uXjVPXcey0g=/>

### Modelo de Dominio Enriquecido

Aquí se encuentra toda la documentación del proyecto, están todos los objetos de dominio con sus respectivos atributos, reglas de negocio y restricciones que debe tener cada atributo, es decir, el inventario tiene como atributos un identificador, nombre, cantidad producto y estado (permite saber si el inventario está activo o inactivo); el préstamo tiene un identificador, un producto, cantidad de productos prestados, fecha y hora del préstamo, monitor que recibe y entrega y el prestador; producto tiene un identificador, nombre y descripción; el monitor y el administrador tienen un identificador, nombre y documento de identidad; al prestador se le piden los mismos datos que al monitor y al administrador pero se le agregan datos como el correo, dirección y teléfono; una observación del préstamo tiene un identificador, si la devolución fue completa o quedaron productos sin devolver, una extensión del préstamo para cuando necesiten por más tiempo los productos, una descripción y una devolución a tiempo que es para cuando se devuelve una producto saber si fue dentro del rango permitido o se le venció el plazo de entrega y realizarle un cobro; por último el área y la empresa tienen un identificador y un nombre. Cada uno de estos tiene su tipo de dato, sea alfanumérica para cualquier entrada de texto y números, entero para valores que son únicamente números, boolean para cuando se necesita verificar que una tarea se realiza o no por ejemplo para verificar si la entrega fue completa o no, o para saber si el préstamo está activo o desactivo; adicional a eso llevan los formatos para cada tipo de dato y si tiene valor por defecto o no.

https://docs.google.com/spreadsheets/d/13KFX2ZlztOURlAuPZS58E1ey60KT_uUD/edit#gid=1093604456

### Diagrama de Clases 
El diagrama de clases presenta los mismos objetos que se dan en el modelo de dominio y llevan en su mayoría una relación de asociación porque tiene una relación entre ellos pero no es de dependencia, como por ejemplo la relación entre el préstamo y el prestador que es de dependencia puesto que para que se de un préstamo se necesita que haya un prestado. Por otro lado hay unas relaciones de composición porque se bien una necesita de la otra, no son tan necesarias, se componen entres si.

![](https://cdn.discordapp.com/attachments/1010673900398587974/1039707845748346960/ClassDiagram1.png)

### Modelo Entidad Relación

Para el MER nos basamos en el diagrama de clases, sin embargo, lo que eran monitor, administrador, y prestador se combinar y sólo quedó persona puesto que compartían los mismos atributos, pero se creó una entidad de prestador para que contenga los datos adicionales que lleva éste. 

![](https://cdn.discordapp.com/attachments/1010673900398587974/1039717978079514654/Relational_1.png)
