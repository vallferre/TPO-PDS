package pedido;

import cliente.CuponDescuento;
import cliente.ICuponAplicable;
import pago.MetodoPago;
import plataforma.Plataforma;
import plataforma.Totem;
import producto.IProducto;
import producto.Producto;

import java.io.*;
import java.util.*;

public class Cobro {

    private double monto;

    private MetodoPago metodoPago;

    private ICuponAplicable cupon;

    private List<IProducto> detalles;

    public Cobro(float monto, MetodoPago metodoPago, List<IProducto> detalles, ICuponAplicable cupon) {
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
        this.cupon = cupon;
    }

    public boolean irAPagar(Plataforma plataforma) {
        if (cupon != null && plataforma.getClass() != Totem.class) {
            monto = aplicarCupon();
        }

        boolean pagoExitoso = metodoPago.procesarPago(monto);

        return pagoExitoso;
    }

    public double aplicarCupon() {
        double nuevoTotal = cupon.aplicarDescuento(monto);
        return nuevoTotal;
    }

}