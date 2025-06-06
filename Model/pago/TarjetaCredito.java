package pago;

import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class TarjetaCredito extends Tarjeta{

    private double limite;

    public TarjetaCredito(String numeroTarjeta, String nombre, String direccion, YearMonth fechaExpiracion, int CVV, double limite) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaExpiracion = fechaExpiracion;
        this.CVV = CVV;
        this.limite = limite;
    }

    @Override
    public boolean validarFondos(double monto) {
        if (monto <= limite) {
            return true;
        }
        return false;
    }
}