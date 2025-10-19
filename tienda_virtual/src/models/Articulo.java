package models;

public class Articulo {
    private int id;
    private String nombre;
    private double precio;
    private Categoria categoria;

    private static int contadorArticulos = 1;

    public Articulo(String nombre, double precio, Categoria categoria) {
        this.id = contadorArticulos++;  
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String mostrarInformacion() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Categoria: " + categoria.getNombre();
    }

  }

