package pedido;

import cliente.Cliente;

import java.io.*;
import java.util.*;

public class Pendiente extends Estado {

    public Pendiente() {
    }

    public void avanzarEstado(Pedido pedido) {
        boolean cobroExitoso = pedido.cobrar();
        if (cobroExitoso) {
            Procesando procesando = new Procesando();
            Cliente cliente = pedido.getCliente();
            cliente.recibirNotificacion(cliente.getNombre() + " Tu pedido fue aceptado", pedido);
            pedido.setEstado(procesando);
            pedido.getEstado().avanzarEstado(pedido);
        } else {
            Cliente cliente = pedido.getCliente();
            cliente.recibirNotificacion(cliente.getNombre() + " Tu pedido fue cancelado", pedido);
            Cancelado cancelado = new Cancelado();
            pedido.setEstado(cancelado);
        }
    }

}