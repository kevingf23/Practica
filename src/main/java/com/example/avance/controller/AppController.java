package com.example.avance.controller;

import com.example.avance.model.Usuario;
import com.example.avance.repository.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @Autowired
    private IUsuariosRepository repoUsuarios;

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        return "login";
    }
    @GetMapping("/")
    public String mostrarLogin2(Model model) {
        return "login";
    }

    @GetMapping("/principal")
    public String mostrarCategorias(Model model) {
        return "menu";
    }

}
