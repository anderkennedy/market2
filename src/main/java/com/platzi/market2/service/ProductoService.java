package com.platzi.market2.service;

import com.platzi.market2.dto.ProductoDto;
import com.platzi.market2.mapper.ProductoMapper;
import com.platzi.market2.model.Producto;
import com.platzi.market2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper mapper;

    public ProductoDto guardar(ProductoDto productoDto) {
        Producto producto = mapper.toProdcuto(productoDto);
        return mapper.toProductoDto(productoRepository.save(producto));
    }

    public Optional<List<ProductoDto>> traerPorCategoria(int idCategoria){
        List<Producto> productos = productoRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.of(mapper.toProductoDtos(productos));
    }

    public Page<ProductoDto> traerTodo (Pageable pageable){
        Page<Producto> productos = productoRepository.findAll(pageable);
        return new PageImpl<>(mapper.toProductoDtos(productos.getContent()),pageable,productos.getTotalElements());
    }

    public Optional<ProductoDto> traerProducto (int idProducto) {
        Optional<Producto> producto = productoRepository.findById((long)idProducto);
        Optional<ProductoDto> productoDto = producto.map(pro -> mapper.toProductoDto(pro));
        return productoDto;
//        return productoRepository.findById((long)idProducto).map(producto -> mapper.toProductoDto(producto));
    }

    public boolean eliminar (int idProducto) {
        if (traerProducto(idProducto).isPresent()) {
            productoRepository.deleteById((long)idProducto);
            return true;
        } else {
            return false;
        }
    }
}
