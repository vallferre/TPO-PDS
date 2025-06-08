package notificacion;

import cliente.Cliente;
import pedido.Pedido;
import restaurante.Staff;

import java.io.*;
import java.util.*;

public interface INotificable {

    void notificar(String mensaje, Pedido pedido, Cliente cliente, Staff staff);

}