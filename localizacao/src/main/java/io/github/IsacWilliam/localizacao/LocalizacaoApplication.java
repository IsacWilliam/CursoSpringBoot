package io.github.IsacWilliam.localizacao;

import io.github.IsacWilliam.localizacao.domain.entity.Cidade;
import io.github.IsacWilliam.localizacao.domain.repository.CidadeRepository;
import io.github.IsacWilliam.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService service;

	@Override
	public void run(String... args) throws Exception {
		service.listarCidadesPorNome();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
