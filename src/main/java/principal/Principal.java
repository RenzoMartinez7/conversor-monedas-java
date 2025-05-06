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
        int opcionMoneda, controlDoWhile = 0;

        System.out.println("""
                ¡Bienvenidos a la casa de cambios AluCash!
                ******************************************
                """);
        do {
            try{
                System.out.println("¿Qué moneda vas a cambiar?");
                consultaCambio.soutListaMonedas();

                opcionMoneda = sc.nextInt();
                switch (opcionMoneda){
                    case 1:
                        monedaOrigen = "USD"; break;
                    case 2:
                        monedaOrigen = "EUR"; break;
                    case 3:
                        monedaOrigen = "PEN"; break;
                    case 4:
                        monedaOrigen = "COP"; break;
                    case 5:
                        monedaOrigen = "ARS"; break;
                    case 6:
                        System.out.println("Ingresa el código de moneda que deseas cambiar (ej. JPY): ");
                        sc.nextLine();
                        monedaOrigen = sc.nextLine().toUpperCase().trim();
                        break;
                    case 7:
                        controlDoWhile = 7;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        sc.nextLine();
                        continue;
                }

                if (controlDoWhile == 7) {
                    break;
                }

                System.out.println("¿Cuánto deseas cambiar?");
                cantidadACambiar = sc.nextDouble();
                if(cantidadACambiar < 0){
                    System.out.println("La cantidad a cambiar no puede ser negativa.");
                    continue;
                }

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
                    case 6:
                        System.out.println("Ingresa el código de moneda que deseas cambiar (ej. JPY): ");
                        sc.nextLine();
                        monedaDestino = sc.nextLine().toUpperCase().trim();
                        break;
                    case 7:
                        controlDoWhile = 7;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        sc.nextLine();
                        continue;
                }

                if (controlDoWhile == 7) {
                    break;
                }

                var monedaCambio = consultaCambio.consultaCambioMoneda(monedaOrigen);

                // Verificando si la moneda de origen es válida
                var tasa = monedaCambio.conversion_rates().get(monedaDestino); // get(key) -> retorna el Valor

                if (tasa == null) {
                    System.out.println("No se encontró la moneda destino.");
                    return;
                }

                Cambio cambio = new Cambio(monedaOrigen, monedaDestino, cantidadACambiar, tasa);
                System.out.println(cambio);
            }catch (Exception e){
                System.out.println("Moneda no existente o cantidad a cambiar errónea. Intentalo de nuevo.");
                sc.nextLine();
            }
        }while (controlDoWhile != 7);
        sc.close();
    }
}
