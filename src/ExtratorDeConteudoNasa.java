import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {

	public List<Conteudo> extractContent(String json) {

		var parser = new JSONParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
		List<Conteudo> conteudos = new ArrayList<>();

		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String urlImg = atributos.get("url");
			var conteudo = new Conteudo(titulo, urlImg);

			conteudos.add(conteudo);
		}
		return conteudos;

	}
}
