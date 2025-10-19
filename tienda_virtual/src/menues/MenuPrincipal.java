package menues;

import java.util.ArrayList;
import java.util.Scanner;

import models.articulos.Articulo;
import models.categorias.Categoria;
import models.usuarios.UsuarioBase;

public class MenuPrincipal {
    private boolean continuar = true;
    private Scanner sc;
    ArrayList<UsuarioBase> listaUsuarios;
    ArrayList<Articulo> listaArticulos;
    ArrayList<Categoria> listaCategorias;
    models.carrito.Carrito carrito = new models.carrito.Carrito();

    public MenuPrincipal(Scanner sc, ArrayList<UsuarioBase> listaUsuarios, ArrayList<Articulo> listaArticulos, ArrayList<Categoria> listaCategorias) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
        this.listaArticulos = listaArticulos;
        this.listaCategorias = listaCategorias;
    }

    private void mostrarOpciones() {
        System.out.println("----- Menú Principal -----");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void iniciar(){
        while (continuar) {
            int opcion = this.elegirOpcionMenu();
            this.realizarAccion(opcion);
        }
    }

    private int elegirOpcionMenu() {
        this.mostrarOpciones();
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        return opcion;
    }

    private void realizarAccion(int opcion) {
        switch (opcion) {
            case 1:
                MenuLogin menuLogin = new MenuLogin(sc, listaUsuarios, listaArticulos, listaCategorias, carrito);
                menuLogin.iniciar();
                break;
            case 2:
                MenuRegistro menuRegistro = new MenuRegistro(sc, listaUsuarios);
                menuRegistro.mostrarMenu();
                break;
            case 3:
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                continuar = false;
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }
    }

}
