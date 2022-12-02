package com.example.avance.repository;

import com.example.avance.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuariosRepository extends JpaRepository<Usuario, Integer> {
}
