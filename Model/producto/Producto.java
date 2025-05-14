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

    private String alergenos;

    public Producto(int idProducto, String nombre, String descripcion, float precio, String alergenos) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.alergenos = alergenos;
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