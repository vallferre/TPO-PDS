package pago;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class TarjetaCredito extends MetodoPago {

    /**
     * Default constructor
     */
    public TarjetaCredito() {
    }

    /**
     * 
     */
    private int numeroTarjeta;

    /**
     *
     */
    private Date fechaExpiracion;

    /**
     *
     */
    private int CVV;

    @Override
    public void procesarPago(double monto) {
        // TODO implement here
    }

}