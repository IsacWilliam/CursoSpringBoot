package io.github.IsacWilliam.domain.repository;

import io.github.IsacWilliam.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
