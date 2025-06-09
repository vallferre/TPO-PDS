package pago;

public class MetodoPagoFactory {
    public MetodoPago crearMetodoPago(String tipo, Tarjeta tarjeta, Double saldo) {
        return switch (tipo.toLowerCase()) {
            case "mercadopago" -> new PagoConMercadoPago(saldo, tarjeta);
            case "googlepay" -> new PagoConGooglePay(tarjeta);
            case "tarjeta" -> new PagoConTarjeta(tarjeta);
            case "efectivo" -> new PagoConEfectivo(saldo);
            default -> throw new IllegalArgumentException("Tipo de pago no reconocido");
        };
    }

}
