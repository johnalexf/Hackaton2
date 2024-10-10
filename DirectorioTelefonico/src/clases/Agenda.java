package clases;

import java.util.HashSet;
import java.util.Set;

public class Agenda extends Contacto {

    Set<Contacto> agenda = new HashSet<>();

    private int maxSize = 10;


    public Agenda(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    public boolean verificarContacto(String nombre, String apellido) {
        boolean existe = false;
        for (Contacto contacto : agenda) {
            if(contacto.getNombre().equals(nombre.toLowerCase()) &&
                    contacto.getApellido().equals(apellido.toLowerCase())){
                existe = true;
                break;
            }
        }
        return existe;
    }

    public void anadirContacto(String nombre, String apellido, int telefono){

            Contacto contacto = new Contacto(nombre.toLowerCase(), apellido.toLowerCase(), telefono);
            agenda.add(contacto);
            System.out.println("Contacto añadadido");
            System.out.println("Nombre : " + contacto.getNombre());
            System.out.println("Apellido : " + contacto.getApellido());
            System.out.println("Telefono : " + contacto.getTelefono());
    }

    public void buscarContacto(String nombre, String apellido){
        boolean existe = false;
        for (Contacto contacto : agenda) {
            if(contacto.getNombre().equals(nombre.toLowerCase()) &&
                    contacto.getApellido().equals(apellido.toLowerCase())){
                System.out.println("Contacto encontrado");
                System.out.println("El telefono del contacto es : " + contacto.getTelefono());
                existe = true;
                break;
            }
        }
        if(!existe) {
            System.out.println("Contacto no encontrado");
        }
    }

    public void listarContacto(){
        for(Contacto contacto: agenda){
            System.out.println( contacto.getNombre()
                    + " " + contacto.getApellido()
                    + " - " + contacto.getTelefono()
            );
        }
    }

    public void eliminarContacto(String nombre, String apellido){
        for (Contacto contacto : agenda) {
            if(contacto.getNombre().equals(nombre.toLowerCase()) &&
                    contacto.getApellido().equals(apellido.toLowerCase())){
                System.out.println("El contacto " + contacto.getNombre() +
                        " " + contacto.getApellido()
                        + " fue eliminado "
                );
                agenda.remove(contacto);
                break;
            }
        }
    }

    public void modificarContacto (String nombre, String apellido, int telefono){
        for (Contacto contacto : agenda) {
            if(contacto.getNombre().equals(nombre.toLowerCase()) &&
                    contacto.getApellido().equals(apellido.toLowerCase())){
                contacto.setNombre(nombre.toLowerCase());
                contacto.setApellido(apellido.toLowerCase());
                contacto.setTelefono(telefono);
                System.out.println("Contacto modificado con exito");
                break;
            }
        }
    }

    public void modificarTelefono(String nombre, String apellido, int telefono){
        for (Contacto contacto : agenda) {
            if(contacto.getNombre().equals(nombre.toLowerCase()) &&
                    contacto.getApellido().equals(apellido.toLowerCase())){
                contacto.setTelefono(telefono);
                System.out.println("Telefono modificado para" + contacto.getNombre() +
                        " " + contacto.getApellido()
                        + " y el nuevo número es: " + contacto.getTelefono()
                );
                break;
            }
        }
    }

    public void espaciosLibres(){
        System.out.println("Tienes espacio para " + (maxSize - agenda.size()) + " contactos");
    }

    public boolean agendaLlena(){
        return (agenda.size() >= maxSize);
    }




}
