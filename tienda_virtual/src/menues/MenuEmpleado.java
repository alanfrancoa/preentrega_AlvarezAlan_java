package menues;

import java.util.ArrayList;
import java.util.Scanner;

import models.articulos.Articulo;
import models.categorias.Categoria;

public class MenuEmpleado {

    private boolean continuar = true;
    private Scanner sc;
    private ArrayList<Articulo> listaArticulos;
    private ArrayList<Categoria> listaCategorias;

    public MenuEmpleado(Scanner sc, ArrayList<Articulo> listaArticulos, ArrayList<Categoria> listaCategorias) {
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
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                continue;
            }

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
        double precio = -1;
        while (true) {
            System.out.print("Ingrese el precio del artículo: ");
            try {
                precio = Double.parseDouble(sc.nextLine());
                if (precio >= 0) break;
                else System.out.println("El precio debe ser mayor o igual a cero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        listarCategorias();
        int categoriaId = -1;
        while (true) {
            System.out.print("Ingrese ID de la categoría: ");
            try {
                categoriaId = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
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
        int id = -1;
        while (true) {
            System.out.print("Ingrese el ID del artículo a editar: ");
            try {
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        Articulo articuloAEditar = null;
        for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                articuloAEditar = articulo;
                break;
            }
        }
        if (articuloAEditar != null) {
            System.out.println("Editando artículo:");
            System.out.println(articuloAEditar.mostrarInformacion());
            System.out.print("Ingrese el nuevo nombre del artículo: ");
            String nuevoNombre = sc.nextLine();
            double nuevoPrecio = -1;
            while (true) {
                System.out.print("Ingrese el nuevo precio del artículo: ");
                try {
                    nuevoPrecio = Double.parseDouble(sc.nextLine());
                    if (nuevoPrecio >= 0) break;
                    else System.out.println("El precio debe ser mayor o igual a cero.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                }
            }
            listarCategorias();
            int nuevaCategoriaId = -1;
            while (true) {
                System.out.print("Ingrese ID de la categoría: ");
                try {
                    nuevaCategoriaId = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                }
            }
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
        int id = -1;
        while (true) {
            System.out.print("Ingrese el ID del artículo a eliminar: ");
            try {
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        Articulo articuloAEliminar = null;
        for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                articuloAEliminar = articulo;
                break;
            }
        }
        if (articuloAEliminar != null) {
            System.out.println("Eliminando artículo:");
            System.out.println(articuloAEliminar.mostrarInformacion());
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
        int id = -1;
        while (true) {
            System.out.print("Ingrese el ID de la categoría a editar: ");
            try {
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
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
            System.out.println(categoriaAEditar.mostrarInformacion());
            System.out.println("Categoría editada exitosamente.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    private void eliminarCategoria() {
        listarCategorias();
        int id = -1;
        while (true) {
            System.out.print("Ingrese el ID de la categoría a eliminar: ");
            try {
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        Categoria categoriaAEliminar = null;
        for (Categoria categoria : listaCategorias) {
            if (categoria.getId() == id) {
                categoriaAEliminar = categoria;
                break;
            }
        }
        if (categoriaAEliminar != null) {
            System.out.println("Eliminando categoría:");
            System.out.println(categoriaAEliminar.mostrarInformacion());
            listaCategorias.remove(categoriaAEliminar);
            System.out.println("Categoría eliminada exitosamente.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

}
