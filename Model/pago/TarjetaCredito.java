package pago;

import java.io.*;
import java.util.*;

public class TarjetaCredito extends MetodoPago {

    public TarjetaCredito(int numeroTarjeta, String nombre, String direccion, Date fechaExpiracion, int CVV) {
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