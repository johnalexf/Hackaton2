import clases.Agenda;
import clases.Contacto;

import java.util.Scanner;


public class Main {

    public static String[] pedirNombreApellido(Scanner sc) {
        String nombre;
        String apellido;

        System.out.println("Escriba el nombre del contacto");
        nombre = sc.nextLine();
        System.out.println("Escriba el apellido del contacto");
        apellido = sc.nextLine();
        return new String[]{nombre, apellido};
    }

    public static int pedirTelefono(Scanner sc) {
        int telefono1;
        System.out.println("Escriba el telefono nuevo del contacto");
        telefono1 = sc.nextInt();
        return telefono1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Variable de control de maximo tamaño de la agenda
        int maxAgenda = 10;

        // Crear agenda personalizada preguntar a usuario
        System.out.println("""
                \nBienvenido al servicio de agenda telefonica
                El plan basico te ofrece 10 contactos
                Si deseas un plan personalizado ingresa 's' en caso contrario 'n'
                """);
        //Si el usuario desea cambiar el tamaño maximo se le pregunta de que tamaño lo desea
        if (scanner.nextLine().equals("s")) {
            System.out.println("Escriba la cantidad maxima de contactos");
            maxAgenda = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
        }

        Agenda agendaTelefonica = new Agenda(maxAgenda);

        String[] menu = {"Añadir contacto",
                "Buscar contacto",
                "Listar contactos",
                "Modificar contacto",
                "Modificar Telefono",
                "Espacios disponibles",
                "Eliminar contacto",
                "Salir"
        };

        int opcion = 0;
        String[] nombreApellido = {"", ""};
        int telefono = 0;
        String temporal = "";

        do {
            System.out.println("\n Menu principal de agenda");
            //for para imprimir las opciones del menu
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + 1 + " : " + menu[i]);
            }
            System.out.println("Elija una de las opciones anteriores");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    // "Añadir contacto"
                    if(!agendaTelefonica.agendaLlena()) {

                        nombreApellido = pedirNombreApellido(scanner);
                        // Verificar si ya existe usuario
                        if (!agendaTelefonica.verificarContacto(nombreApellido[0], nombreApellido[1])) {
                            telefono = pedirTelefono(scanner);
                            agendaTelefonica.anadirContacto(nombreApellido[0], nombreApellido[1], telefono);
                        } else {
                            System.out.println("El usuario ya existe");
                        }

                    }else{
                        System.out.println("""
                        \nLa agenda esta llena,
                        Por favor eliminar un contacto si desea agregar uno nuevo.
                        """);
                    }
                    scanner.nextLine();
                    break;

                case 2:
                    // "Buscar contacto"
                    nombreApellido = pedirNombreApellido(scanner);
                    agendaTelefonica.buscarContacto(nombreApellido[0], nombreApellido[1]);
                    scanner.nextLine();
                    break;

                case 3:
                    // "Listar contactos"
                    agendaTelefonica.listarContacto();
                    break;

                case 4:
                    // "Modificar contacto"
                    nombreApellido = pedirNombreApellido(scanner);

                    // Verificar si ya existe usuario
                    if (agendaTelefonica.verificarContacto(nombreApellido[0], nombreApellido[1])) {
                        nombreApellido = pedirNombreApellido(scanner);
                        telefono = pedirTelefono(scanner);
                        agendaTelefonica.modificarContacto(nombreApellido[0], nombreApellido[1], telefono);
                    } else {
                        System.out.println("El usuario no existe");
                    }
                    scanner.nextLine();
                    break;

                case 5:
                    // "Modificar Telefono"
                    nombreApellido = pedirNombreApellido(scanner);

                    // Verificar si ya existe usuario
                    if (agendaTelefonica.verificarContacto(nombreApellido[0], nombreApellido[1])) {
                        telefono = pedirTelefono(scanner);
                        agendaTelefonica.modificarTelefono(nombreApellido[0], nombreApellido[1], telefono);
                    } else {
                        System.out.println("El usuario no existe");
                    }
                    scanner.nextLine();
                    break;

                case 6:
                    // "Espacios disponibles"
                    agendaTelefonica.espaciosLibres();
                    break;

                case 7:
                    // "Eliminar Contacto"
                    System.out.println("Escribe los siguientes datos del contacto que deseas eliminar");
                    nombreApellido = pedirNombreApellido(scanner);
                    if (agendaTelefonica.verificarContacto(nombreApellido[0], nombreApellido[1])) {
                        agendaTelefonica.eliminarContacto(nombreApellido[0], nombreApellido[1]);
                    } else {
                        System.out.println("El usuario no existe");
                    }
                    scanner.nextLine();
                    break;

                case 8:
                    // "Salir"
                    break;

                default:
                    System.out.println("Opcion no valida");
            }


            System.out.println("Para continuar oprime enter");
            temporal = scanner.nextLine();

        } while (opcion != 8);

        scanner.close(); // Cerrar el scanner al final del programa
    }
}