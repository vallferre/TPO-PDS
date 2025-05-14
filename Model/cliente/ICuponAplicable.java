package cliente;

import pedido.Cobro;

public interface ICuponAplicable {

    float aplicarDescuento(float total);

    int getPorcentajeDto();
}