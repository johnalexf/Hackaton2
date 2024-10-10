# Hackaton2
Grupo 3
Integrantes
Carla Valderrama
Rafael Arteaga
John Forero


Indíce documentación Hackaton 2.0

1) Resumen
2) Clase Contacto
2) Clase Agenda
3) Clase PedirDatosConsola
4) Clase Main

# Resumen

El siguiente proyecto fue diseñado para la presentacion 2 del hackaton del programa de 
la corte 6 de Desarrollo Fullstack Java Junior de Generation Colombia, en la cual estuvimos trabajando,
en una agenda interactiva la cual debe manejar las siguientes consideraciones:


Crea un sistema que permita gestionar una agenda telefónica teniendo en cuenta las siguientes indicaciones:

Un contacto está definido por:
Un nombre, un apellido y un teléfono (no es necesario validar el formato del teléfono).
Un contacto se considera igual a otro cuando tienen el mismo nombre y apellido (sin distinguir entre mayúsculas y minúsculas).
La agenda de contactos está formada por un conjunto de contactos.
La agenda puede crearse de dos formas:
Indicando el tamaño máximo.
Usando un tamaño por defecto de 10 contactos.
Validaciones importantes:
Los nombres y apellidos no pueden estar vacíos.
No se pueden añadir contactos duplicados (es decir, dos contactos con el mismo nombre y apellido).


Crea un menú con opciones por consola para probar todas estas funcionalidades.

añadirContacto(Contacto c):
Añade un contacto a la agenda. Si no hay espacio suficiente, se debe indicar al usuario que la agenda está llena.

Antes de añadir el contacto, se debe comprobar que no exista ya en la agenda (contactos con el mismo nombre y apellido se consideran duplicados).

No se puede añadir un contacto si el nombre o apellido están vacíos.

existeContacto(Conctacto c):
Verifica si un contacto ya existe en la agenda.

Los contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar el teléfono.

listarContactos():
Muestra todos los contactos de la agenda en el siguiente formato: Nombre Apellido - Teléfono.

Ordena los contactos alfabéticamente por nombre y apellido antes de mostrarlos.

buscaContacto(String nombre):
Permite buscar un contacto por nombre y apellido.

Si el contacto existe, muestra el teléfono. Si no existe, muestra un mensaje indicando que no se ha encontrado.

eliminarContacto(Contacto c):
Elimina un contacto de la agenda. Muestra un mensaje indicando si la eliminación ha sido exitosa o no.

Si se intenta eliminar un contacto que no existe, debe indicarse al usuario.

modificarTelefono(String nombre, String apellido, String nuevoTelefono):
Permite modificar el teléfono de un contacto existente.

Si el contacto no existe, debe mostrar un mensaje.

agendaLlena():
Indica si la agenda está llena.

Muestra un mensaje indicando que no hay espacio disponible para nuevos contactos.

espacioLibres():
Muestra cuántos contactos más se pueden agregar a la agenda.

Esto debe basarse en el tamaño máximo definido al crear la agenda.


# Clase contacto 

# Contacto

La clase Contacto forma parte del paquete clases y 
representa un modelo básico de un contacto con tres atributos principales: nombre, apellido, y telefono. 
Está diseñada para gestionar y almacenar la información de un contacto.

 Atributos

- nombre(String): El nombre del contacto.
- apellido(String): El apellido del contacto.
- telefono (String): El número de teléfono del contacto. Se almacena como (String) para permitir mayor facilidad,
en cuanto a validaciones, sin embargo dada la naturaleza de la agenda realizada

# Constructores

# Constructor sin parámetros

public Contacto()
Este constructor vacío permite crear un objeto Contacto sin inicializar sus atributos.
Es útil si se quiere crear el contacto e inicializar sus valores más tarde utilizando los 
métodos set.

# Constructor con parámetros

public Contacto(String nombre, String apellido, String telefono)
Este constructor permite inicializar el objeto Contacto con los valores de: 
nombre, apellido, y telefono al momento de su creación.

Métodos
Getters
Los métodos get permiten acceder a los valores de los atributos del objeto Contacto:

getNombre(): Retorna el valor del atributo nombre.
getApellido(): Retorna el valor del atributo apellido.
getTelefono(): Retorna el valor del atributo telefono.
Setters
Los métodos set permiten modificar los valores de los atributos del objeto Contacto:

