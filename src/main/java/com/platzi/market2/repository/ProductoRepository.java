package com.platzi.market2.repository;

import com.platzi.market2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

}
