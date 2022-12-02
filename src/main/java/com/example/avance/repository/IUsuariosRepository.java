package com.example.avanceunidad3.repository;

import com.example.avanceunidad3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuariosRepository extends JpaRepository<Usuario, Integer> {
}
