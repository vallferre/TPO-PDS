package cliente;

import notificacion.INotificable;
import notificacion.NotificacionEmail;
import notificacion.NotificacionPush;
import pago.MetodoPago;
import pedido.Cancelado;
import pedido.Estado;
import pedido.Pedido;
import pedido.Pendiente;
import producto.IProducto;
import restaurante.Restaurante;

import java.io.*;
import java.util.*;

public class Cliente {

    private String idCliente;

    private String nombre;

    private Email email;

    private List<Pedido> historialPedidos;

    private INotificable canal;

    public Cliente(String nombre, Email email, INotificable canal) {
        this.idCliente = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.email = email;
        this.historialPedidos = new ArrayList<>();
        this.canal = canal;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmailNombre() {
        String emailCompleto = email.getUsername() + email.getDomain();
        return emailCompleto;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void setHistorialPedidos(List<Pedido> historialPedidos) {
        this.historialPedidos = historialPedidos;
    }

    public void realizarPedido(Restaurante restaurante, float total, MetodoPago metodoPago, List<IProducto> productos, ICuponAplicable cupon) {
        Pendiente pendiente = new Pendiente();
        Pedido pedido = new Pedido(pendiente, metodoPago, productos, cupon, this);
        historialPedidos.add(pedido);
        pendiente.notificar();
        restaurante.gestionarPedidos(pedido);
    }

    public void cancelarPedido(Restaurante restaurante) {
        Cancelado cancelado = new Cancelado();
        Pedido ultimoPedido = historialPedidos.getLast();
        ultimoPedido.setEstado(cancelado);
    }

    public void recibirNotificacion(String mensaje, Pedido pedido) {
        canal.notificar(mensaje, pedido);
    }

}