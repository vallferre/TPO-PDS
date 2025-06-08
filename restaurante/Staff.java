package restaurante;

import java.io.*;
import java.util.*;
import pedido.Estado;
import pedido.Pedido;

public abstract class Staff {

    protected String idStaff;

    protected String nombre;

    protected String dni;

    protected boolean ocupado;

    protected Pedido pedido;

    protected List<Pedido> pedidosAsignados;

    public Staff() {
    }

    public abstract void actualizarEstado(Estado estado);

    public abstract void asignarPedido(Pedido pedido);

    public abstract boolean estaLibre();

    public abstract void liberar(Pedido pedido);

    @Override
    public String toString() {
        return "Staff{" +
                "idStaff='" + idStaff + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}