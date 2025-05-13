package pedido;

import pago.MetodoPago;
import producto.Producto;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Cobro {

    /**
     * Default constructor
     */
    public Cobro() {
    }

    /**
     * 
     */
    private Date fecha;

    /**
     * 
     */
    private double monto;

    /**
     * 
     */
    private MetodoPago metodoPago;

    /**
     * 
     */
    private List<Producto> detalles;

    /**
     * @return
     */
    public void pagar() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void aplicarCupon() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void generarFactura() {
        // TODO implement here
    }

}