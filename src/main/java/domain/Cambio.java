package domain;

public class Cambio {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;
    private double resultado;

    public Cambio(String monedaOrigen, String monedaDestino, double cantidad, double tasaCambio) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.resultado = cantidad * tasaCambio;
    }

    @Override
    public String toString() {
        return """
                Cambiaste %.2f %s y recibiste %.2f %s""".formatted(cantidad, monedaOrigen, resultado, monedaDestino);
    }
}
