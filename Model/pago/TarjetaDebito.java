package pago;

import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

/**
 * 
 */
public class TarjetaDebito extends Tarjeta {

    private float fondos;

    public TarjetaDebito(String numeroTarjeta, String nombre, String direccion, YearMonth fechaExpiracion, int CVV, float fondos) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaExpiracion = fechaExpiracion;
        this.CVV = CVV;
        this.fondos = fondos;
    }

    public boolean validarFondos(double monto) {
        return this.fondos >= monto;
    }
}