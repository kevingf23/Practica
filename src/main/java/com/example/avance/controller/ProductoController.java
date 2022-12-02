package com.example.avance.controller;

import com.example.avance.model.Producto;
import com.example.avance.repository.CategoriaRepository;
import com.example.avance.repository.IProductoRepository;
import com.example.avance.repository.ProveedoresRepository;
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
@RequestMapping("products")
public class ProductoController {

    @Autowired
    private IProductoRepository productosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedoresRepository proveedorRepository;

    //Vista Principal
    @GetMapping("/view")
    ModelAndView MainView(){
        //traemos Productos
        List<Producto> listProducts = productosRepository.findAll();

        //retornamos vista usuarios
        return new ModelAndView("producto/productos")
                .addObject("producto", listProducts);

    }

    //Vista Nuevo
    @GetMapping("/new")
    ModelAndView NewUser(){
        return new ModelAndView("producto/new")
                .addObject("producto", new Producto())
                .addObject("categoria", categoriaRepository.findAll())
                .addObject("proveedor", proveedorRepository.findAll());
    }

    // Creacion Registro
    @PostMapping("/create")
    public String crear(Producto productoModel, BindingResult result, RedirectAttributes attributes, Model model){

        if(result.hasErrors()) {
            for(ObjectError error: result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("usuario", productoModel);
            return "usuario/new";
        }

        productosRepository.save(productoModel);

        attributes.addFlashAttribute("msgExito", "El Producto ha sido guardado exitosamente");
        return "redirect:/products/view";


    }

    // Vista Edit
    @GetMapping("/{ID}/edit")
    ModelAndView editar(@PathVariable Integer ID){
        Producto productObj = productosRepository.findById(ID)
                .orElseThrow(EntityNotFoundException::new);
        return new ModelAndView("producto/edit")
                .addObject("categoria", categoriaRepository.findAll())
                .addObject("proveedor", proveedorRepository.findAll())
                .addObject("producto", productObj);
    }

    // Edicion Registro
    @PostMapping("/{ID}/edit")
    ModelAndView actualizar(
            @PathVariable Integer ID,
            @Validated Producto productModel,
            BindingResult bindingResult,
            RedirectAttributes re
    ){
        productosRepository.findById(ID).orElseThrow(EntityNotFoundException::new);
        if (bindingResult.hasErrors()){
            return new ModelAndView("product/edit")
                    .addObject("producto", productModel);

        }

        productosRepository.save(productModel);
        re.addFlashAttribute("msgExitoAct", "El Producto se ha actualizado correctamente");
        return new ModelAndView("redirect:/products/view");
    }

    @GetMapping("/{ID}/delete")
    ModelAndView eliminar(@PathVariable Integer ID) {

        productosRepository.deleteById(ID);

        return new ModelAndView("redirect:/products/view");
    }
}
