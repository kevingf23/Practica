package com.example.avanceunidad3.controller;

import com.example.avanceunidad3.model.Usuario;
import com.example.avanceunidad3.repository.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("users")
public class UsuarioController {

    @Autowired
    private IUsuariosRepository usuariosRepository;

    //Vista Principal
    @GetMapping("/view")
    ModelAndView MainView(){
        //traemos usuarios
        List<Usuario> listUsers = usuariosRepository.findAll();

        //retornamos vista usuarios
        return new ModelAndView("usuario/usuarios")
                .addObject("usuario", listUsers);

    }
    //Vista Nuevo Usuario
    @GetMapping("/new")
    ModelAndView NewUser(){
        return new ModelAndView("usuario/new")
                .addObject("usuario", new Usuario());
    }

    // Creacion Registro
    @PostMapping("/create")
    public String crear(Usuario usuarioModel, BindingResult result, RedirectAttributes attributes, Model model){

        if(result.hasErrors()) {
            for(ObjectError error: result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("usuario", usuarioModel);
            return "usuario/new";
        }

        usuariosRepository.save(usuarioModel);

        attributes.addFlashAttribute("msgExito", "El Usuario ha sido guardado exitosamente");
        return "redirect:/users/view";


    }

    // Vista Edit
    @GetMapping("/{ID}/edit")
    ModelAndView editar(@PathVariable Integer ID){
        Usuario usuarioObj = usuariosRepository.findById(ID)
                .orElseThrow(EntityNotFoundException::new);
        return new ModelAndView("usuario/edit")
                .addObject("usuario", usuarioObj);
    }

    // Edicion Registro
    @PostMapping("/{ID}/edit")
    ModelAndView actualizar(
            @PathVariable Integer ID,
            @Validated Usuario usuarioModel,
            BindingResult bindingResult,
            RedirectAttributes re
    ){
        usuariosRepository.findById(ID).orElseThrow(EntityNotFoundException::new);
        if (bindingResult.hasErrors()){
            return new ModelAndView("usuario/edit")
                    .addObject("usuario", usuarioModel);

        }
        //usuarioModel.setID(ID);
        usuariosRepository.save(usuarioModel);
        re.addFlashAttribute("msgExitoAct", "El Usuario se ha actualizado correctamente");
        return new ModelAndView("redirect:/users/view");
    }

    @GetMapping("/{ID}/delete")
    ModelAndView eliminar(@PathVariable Integer ID) {

        usuariosRepository.deleteById(ID);

        return new ModelAndView("redirect:/users/view");
    }
}
