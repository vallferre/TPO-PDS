package plataforma;

import cliente.Cliente;
import pedido.Pedido;
import restaurante.Staff;

public interface Plataforma {
    boolean aceptaCupones();
    void notificar(String mensaje, Pedido pedido, Cliente cliente, Staff staff);
}