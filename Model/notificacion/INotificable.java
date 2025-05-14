package notificacion;

import pedido.Pedido;

import java.io.*;
import java.util.*;

public interface INotificable {

    void notificar(String mensaje, Pedido pedido);

}