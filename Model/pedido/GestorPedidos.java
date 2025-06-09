package pedido;
import cliente.Cliente;
import cliente.ICuponAplicable;
import pago.MetodoPago;
import producto.IProducto;
import restaurante.Restaurante;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestorPedidos implements Runnable {

    private static GestorPedidos instancia;

    private List<Pedido> pedidos = new ArrayList<>();
    private List<Pedido> pedidosProgramados = new ArrayList<>();
    private Restaurante restaurante;

    private GestorPedidos(Restaurante restaurante) {
        this.restaurante = restaurante;
        Thread hilo = new Thread(this); // hilo de control de programados
        hilo.setDaemon(true);
        hilo.start();
    }

    public static GestorPedidos getInstancia(Restaurante r) {
        if (instancia == null) {
            instancia = new GestorPedidos(r);
        }
        return instancia;
    }

    public Pedido crearPedido(Restaurante restaurante, Cliente cliente, MetodoPago metodoPago, List<IProducto> productos, ICuponAplicable cupon, LocalTime horaProgramada) {
        Pendiente pendiente = new Pendiente();
        Pedido pedido = new Pedido(pendiente, metodoPago, productos, cupon, cliente, horaProgramada, restaurante);
        pedidos.add(pedido);
        cliente.getHistorialPedidos().add(pedido);
        if (pedido.isEsProgramado()) {
            if (!(LocalTime.now().isAfter(horaProgramada))){
                pedidosProgramados.add(pedido);
                System.out.println("Pedido programado para " + horaProgramada);
            } else {
                System.out.println("Pedido programado para " + horaProgramada);
                restaurante.gestionarPedidos(pedido);
                System.out.println("Pedido enviado al restaurante");
            }
        } else {
            restaurante.gestionarPedidos(pedido);
            System.out.println("Pedido enviado al restaurante");
        }

        return pedido;
    }

    public void cancelarPedido(Pedido pedido) {
        if (pedido.getEstado() instanceof Entregado || pedido.getEstado() instanceof Cancelado) {
            System.out.println("No se puede cancelar este pedido.");
            return;
        }

        pedido.cancelar();
        System.out.println("Pedido cancelado.");
    }

    @Override
    public void run() {
        while (true) {
            for (Pedido p : pedidosProgramados) {
                if (!p.isActivado() && LocalTime.now().isAfter(p.getHoraProgramada())) {
                    System.out.println("Activando pedido programado de " + p.getCliente().getNombre());
                    restaurante.gestionarPedidos(p);
                    p.setActivado(true);
                }
            }

            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}