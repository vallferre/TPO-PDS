package restaurante;

import cliente.Email;
import pedido.Estado;
import pedido.Pedido;

import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Chef extends Staff {

    private String especialidad;

    public Chef(String nombre, String dni, String especialidad) {
        idStaff = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.dni = dni;
        this.especialidad = especialidad;
        ocupado = false;
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
        pedido.setChefAsignado(this);
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

        // Verificamos si el pedido es programado
        if (pedido.isEsProgramado()) {
            LocalTime ahora = LocalTime.now();
            LocalTime horaProgramada = pedido.getHoraProgramada();

            if (ahora.isBefore(horaProgramada)) {
                System.out.println("No se puede avanzar el estado del pedido programado hasta su hora (" + horaProgramada + ").");
                return;
            }
        }

        // Si pasó la hora o no es programado, se permite actualizar
        pedido.setEstado(nuevoEstado);
        pedido.getEstado().avanzarEstado(pedido);
    }


    @Override
    public String toString() {
        return "Chef{" +
                "idStaff='" + idStaff + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", ocupado=" + ocupado +
                ", pedido=" + pedido +
                ", pedidosAsignados=" + pedidosAsignados +
                '}';
    }
}