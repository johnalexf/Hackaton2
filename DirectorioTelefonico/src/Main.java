import clases.Agenda;

import java.util.Scanner;

public class Main {

    public static String[] pedirNombreApellido(){
        Scanner sc = new Scanner(System.in);
        String nombre;
        String apellido;

        System.out.println("Escriba el nombre del contacto");
        nombre = sc.nextLine();
        System.out.println("Escriba el apellido del contacto");
        apellido = sc.nextLine();
        sc.close();
        return new String[]{nombre, apellido};
    }

    public static String pedirTelefono(){
        Scanner sc2 = new Scanner(System.in);
        String telefono1;
        System.out.println("Escriba el telefono nuevo del contacto");
        telefono1 = sc2.nextLine();
        sc2.close();
        return telefono1;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        //variable de control de maximo tamaño de la agenda
        int maxAgenda = 10;

        //crear agenda personalizada preguntar a usuario
        System.out.println("Bienvenido al servicio de agenda telefonica" +
                "\nEl plan basico te ofrece 10 contactos"+
                "\n Si deseas un plan personalizado ingresa 's' en caso contrario 'n'");
        if(scanner.nextLine().equals("s")){
            System.out.println("Escriba la cantidad maxima de contactos");
            maxAgenda = scannerInt.nextInt();
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
        String[] nombreApellido = {"",""};
        int telefono = 0;

        do {
            System.out.println("\n Menu principal de agenda");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i+1 + " : " + menu[i]);
            }
            System.out.println("Elija una de las opciones anteriores");
            opcion = scannerInt.nextInt();
            switch (opcion) {
                case 1:
                    //"Añadir contacto"
                    nombreApellido = pedirNombreApellido();

                    //verificar si ya existe usuario
                    if(!agendaTelefonica.verificarContacto(nombreApellido[0],nombreApellido[1])){
                        System.out.println("Escriba el telefono nuevo del contacto");
                        String tel = scanner.nextLine();
                        System.out.println(tel);
//                        scanner.nextLine();
//                        telefono = scanner.nextInt();
                        //System.out.println(pedirTelefono());
                        agendaTelefonica.anadirContacto(nombreApellido[0],nombreApellido[1],telefono);
                    }else{
                        System.out.println("El usuario ya existe");
                    }
                    break;


                case 2:
                    //"Buscar contacto"
                    nombreApellido = pedirNombreApellido();
                    agendaTelefonica.buscarContacto(nombreApellido[0],nombreApellido[1]);
                    break;


                case 3:
                    //"Listar contactos"
                    agendaTelefonica.listarContacto();
                    break;


                case 4:
                    //"Modificar contacto"

                    break;


                case 5:
                    //"Modificar Telefono"
                    nombreApellido = pedirNombreApellido();

                    //verificar si ya existe usuario
                    if(agendaTelefonica.verificarContacto(nombreApellido[0],nombreApellido[1])){
                        //telefono = pedirTelefono();
                        agendaTelefonica.modifcarTelefono(nombreApellido[0],nombreApellido[1],telefono);
                    }else{
                        System.out.println("El usuario no existe");
                    }
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