import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {

		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD-JamesWebbSpaceTelescope.json";
//		String url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";

		var http = new ClienteHTTP();
		String json = http.buscaDados(url);
		ExtratorDeConteudo extract = new ExtratorDeConteudoNasa();
		List<Conteudo> conteudos = extract.extractContent(json);

		var generate = new GenerateFigures();

		for (int i = 0; i < 3; i++) {
			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.getUrlImg()).openStream();
			String fileName = "saida/" + conteudo.getTitulo() + ".png";

			generate.create(inputStream, fileName);

			System.out.println(conteudo.getTitulo());
		}

	}
}
