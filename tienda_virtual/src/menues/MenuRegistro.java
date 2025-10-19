package menues;

import java.util.ArrayList;
import java.util.Scanner;

import models.usuarios.Empleado;
import models.usuarios.Cliente;
import models.usuarios.UsuarioBase;

public class MenuRegistro {
    private Scanner sc;
    private ArrayList<UsuarioBase> listaUsuarios;
    private boolean continuar = true;

    public MenuRegistro(Scanner sc, ArrayList<UsuarioBase> listaUsuarios) {
        this.sc = sc;
        this.listaUsuarios = listaUsuarios;
    }

    public void mostrarMenu() {
        while (continuar) {
            System.out.println("----- Menú Registro -----");
            System.out.println("1. Registrarse");
            System.out.println("2. Volver al Menú Principal");
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
                    this.registrarUsuario();
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private boolean usuarioExiste(String nombreUsuario) {
        for (UsuarioBase usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    private boolean validarNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
            System.out.println("Error: El nombre de usuario no puede estar vacío.");
            return false;
        }
        if (nombreUsuario.length() < 3) {
            System.out.println("Error: El nombre de usuario debe tener al menos 3 caracteres.");
            return false;
        }
        if (usuarioExiste(nombreUsuario)) {
            System.out.println("Error: El nombre de usuario ya existe. Por favor, elija otro.");
            return false;
        }
        return true;
    }

    private boolean validarClave(String clave) {
        if (clave == null || clave.trim().isEmpty()) {
            System.out.println("Error: La clave no puede estar vacía.");
            return false;
        }
        if (clave.length() < 4) {
            System.out.println("Error: La clave debe tener al menos 4 caracteres.");
            return false;
        }
        return true;
    }

    private int validarRol() {
        while (true) {
            try {
                System.out.print("Ingrese rol de usuario (1-Empleado/2-Cliente): ");
                int rolUsuario = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                if (rolUsuario != 1 && rolUsuario != 2) {
                    System.out.println("Error: Debe ingresar 1 para Empleado o 2 para Cliente.");
                    continue;
                }
                return rolUsuario;
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine(); // Limpiar buffer
            }
        }
    }

    private void registrarUsuario() {
        String nombreUsuario;
        String claveUsuario;
        
        do {
            System.out.print("Ingrese nombre de usuario: ");
            nombreUsuario = sc.nextLine();
        } while (!validarNombreUsuario(nombreUsuario));

        do {
            System.out.print("Ingrese clave de usuario: ");
            claveUsuario = sc.nextLine();
        } while (!validarClave(claveUsuario));

        int rolUsuario = validarRol();
        
        String rol = (rolUsuario == 1) ? "Empleado" : "Cliente";
        if (rol.equals("Empleado")) {
            Empleado nuevoUsuario = new Empleado(nombreUsuario, claveUsuario);
            listaUsuarios.add(nuevoUsuario);
            System.out.println("¡Registro exitoso! Ahora puede iniciar sesión.");
        } else {
            Cliente nuevoUsuario = new Cliente(nombreUsuario, claveUsuario);
            listaUsuarios.add(nuevoUsuario);
            System.out.println("¡Registro exitoso! Ahora puede iniciar sesión.");
        }
    }
}
