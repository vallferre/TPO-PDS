package pago;

public class PagoConEfectivo extends MetodoPago {

    private double saldo;

    public PagoConEfectivo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}