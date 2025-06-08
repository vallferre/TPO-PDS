package pedido;

import pago.MetodoPago;

import java.io.*;
import java.util.*;

public class Cancelado extends Estado {

    public Cancelado() {
    }

    @Override
    public int calcularTiempo(Pedido pedido) {
        return 0;
    }

    public String getRazon(Pedido pedido){
        String mensaje = "";
        MetodoPago metodoPago = pedido.getMetodoPago();
        if(metodoPago.procesarPago(pedido.getTotal()) == false){
            mensaje = "Razon: Fondos insuficientes";
            return mensaje;
        } else {
            double montoRetornar = (pedido.getTotal())*0.75;
            mensaje = "Pedido cancelado, monto retornado: " + Math.round(montoRetornar*100.0)/100.0;
        }
        return mensaje;
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(this);
        pedido.getMozoAsignado().liberar(pedido);
        pedido.getAdminAsignado().liberar(pedido);
        pedido.getChefAsignado().liberar(pedido);
        pedido.getCliente().recibirNotificacion(pedido.getCliente().getNombre() + ". " + getRazon(pedido) + ". ",  pedido, pedido.getCliente(), pedido.getMozoAsignado());
    }
}