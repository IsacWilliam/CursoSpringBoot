package io.github.IsacWilliam.localizacao.domain.repository;

import io.github.IsacWilliam.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //busca pelo nome correto
    List<Cidade> findByNome(String nome);

    //busca pelo nome like
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome);

    /*busca pelo nome começando com aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);*/

    //busca pelo nome terminando com aquele pedaço
    List<Cidade> findByNomeEndingWith(String nome);

    //busca pelo nome contendo aquele pedaço
    List<Cidade> findByNomeContaining(String nome);

    //busca por quantidade de habitantes
    List<Cidade> findByHabitantes(Long habitantes);

    //busca cidade por número de habitantes MENOR QUE
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    //busca cidade por número de habitantes MAIOR QUE
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    //busca cidade por número de habitantes MAIOR OU IGUAL QUE
    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes);

    //junção de querys
    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);

}
