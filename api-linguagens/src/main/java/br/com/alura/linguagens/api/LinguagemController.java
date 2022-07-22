package br.com.alura.linguagens.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

	@Autowired
	private LinguagemRepository repository;

	@GetMapping("/linguagens/findLinguagens")
	public List<Linguagem> findLinguagens() {
		List<Linguagem> linguagens = repository.findAll();
		return linguagens;
	}

	@PostMapping("/linguagens")
	public Linguagem postLinguagens(@RequestBody Linguagem linguagem) {
		repository.save(linguagem);
		return linguagem;
	}

	@DeleteMapping("/linguagens/{id}")
	public void deleteLinguagens(@PathVariable Linguagem id) {
		repository.delete(id);
	}

}
