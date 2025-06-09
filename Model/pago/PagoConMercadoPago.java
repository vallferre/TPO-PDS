package pago;

public class PagoConMercadoPago extends MetodoPago {
    private double saldo;
    private Tarjeta tarjeta;
    public PagoConMercadoPago(double saldo, Tarjeta tarjeta) {
        this.saldo = saldo;
        this.tarjeta = tarjeta;
    }

    @Override
    public boolean procesarPago(double monto){
        if (tarjeta != null) {
            boolean fondosExitosos = tarjeta.validarFondos(monto);
            return fondosExitosos;
        }
        if (saldo >= monto) {
            return true;
        }
        return false;
    }

}