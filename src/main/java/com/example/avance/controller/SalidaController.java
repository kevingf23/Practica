package com.example.avance.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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


import com.example.avance.model.Salida;
import com.example.avance.repository.IProductoRepository;
import com.example.avance.repository.SalidaRepository;

@Controller
@RequestMapping("salidas")
public class SalidaController {
    
    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private SalidaRepository salidaRepository;

    
    //Vista Principal
    @GetMapping("/view")
    ModelAndView MainView(){
        //traemos Productos
        List<Salida> listsalida = salidaRepository.findAll();

        //retornamos vista usuarios
        return new ModelAndView("salida/salidas")
                .addObject("salida", listsalida);

    }

    //Vista Nuevo
    @GetMapping("/new")
    ModelAndView New(){
        return new ModelAndView("salida/new")
                .addObject("salida", new Salida())
                .addObject("producto", productoRepository.findAll());
    }

    // Creacion Registro
    @PostMapping("/create")
    public String crear(Salida salidaModel, BindingResult result, RedirectAttributes attributes, Model model){

        if(result.hasErrors()) {
            for(ObjectError error: result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("salida", salidaModel);
            return "salida/new";
        }

        salidaRepository.save(salidaModel);

        attributes.addFlashAttribute("msgExito", "La salida ha sido guardado exitosamente");
        return "redirect:/salidas/view";


    }

    // Vista Edit
    @GetMapping("/{ID}/edit")
    ModelAndView editar(@PathVariable Integer ID){

        Salida salidaObj = salidaRepository.findById(ID)
                .orElseThrow(EntityNotFoundException::new);

        return new ModelAndView("salida/new")
                .addObject("producto", productoRepository.findAll())
                .addObject("salida", salidaObj);
    }

    // Edicion Registro
    @PostMapping("/{ID}/edit")
    ModelAndView actualizar(
            @PathVariable Integer ID,
            @Validated Salida salidaModel,
            BindingResult bindingResult,
            RedirectAttributes re
    ){
        salidaRepository.findById(ID).orElseThrow(EntityNotFoundException::new);
        if (bindingResult.hasErrors()){
            return new ModelAndView("product/edit")
                    .addObject("producto", salidaModel);

        }

        salidaRepository.save(salidaModel);
        re.addFlashAttribute("msgExitoAct", "La salida se ha actualizado correctamente");
        return new ModelAndView("redirect:/salidas/view");
    }

    @GetMapping("/{ID}/delete")
    ModelAndView eliminar(@PathVariable Integer ID) {

        salidaRepository.deleteById(ID);

        return new ModelAndView("redirect:/salidas/view");
    }
 
    

}
