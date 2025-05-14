package pago;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class TarjetaDebito extends MetodoPago {

    private float fondos;

    public TarjetaDebito(int numeroTarjeta, String nombre, String direccion, Date fechaExpiracion, int CVV, float fondos) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaExpiracion = fechaExpiracion;
        this.CVV = CVV;
        this.fondos = fondos;
    }

    @Override
    public boolean procesarPago(float monto) {
        if (validarFondos(monto)) {
            return true;
        }
        return false;
    }

    public boolean validarFondos(float monto) {
        return this.fondos >= monto;
    }
}