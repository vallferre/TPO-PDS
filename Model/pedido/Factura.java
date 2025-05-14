package pedido;

import pago.MetodoPago;
import producto.IProducto;
import producto.Producto;

import java.io.*;
import java.util.*;

public class Factura {

    private Date fecha;

    private double monto;

    private MetodoPago metodoPago;

    private List<IProducto> detalles;

    public Factura(Date fecha, double monto, MetodoPago metodoPago, List<IProducto> detalles) {
        this.fecha = fecha;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
    }

    public void imprimirFactura() {
        System.out.println("Factura " + fecha);
        System.out.println("Monto: " + monto);
        System.out.println("Metodo de pago: " + metodoPago);
        System.out.println("Detalles: ");
        for (IProducto p : detalles) {
            System.out.println(p);
        }
    }

}