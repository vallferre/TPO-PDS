package pedido;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Procesando extends Estado {

    private Estado estado;
    /**
     * Default constructor
     */
    public Procesando() {
    }


    /**
     * @param pedido 
     * @return
     */
    public void avanzarEstado(Pedido pedido) {
        // TODO implement here
        estado.notificar();
    }
}