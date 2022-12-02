package com.example.avance.controller;

import com.example.avance.model.Compra;
import com.example.avance.repository.ICompraRepository;
import com.example.avance.repository.IProductoRepository;
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
@RequestMapping("compras")
public class CompraController {

    @Autowired
    private ICompraRepository compraRepository;

    @Autowired
    private IProductoRepository productoRepository;



    //Vista Principal
    @GetMapping("/view")
    ModelAndView MainView(){
        //traemos Productos
        List<Compra> listCompras = compraRepository.findAll();

        //retornamos vista usuarios
        return new ModelAndView("compra/compras")
                .addObject("compra", listCompras);

    }

    //Vista Nuevo
    @GetMapping("/new")
    ModelAndView New(){
        return new ModelAndView("compra/new")
                .addObject("compra", new Compra())
                .addObject("producto", productoRepository.findAll());
    }

    // Creacion Registro
    @PostMapping("/create")
    public String crear(Compra compraModel, BindingResult result, RedirectAttributes attributes, Model model){

        if(result.hasErrors()) {
            for(ObjectError error: result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("compra", compraModel);
            return "compra/new";
        }

        compraRepository.save(compraModel);

        attributes.addFlashAttribute("msgExito", "La compra ha sido guardado exitosamente");
        return "redirect:/compras/view";


    }

    // Vista Edit
    @GetMapping("/{ID}/edit")
    ModelAndView editar(@PathVariable Integer ID){

        Compra compraObj = compraRepository.findById(ID)
                .orElseThrow(EntityNotFoundException::new);

        return new ModelAndView("compra/edit")
                .addObject("producto", productoRepository.findAll())
                .addObject("compra", compraObj);
    }

    // Edicion Registro
    @PostMapping("/{ID}/edit")
    ModelAndView actualizar(
            @PathVariable Integer ID,
            @Validated Compra compraModel,
            BindingResult bindingResult,
            RedirectAttributes re
    ){
        compraRepository.findById(ID).orElseThrow(EntityNotFoundException::new);
        if (bindingResult.hasErrors()){
            return new ModelAndView("product/edit")
                    .addObject("producto", compraModel);

        }

        compraRepository.save(compraModel);
        re.addFlashAttribute("msgExitoAct", "La compra se ha actualizado correctamente");
        return new ModelAndView("redirect:/compras/view");
    }

    @GetMapping("/{ID}/delete")
    ModelAndView eliminar(@PathVariable Integer ID) {

        compraRepository.deleteById(ID);

        return new ModelAndView("redirect:/compras/view");
    }
}
