package cliente;

import notificacion.INotificable;
import pago.MetodoPago;
import pedido.Cancelado;
import pedido.GestorPedidos;
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

    public List<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public INotificable getCanal() {
        return canal;
    }

    public void recibirNotificacion(String mensaje, Pedido pedido, Cliente cliente, Staff staff) {
        plataforma.notificar(mensaje, pedido, cliente, staff);
    }

}