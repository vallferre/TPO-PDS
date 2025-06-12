package producto;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Producto implements IProducto {

    private int idProducto;

    private String nombre;

    private String descripcion;

    private float precio;

    private List<String> alergenos;

    private CategoriaProducto categoriaProducto;

    private int tiempoPreparacion;

    public Producto(int idProducto, String nombre, String descripcion, float precio, List<String> alergenos, CategoriaProducto categoria, int tiempoPreparacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.alergenos = alergenos;
        this.categoriaProducto = categoria;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getId() {
        return idProducto;
    }

    @Override
    public int getTiempoEstimado() {
        return tiempoPreparacion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", alergenos=" + alergenos +
                ", categoriaProducto=" + categoriaProducto +
                ", tiempoPreparacion=" + tiempoPreparacion +
                '}';
    }
}