package cliente;

import notificacion.NotificacionEmail;
import notificacion.NotificacionPush;
import pedido.Pedido;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Cliente {

    /**
     * Default constructor
     */
    public Cliente() {
    }

    /**
     * 
     */
    private int idCliente;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private Email email;

    /**
     * 
     */
    private List<Pedido> historialPedidos;

    /**
     * @return
     */
    public void realizarPedido() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void recibirNotificacion() {
        // TODO implement here
    }

}