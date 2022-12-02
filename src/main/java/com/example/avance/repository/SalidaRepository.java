package com.example.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.avance.model.Salida;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Integer> {
    
}
