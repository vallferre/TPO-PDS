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

    public Producto(int idProducto, String nombre, String descripcion, float precio, List<String> alergenos, CategoriaProducto categoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.alergenos = alergenos;
        this.categoriaProducto = categoria;
    }

    @Override
    public float getPrecio() {
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
}