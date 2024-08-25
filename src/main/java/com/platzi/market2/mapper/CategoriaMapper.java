package com.platzi.market2.mapper;

import com.platzi.market2.dto.CategoriaDto;
import com.platzi.market2.model.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDto toCategoriaDto (Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(CategoriaDto categoriaDto);
}
