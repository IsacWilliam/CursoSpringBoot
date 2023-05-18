package io.github.IsacWilliam.service;

import io.github.IsacWilliam.domain.entity.Pedido;
import io.github.IsacWilliam.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
