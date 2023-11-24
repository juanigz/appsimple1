# TrabajoNeoris1

Objetivo de la actividad:

Aplicar los conceptos y habilidades adquiridos en los módulos anteriores del curso para desarrollar una aplicación de registro de personas en Java.



Descripción de la actividad:

Los estudiantes deben crear una aplicación de registro de personas en Java que cumpla con los siguientes requisitos:



Requisitos funcionales:
La aplicación debe permitir al usuario ingresar los siguientes datos de una persona:
 - Nombre

 - Apellido

 - DNI (Documento Nacional de Identidad)

 - Fecha de nacimiento

Los datos ingresados deben ser validados de acuerdo a las siguientes reglas:
 - El nombre y el apellido no pueden estar en blanco.

 - El DNI debe ser un número válido de 8 dígitos.

 - La fecha de nacimiento debe ser una fecha válida en el formato dd/mm/yyyy.

La aplicación debe permitir al usuario guardar los datos de una persona.
La aplicación debe permitir al usuario listar todas las personas registradas hasta el momento, mostrando todos sus datos. 



Requisitos técnicos:
Utilizar un IDE o editor de código para desarrollar la aplicación.
Aplicar las estructuras de control y tipos de datos aprendidos en el curso para la validación de datos y la gestión de la información.
Utilizar arrays o colecciones para almacenar los datos de las personas registradas.
Implementar una interfaz de usuario simple que permita al usuario ingresar los datos y realizar las operaciones mencionadas.

--------------------------------------------------
1- se creó una clase persona con los atributos solicitados, la clase permite a su vez crear un 
objeto de tipo persona, y acceder a sus datos a través de metodos de acceso.

2- sus datos se validan por medio de 2 opciones a elegir: (1- excepciones dentro de la clase persona.
2- atribuirle permisos a los metodos parse, que será la biblioteca a utilizar desde el main para esta actividad integradora).

3- se creó la clase registro para guardar un listado de personas, y poder agregar a las personas a este listado, eliminarlas, y consultar su existencia y sus datos.

4- se debería cumplir el punto 4 listando a todas esas personas. (si no, hay otra forma, se realiza un metodo de muestra de datos dentro de la clase persona, y al agregarlas al registro, se recorrerá por medio de un ciclo a todas las personas, llamando a este metodo de muestra de personas. logrando asi que se muestren absolutamente todas las personas con sus datos predefinidos por consola).

----------------------------------------------------

para la creación de esta aplicación de registro de personas, utilicé el patrón de diseño MVC (modelo-vista-controlador).
hice una interfaz sencilla, de un único frame, donde cree los labels, campos a rellenar, y botones de acción.
el controlador contiene 2 clases, la que hace referencia a la interfaz funciona como intermediario entre los datos que el usuario ingresa a la ventana de registro, y envía la información a ser procesada por la parte lógica del sistema. a su vez, la lógica procesa estos datos creando y registrando personas, y las envía muestra nuevamente al controlador para que estén disponibles para las acciones a realizar en la interfaz, ya sea registrar una nueva persona agregandola a la lista, y luego recorrer la lista para que las personas sean mostradas por consola.

comentarios: uno de los inconvenientes que tuve fue a la hora de solicitar y procesar la fecha de nacimiento del usuario, primero no lograba capturar el valor ingresado, ni procesarlo en el formado dd/MM/yyyy. luego no podía evaluarlo para afirmar que el dato ingresado era el correcto. finalmente utilicé otro componente de "widgets", JSpinner, en este caso para acceder directamente a la biblioteca que soporta los calendarios, y acceder al mismo a la vez que puede ser editado desde la interfaz.
descubrí que no hay forma de anticipar fallos, ya que este componente no los tiene, se anticipa y los corrige. por ende, no fue necesario realizar algun método privado de validación de datos particulares para la fecha ingresada.

