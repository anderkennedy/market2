package com.platzi.market2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ComprasProductoDto {
    private int idProducto;

    private int cantidad;

    private double total;

    private boolean estado;
}
