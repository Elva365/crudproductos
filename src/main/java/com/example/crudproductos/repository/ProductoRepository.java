/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.crudproductos.repository;

import com.example.crudproductos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author table
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
