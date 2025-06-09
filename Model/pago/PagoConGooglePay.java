package pago;

public class PagoConGooglePay extends MetodoPago {

    private Tarjeta tarjeta;

    public PagoConGooglePay(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public boolean procesarPago(double monto){
        if (tarjeta != null) {
            boolean fondosExitosos = tarjeta.validarFondos(monto);
            return fondosExitosos;
        }
        return false;
    }

}