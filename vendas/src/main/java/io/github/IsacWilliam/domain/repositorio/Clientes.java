package io.github.IsacWilliam.domain.repositorio;

import io.github.IsacWilliam.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {
    //Consulta JPQL
    //@Query(value = " select c from Cliente c where c.nome like :nome ")

    //Consulta SQL NATIVA
    @Query(value = " select * from Cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome( @Param("nome") String nome);

    @Query(" delete from Cliente c where c.nome = :nome ")
    @Modifying
    void deleteBynome (String nome);

    boolean existsByNome(String nome);
}
