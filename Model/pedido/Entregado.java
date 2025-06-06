package pedido;

import java.io.*;
import java.util.*;

public class Entregado extends Estado {

    public Entregado() {
    }

    @Override
    public int calcularTiempo(Pedido pedido) {
        return 0;
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.getCliente().recibirNotificacion("Tu pedido fue entregado. ", pedido, pedido.getCliente(), pedido.getMozoAsignado());
        pedido.getMozoAsignado().liberar(pedido);
        pedido.getAdminAsignado().liberar(pedido);
        pedido.getChefAsignado().liberar(pedido);
        pedido.setEstado(this);
        generarFactura(pedido);
    }

    public void generarFactura(Pedido pedido){
        Factura factura = new Factura(pedido.getTotal(), pedido.getMetodoPago(), pedido.getProductos(), pedido.getCuponAplicable());
        factura.imprimirFactura();
    }
}