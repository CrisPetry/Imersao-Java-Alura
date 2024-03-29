import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHTTP {

	public String buscaDados(String url) {
		try {
			URI adress = URI.create(url);
			var client = HttpClient.newHttpClient();
			var request = HttpRequest.newBuilder(adress).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String body = response.body();
			return body;
			
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}

	}
}
