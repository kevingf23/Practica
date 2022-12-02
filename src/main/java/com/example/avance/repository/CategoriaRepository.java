package com.example.avanceunidad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.avanceunidad3.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository< Categoria, Integer>{
    
}
