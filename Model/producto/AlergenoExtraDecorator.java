package producto;

import java.io.*;
import java.util.*;

public class AlergenoExtraDecorator extends ProductoDecorador {

    private String alergenoExtra;
    private float cargoExtra;

    public AlergenoExtraDecorator(IProducto componente, String alergenoExtra, float cargoExtra) {
        super(componente);
        this.alergenoExtra = alergenoExtra;
        this.cargoExtra = cargoExtra;
    }

    @Override
    public int getTiempoEstimado() {
        return 0;
    }

    @Override
    public float getPrecio() {
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
    public void modificarPrecio() {
        // Si querés modificar dinámicamente el precio del cargo extra
        this.cargoExtra *= 1.1f; // Ejemplo: aumenta un 10%
    }
}