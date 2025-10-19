package models.carrito;

import models.articulos.Articulo;

public class Renglon {

    // Atributos
    private int cantidad;
    private Articulo articulo;

    // Constructor
    public Renglon(int cantidad, Articulo articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
    }

    // Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }   
    public Articulo getArticulo() {
        return articulo;
    }
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    //Método de la clase Renglon
    public double calcularSubtotal() {
        return this.cantidad * this.articulo.getPrecio();
    }
    
}
