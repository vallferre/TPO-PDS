package pedido;

import notificacion.INotificable;

import java.io.*;
import java.util.*;

public class Enviado extends Estado {

    private ApiEnvios api;

    public Enviado() {
        this.api = new ApiRappi();
    }

    @Override
    public int calcularTiempo(Pedido pedido) {
        return api.calcularTiempoEntrega();
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.getCliente().recibirNotificacion("Tu pedido ha sido enviado. ", pedido, pedido.getCliente(), pedido.getMozoAsignado());
        System.out.println("Tiempo estimado: " + calcularTiempo(pedido) + " minutos.");
    }

}