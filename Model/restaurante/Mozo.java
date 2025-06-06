package restaurante;

import cliente.Cliente;
import cliente.Email;
import notificacion.INotificable;
import pedido.Estado;
import pedido.Pedido;

import java.io.*;
import java.util.*;

public class Mozo extends Staff {

    private String idStaff;
    private String nombre;
    private String dni;
    private Email email;

    private boolean ocupado;

    private Pedido pedido;

    private INotificable canal;

    private List<Pedido> pedidosAsignados = new ArrayList<>();

    public Mozo(String nombre, String dni, Email email, INotificable canal) {
        idStaff = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.ocupado = false;
        this.canal = canal;
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

    public INotificable getCanal() {
        return canal;
    }

    public void setCanal(INotificable canal) {
        this.canal = canal;
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
        pedido.setMozoAsignado(this);
        this.pedido = pedido;
        pedido.getEstado().avanzarEstado(pedido);
    }

    public void liberar(Pedido pedido) {
        ocupado = false;
        pedidosAsignados.remove(pedido);
        this.pedido = null;
    }
    @Override
    public void actualizarEstado(Estado estado) {
        pedido.getEstado().avanzarEstado(pedido);
    }

    public void recibirNotificacion(String mensaje, Pedido pedido, Cliente cliente, Staff staff) {
        canal.notificar(mensaje, pedido, cliente, staff);
    }

    public void getPedidosAsignados() {
        for (Pedido pedido : pedidosAsignados) {
            System.out.println(pedido.getNombreEstado());
        }
    }

    @Override
    public String toString() {
        return "Mozo{" +
                "idStaff='" + idStaff + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email=" + email +
                '}';
    }
}