package com.platzi.market2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
    private long idProducto;

    private String nombre;

    private int idCategoria;

    private double precioVenta;

    private int cantidadStock;

    private boolean estado;

    private CategoriaDto categoria;
}
