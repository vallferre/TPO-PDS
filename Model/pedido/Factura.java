package pedido;

import pago.MetodoPago;
import producto.IProducto;
import producto.Producto;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Factura {

    private LocalDateTime fecha;

    private double monto;

    private MetodoPago metodoPago;

    private List<IProducto> detalles;

    public Factura(double monto, MetodoPago metodoPago, List<IProducto> detalles) {
        this.fecha = LocalDateTime.now();
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
    }

    public LocalDateTime getFechaEmision() {
        return fecha;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fecha = fechaEmision;
    }

    public void imprimirFactura() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaFormateada = fecha.format(formato);
        System.out.println("Factura " + fechaFormateada);
        System.out.println("Monto: " + monto);
        System.out.println("Metodo de pago: " + metodoPago.getClass().getSimpleName());
        System.out.println("Detalles: ");
        for (IProducto p : detalles) {
            System.out.println(p.getDescripcion());
        }
        System.out.println("-----------------------------------");
    }

}