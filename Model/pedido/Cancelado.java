package pedido;

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
        if(pedido.getMetodoPago().procesarPago(pedido.getTotal()) == false){
            mensaje = "Razon: Fondos insuficientes";
            return mensaje;
        } else {
            double montoRetornar = (pedido.getTotal())*0.75;
            mensaje = "Pedido cancelado, monto retornado: " + montoRetornar;
        }
        return mensaje;
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(this);
        pedido.getMozoAsignado().liberar(pedido);
        pedido.getCliente().recibirNotificacion(pedido.getCliente().getNombre() + " Tu pedido fue cancelado. " + getRazon(pedido) + ". ",  pedido, pedido.getCliente(), pedido.getMozoAsignado());
    }
}