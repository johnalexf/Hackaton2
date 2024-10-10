package clases;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Agenda extends Contacto{

    Set<Contacto> agenda = new HashSet<>();

    private int maxSize = 10;


    public Agenda(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    public void anadirContacto(String nombre, String apellido, int telefono){

    }

    public int buscarContacto(String nombre, String apellido){


    }

    public void listarContacto(){

    }

    public void eliminarContacto(String nombre, String apellido){

    }

    public void modifcarTelefono(String nombre, String apellido){

    }
    public void espaciosLibres(){

    }
    public void agendaLlena(){

    }




}
