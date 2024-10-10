package clases;
// Clase padre contacto con los parametros asignados definida como publica
public class Contacto {
// atributos designados por el ejercicio
    private String nombre;
    private String apellido;
    private int telefono;
//constructor sin parametros en caso de necesitar creacion de objetos vacios
    public Contacto() {
    }
//constructor con parametros requeridos
    public Contacto(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
//getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
