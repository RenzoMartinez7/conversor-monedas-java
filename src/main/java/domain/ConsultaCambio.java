package domain;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {
    public Moneda consultaCambioMoneda(String monedaOrigen){

        // Asignando la API Key -> Esto se encuentra en la página de la API: https://app.exchangerate-api.com/
        String api_key = "dio421658fe7504a62bea38b"; // API Key de ejemplo -> reemplazar por la tuya
        // Definiendo la URI
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + api_key + "/latest/" + monedaOrigen);

        // Creando el cliente HTTP -> Instancia el cliente HTTP de manera predefinida
        HttpClient client = HttpClient.newHttpClient();

        // Creando la petición HTTP -> Se define el método de la petición y la URI
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try{
            // Enviando la petición y obteniendo la respuesta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Deserializando la respuesta JSON a un objeto de tipo Moneda
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda.");
        }
    }

    public void soutListaMonedas(){
        System.out.println("""
                Escoge una moneda de la lista:
                1) USD
                2) EUR
                3) PEN
                4) COP
                5) ARS
                6) Otra moneda
                7) Salir
                """);
    }
}
