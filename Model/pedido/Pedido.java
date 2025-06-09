package pedido;

import cliente.Cliente;
import cliente.ICuponAplicable;
import pago.MetodoPago;
import producto.IProducto;
import restaurante.Administrativos;
import restaurante.Chef;
import restaurante.Mozo;
import restaurante.Restaurante;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Pedido {

    private String idPedido;

    private String numeroOrden;

    private Estado estado;

    private double total;

    private MetodoPago metodoPago;

    private List<IProducto> productos;

    private Mozo mozoAsignado;

    private Chef chefAsignado;

    private Administrativos adminAsignado;

    private ICuponAplicable cuponAplicable;

    private Cliente cliente;

    private String detalles;

    private LocalTime horaProgramada;

    private boolean esProgramado;

    private Restaurante restaurante;

    private boolean activado = false;

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {this.estado = estado;}

    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public List<IProducto> getProductos() {
        return productos;
    }

    public Mozo getMozoAsignado() {
        return mozoAsignado;
    }

    public void setMozoAsignado(Mozo mozoAsignado) {
        this.mozoAsignado = mozoAsignado;
    }

    public ICuponAplicable getCuponAplicable() {
        return cuponAplicable;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Chef getChefAsignado() {
        return chefAsignado;
    }

    public void setChefAsignado(Chef chefAsignado) {
        this.chefAsignado = chefAsignado;
    }

    public Administrativos getAdminAsignado() {
        return adminAsignado;
    }

    public void setAdminAsignado(Administrativos adminAsignado) {
        this.adminAsignado = adminAsignado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public boolean isEsProgramado() {
        return esProgramado;
    }

    public LocalTime getHoraProgramada() {
        return horaProgramada;
    }

    public Pedido(Estado estado, MetodoPago metodoPago, List<IProducto> productos, ICuponAplicable cupon, Cliente cliente, LocalTime horaProgramada, Restaurante restaurante) {
        this.idPedido = UUID.randomUUID().toString();
        this.numeroOrden = UUID.randomUUID().toString();
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.productos = productos;
        cuponAplicable = cupon;
        this.cliente = cliente;
        total = calcularTotal(productos);
        this.horaProgramada = horaProgramada;
        if (horaProgramada != null) {
            esProgramado = true;
        }
        this.restaurante = restaurante;
    }

    public double calcularTotal(List<IProducto> productos) {
        for (IProducto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public boolean cobrar() {
        Cobro cobro = new Cobro(total, metodoPago, productos, cuponAplicable);

        boolean exito = cobro.irAPagar(this, cliente.getPlataforma());

        return exito;
    }

    public void cancelar(){
        Pedido ultimoPedido = cliente.getHistorialPedidos().getLast();
        Cancelado cancelado = new Cancelado();
        ultimoPedido.setEstado(cancelado);
        ultimoPedido.getEstado().avanzarEstado(ultimoPedido);
    }
}