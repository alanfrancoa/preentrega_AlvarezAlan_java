package menues;

import java.util.ArrayList;
import java.util.Scanner;

import models.articulos.Articulo;
import models.carrito.Carrito;
import models.categorias.Categoria;

public class MenuCliente {
    private boolean continuar = true;
    private Scanner sc;
    private ArrayList<Articulo> listaArticulos;
    private ArrayList<Categoria> listaCategorias;
    private Carrito carritoUsuario;

    public MenuCliente(Scanner sc, ArrayList<Articulo> listaArticulos, ArrayList<Categoria> listaCategorias, Carrito carritoUsuario) {
        this.sc = sc;
        this.listaArticulos = listaArticulos;
        this.listaCategorias = listaCategorias;
        this.carritoUsuario = carritoUsuario;
    }

    public void mostrarMenu() {
        while (continuar) {
            System.out.println("----- Menú Cliente -----");
            System.out.println("1. Ver Carrito de Compras");
            System.out.println("2. Agregar Artículo al Carrito");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    carritoUsuario.verCarrito();
                    break;
                case 2:
                    agregarArticuloAlCarrito();
                    break;
                case 3:
                    System.out.println("Saliendo del menú de cliente.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void agregarArticuloAlCarrito() {
        listaArticulos.forEach(articulo -> {
            System.out.println(articulo.getId() + ". " + articulo.getNombre() + " - $" + articulo.getPrecio());
        });

        int idArticulo = -1;
        while (true) {
            System.out.print("Ingrese el ID del artículo que desea agregar al carrito: ");
            try {
                idArticulo = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        Articulo articuloSeleccionado = null;
        for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == idArticulo) {
                articuloSeleccionado = articulo;
                break;
            }
        }
        if (articuloSeleccionado != null) {
            int cantidad = -1;
            while (true) {
                System.out.print("Ingrese la cantidad que desea agregar: ");
                try {
                    cantidad = Integer.parseInt(sc.nextLine());
                    if (cantidad > 0) {
                        break;
                    } else {
                        System.out.println("La cantidad debe ser mayor a cero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                }
            }
            models.carrito.Renglon renglon = new models.carrito.Renglon(cantidad, articuloSeleccionado);
            carritoUsuario.agregarArticulo(renglon);
            System.out.println("Artículo agregado al carrito.");
            System.out.println("Carrito actualizado:");
            carritoUsuario.verCarrito();
        } else {
            System.out.println("Artículo no encontrado. Intente de nuevo.");
        }
    }

}
