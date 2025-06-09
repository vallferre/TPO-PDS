package pago;

public class MPFactory implements MetodoPagoFactory {

    private double saldo;
    private Tarjeta tarjeta;

    public MPFactory(double saldo, Tarjeta tarjeta) {
        this.saldo = saldo;
        this.tarjeta = tarjeta;
    }

    @Override
    public MetodoPago crearMetodoPago() {
        return new PagoConMercadoPago(saldo, tarjeta);
    }
}