setNombre(String nombre): Modifica el valor del atributo nombre.
setApellido(String apellido): Modifica el valor del atributo apellido.
setTelefono(String telefono): Modifica el valor del atributo telefono.
Ejemplo de uso
A continuación se muestra un ejemplo básico de cómo crear y utilizar la clase Contacto en la clase principal Main:

    public class Main {
    public static void main(String[] args) { 
    // Crear un contacto vacío

        Contacto contactoVacio = new Contacto();
        contactoVacio.setNombre("Pepito");
        contactoVacio.setApellido("Perez");
        contactoVacio.setTelefono("3021456987");

        Crear un contacto con valores iniciales
        Contacto contactoConValores = new Contacto("Mengano", "Lopez", "6045673245");

        // Imprimir información del contacto

        System.out.println("Nombre: " + contactoConValores.getNombre());
        System.out.println("Apellido: " + contactoConValores.getApellido());
        System.out.println("Teléfono: " + contactoConValores.getTelefono());
    }}

En este ejemplo, mostramos cómo:

Crear un contacto vacío y luego asignar valores a sus atributos utilizando los métodos set.
Crear un contacto proporcionando los valores en el constructor.
Acceder a los valores del contacto mediante los métodos get.

# Clase Agenda

# Agenda

La clase Agenda extiende la clase Contacto y 
representa una agenda de contactos con funcionalidad para añadir, buscar, 
modificar y eliminar contactos. La agenda tiene un tamaño máximo configurable y 
está diseñada para gestionar contactos de manera sencilla usando una coleccion Set de objetos Contacto.

## Atributos

- agenda (Set<Contacto>): Una colección de contactos almacenada en un HashSet, lo que garantiza que no haya duplicados.
- maxSize (int): El número máximo de contactos que pueden ser almacenados en la agenda. Este valor se define en el constructor.

## Constructores

# Constructor con tamaño máximo

public Agenda(int maxSize)
Este constructor permite crear una agenda con un número máximo de contactos definido por el parámetro maxSize.

// Métodos

verificarContacto(String nombre, String apellido)
Verifica si un contacto con el nombre y apellido dados ya existe en la agenda. Los nombres y 
apellidos se comparan ignorando las mayúsculas.
Parámetros: nombre (String), apellido (String)
Retorno: boolean (true si el contacto existe, false de lo contrario)


anadirContacto(String nombre, String apellido, String telefono)
Añade un nuevo contacto a la agenda si no excede el tamaño máximo. 
Los nombres y apellidos se almacenan en minúsculas para una comparación uniforme.
Parámetros: nombre (String), apellido (String), telefono (String)
Salida: Imprime un mensaje de confirmación en la consola.


buscarContacto(String nombre, String apellido)
Busca un contacto por su nombre y apellido en la agenda. 
Si el contacto es encontrado, se muestra el número de teléfono.
Parámetros: nombre (String), apellido (String)
Salida: Muestra el número de teléfono del contacto o un mensaje indicando que no se encontró.


listarContacto()
Lista todos los contactos almacenados en la agenda, mostrando el nombre completo 
y el número de teléfono de cada uno.
Salida: Imprime la lista de contactos en la consola.


eliminarContacto(String nombre, String apellido)
Elimina un contacto de la agenda que coincida con el nombre y apellido dados.
Parámetros: nombre (String), apellido (String)
Salida: Imprime un mensaje indicando que el contacto fue eliminado.


modificarContacto(String nombre, String apellido, String telefono)
Modifica un contacto existente cambiando su nombre, apellido y número de teléfono.
Parámetros: nombre (String), apellido (String), telefono (String)
Salida: Imprime un mensaje confirmando la modificación.



modificarTelefono(String nombre, String apellido, String telefono)
Modifica únicamente el número de teléfono de un contacto existente.
Parámetros: nombre (String), apellido (String), telefono (String)
Salida: Imprime un mensaje confirmando el cambio de número de teléfono.


espaciosLibres()
Muestra cuántos espacios libres quedan en la agenda.
Salida: Muestra en la consola el número de contactos que aún se pueden añadir.
agendaLlena()
Verifica si la agenda ha alcanzado su capacidad máxima de contactos.

