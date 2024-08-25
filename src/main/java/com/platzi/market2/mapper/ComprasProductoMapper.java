package com.platzi.market2.mapper;

import com.platzi.market2.dto.ComprasProductoDto;
import com.platzi.market2.model.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface ComprasProductoMapper {

    @Mapping(source = "id.idProducto", target = "idProducto")
    ComprasProductoDto toComprasProductoDto (ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    ComprasProducto toComprasProducto (ComprasProductoDto comprasProductoDto);
}
