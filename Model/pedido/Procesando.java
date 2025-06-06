package pedido;

import producto.IProducto;
import producto.Producto;
import restaurante.Mozo;

import java.io.*;
import java.util.*;

public class Procesando extends Estado {

    public Procesando() {
    }

    @Override
    public int calcularTiempo(Pedido pedido) {
        int total = 0;
        for (IProducto producto : pedido.getProductos()) {
            total += producto.getTiempoEstimado(); // cada producto tiene tiempo estimado
        }
        return total;
    }

    public void avanzarEstado(Pedido pedido) {
        if (!(pedido.getEstado() instanceof Cancelado)){
            pedido.getCliente().recibirNotificacion("Tu pedido está en preparación. ", pedido, pedido.getCliente(), pedido.getMozoAsignado());
            System.out.println("Tiempo estimado: " + calcularTiempo(pedido) + " minutos");
            if (pedido.getMozoAsignado() != null) {
                Mozo mozo = pedido.getMozoAsignado();
                mozo.recibirNotificacion(mozo.getClass().getSimpleName() + " El pedido #" + pedido.getIdPedido() + " está listo para entregar. ", pedido, pedido.getCliente(), mozo);
                Enviado enviado = new Enviado();
                mozo.actualizarEstado(enviado);
            }
        } else {
            System.out.println("El pedido fue cancelado.");
        }
    }
}