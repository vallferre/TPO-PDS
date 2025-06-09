package notificacion;

import java.io.*;
import java.util.*;

import cliente.Cliente;
import cliente.Email;
import pedido.Pedido;
import plataforma.AppMobile;
import restaurante.Mozo;
import restaurante.Staff;

public class NotificacionEmail implements INotificable {

    private Email emailDestino;

    public NotificacionEmail(Email emailDestino) {
        this.emailDestino = emailDestino;
    }

    @Override
    public void notificar(String mensaje, Pedido pedido, Cliente cliente, Staff staff) {
        if (cliente.getPlataforma() instanceof AppMobile) {
            System.out.println("[EMAIL a " + emailDestino.getUsername() + emailDestino.getDomain() + "] " + mensaje);
        }
    }

    @Override
    public String toString() {
        return "NotificacionEmail{" +
                "emailDestino=" + emailDestino +
                '}';
    }
}