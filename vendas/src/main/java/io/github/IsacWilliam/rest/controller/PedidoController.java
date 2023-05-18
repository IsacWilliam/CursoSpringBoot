package io.github.IsacWilliam.rest.controller;

import io.github.IsacWilliam.domain.entity.Pedido;
import io.github.IsacWilliam.rest.dto.PedidoDTO;
import io.github.IsacWilliam.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save (@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }

}
