package pedido;

import java.io.*;
import java.util.*;

public class Pendiente extends Estado {

    public Pendiente() {
    }

    public void avanzarEstado(Pedido pedido) {
        boolean cobroExitoso = pedido.cobrar();
        if (cobroExitoso) {
            Procesando procesando = new Procesando();
            pedido.setEstado(procesando);
            pedido.getCliente().recibirNotificacion("Tu pedido fue aceptado", pedido);
        } else {
            Cancelado cancelado = new Cancelado();
            pedido.setEstado(cancelado);
            pedido.getCliente().recibirNotificacion("Tu pedido fue cancelado", pedido);
        }
    }

}