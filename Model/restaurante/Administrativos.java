package restaurante;

import pedido.Estado;
import pedido.Pedido;

import java.io.*;
import java.util.*;

public class Administrativos extends Staff {

    private boolean ocupado;

    private Pedido pedido;

    public Administrativos() {
    }

    public boolean estaLibre() {
        return !ocupado;
    }

    public void asignarPedido(Pedido pedido) {
        ocupado = true;
        this.pedido = pedido;
    }

    public void liberar() {
        ocupado = false;
        pedido = null;
    }
    @Override
    public void actualizarEstado(Estado estado) {
        pedido.getEstado().avanzarEstado(pedido);
    }
}