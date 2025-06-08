package cliente;

import notificacion.INotificable;
import pago.MetodoPago;
import pedido.Cancelado;
import pedido.GestorPedidosProgramados;
import pedido.Pedido;
import pedido.Pendiente;
import plataforma.Plataforma;
import producto.IProducto;
import restaurante.Restaurante;
import restaurante.Staff;
import java.time.LocalTime;
import java.util.*;

public class Cliente {

    private String idCliente;

    private String nombre;

    private Email email;

    private List<Pedido> historialPedidos;

    private INotificable canal;

    private Plataforma plataforma;

    public Cliente(String nombre, Email email, INotificable canal, Plataforma plataforma) {
        this.idCliente = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.email = email;
        this.historialPedidos = new ArrayList<>();
        this.canal = canal;
        this.plataforma = plataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public Pedido realizarPedido(Restaurante restaurante, MetodoPago metodoPago, List<IProducto> productos, ICuponAplicable cupon, LocalTime horaProgramada) {
        Pendiente pendiente = new Pendiente();
        Pedido pedido = new Pedido(pendiente, metodoPago, productos, cupon, this, horaProgramada, restaurante);
        historialPedidos.add(pedido);
        System.out.println("Tu total: " + pedido.getTotal());
        if (pedido.isEsProgramado()) {
            System.out.println("Pedido programado para las " + horaProgramada);
            GestorPedidosProgramados.agregarPedido(pedido);
        } else {
            restaurante.gestionarPedidos(pedido);
        }

        return pedido;
    }

    public void cancelarPedido() {
        Pedido ultimoPedido = historialPedidos.getLast();
        Cancelado cancelado = new Cancelado();
        ultimoPedido.setEstado(cancelado);
        ultimoPedido.getEstado().avanzarEstado(ultimoPedido);
    }

    public void recibirNotificacion(String mensaje, Pedido pedido, Cliente cliente, Staff staff) {
        canal.notificar(mensaje, pedido, cliente, staff);
    }

}