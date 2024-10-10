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

        do {
            System.out.println("\n Menu principal de agenda");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + " : " + menu[i]);
            }
            System.out.println("Elija una de las opciones anteriores");
            switch (scanInt.nextInt()) {
                case 0:
                    //"Añadir contacto"

                    break;
                case 1:
                    //"Buscar contacto"

                    break;
                case 2:
                    //"Listar contactos"

                    break;
                case 0:
                    //"Añadir contacto"

                    break;

                
            }




        }while();





    }
}