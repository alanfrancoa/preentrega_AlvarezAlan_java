package main;

import java.util.ArrayList;
import java.util.Scanner;

import models.articulos.Articulo;
import models.categorias.Categoria;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<models.usuarios.UsuarioBase> listaUsuarios = new ArrayList<>();
        ArrayList<Articulo> listaArticulos = new ArrayList<>();
        ArrayList<Categoria> listaCategorias = new ArrayList<>();

        Categoria cat1 = new Categoria("Electrónica");
        Categoria cat2 = new Categoria("Ropa");
        listaCategorias.add(cat1);
        listaCategorias.add(cat2);

        menues.MenuPrincipal menuPrincipal = new menues.MenuPrincipal(sc, listaUsuarios, listaArticulos,
                listaCategorias);
        menuPrincipal.iniciar();
        sc.close();
    }
}