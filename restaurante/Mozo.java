package restaurante;

import cliente.Cliente;
import cliente.Email;
import notificacion.INotificable;
import pedido.Estado;
import pedido.Pedido;

import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Mozo extends Staff {

    private Email email;

    private INotificable canal;

    public Mozo(String nombre, String dni, Email email, INotificable canal) {
        idStaff = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.ocupado = false;
        this.canal = canal;
        pedidosAsignados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean estaLibre() {
        return pedidosAsignados.isEmpty();
    }

    public void asignarPedido(Pedido pedido) {
        ocupado = true;
        pedidosAsignados.add(pedido);
        pedido.setMozoAsignado(this);
        this.pedido = pedido;
    }

    @Override
    public void liberar(Pedido pedido) {
        if (this.pedido != null){
            LocalTime ahora = LocalTime.now();
            LocalTime horaProgramada = pedido.getHoraProgramada();
            if (pedido.isEsProgramado()){
                if (ahora.isBefore(horaProgramada)){
                    System.out.println("No tiene staff programado hasta su hora (" + horaProgramada + ").");
                    return;
                }
            }
            ocupado = false;
            pedidosAsignados.remove(pedido);
            this.pedido = null;
        }
    }

    @Override
    public void actualizarEstado(Estado nuevoEstado) {
        if (this.pedido == null) {
            System.out.println("No hay pedido asignado a este " + this.getClass().getSimpleName());
            return;
        }

        if (pedido.isEsProgramado()) {
            LocalTime ahora = LocalTime.now();
            LocalTime horaProgramada = pedido.getHoraProgramada();

            if (ahora.isBefore(horaProgramada)) {
                System.out.println("No se puede avanzar el estado del pedido programado hasta su hora (" + horaProgramada + ").");
                return;
            }
        }

        pedido.setEstado(nuevoEstado);
        pedido.getEstado().avanzarEstado(pedido);
    }


    public void recibirNotificacion(String mensaje, Pedido pedido, Cliente cliente, Staff staff) {
        canal.notificar(mensaje, pedido, cliente, staff);
    }

    @Override
    public String toString() {
        return "Mozo{" +
                "idStaff='" + idStaff + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email=" + email +
                ", ocupado=" + ocupado +
                ", pedido=" + pedido +
                ", canal=" + canal +
                ", pedidosAsignados=" + pedidosAsignados +
                '}';
    }
}