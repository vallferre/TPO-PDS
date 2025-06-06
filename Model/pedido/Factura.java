package pedido;

import cliente.Cliente;
import cliente.ICuponAplicable;
import pago.MetodoPago;
import producto.IProducto;
import producto.Producto;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Factura {

    private Cliente cliente;

    private LocalDateTime fecha;

    private double monto;

    private MetodoPago metodoPago;

    private List<IProducto> detalles;

    private ICuponAplicable cupon;

    public Factura(Cliente cliente, double monto, MetodoPago metodoPago, List<IProducto> detalles, ICuponAplicable cupon) {
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
        this.cupon = cupon;
    }

    public LocalDateTime getFechaEmision() {
        return fecha;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fecha = fechaEmision;
    }

    public void imprimirFactura() {
        System.out.println("-----------------------------------");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaFormateada = fecha.format(formato);
        System.out.println("Factura " + fechaFormateada);
        System.out.println(cliente.getNombre());
        if (cupon != null){
            System.out.println("Descuento: " + cupon.getPorcentajeDto() + "%");
        }
        System.out.println("Monto: " + Math.round(monto * 100.0)/100.0);
        System.out.println("Metodo de pago: " + metodoPago.getClass().getSimpleName());
        System.out.println("Detalles: ");
        for (IProducto p : detalles) {
            System.out.println(p.getDescripcion());
        }
        System.out.println("-----------------------------------");
    }

}