package com.example.avanceunidad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.avanceunidad3.model.Salida;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Integer> {
    
}
