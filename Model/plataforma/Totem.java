package plataforma;

import cliente.Cliente;
import pedido.Pedido;
import restaurante.Staff;

public class Totem implements Plataforma{

    public Totem() {
    }

    @Override
    public boolean aceptaCupones() { return false; }
    @Override
    public void notificar(String msg, Pedido p, Cliente c, Staff s) {}

}