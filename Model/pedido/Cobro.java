package pedido;

import cliente.CuponDescuento;
import cliente.ICuponAplicable;
import pago.MetodoPago;
import producto.IProducto;
import producto.Producto;

import java.io.*;
import java.util.*;

public class Cobro {

    private float monto;

    private MetodoPago metodoPago;

    private ICuponAplicable cupon;

    private List<IProducto> detalles;

    public Cobro(float monto, MetodoPago metodoPago, List<IProducto> detalles, ICuponAplicable cupon) {
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
        this.cupon = cupon;
    }

    public boolean irAPagar() {
        if (cupon != null) {
            monto = aplicarCupon();
        }

        boolean pagoExitoso = metodoPago.procesarPago(monto);

        if (pagoExitoso) {
            generarFactura();
        }

        return pagoExitoso;
    }

    public float aplicarCupon() {
        float nuevoTotal = cupon.aplicarDescuento(monto);
        return nuevoTotal;
    }

    public void generarFactura() {
        Factura factura = new Factura(monto, metodoPago, detalles, cupon);
        factura.imprimirFactura();
    }

}