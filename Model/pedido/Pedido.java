package pedido;

import cliente.Cliente;
import cliente.ICuponAplicable;
import pago.MetodoPago;
import producto.IProducto;
import restaurante.Mozo;
import restaurante.Restaurante;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Pedido {

    private String idPedido;

    private String numeroOrden;

    private Estado estado;

    private float total;

    private MetodoPago metodoPago;

    private List<IProducto> productos;

    private Mozo mozoAsignado;

    private ICuponAplicable cuponAplicable;

    private Cliente cliente;

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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getTotal() {
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido(Estado estado,  MetodoPago metodoPago, List<IProducto> productos, ICuponAplicable cupon, Cliente cliente) {
        this.idPedido = UUID.randomUUID().toString();
        this.numeroOrden = UUID.randomUUID().toString();
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.productos = productos;
        cuponAplicable = cupon;
        this.cliente = cliente;
        total = setTotal(productos);
    }

    public void asignarMozo(Mozo mozo){
        mozoAsignado = mozo;
    }

    public boolean cobrar() {
        LocalDate fechaActual = LocalDate.now();
        Date fechaHoy = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Cobro cobro = new Cobro(fechaHoy, total, metodoPago, productos, cuponAplicable);

        boolean exito = cobro.irAPagar();

        return exito;
    }

    public String getNombreEstado() {
        return estado.getClass().getSimpleName();
    }

}