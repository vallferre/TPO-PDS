package cliente;

import notificacion.INotificable;
import notificacion.NotificacionEmail;
import notificacion.NotificacionPush;
import pago.MetodoPago;
import pedido.Cancelado;
import pedido.Estado;
import pedido.Pedido;
import pedido.Pendiente;
import plataforma.Plataforma;
import producto.IProducto;
import restaurante.Mozo;
import restaurante.Restaurante;
import restaurante.Staff;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Cliente {

    private String idCliente;

    private String nombre;

    private Email email;

    private List<Pedido> historialPedidos;

    private INotificable canal;

    private LocalDateTime horaProgramada;

    private Plataforma plataforma;

    public Cliente(String nombre, Email email, INotificable canal, Plataforma plataforma) {
        this.idCliente = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.email = email;
        this.historialPedidos = new ArrayList<>();
        this.canal = canal;
        this.plataforma = plataforma;
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

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void setHistorialPedidos(List<Pedido> historialPedidos) {
        this.historialPedidos = historialPedidos;
    }

    public Email getEmail() {
        return email;
    }

    public INotificable getCanal() {
        return canal;
    }

    public void setCanal(INotificable canal) {
        this.canal = canal;
    }

    public LocalDateTime getHoraProgramada() {
        return horaProgramada;
    }

    public void setHoraProgramada(LocalDateTime horaProgramada) {
        this.horaProgramada = horaProgramada;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Pedido realizarPedido(Restaurante restaurante, MetodoPago metodoPago, List<IProducto> productos, ICuponAplicable cupon) {
        Pendiente pendiente = new Pendiente();
        Pedido pedido = new Pedido(pendiente, metodoPago, productos, cupon, this, horaProgramada, restaurante);
        historialPedidos.add(pedido);
        System.out.println("Tu total: " + pedido.getTotal());
        restaurante.gestionarPedidos(pedido);
        return pedido;
    }

    public void cancelarPedido() {
        Pedido ultimoPedido = historialPedidos.getLast();
        Estado estado = ultimoPedido.getEstado();
        estado.avanzarEstado(ultimoPedido);
    }

    public void recibirNotificacion(String mensaje, Pedido pedido, Cliente cliente, Staff staff) {
        canal.notificar(mensaje, pedido, cliente, staff);
    }

}