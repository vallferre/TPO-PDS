package pago;

import java.io.*;
import java.util.*;

public abstract class MetodoPago{

    protected int numeroTarjeta;

    protected String nombre;

    protected String direccion;

    protected Date fechaExpiracion;

    protected int CVV;

    public MetodoPago() {
    }

    public boolean procesarPago(float monto) {
        return false;
    }

}