package pedido;

import notificacion.INotificable;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Estado {

    /**
     * Default constructor
     */
    public Estado() {
    }

    /**
     * @param pedido
     */
    public abstract void avanzarEstado(Pedido pedido);

    /**
     * @return
     */
    public void notificar() {
        // TODO implement here
    }

}