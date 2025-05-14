package notificacion;

import java.io.*;
import java.util.*;

import cliente.Cliente;
import cliente.Email;
import pedido.Pedido;

public class NotificacionEmail implements INotificable {

    private Email emailDestino;

    public NotificacionEmail(Email emailDestino) {
        this.emailDestino = emailDestino;
    }

    @Override
    public void notificar(String mensaje, Pedido pedido) {
        System.out.println("[EMAIL a " + emailDestino.getUsername() + emailDestino.getDomain() + "] " + mensaje + pedido.getNombreEstado());
    }

}