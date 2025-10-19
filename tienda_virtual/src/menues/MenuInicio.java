package menues;

import java.util.ArrayList;
import java.util.Scanner;

import models.Articulo;
import models.Categoria;

public class MenuInicio {

    private boolean continuar = true;
    private Scanner sc;
    private ArrayList<Articulo> listaArticulos;
    private ArrayList<Categoria> listaCategorias;

    public MenuInicio(Scanner sc, ArrayList<Articulo> listaArticulos, ArrayList<Categoria> listaCategorias) {
        this.sc = sc;
        this.listaArticulos = listaArticulos;
        this.listaCategorias = listaCategorias;
    }

    public void mostrarMenu() {
        while (continuar) {
            System.out.println("----- Menú Inicio -----");
            System.out.println("1. Ver Artículos");
            System.out.println("2. Agregar Artículo");
            System.out.println("3. Editar Artículo");
            System.out.println("4. Eliminar Artículo");

            System.out.println("-----------------------");
            System.out.println("5. Ver Categorías");
            System.out.println("6. Agregar Categoría");
            System.out.println("7. Editar Categoría");
            System.out.println("8. Eliminar Categoría");

            System.out.println("-----------------------");

            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    listarArticulos();
                    break;
                case 2:
                    agregarArticulo();
                    break;

                case 3:
                    editarArticulo();
                    break;
                case 4:
                    eliminarArticulo();
                    break;

                case 5:
                    listarCategorias();
                    break;
                case 6:
                    agregarCategoria();
                    break;
                case 7:
                    editarCategoria();
                    break;
                case 8:
                    eliminarCategoria();
                    break;
                case 9:
                    continuar = false;
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Métodos para CRUD artículos
    private void listarArticulos() {
        System.out.println("Lista de Artículos:");
        for (Articulo articulo : listaArticulos) {
            System.out.println(articulo.mostrarInformacion());
        }
    }

    private void agregarArticulo() {
        System.out.print("Ingrese el nombre del artículo: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el precio del artículo: ");
        double precio = sc.nextDouble();
        sc.nextLine(); // Limpiar el buffer
        listarCategorias();
        System.out.print("Ingrese ID de la categoría: ");
        int categoriaId = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        Categoria categoriaSeleccionada = null;
        for (Categoria cat : listaCategorias) {
            if (cat.getId() == categoriaId) {
                categoriaSeleccionada = cat;
                break;
            }
        }
        if (categoriaSeleccionada != null) {
            Articulo nuevoArticulo = new Articulo(nombre, precio, categoriaSeleccionada);
            listaArticulos.add(nuevoArticulo);
            System.out.println("Artículo agregado exitosamente.");
        } else {
            System.out.println("Categoría no encontrada. Artículo no agregado.");
        }
    }

    private void editarArticulo() {
        listarArticulos();
        System.out.println("Ingrese el ID del artículo a editar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        Articulo articuloAEditar = null;
        for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                articuloAEditar = articulo;
                break;
            }
        }
        if (articuloAEditar != null) {

            articuloAEditar.mostrarInformacion();

            System.out.print("Ingrese el nuevo nombre del artículo: ");
            String nuevoNombre = sc.nextLine();
            System.out.print("Ingrese el nuevo precio del artículo: ");
            double nuevoPrecio = sc.nextDouble();
            sc.nextLine(); // Limpiar el buffer
            listarCategorias();
            System.out.print("Ingrese ID de la categoría: ");
            int nuevaCategoriaId = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            Categoria categoriaSeleccionada = null;
            for (Categoria cat : listaCategorias) {
                if (cat.getId() == nuevaCategoriaId) {
                    categoriaSeleccionada = cat;
                    break;
                }
            }
            if (categoriaSeleccionada != null) {
                articuloAEditar.setNombre(nuevoNombre);
                articuloAEditar.setPrecio(nuevoPrecio);
                articuloAEditar.setCategoria(categoriaSeleccionada);
                System.out.println("Artículo editado exitosamente.");
            } else {
                System.out.println("Categoría no encontrada. Artículo no editado.");
            }
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private void eliminarArticulo() {
        listarArticulos();
        System.out.print("Ingrese el ID del artículo a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        Articulo articuloAEliminar = null;
        for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                articuloAEliminar = articulo;
                break;
            }
        }
        if (articuloAEliminar != null) {
            articuloAEliminar.mostrarInformacion();
            listaArticulos.remove(articuloAEliminar);
            System.out.println("Artículo eliminado exitosamente.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    // Métodos para CRUD categorías
    private void listarCategorias() {
        System.out.println("Lista de Categorías:");
        for (Categoria categoria : listaCategorias) {
            System.out.println(categoria.mostrarInformacion());
        }
    }

    private void agregarCategoria() {
        System.out.print("Ingrese el nombre de la categoría: ");
        String nombre = sc.nextLine();
        Categoria nuevaCategoria = new Categoria(nombre);
        listaCategorias.add(nuevaCategoria);
        System.out.println("Categoría agregada exitosamente.");
    }

    private void editarCategoria() {
        listarCategorias();
        System.out.print("Ingrese el ID de la categoría a editar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        Categoria categoriaAEditar = null;
        for (Categoria categoria : listaCategorias) {
            if (categoria.getId() == id) {
                categoriaAEditar = categoria;
                break;
            }
        }
        if (categoriaAEditar != null) {
            System.out.print("Ingrese el nuevo nombre de la categoría: ");
            String nuevoNombre = sc.nextLine();
            categoriaAEditar.setNombre(nuevoNombre);
            categoriaAEditar.mostrarInformacion();
            System.out.println("Categoría editada exitosamente.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    private void eliminarCategoria() {
        listarCategorias();
        System.out.print("Ingrese el ID de la categoría a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        Categoria categoriaAEliminar = null;
        for (Categoria categoria : listaCategorias) {
            if (categoria.getId() == id) {
                categoriaAEliminar = categoria;
                break;
            }
        }
        if (categoriaAEliminar != null) {
            categoriaAEliminar.mostrarInformacion();
            listaCategorias.remove(categoriaAEliminar);
            System.out.println("Categoría eliminada exitosamente.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

}
