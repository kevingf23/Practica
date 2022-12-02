package com.example.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.avance.model.Proveedores;
@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer>{
    
}
