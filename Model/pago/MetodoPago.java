package pago;

import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public abstract class MetodoPago{

    protected String numeroTarjeta;

    protected String nombre;

    protected String direccion;

    protected YearMonth fechaExpiracion;

    protected int CVV;

    public MetodoPago() {
    }

    public boolean procesarPago(float monto) {
        return false;
    }

}