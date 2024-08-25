package com.platzi.market2.mapper;


import com.platzi.market2.dto.ProductoDto;
import com.platzi.market2.model.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface ProductoMapper {

    ProductoDto toProductoDto(Producto producto);
    List<ProductoDto> toProductoDtos(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProdcuto (ProductoDto productoDto);
}
