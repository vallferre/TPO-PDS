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

    public abstract int calcularTiempo(Pedido pedido);

    /**
     * @param pedido
     */
    public abstract void avanzarEstado(Pedido pedido);

}