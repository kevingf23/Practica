package com.example.avanceunidad3.repository;

import com.example.avanceunidad3.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
