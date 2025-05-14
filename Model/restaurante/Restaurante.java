package restaurante;

import pedido.Pedido;

import java.io.*;
import java.util.*;

public class Restaurante {

    private int idRestaurante;

    private String nombre;

    private String direccion;

    private List<Staff> staff;

    public Restaurante(int idRestaurante, String nombre, String direccion, List<Staff> staff) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.direccion = direccion;
        this.staff = staff;
    }

    public void gestionarPedidos(Pedido pedido) {
        for (Staff miembro : staff) {
            if (miembro instanceof Mozo) {
                Mozo mozo = (Mozo) miembro;
                if (mozo.estaLibre()){
                    mozo.asignarPedido(pedido);
                }
            }
        }

    }
}