Retorno: boolean (true si la agenda está llena, false de lo contrario)
Ejemplo de uso

        public class Main {
        public static void main(String[] args) {
        Agenda miAgenda = new Agenda(5); // Crear una agenda con un máximo de 5 contactos

        // Añadir contactos
        miAgenda.anadirContacto("Juan", "Pérez", "1234567890");
        miAgenda.anadirContacto("Ana", "Gómez", "9876543210");

        // Listar contactos
        miAgenda.listarContacto();

        // Buscar un contacto
        miAgenda.buscarContacto("Juan", "Pérez");

        // Modificar un contacto
        miAgenda.modificarTelefono("Ana", "Gómez", "5555555550");

        // Eliminar un contacto
        miAgenda.eliminarContacto("Juan", "Pérez");

        // Verificar espacios libres
        miAgenda.espaciosLibres();

        // Verificar si la agenda está llena
        if (miAgenda.agendaLlena()) {
            System.out.println("La agenda está llena");
        } else {
            System.out.println("Aún hay espacio en la agenda");
        }
    }
    }

Este ejemplo demuestra cómo usar las principales funcionalidades de la clase Agenda.

Consideraciones
Comparación insensible a mayúsculas: Los nombres y apellidos se almacenan 
en minúsculas para facilitar comparaciones que ignoren las diferencias entre 
mayúsculas y minúsculas.
Uso de Set: Se usa un HashSet para evitar la duplicación de contactos, 
por lo que no se permiten contactos repetidos con el mismo nombre y apellido.
Espacio limitado: La agenda tiene un número máximo de contactos configurable. 
Si se intenta añadir un contacto cuando la agenda está llena, se debe manejar 
apropiadamente esa situación.

# PedirDatosConsola

La clase `PedirDatosConsola` se utiliza para interactuar con el usuario a través de la consola, permitiendo la entrada de datos como nombres, apellidos y números de teléfono. Implementa verificaciones de formato y reglas específicas para validar los datos introducidos por el usuario.

## Métodos principales

### `esNumero(String nombre)`
Verifica si una cadena contiene solo letras y espacios, asegurando que no incluya números ni caracteres especiales.

- **Parámetros**:
    - `nombre` (`String`): La cadena que será verificada.
- **Retorno**:
    - `boolean` (`true` si la cadena contiene solo letras y espacios, `false` si contiene números u otros caracteres).

### `pedirNombreApellido(Scanner sc)`
Solicita al usuario ingresar el nombre y apellido a través de la consola, con validaciones para asegurar que ambos:
- Contengan más de dos caracteres.
- No incluyan números u otros caracteres no alfabéticos.

- **Parámetros**:
    - `sc` (`Scanner`): El objeto `Scanner` para leer la entrada de la consola.
- **Retorno**:
    - `String[]`: Un arreglo de dos elementos que contiene el nombre y el apellido validados.
- **Validaciones**:
    - El nombre y el apellido deben tener más de dos caracteres.
    - No deben contener números.

### `empiezaCon(String cadena)`
Verifica si una cadena numérica (que representa un número de teléfono) comienza con los dígitos `3` o `6`.

- **Parámetros**:
    - `cadena` (`String`): El número de teléfono a verificar.
- **Retorno**:
    - `boolean` (`true` si el número comienza con `3` o `6`, `false` de lo contrario).

- **Reglas**:
    - Números que empiezan con `3`: Teléfonos celulares.
    - Números que empiezan con `6`: Teléfonos fijos locales.

### `pedirTelefono(Scanner sc)`
Solicita al usuario ingresar un número de teléfono a través de la consola, validando que:
- El número tenga exactamente 10 dígitos.
- Comience con `3` (celular) o `6` (teléfono fijo).

- **Parámetros**:
    - `sc` (`Scanner`): El objeto `Scanner` para leer la entrada de la consola.
- **Retorno**:
    - `String`: El número de teléfono validado.

- **Validaciones**:
    - El número debe tener exactamente 10 dígitos.
    - Debe empezar con `3` o `6`.

