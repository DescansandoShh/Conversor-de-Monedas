import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TasaDeCambio {
    public static double ObtenerTasaDeCambio(String monedaOrigen, String monedaFinal) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/153fd794bd4a09504b23f4c2/latest/" + monedaOrigen);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);

        return moneda.conversion_rates().get(monedaFinal);

    }
}
