package pago;

public class GooglePayFactory implements MetodoPagoFactory {

    private Tarjeta tarjeta;

    public GooglePayFactory(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public MetodoPago crearMetodoPago() {
        return new PagoConGooglePay(tarjeta);
    }
}

