package principal;

import domain.Cambio;
import domain.ConsultaCambio;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConsultaCambio consultaCambio = new ConsultaCambio();
        String monedaOrigen = "", monedaDestino = "";
        double cantidadACambiar;

        System.out.println("""
                ¡Bienvenidos a la casa de cambios AluCash!
                """);

        try{
            System.out.println("¿Qué moneda vas a cambiar?");
            consultaCambio.soutListaMonedas();
            int opcionMoneda = sc.nextInt();
            switch (opcionMoneda){
                case 1:
                    monedaOrigen = "USD";
                    break;
                case 2:
                    monedaOrigen = "EUR";
                    break;
                case 3:
                    monedaOrigen = "PEN";
                    break;
                case 4:
                    monedaOrigen = "COP";
                    break;
                case 5:
                    monedaOrigen = "ARS";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.println("¿Cuánto deseas cambiar?");
            cantidadACambiar = sc.nextDouble();

            System.out.println("¿Qué moneda deseas recibir?");
            consultaCambio.soutListaMonedas();
            opcionMoneda = sc.nextInt();
            switch (opcionMoneda){
                case 1:
                    monedaDestino = "USD";
                    break;
                case 2:
                    monedaDestino = "EUR";
                    break;
                case 3:
                    monedaDestino = "PEN";
                    break;
                case 4:
                    monedaDestino = "COP";
                    break;
                case 5:
                    monedaDestino = "ARS";
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            var monedaCambio = consultaCambio.consultaCambioMoneda(monedaOrigen);
            var tasa = monedaCambio.conversion_rates().get(monedaDestino);

            if (tasa == null) {
                System.out.println("No se encontró la moneda destino.");
                return;
            }

            Cambio cambio = new Cambio(monedaOrigen, monedaDestino, cantidadACambiar, tasa);
            System.out.println(cambio);
        }catch (Exception e){
            System.out.println("No encontré esa moneda.");
        }

    }
}
