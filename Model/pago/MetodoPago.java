package pago;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class MetodoPago{

    /**
     * Default constructor
     */
    public MetodoPago() {
    }

    /**
     * 
     */
    protected double monto;

    /**
     * @return
     */
    public boolean validarFondos() {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void procesarPago(double monto) {
        // TODO implement pago.IPagable.procesarPago(monto: double)() here
    }

}