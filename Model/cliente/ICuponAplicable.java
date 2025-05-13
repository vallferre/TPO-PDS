package cliente;

import pedido.Cobro;

/**
 * 
 */
public interface ICuponAplicable {


    /**
     * @param total
     */
    public abstract void aplicarDescuento(double total);

}