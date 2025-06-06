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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Pedido {

    private String idPedido;

    private String numeroOrden;

    private Estado estado;

    private float total;

    private MetodoPago metodoPago;

    private List<IProducto> productos;

    private Mozo mozoAsignado;

    private Chef chefAsignado;

    private Administrativos adminAsignado;

    private ICuponAplicable cuponAplicable;

    private Cliente cliente;

    private String detalles;

    private LocalDateTime horaProgramada;

    private boolean esProgramado;

    private Restaurante restaurante;

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {this.estado = estado;}

    public float getTotal() {
        return total;
    }

    public float setTotal(List<IProducto> productos) {
        for (IProducto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<IProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<IProducto> productos) {
        this.productos = productos;
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

    public void setCuponAplicable(ICuponAplicable cuponAplicable) {
        this.cuponAplicable = cuponAplicable;
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

    public String getNombreEstado() {
        return estado.getClass().getSimpleName();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Pedido(Estado estado, MetodoPago metodoPago, List<IProducto> productos, ICuponAplicable cupon, Cliente cliente, LocalDateTime horaProgramada, Restaurante restaurante) {
        this.idPedido = UUID.randomUUID().toString();
        this.numeroOrden = UUID.randomUUID().toString();
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.productos = productos;
        cuponAplicable = cupon;
        this.cliente = cliente;
        total = setTotal(productos);
        this.horaProgramada = horaProgramada;
        if (horaProgramada != null) {
            esProgramado = true;
        }
        this.restaurante = restaurante;
    }

    public boolean cobrar() {
        Cobro cobro = new Cobro(total, metodoPago, productos, cuponAplicable);

        boolean exito = cobro.irAPagar(cliente.getPlataforma());

        return exito;
    }

    public boolean debeActivarse() {
        if (esProgramado) {
            return true;
        }
        return false;
    }
}