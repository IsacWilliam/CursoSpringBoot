package io.github.IsacWilliam.service.impl;

import io.github.IsacWilliam.domain.repository.Pedidos;
import io.github.IsacWilliam.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
