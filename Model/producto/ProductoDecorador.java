package producto;

import java.io.*;
import java.util.*;

public abstract class ProductoDecorador implements IProducto {

    protected IProducto componente;

    public ProductoDecorador(IProducto componente) {
        this.componente = componente;
    }

    @Override
    public double getPrecio() {
        return componente.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return componente.getDescripcion();
    }

    @Override
    public String getNombre() {
        return componente.getNombre();
    }

    @Override
    public int getId() {
        return componente.getId();
    }

    public abstract double modificarPrecio();
}