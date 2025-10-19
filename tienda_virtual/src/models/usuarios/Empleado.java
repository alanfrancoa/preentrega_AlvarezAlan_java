package models.usuarios;

import java.util.ArrayList;

import models.articulos.Articulo;
import models.categorias.Categoria;

public class Empleado extends UsuarioBase {

    private ArrayList<Articulo> listadoArticulos;
    private ArrayList<Categoria> listadoCategorias;

    public Empleado(String nombreUsuario, String claveUsuario) {
        super(nombreUsuario, claveUsuario);
        this.listadoArticulos = new ArrayList<>();
        this.listadoCategorias = new ArrayList<>();
    }

    // Getters y Setters

    @Override
    public String getRolUsuario() {
        return "Empleado";
    }

    
    
    // Métodos para gestionar el listado de artículos
    public ArrayList<Articulo> getListadoArticulos() {
        return listadoArticulos;
    }
    
    public void agregarArticulo(Articulo articulo) {
        this.listadoArticulos.add(articulo);
        
    }
    
    public void editarArticulo(Articulo articuloActualizado, double nuevoPrecio, String nuevoNombre,
    Categoria nuevaCategoria) {
        articuloActualizado.setPrecio(nuevoPrecio);
        articuloActualizado.setNombre(nuevoNombre);
        articuloActualizado.setCategoria(nuevaCategoria);
    }
    
    public void eliminarArticulo(int idArticulo) {
        this.listadoArticulos.removeIf(articulo -> articulo.getId() == idArticulo);
    }
    
    public void mostrarArticulo(Articulo articulo) {
        System.out.println("{ id_articulo: " + articulo.getId() + ", nombre: " + articulo.getNombre()
        + ", precio: " + articulo.getPrecio() + ", categoria: " + articulo.getCategoria().getNombre() + "}");
    }
    
    // Métodos para gestionar el listado de categorías
    
    public ArrayList<Categoria> getListadoCategorias() {
        return listadoCategorias;
    }

    public void agregarCategoria(Categoria categoria) {
        this.listadoCategorias.add(categoria);
    }

    public void editarCategoria(Categoria categoriaActualizada, String nuevoNombre) {
        categoriaActualizada.setNombre(nuevoNombre);
    }

    public void eliminarCategoria(int idCategoria) {
        this.listadoCategorias.removeIf(categoria -> categoria.getId() == idCategoria);
    }

    public void mostrarCategoria(Categoria categoria) {
        System.out.println("{ id_categoria: " + categoria.getId() + ", nombre: " + categoria.getNombre() + "}");
    }


}
