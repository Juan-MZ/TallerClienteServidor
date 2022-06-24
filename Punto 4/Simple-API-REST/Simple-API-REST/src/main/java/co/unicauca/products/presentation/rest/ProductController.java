/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.products.presentation.rest;

import co.unicauca.products.domain.service.ProductService;
import co.unicauca.products.domain.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * API REST de los servicios web. Es muy simple por ahora, en otra versión se
 * hará una API más robusta. Son nuestros servicios web. La anotación @Path
 * indica la URL en la cual responderá los servicios. Esta anotación se puede
 * poner a nivel de clase y método. En este ejemplo todos los servicios
 * comparten el mismo Path, la acción se hacer mediante la anotació GET
 * (consultar), POST (agregar), PUT (editar), DELETE (eliminar).
 * 
 * @author JuanMZ
 */
@Stateless
@Path("products")
public class ProductController {
    /**
     * Se inyecta la única implementación que hay de ProductService
     */
    @Inject
    private ProductService service;

    public ProductController() {

    }
    
    /*
     * Su uso desde consola mediante client url:
     * curl -X GET http://localhost:8080/Simple-API-REST/product-service/products/
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> findAll() {
       return service.findAll();
    }
    
    /*
     * Su uso desde consola mediante client url:
     * curl -X GET http://localhost:8080/Simple-API-REST/productservice/products/1
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Product findById(@PathParam("id") int id) {
       return service.findById(id);
    }
    
    /*
     * Su uso desde consola mediante client url:
     * curl -X POST \
     * http://localhost:8080/Simple-API-REST/product-service/products/ \
     * -H 'Content-Type: application/json' \
     * -d '{
     * "id":1,
     * "name":"Nevera Lg",
     * "price":6700000
     * }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(Product prod) {
        if (service.create(prod)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Producto creado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo crear el producto\",\"errores\":\"Id ya existe\"}";
        }
    }
    
    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
        http://localhost:8080/Simple-API-REST/product-service/products/\
        -H 'Content-Type: application/json' \
        -d '{
        "name":"Nevera Lg REF. JDK3-34-343",
        "price":2450000
        }'
    */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String update(Product prod) {
        if (service.update(prod)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Producto modificado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo modificar el producto\",\"errores\":\"Id no existe\"}";
        }
    }
    
    /*
    Su uso desde consola mediante client url:
    curl -X DELETE http://localhost:8080/Simple-API-REST/productservice/products/
    */
    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Integer id) {
        if (service.delete(id)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Producto borrado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo borrar el producto\",\"errores\":\"Id no existe\"}";
        }
    }
}
