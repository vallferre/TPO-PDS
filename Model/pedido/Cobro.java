package pedido;

import cliente.CuponDescuento;
import cliente.ICuponAplicable;
import pago.MetodoPago;
import producto.IProducto;
import producto.Producto;

import java.io.*;
import java.util.*;

public class Cobro {

    private Date fecha;

    private float monto;

    private MetodoPago metodoPago;

    private ICuponAplicable cupon;

    private List<IProducto> detalles;

    public Cobro(Date fecha, float monto, MetodoPago metodoPago, List<IProducto> detalles, ICuponAplicable cupon) {
        this.fecha = fecha;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
        this.cupon = cupon;
    }

    public boolean irAPagar() {
        if (cupon != null) {
            aplicarCupon();
        }

        boolean pagoExitoso = metodoPago.procesarPago(monto);

        if (pagoExitoso) {
            generarFactura();
        }

        return pagoExitoso;
    }

    public void aplicarCupon() {
        cupon.aplicarDescuento(monto);
    }

    public void generarFactura() {
        Factura factura = new Factura(fecha, monto, metodoPago, detalles);
        factura.imprimirFactura();
    }

}