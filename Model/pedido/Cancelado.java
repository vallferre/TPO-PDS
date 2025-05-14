package pedido;

import java.io.*;
import java.util.*;

public class Cancelado extends Estado {

    public Cancelado() {
    }

    public String getRazon(Pedido pedido){
        String mensaje = "";
        if(pedido.getMetodoPago().procesarPago(pedido.getTotal()) == false){
            mensaje = "Razon: Fondos insuficientes.";
            return mensaje;
        };
        return mensaje;
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(this);
        pedido.getMozoAsignado().liberar(pedido);
    }
}