package restaurante;

import producto.IProducto;
import producto.Producto;

import java.io.*;
import java.util.*;

public class Menu {

    private List<IProducto> listaProductos;

    public Menu() {
        listaProductos = new ArrayList<>();
    }

    public void agregarProducto(IProducto p) {
        listaProductos.add(p);
    }

    public void eliminarProducto(IProducto p) {
        listaProductos.remove(p);
    }

    public void actualizarProducto(IProducto p) {
        for (int i = 0; i < listaProductos.size(); i++) {
            IProducto actual = listaProductos.get(i);

            if (actual.getId() == p.getId()) {
                listaProductos.set(i, p);
                return;
            }
        }
    }

    public List<IProducto> getListaProductos() {
        return listaProductos;
    }
}