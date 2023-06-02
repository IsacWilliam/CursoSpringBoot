package io.github.IsacWilliam.localizacao.domain.repository;

import io.github.IsacWilliam.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
