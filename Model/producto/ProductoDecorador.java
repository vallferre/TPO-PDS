package producto;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class ProductoDecorador implements IProducto {

    /**
     * Default constructor
     */
    public ProductoDecorador() {
    }

    /**
     * 
     */
    private IProducto componente;


    /**
     * @return
     */
    public void modificarPrecio() {
        // TODO implement here
    }

    /**
     * @return
     */
    @Override
    public float getPrecio() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    @Override
    public String getDescripcion() {
        // TODO implement here
        return "";
    }

}