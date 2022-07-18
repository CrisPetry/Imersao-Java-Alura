import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) throws Exception {

		// fazer conexao HTTP e buscar os top 250 filmes
		String url = "https://api.mocki.io/v2/549a5d8b";
		URI adress = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(adress).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		// extrair só os dados que interessam (titulo, poster, classificacao)
		JSONParser parser = new JSONParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

		// exibir e manipular os dados
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.printf("titulo: %s%n poster: %s%n rating: %s%n%n", filme.get("title"), filme.get("image"),
					filme.get("imDbRating"));
		}

	}
}
