package clases;

import java.util.Scanner;

public class PedirDatosConsola  {

    public static boolean esNumero(String nombre) {
        return nombre.matches("^[a-zA-Z\\s]+$"); // Verifica números enteros y decimales
    }

    public static String[] pedirNombreApellido(Scanner sc) {
        String nombre;
        String apellido;

        System.out.println("Escriba el nombre del contacto");
        nombre = sc.nextLine();
        while(nombre.length()<=2 || !esNumero(nombre)){
            System.out.println("""
                    Nombre invalido, 
                    debe tener mas de dos caracteres, 
                    y no debe contener numeros
                    """);
            System.out.println("Escriba el nombre del contacto");
            nombre = sc.nextLine();
        }

        System.out.println("Escriba el apellido del contacto");
        apellido = sc.nextLine();
        while(apellido.length()<=2 || !esNumero(apellido)){
            System.out.println("Apellido invalido, debe tener mas de dos caracteres");
            System.out.println("Escriba el apellido del contacto");
            apellido = sc.nextLine();
        }

        return new String[]{nombre, apellido};
    }


    public static boolean empiezaCon(String cadena) {
        if (cadena != null && !cadena.isEmpty() && cadena.matches("^[0-9]+$")) {
            char primerChart = cadena.charAt(0);
            return primerChart == '3' || primerChart == '6';
        }else{
            return false;
        }
    }


    public static String pedirTelefono(Scanner sc) {
        String telefono1;
        System.out.println("Escriba el telefono nuevo del contacto");
        telefono1 = sc.nextLine();
        while((telefono1.length()!=10) || !empiezaCon(telefono1)){

            System.out.println(""" 
                        \nTelefono invalido
                        Debe tener 10 numeros
                        Empieza con 3 para un numero de celular
                        Empieza con 6 para numero local fijo
                        Escribe nuevamente el numero por favor
                        """
            );
            telefono1 = sc.nextLine();

        }

        return telefono1;
    }



}
