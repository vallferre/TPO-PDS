package pedido;

import pago.MetodoPago;
import producto.IProducto;
import restaurante.Restaurante;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Pedido {

    /**
     * Default constructor
     */
    public Pedido() {
    }

    /**
     * 
     */
    private int idPedido;

    /**
     * 
     */
    private int numeroOrden;

    /**
     * 
     */
    private Estado estado;

    /**
     * 
     */
    private double total;

    /**
     * 
     */
    private MetodoPago metodoPago;

    /**
     * @return
     */
    public void cambiarEstado() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void cobrar() {
        // TODO implement here
    }

}