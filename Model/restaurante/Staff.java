package restaurante;

import java.io.*;
import java.util.*;
import pedido.Estado;
import pedido.Pedido;

/**
 * 
 */
public abstract class Staff {

    /**
     * Default constructor
     */
    public Staff() {
    }

    public abstract void actualizarEstado(Pedido pedido, Estado estado);

}