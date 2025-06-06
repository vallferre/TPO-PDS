package pedido;
import restaurante.Restaurante;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestorPedidosProgramados implements Runnable {

    private static final List<Pedido> pedidosProgramados = new ArrayList<>();
    private static Restaurante restaurante;

    public static void inicializar(Restaurante r) {
        restaurante = r;
        Thread hilo = new Thread(new GestorPedidosProgramados());
        hilo.setDaemon(true);
        hilo.start();
    }

    public static void agregarPedido(Pedido pedido) {
        pedidosProgramados.add(pedido);
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (Pedido p : new ArrayList<>(pedidosProgramados)) {
                    if (!p.isActivado() && LocalTime.now().isAfter(p.getHoraProgramada())) {
                        System.out.println("Activando pedido programado de " + p.getCliente().getNombre());
                        restaurante.gestionarPedidos(p);
                        p.setActivado(true);
                    }
                }
                Thread.sleep(30000); // revisar cada 30 segundos
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
