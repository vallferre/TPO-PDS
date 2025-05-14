package restaurante;

import notificacion.INotificable;
import pedido.Estado;
import pedido.Pedido;

import java.io.*;
import java.util.*;

public class Mozo extends Staff {

    private boolean ocupado;

    private Pedido pedido;

    private INotificable canal;

    private List<Pedido> pedidosAsignados = new ArrayList<>();

    public Mozo(INotificable canal) {
        this.ocupado = false;
        this.canal = canal;
    }

    public boolean estaLibre() {
        return pedidosAsignados.isEmpty();
    }

    public void asignarPedido(Pedido pedido) {
        ocupado = true;
        pedidosAsignados.add(pedido);
        pedido.asignarMozo(this);
        this.pedido = pedido;
    }

    public void liberar(Pedido pedido) {
        ocupado = false;
        pedidosAsignados.remove(pedido);
        this.pedido = null;
    }
    @Override
    public void actualizarEstado(Estado estado) {
        pedido.getEstado().avanzarEstado(pedido);
    }

    public void recibirNotificacion(String mensaje, Pedido pedido) {
        canal.notificar(mensaje, pedido);
    }

}