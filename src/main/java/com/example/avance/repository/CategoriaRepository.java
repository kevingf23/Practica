package com.example.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.avance.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository< Categoria, Integer>{
    
}
