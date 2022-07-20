import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {

		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD-JamesWebbSpaceTelescope.json";

		var http = new ClienteHTTP();
		String json = http.buscaDados(url);
		ExtratorDeConteudoNasa extractNasa = new ExtratorDeConteudoNasa();
		List<Conteudo> conteudos = extractNasa.extractContent(json);

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
