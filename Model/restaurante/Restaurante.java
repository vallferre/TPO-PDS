package restaurante;

import cliente.Cliente;
import pedido.Pedido;
import pedido.Pendiente;

import java.io.*;
import java.util.*;

public class Restaurante {

    private int idRestaurante;

    private String nombre;

    private String direccion;

    private List<Staff> staff;

    private List<Pedido> pedidos = new ArrayList();

    public Restaurante(int idRestaurante, String nombre, String direccion, List<Staff> staff) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.direccion = direccion;
        this.staff = staff;
    }

    public void gestionarPedidos(Pedido pedido) {
        boolean mozoAsignado = false;
        boolean adminAsignado = false;
        boolean chefAsignado = false;

        for (Staff miembro : staff) {
            if (!mozoAsignado && miembro instanceof Mozo mozo && mozo.estaLibre()) {
                mozo.asignarPedido(pedido);
                mozoAsignado = true;
            } else if (!adminAsignado && miembro instanceof Administrativos admin && admin.estaLibre()) {
                admin.asignarPedido(pedido);
                adminAsignado = true;
            } else if (!chefAsignado && miembro instanceof Chef chef && chef.estaLibre()) {
                chef.asignarPedido(pedido);
                chefAsignado = true;
            }

            if (mozoAsignado && adminAsignado && chefAsignado) {
                break;
            }
        }
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "idRestaurante=" + idRestaurante +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", staff=" + staff +
                ", pedidos=" + pedidos +
                '}';
    }
}