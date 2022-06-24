/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.products.domain.service;

import co.unicauca.products.access.IProductRepository;
import co.unicauca.products.domain.entity.Product;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * Fachada de acceso al negocio por parte de la presentación. Usa el repositorio
 * por defecto. Si no se pone @Default tambien funciona, pues inyecta la
 * implementaició por defecto
 *
 * @author JuanMZ
 */
public class ProductService {
    /**
     * Inyecta una implementación del repositorio
     */
    @Inject
    @Default
    IProductRepository repo;

    public ProductService() {
        
    }
    
    public List<Product> findAll() {
        return repo.findAll();
    }
    
    public Product findById(int id) {
        return repo.findById(id);
    }
    
    public boolean create(Product prod) {
        return repo.create(prod);
    }
    
    public boolean update(Product prod) {
        return repo.update(prod);
    }
    
    public boolean delete(int id) {
        return repo.delete(id);
    }
}
