package restaurante;

import pedido.Estado;
import pedido.Pedido;

import java.io.*;
import java.util.*;

public class Chef extends Staff {

    private boolean ocupado;

    private Pedido pedido;

    public Chef(String nombre) {
        idStaff = UUID.randomUUID().toString();
        this.nombre = nombre;
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