/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.products.access;

import co.unicauca.products.domain.entity.Product;
import java.util.List;
/**
 * Interface de los servicios del repositorio
 * 
 * @author JuanMZ
 */
public interface IProductRepository {
    
    List<Product> findAll();
    
    Product findById(Integer id);
    
    boolean create(Product newProduct);
    
    boolean update(Product newProduct);
    
    boolean delete(Integer id);
    
}
