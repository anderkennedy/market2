package com.platzi.market2.dto;

import com.platzi.market2.model.ComprasProducto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class CompraDto {
    private int idCompra;

    private String idCliente;

    private LocalDateTime fecha;

    private String medioPago;

    private String comentario;

    private String estado;

    private List<ComprasProductoDto> comprasProductos;
}
