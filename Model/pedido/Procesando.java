package pedido;

import restaurante.Mozo;

import java.io.*;
import java.util.*;

public class Procesando extends Estado {

    public Procesando() {
    }

    public void avanzarEstado(Pedido pedido) {

        pedido.getCliente().recibirNotificacion("Tu pedido está en preparación ", pedido);

        if (pedido.getMozoAsignado() != null) {
            Mozo mozo = pedido.getMozoAsignado();
            mozo.recibirNotificacion(mozo.getClass().getSimpleName() + " El pedido #" + pedido.getIdPedido() + " está listo para entregar.", pedido);
        }
        Enviado enviado = new Enviado();
        pedido.setEstado(enviado);
    }
}