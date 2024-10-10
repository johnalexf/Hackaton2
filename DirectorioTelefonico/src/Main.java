import clases.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        //variable de control de maximo tamaño de la agenda
        int maxAgenda = 10;

        //crear agenda personalizada preguntar a usuario
        System.out.println("Bienvenido al servicio de agenda telefonica" +
                "\nEl plan basico te ofrece 10 contactos"+
                "\n Si deseas un plan personalizado ingresa 's' en caso contrario 'n'");
        if(scanInt.nextLine().equals("s")){
            System.out.println("Escriba la cantidad maxima de contactos");
            maxAgenda = scanInt.nextInt();
        }

        Agenda agendaTelefonica = new Agenda(maxAgenda);


            String[] menu = {"Añadir contacto",
                    "Buscar contacto",
                    "Listar contactos",
                    "Modificar contacto",
                    "Modificar Telefono",
                    "Espacios disponible",
                    "Eliminar contacto",
                    "Salir"
            };

        int opcion = 0;
        do {
            System.out.println("\n Menu principal de agenda");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i+1 + " : " + menu[i]);
            }
            System.out.println("Elija una de las opciones anteriores");
            opcion = scanInt.nextInt();
            switch (opcion) {
                case 1:
                    //"Añadir contacto"
                    
                    break;
                case 2:
                    //"Buscar contacto"

                    break;
                case 3:
                    //"Listar contactos"

                    break;
                case 4:
                    //"Modificar contacto"

                    break;
                case 5:
                    //"Modificar Telefono"

                    break;
                case 6:
                    //"Espacios disponibles"

                    break;
                case 7:
                    //"Eliminar Contacto"

                    break;
                case 8:
                    //"Salir"

                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }while(opcion != 8);





    }
}