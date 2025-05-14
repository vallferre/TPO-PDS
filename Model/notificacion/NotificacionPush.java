package notificacion;

import pedido.Pedido;

import java.io.*;
import java.util.*;

public class NotificacionPush implements INotificable {

    public NotificacionPush() {
    }

    @Override
    public void notificar(String mensaje, Pedido pedido) {
        System.out.println("El pedido [" + pedido.getIdPedido() + "] esta en estado " + pedido.getEstado());
    }

}