## Ejemplo de uso

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedir nombre y apellido
        String[] nombreApellido = PedirDatosConsola.pedirNombreApellido(sc);
        System.out.println("Nombre: " + nombreApellido[0]);
        System.out.println("Apellido: " + nombreApellido[1]);
        
        // Pedir número de teléfono
        String telefono = PedirDatosConsola.pedirTelefono(sc);
        System.out.println("Teléfono: " + telefono);
        
        sc.close();
    }
}
En este ejemplo:

Se solicita al usuario que ingrese un nombre y apellido, asegurando que cumplan con las reglas de validación.
Luego, se solicita un número de teléfono que debe tener exactamente 10 dígitos y comenzar con 3 o 6.
Validaciones
Nombre y Apellido
Debe contener más de 2 caracteres.
No debe contener números ni caracteres especiales.
Número de Teléfono
Debe contener exactamente 10 dígitos.
Debe comenzar con 3 (celular) o 6 (fijo).
Consideraciones
Los nombres y apellidos se validan para evitar la entrada de caracteres no permitidos.
Los números de teléfono se validan para asegurar que cumplan con las reglas locales de formato (10 dígitos y comienzos específicos).
Si el formato de los datos no es correcto, el sistema repetirá la solicitud hasta que el usuario introduzca un valor válido.


#Clase Main

## Funcionalidades

La clase `Main` proporciona el flujo principal del programa, presentando un menú interactivo para gestionar los contactos de la agenda telefónica. El menú incluye las siguientes opciones:

1. **Añadir Contacto**: Permite añadir un nuevo contacto, siempre que la agenda no esté llena y el contacto no exista ya.
2. **Buscar Contacto**: Permite buscar un contacto por su nombre y apellido.
3. **Listar Contactos**: Muestra todos los contactos guardados en la agenda.
4. **Modificar Contacto**: Permite modificar el nombre, apellido y teléfono de un contacto existente.
5. **Modificar Teléfono**: Permite modificar solo el teléfono de un contacto existente.
6. **Espacios Disponibles**: Muestra la cantidad de espacios libres en la agenda.
7. **Eliminar Contacto**: Permite eliminar un contacto existente de la agenda.
8. **Salir**: Termina la ejecución del programa.

## Estructura del Proyecto

### Clases principales

- **Main**: La clase principal que gestiona el flujo del programa y proporciona un menú interactivo para interactuar con la agenda.
- **Agenda**: Almacena y gestiona los contactos. Se encarga de agregar, buscar, modificar, eliminar y listar los contactos.
- **PedirDatosConsola**: Contiene métodos estáticos que solicitan datos al usuario y validan entradas como nombres, apellidos y números de teléfono.

### Flujo del Programa

1. Al iniciar, el programa solicita al usuario si desea cambiar el tamaño máximo de la agenda. Si no, se utiliza el valor por defecto de 10 contactos.
2. El usuario puede interactuar con la agenda a través del menú, seleccionando opciones ingresando el número correspondiente.
3. Dependiendo de la opción seleccionada, el programa solicita información adicional, como el nombre, apellido o teléfono del contacto, y ejecuta la operación correspondiente.
4. El ciclo del menú se repite hasta que el usuario elige la opción de salir.

### Validaciones de Datos

- **Nombre y Apellido**: Se validan para asegurarse de que contengan más de dos caracteres y no incluyan números.
- **Teléfono**: Debe ser un número de 10 dígitos que comience con `3` (celular) o `6` (fijo).

## Uso del Programa

1. Clonar o descargar el proyecto.
2. Compilar y ejecutar la clase `Main`.
3. El programa mostrará un menú interactivo para gestionar los contactos.

### Ejemplo de uso:

Bienvenido al servicio de agenda telefonica
El plan basico te ofrece 10 contactos
Si deseas un plan personalizado ingresa 's' en caso contrario 'n'
El programa solicitará al usuario que ingrese el tamaño de la agenda si elige un plan personalizado. Luego, el menú principal permitirá gestionar los contactos:


Menu principal de agenda:
1 : Añadir contacto
2 : Buscar contacto
3 : Listar contactos
4 : Modificar contacto
5 : Modificar Telefono
6 : Espacios disponibles
7 : Eliminar contacto
8 : Salir
Elija una de las opciones anteriores:
Dependencias
El proyecto no tiene dependencias externas más allá de la biblioteca estándar de Java.

Requisitos previos:
Java 8 o superior.
