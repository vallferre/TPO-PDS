package pedido;

import java.io.*;
import java.util.*;

public class Entregado extends Estado {

    public Entregado() {
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.getMozoAsignado().liberar(pedido);
        pedido.getCliente().recibirNotificacion("Tu pedido fue entregado", pedido);
    }
}