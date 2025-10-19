package models.carrito;

import java.util.ArrayList;

public class Carrito {

    private ArrayList<Renglon> listaCompra;

    // Constructor
    public Carrito() {

        this.listaCompra = new ArrayList<>();
    }

    // Getters y Setters
    public ArrayList<Renglon> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompras(ArrayList<Renglon> listaCompras) {
        this.listaCompra = listaCompras;
    }

    public void verCarrito() {
        if (this.listaCompra.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Contenido del carrito:");
            for (Renglon renglon : this.listaCompra) {
                System.out.println("- " + renglon.getArticulo().getNombre() +
                        " | Cantidad: " + renglon.getCantidad() +
                        " | Subtotal: $" + renglon.calcularSubtotal());
            }
            System.out.println("Total a pagar: $" + calcularTotal());
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Renglon renglon : this.listaCompra) {
            total += renglon.calcularSubtotal();
        }
        return total;
    }

    public void agregarArticulo(Renglon nuevoRenglon) {
        for (Renglon renglon : this.listaCompra) {
            if (renglon.getArticulo().getId() == nuevoRenglon.getArticulo().getId()) {
                renglon.setCantidad(renglon.getCantidad() + nuevoRenglon.getCantidad());
                return;
            }
        }
        this.listaCompra.add(nuevoRenglon);
    }

}
