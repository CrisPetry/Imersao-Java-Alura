import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) throws Exception {

		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/MostPopularTVs.json";

		URI adress = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(adress).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		var parser = new JSONParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

		var generateFigures = new GenerateFigures();

		for (Map<String, String> filme : listaDeFilmes) {

			String urlImg = filme.get("image");
			String titulo = filme.get("title");

			InputStream inputStream = new URL(urlImg).openStream();
			String nomeArquivo = titulo + ".png";

			generateFigures.create(inputStream, nomeArquivo);

			System.out.println(titulo + "\n");

			inputStream.close();

		}

	}
}
