package pago;

public class PagoConTarjeta extends MetodoPago {
    private Tarjeta tarjeta;
    public PagoConTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (tarjeta != null) {
            boolean fondosExitosos = tarjeta.validarFondos(monto);
            return fondosExitosos;
        }
        return false;
    }
}