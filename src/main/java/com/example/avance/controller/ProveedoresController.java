package com.example.avanceunidad3.controller;


import com.example.avanceunidad3.model.Proveedores;

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

import com.example.avanceunidad3.repository.ProveedoresRepository;

@Controller
public class ProveedoresController {
    @Autowired
    private ProveedoresRepository proveedoresRepository;

    //home de proveedores
    @GetMapping("proveedor/viewproveedores")
    ModelAndView verproveedores(){
        List<Proveedores> proveedores = proveedoresRepository.findAll();
        return new ModelAndView("proveedor/verproveedores")
                .addObject("proveedores", proveedores);
    }
    //Agregar proveedores
    @GetMapping("proveedor/newproveedor")
    ModelAndView newproveedor(){
        return new ModelAndView("proveedor/newproveedor")
                .addObject("proveedores", new Proveedores());
    }

    @PostMapping("proveedor/newproveedor")
    ModelAndView crear(@Validated Proveedores proveedores, BindingResult bindingResult, RedirectAttributes re){
        if(bindingResult.hasErrors()){
            return new ModelAndView("proveedor/newproveedor")
                    .addObject("proveedores", proveedores);
        }
        proveedoresRepository.save(proveedores);
        re.addFlashAttribute("msgExito", "El proveedor ha sido guardado exitosamente");
        return new ModelAndView("redirect:/proveedor/viewproveedores");
    }

    @GetMapping("/{ID}/newproveedor")
    ModelAndView editar(@PathVariable Integer ID){
        Proveedores proveedores = proveedoresRepository.findById(ID)
                .orElseThrow(EntityNotFoundException::new);
        return new ModelAndView("proveedor/newproveedor")
                .addObject("proveedores", proveedores);
    }

    @PostMapping("/{ID}/newproveedor")
    ModelAndView actualizar(
            @PathVariable Integer ID,
            @Validated Proveedores proveedores,
            BindingResult bindingResult,
            RedirectAttributes re
    ){
        proveedoresRepository.findById(ID).orElseThrow(EntityNotFoundException::new);
        if (bindingResult.hasErrors()){
            return new ModelAndView("proveedor/newproveedor")
                    .addObject("proveedores", proveedores);

        }
        proveedores.setID(ID);
        proveedoresRepository.save(proveedores);
        re.addFlashAttribute("msgExitoAct", "El proveedor se ha actualizado correctamente");
        return new ModelAndView("redirect:/proveedor/viewproveedores");
         }

        @GetMapping("/{ID}/eliminar")
        ModelAndView eliminar(@PathVariable Integer ID){
            proveedoresRepository.deleteById(ID);
            return new ModelAndView("redirect:/proveedor/viewproveedores");
        }

        }
