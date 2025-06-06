package cliente;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class CuponDescuento implements ICuponAplicable {

    private String codigo;

    public int porcentajeDescuento;

    private Date fechaExpiracion;

    private LocalDate fechaActual = LocalDate.now();

    public CuponDescuento(String codigo, int porcentajeDescuento, Date fechaExpiracion) {
        this.codigo = codigo;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public double aplicarDescuento(double total){
        Date fechaHoy = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (fechaHoy.before(fechaExpiracion)){
            double descuento = total * ((float) porcentajeDescuento /100);
            total = total-descuento;
        }
        return total;
    };

    @Override
    public int getPorcentajeDto() {
        return porcentajeDescuento;
    }
}