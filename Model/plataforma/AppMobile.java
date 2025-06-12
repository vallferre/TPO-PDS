package plataforma;

import cliente.Cliente;
import pedido.Pedido;
import restaurante.Staff;

public class AppMobile implements Plataforma{

    public AppMobile() {
    }

    @Override
    public boolean aceptaCupones() {
        return true;
    }
    @Override
    public void notificar(String msg, Pedido p, Cliente c, Staff s) {
        c.getCanal().notificar(msg, p, c,s);
    }

}