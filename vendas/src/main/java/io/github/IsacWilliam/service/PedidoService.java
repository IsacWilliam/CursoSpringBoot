package io.github.IsacWilliam.service;

import io.github.IsacWilliam.domain.entity.Pedido;
import io.github.IsacWilliam.domain.enums.StatusPedido;
import io.github.IsacWilliam.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
