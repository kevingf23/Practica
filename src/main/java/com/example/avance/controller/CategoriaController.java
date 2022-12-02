package com.example.avanceunidad3.controller;


import java.util.List;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.avanceunidad3.model.Categoria;
import com.example.avanceunidad3.repository.CategoriaRepository;



@Controller
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("viewcategoria")
    ModelAndView viewcategoria() {

        List<Categoria> lista = categoriaRepository.findAll();
        
        return new ModelAndView("categoria/viewcategoria")
        .addObject("categoria", lista);
    }

    @GetMapping("addCategoria")
    ModelAndView addCategoria() {

        return new ModelAndView("categoria/addCategoria")
        .addObject("categoria", new Categoria());

    }

    @PostMapping("/addCategoria")
    ModelAndView crear (@Validated Categoria categoria, BindingResult bindingResult, RedirectAttributes re) {

        if (bindingResult.hasErrors()) {

            return new ModelAndView("categoria/addCategoria")
        .addObject("categoria", categoria);
        }

        categoriaRepository.save (categoria);

        re.addFlashAttribute("msgExit", "La categoria a sido agregada exitosamente");

        return new ModelAndView("redirect:/viewcategoria");
    }

    @GetMapping("/{ID}/editarCategoria")
    ModelAndView editar(@PathVariable Integer ID){
        Categoria categoria = categoriaRepository.findById(ID)
                .orElseThrow(EntityNotFoundException::new);
        return new ModelAndView("categoria/addCategoria")
                .addObject("categoria", categoria);
    }

    @PostMapping("/{ID}/editarCategoria")
    ModelAndView actualizar(@PathVariable Integer ID, @Validated Categoria categoria, BindingResult bindingResult, RedirectAttributes re) {

        categoriaRepository.findById(ID).orElseThrow(EntityNotFoundException::new);

        if (bindingResult.hasErrors()) {

            return new ModelAndView("categoria/addCategoria").addObject("categoria", categoria);
        }
        categoria.setID(ID);
        categoriaRepository.save(categoria);
        re.addFlashAttribute("msgExitoAct", "La categoria se ha actualizado correctamente");

        return new ModelAndView("redirect:/viewcategoria");
    }

    @GetMapping("/{ID}/eliminarCategoria")
    ModelAndView eliminar(@PathVariable Integer ID) {

        categoriaRepository.deleteById(ID);

        return new ModelAndView("redirect:/viewcategoria");
    }



}

