package cliente;

import java.util.*;

/**
 * 
 */
public class CuponDescuento implements ICuponAplicable {

    /**
     * Default constructor
     */
    public CuponDescuento() {
    }

    /**
     * 
     */
    private int codigo;

    /**
     * 
     */
    public int porcentajeDescuento;

    /**
     * 
     */
    private Date fechaExpiracion;


    /**
     * @return
     */
    public boolean validar() {
        // TODO implement here
        return false;
    }


    /**
     * @param total
     */
    @Override
    public void aplicarDescuento(double total){};

}