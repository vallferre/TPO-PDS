package notificacion;

import cliente.Cliente;
import pedido.Pedido;
import plataforma.AppMobile;
import restaurante.Mozo;
import restaurante.Staff;

import java.io.*;
import java.util.*;

public class NotificacionPush implements INotificable {

    public NotificacionPush() {
    }

    @Override
    public void notificar(String mensaje, Pedido pedido, Cliente cliente, Staff staff) {
        if (cliente.getPlataforma() instanceof AppMobile){
            System.out.println(mensaje);
        }
    }

}