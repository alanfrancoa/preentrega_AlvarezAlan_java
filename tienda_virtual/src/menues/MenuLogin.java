package menues;
import java.util.ArrayList;
import java.util.Scanner;
import models.articulos.Articulo;
import models.carrito.Carrito;
import models.categorias.Categoria;
import models.usuarios.UsuarioBase;    

public class MenuLogin {
    private Scanner sc;
    private ArrayList<UsuarioBase> listaUsuarios;
    private ArrayList<Articulo> listaArticulos;
    private ArrayList<Categoria> listaCategorias;
    private Carrito carritoUsuario;

    public MenuLogin(Scanner sc, ArrayList<UsuarioBase> listaUsuarios, ArrayList<Articulo> listaArticulos, ArrayList<Categoria> listaCategorias, Carrito carritoUsuario) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
        this.listaArticulos = listaArticulos;
        this.listaCategorias = listaCategorias;
        this.carritoUsuario = carritoUsuario;
    }

    public void iniciar() {
        System.out.println("----- Menú de Inicio de Sesión -----");
        System.out.print("Ingrese su nombre de usuario: ");
        String username = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = sc.nextLine();

        // Lógica para verificar las credenciales del usuario
        UsuarioBase usuario = verificarCredenciales(username, password);
        if (usuario != null) {
            System.out.println("¡Inicio de sesión exitoso!");
            this.redireccionarMenuUsuario(usuario);
        } else {
            System.out.println("Credenciales inválidas. Intente de nuevo.");
        }
    }
    private UsuarioBase verificarCredenciales(String username, String password) {
        for (UsuarioBase usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(username) && usuario.getClaveUsuario().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    private void redireccionarMenuUsuario(UsuarioBase usuario) {
        if (usuario.getRolUsuario().equalsIgnoreCase("Empleado")) {
            MenuEmpleado menuEmpleado = new MenuEmpleado(sc, listaArticulos, listaCategorias);
            menuEmpleado.mostrarMenu();
        } else if (usuario.getRolUsuario().equalsIgnoreCase("Cliente")) {
            MenuCliente menuCliente = new MenuCliente(sc, listaArticulos, listaCategorias, carritoUsuario);
            menuCliente.mostrarMenu();
        } else {
            System.out.println("Rol de usuario no reconocido.");
        }
    }

}

