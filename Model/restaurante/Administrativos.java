package restaurante;

import cliente.Email;
import pedido.Estado;
import pedido.Pedido;

import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Administrativos extends Staff {

    private String idStaff;
    private String nombre;
    private String dni;
    private Email email;

    private boolean ocupado;

    private Pedido pedido;

    private List<Pedido> pedidosAsignados = new ArrayList<>();

    public Administrativos(String nombre, String dni, Email email) {
        idStaff = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.dni = dni;
        this.ocupado = false;
        this.pedido = null;
        this.email = email;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setPedidosAsignados(List<Pedido> pedidosAsignados) {
        this.pedidosAsignados = pedidosAsignados;
    }

    public boolean estaLibre() {
        return pedidosAsignados.isEmpty();
    }

    public void asignarPedido(Pedido pedido) {
        ocupado = true;
        pedidosAsignados.add(pedido);
        pedido.setAdminAsignado(this);
        this.pedido = pedido;
    }

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
        return "Administrativos{" +
                "idStaff='" + idStaff + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email=" + email +
                ", ocupado=" + ocupado +
                ", pedido=" + pedido +
                ", pedidosAsignados=" + pedidosAsignados +
                '}';
    }
}