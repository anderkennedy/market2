package com.platzi.market2.repository;

import com.platzi.market2.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
