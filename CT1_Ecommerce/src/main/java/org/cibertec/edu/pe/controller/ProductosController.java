package org.cibertec.edu.pe.controller;

import org.cibertec.edu.pe.interfaceService.IProductosService;
import org.cibertec.edu.pe.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
public class ProductosController {

    @Autowired
    private IProductosService productosService;

    @GetMapping("/show")
    public String showProductos(Model model) {
        model.addAttribute("productos", productosService.findAll());
        return "show"; // show.html
    }

    @GetMapping("/productos/create")
    public String createProducto() {
        return "productos/create"; // create.html
    }

    @PostMapping("/productos/save")
    public String saveProducto(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        
        return "redirect:/productos";
    }

    @GetMapping("/productos/edit/{id}")
    public String editProducto(@PathVariable String id, Model model) {
        Optional<Producto> optionalProducto = productosService.Buscar(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            model.addAttribute("producto", producto);
            return "productos/edit"; //edit.html
        } else {
            // Manejo de error si el producto no se encuentra
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/update")
    public String updateProducto(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        // Aquí puedes agregar el código para actualizar el producto y la imagen
        return "redirect:/productos";
    }

    @GetMapping("/productos/delete/{id}")
    public String deleteProducto(@PathVariable String id) {
        // Aquí puedes agregar el código para eliminar el producto
        return "redirect:/productos";
    }
}