package models.categorias;

public class Categoria {
    private int id;
    private String nombre;

    private static int contadorCategorias = 1;

    public Categoria(String nombre) {
        this.id = contadorCategorias++;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarInformacion() {
        return "Categoria ID: " + id + ", Nombre: " + nombre;
    }
    
}
