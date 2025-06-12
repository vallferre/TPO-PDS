package pago;

public class PagoConEfectivo extends MetodoPago {

    private double saldo;

    public PagoConEfectivo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto*0.9;
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