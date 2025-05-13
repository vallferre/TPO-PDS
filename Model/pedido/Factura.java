package pedido;

import pago.MetodoPago;
import producto.Producto;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Factura {

    /**
     * Default constructor
     */
    public Factura() {
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
    public void imprimirFactura() {
        // TODO implement here
    }

}