package pedido;

import cliente.Cliente;

import java.io.*;
import java.util.*;

public class Pendiente extends Estado {

    public Pendiente() {
    }

    @Override
    public int calcularTiempo(Pedido pedido) {
        int tiempoEstimado = 5;
        int cantidadPedidos = pedido.getRestaurante().getPedidos().size(); // o vía un servicio

        int bloquesDeDiez = cantidadPedidos / 10;
        tiempoEstimado += bloquesDeDiez * 20;

        return tiempoEstimado;
    }

    public void avanzarEstado(Pedido pedido) {
        boolean cobroExitoso = pedido.cobrar();
        if (cobroExitoso) {
            System.out.println("Tiempo estimado: " + calcularTiempo(pedido) + " minutos");
            Procesando procesando = new Procesando();
            Cliente cliente = pedido.getCliente();
            cliente.recibirNotificacion(cliente.getNombre() + " Tu pedido fue aceptado. ", pedido, pedido.getCliente(), pedido.getMozoAsignado());
            pedido.setEstado(procesando);
            pedido.getEstado().avanzarEstado(pedido);
        } else {
            Cliente cliente = pedido.getCliente();
            Cancelado cancelado = new Cancelado();
            pedido.setEstado(cancelado);
            cliente.recibirNotificacion(cliente.getNombre() + " Tu pedido fue cancelado. " + cancelado.getRazon(pedido) + ". ",  pedido, pedido.getCliente(), pedido.getMozoAsignado());
        }
    }

}