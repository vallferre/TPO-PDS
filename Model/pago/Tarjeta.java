package pago;

import java.time.YearMonth;

public abstract class Tarjeta {

    protected String numeroTarjeta;

    protected String nombre;

    protected String direccion;

    protected YearMonth fechaExpiracion;

    protected int CVV;

    public Tarjeta() {
    }

    public abstract boolean validarFondos(double monto);

}