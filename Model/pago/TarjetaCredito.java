package pago;

import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class TarjetaCredito extends MetodoPago {

    public TarjetaCredito(String numeroTarjeta, String nombre, String direccion, YearMonth fechaExpiracion, int CVV) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaExpiracion = fechaExpiracion;
        this.CVV = CVV;
    }

    @Override
    public boolean procesarPago(float monto) {
        return true;
    }

}