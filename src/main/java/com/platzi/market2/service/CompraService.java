package com.platzi.market2.service;

import com.platzi.market2.dto.CompraDto;
import com.platzi.market2.mapper.CompraMapper;
import com.platzi.market2.model.Compra;
import com.platzi.market2.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    CompraMapper mapper;

    @Autowired
    CompraRepository compraRepository;

    public Page<CompraDto> traerTodo (Pageable pageable){
        Page<Compra> compras = compraRepository.findAll(pageable);
        return new PageImpl<>(mapper.toCompraDtos(compras.getContent()),pageable,compras.getTotalElements());
    }

    public Optional<List<CompraDto>> traerPorCliente(String idCliente) {
        return compraRepository.findByIdCliente(idCliente).map(compras -> mapper.toCompraDtos(compras));

    }

    public CompraDto guardar(CompraDto compraDto) {

        Compra compra = mapper.toCompra(compraDto);
        compra.getComprasProductos().forEach(comprasProducto -> {
            if(comprasProducto.getCantidad()< 3) {
                ;
            }else {
                ;
            }

            comprasProducto.setCompra(compra);
        });

        return mapper.toCompraDto(compraRepository.save(compra));

    }
}
