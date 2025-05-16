package restaurante;

import cliente.Email;
import pedido.Estado;
import pedido.Pedido;

import java.io.*;
import java.util.*;

public class Chef extends Staff {

    private String idStaff;
    private String nombre;
    private String dni;
    private String especialidad;


    private boolean ocupado;

    private Pedido pedido;

    private List<Pedido> pedidosAsignados = new ArrayList<>();

    public Chef(String nombre, String dni, String especialidad) {
        idStaff = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.dni = dni;
        this.especialidad = especialidad;
        ocupado = false;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    public List<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
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
        pedido.setChefAsignado(this);
        this.pedido = pedido;
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

    @Override
    public String toString() {
        return "Chef{" +
                "idStaff='" + idStaff + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}