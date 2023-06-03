package io.github.IsacWilliam.localizacao.domain.repository;

import io.github.IsacWilliam.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //busca pelo nome correto
    List<Cidade> findByNome(String nome);

    //busca pelo nome começando com aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    //busca pelo nome terminando com aquele pedaço
    List<Cidade> findByNomeEndingWith(String nome);

    //busca pelo nome contendo aquele pedaço
    List<Cidade> findByNomeContaining(String nome);

    //busca por quantidade de habitantes
    List<Cidade> findByHabitantes(Long habitantes);
}
