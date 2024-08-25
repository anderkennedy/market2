package com.platzi.market2.cotroller;

import com.platzi.market2.dto.ProductoDto;
import com.platzi.market2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {
    @Autowired
    private ProductoService productoService;


    @CrossOrigin("origins = http://localhost:4200")
    @PostMapping("producto/guardar")
    public ProductoDto guardar(@RequestBody ProductoDto productoDto) {
        return productoService.guardar(productoDto);
    }

    @GetMapping("/categoria/{idCategoria}")
    public Optional<List<ProductoDto>> traerPorCategoria(@PathVariable("idCategoria") int idCategoria){
        return productoService.traerPorCategoria(idCategoria);
    }

    @GetMapping("producto/all")
    Page<ProductoDto> traerTodo(Pageable pageable){
        return productoService.traerTodo(pageable);
    }

    @GetMapping("producto/{id}")
    public Optional<ProductoDto> traerProducto(@PathVariable("id") int idProducto) {
        return productoService.traerProducto(idProducto);
    }

    @DeleteMapping("producto/eliminar/{id}")
    public boolean eliminar (@PathVariable("id") int idProducto) {
        return productoService.eliminar(idProducto);
    }
}
