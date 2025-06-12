package producto;

import java.io.*;
import java.util.*;

public class AlergenoExtraDecorator extends ProductoDecorador {

    private String alergenoExtra;
    private double cargoExtra;

    public AlergenoExtraDecorator(IProducto componente, String alergenoExtra, double cargoExtra) {
        super(componente);
        this.alergenoExtra = alergenoExtra;
        this.cargoExtra = cargoExtra;
    }

    @Override
    public int getTiempoEstimado() {
        return 0;
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + cargoExtra;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " (Contiene: " + alergenoExtra + ")";
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public double modificarPrecio() {
        double precio = componente.getPrecio();
        precio += cargoExtra;
        return precio;
    }
}