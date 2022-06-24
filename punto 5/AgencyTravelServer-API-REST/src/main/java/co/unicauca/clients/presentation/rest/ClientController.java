/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.clients.presentation.rest;

import co.unicauca.clients.domain.service.ClientService;
import co.unicauca.clients.domain.entity.Client;
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
@Path("clients")
public class ClientController {
    /**
     * Se inyecta la única implementación que hay de ProductService
     */
    @Inject
    private ClientService service;

    public ClientController() {

    }
    
    /*
     * Su uso desde consola mediante client url:
     * curl -X GET http://localhost:8080/AgencyTravelServer-API-REST/client-service/clients/
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Client> findAll() {
       return service.findAll();
    }
    
    /*
     * Su uso desde consola mediante client url:
     * curl -X GET http://localhost:8080/AgencyTravelServer-API-REST/client-service/clients/1
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Client findById(@PathParam("id") String id) {
       return service.findById(id);
    }
    
    /*
     * Su uso desde consola mediante client url:
     * curl -X POST \
     * http://localhost:8080/AgencyTravelServer-API-REST/client-service/clients/ \
     * -H 'Content-Type: application/json' \
     * -d '{
     * "id":"98000003",
     * "nombres":"Carlos",
     * "apellidos":"Pantoja",
     * "direccion":"Santa Barbar Popayan",
     * "celular":"3141257846",
     * "email":"carlos@gmail.com",
     * "sexo":"Masculino"
     * }'
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(Client cli) {
        if (service.create(cli)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente creado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo registrar el cliente\",\"errores\":\"Id ya existe\"}";
        }
    }
    
    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
        http://localhost:8080/AgencyTravelServer-API-REST/client-service/clients/\
        -H 'Content-Type: application/json' \
        -d '{
        "nombres":"Juan",
        "apellidos":"Medicis",
        "direccion":"Portal tal",
        "celular":"3213314642",
        "email":"juan@gmail.com",
        "sexo":"Masculino"
        }'
    */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String update(Client cli) {
        if (service.update(cli)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente modificado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo modificar el cliente\",\"errores\":\"Id no existe\"}";
        }
    }
    
    /*
    Su uso desde consola mediante client url:
    curl -X DELETE http://localhost:8080/AgencyTravelServer-API-REST/client-service/clients/
    */
    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") String id) {
        if (service.delete(id)) {
            return "{\"ok\":\"true\", \"mensaje\":\"Cliente borrado\",\"errores\":\"\"}";
        } else {
            return "{\"ok\":\"false\", \"mensaje\":\"No se pudo borrar el cliente\",\"errores\":\"Id no existe\"}";
        }
    }
}
