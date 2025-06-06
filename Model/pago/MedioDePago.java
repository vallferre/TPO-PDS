package pago;

public interface MedioDePago {
    /**
     * @param monto 
     * @return
     */
    boolean cobrar(double monto);

}