package pago;

public class EfectivoFactory implements MetodoPagoFactory {

    private double saldo;

    public EfectivoFactory(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public MetodoPago crearMetodoPago() {
        return new PagoConEfectivo(saldo);
    }
}
