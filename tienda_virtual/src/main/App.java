package main;
import java.util.ArrayList;
import java.util.Scanner;
import menues.MenuInicio;
import models.Articulo;
import models.Categoria;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<Articulo> listaArticulos = new ArrayList<>();
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        
        Categoria cat1 = new Categoria("Electrónica");
        Categoria cat2 = new Categoria("Ropa");
        listaCategorias.add(cat1);
        listaCategorias.add(cat2);


        MenuInicio menu = new MenuInicio(sc, listaArticulos, listaCategorias);
        menu.mostrarMenu();
        sc.close();
    }
}