package pedido;

public class ApiRappi implements ApiEnvios{
    @Override
    public int calcularTiempoEntrega() {
        int tiempoBase = 25;
        int variacionAleatoria = (int) (Math.random() * 16);
        return tiempoBase + variacionAleatoria;
    }
}
