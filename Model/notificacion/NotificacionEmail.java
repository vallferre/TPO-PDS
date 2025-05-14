package notificacion;

import java.io.*;
import java.util.*;

import cliente.Cliente;
import cliente.Email;
import pedido.Pedido;

public class NotificacionEmail implements INotificable {

    private Email emailDestino;

    public NotificacionEmail(Cliente cliente) {
        emailDestino = cliente.getEmail();
    }

    @Override
    public void notificar(String mensaje, Pedido pedido) {
        System.out.println("[EMAIL a " + emailDestino.getDomain() + "] está en estado " + pedido.getEstado());
    }

}