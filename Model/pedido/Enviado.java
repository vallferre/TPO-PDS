package pedido;

import notificacion.INotificable;

import java.io.*;
import java.util.*;

public class Enviado extends Estado {

    public Enviado() {
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.getCliente().recibirNotificacion("Tu pedido ha sido enviado. ", pedido);
        Entregado entregado = new Entregado();
        pedido.setEstado(entregado);
        pedido.getEstado().avanzarEstado(pedido);
    }

}