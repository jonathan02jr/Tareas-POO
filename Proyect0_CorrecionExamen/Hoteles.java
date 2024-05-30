package Proyect0_CorrecionExamen;

//examen corregido-hacer commits
//hola
//este es un comentario escrito desde repositorio remoto
public class Hoteles {
    // Atributos
    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor con parámetros
    public Hoteles(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Constructor sin parámetros para generar valores nulos
    public Hoteles() {
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
    }

    // Métodos personalizados
    public void modificarHotel(String nombre, String direccion, String
            telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método para imprimir los detalles del hotel
    public void imprimirHotel() {
        System.out.println("Hotel: " + nombre);
        System.out.println("Direccion: " + direccion);
        System.out.println("Telefono: " + telefono + '\n');
    }
}
