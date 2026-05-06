/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.crudproductos.controller;

import com.example.crudproductos.entity.Producto;
import com.example.crudproductos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author table
 */
@Controller
public class ProductoController {
    
    @Autowired
    private ProductoRepository repo;
    
    // LISTAR
    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("productos", repo.findAll());
        return "index";
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "form";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
        repo.save(producto);
        return "redirect:/";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Producto producto = repo.findById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "form";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/";
    }

}
