package io.github.IsacWilliam.domain.repository;

import io.github.IsacWilliam.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
