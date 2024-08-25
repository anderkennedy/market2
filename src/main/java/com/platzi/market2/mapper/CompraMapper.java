package com.platzi.market2.mapper;

import com.platzi.market2.dto.CompraDto;
import com.platzi.market2.model.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ComprasProductoMapper.class})
public interface CompraMapper {

    CompraDto toCompraDto (Compra compra);
    List<CompraDto> toCompraDtos (List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(CompraDto compraDto);

}
