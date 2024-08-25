package com.platzi.market2.cotroller;

import com.platzi.market2.dto.CompraDto;
import com.platzi.market2.dto.ProductoDto;
import com.platzi.market2.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompraController {
    @Autowired
    CompraService compraService;

    @GetMapping("compra/all")
    Page<CompraDto> traerTodo(Pageable pageable){
        return compraService.traerTodo(pageable);
    }

    @GetMapping("/cliente/{idCliente}")
    public Optional<List<CompraDto>> traerPorCliente(@PathVariable("idCliente") String idCliente){
        return compraService.traerPorCliente(idCliente);
    }

    @PostMapping("compra/guardar")
    public CompraDto guardar(@RequestBody CompraDto compraDto) {
        return compraService.guardar(compraDto);
    }


}
