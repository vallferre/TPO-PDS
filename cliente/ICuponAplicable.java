package cliente;

import pedido.Cobro;

public interface ICuponAplicable {

    double aplicarDescuento(double total);

    int getPorcentajeDto();
}