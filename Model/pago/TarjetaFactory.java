package pago;

public class TarjetaFactory implements MetodoPagoFactory {

    private Tarjeta tarjeta;

    public TarjetaFactory(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public MetodoPago crearMetodoPago() {
        return new PagoConTarjeta(tarjeta);
    }
}
