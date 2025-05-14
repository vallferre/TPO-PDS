package pedido;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Cancelado extends Estado {

    /**
     * Default constructor
     */
    public Cancelado() {
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(this);
        pedido.getMozoAsignado().liberar(pedido);
    }
}