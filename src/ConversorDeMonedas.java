import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMonedas {

    public Moneda convierteMonedas(String baseCode, String targetCode, double importe) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/64782fcc23380d41733a08f8/pair/"
                + baseCode + "/" + targetCode + "/" + importe);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Si quieres, puedes imprimir el JSON completo para depuración
            // System.out.println(response.body());

            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("No es posible realizar la conversión. " + e.getMessage());
        }
    }
}
