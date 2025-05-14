package pedido;

import java.io.*;
import java.util.*;

public class Procesando extends Estado {

    public Procesando() {
    }

    public void avanzarEstado(Pedido pedido) {
        Enviado enviado = new Enviado();
        pedido.setEstado(enviado);

        pedido.getCliente().recibirNotificacion("Tu pedido está en preparación", pedido);

        if (pedido.getMozoAsignado() != null) {
            pedido.getMozoAsignado().recibirNotificacion("El pedido #" + pedido.getIdPedido() + " está listo para entregar.", pedido);
        }
    }
}