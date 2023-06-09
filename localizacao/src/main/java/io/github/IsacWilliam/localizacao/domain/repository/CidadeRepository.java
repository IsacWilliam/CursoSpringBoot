package io.github.IsacWilliam.localizacao.domain.repository;

import io.github.IsacWilliam.localizacao.domain.entity.Cidade;
import io.github.IsacWilliam.localizacao.domain.repository.projections.CidadeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    @Query(nativeQuery = true, value = "select c.id_cidade as id, c.nome from tb_cidade as c where c.nome =:nome")
    List<CidadeProjection> findByNomeSqlNativo(@Param("nome") String nome);

    //busca pelo nome correto
    List<Cidade> findByNome(String nome);

    //busca pelo nome like ordenado
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    //busca pelo nome like pginado
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);

    //busca pelo nome começando com aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

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
