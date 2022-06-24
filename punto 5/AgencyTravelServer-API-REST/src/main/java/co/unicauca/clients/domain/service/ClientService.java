/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.clients.domain.service;

import co.unicauca.clients.access.IClientRepository;
import co.unicauca.clients.domain.entity.Client;
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
public class ClientService {
    /**
     * Inyecta una implementación del repositorio
     */
    @Inject
    @Default
    IClientRepository repo;

    public ClientService() {
        
    }
    
    public List<Client> findAll() {
        return repo.findAll();
    }
    
    public Client findById(String id) {
        return repo.findById(id);
    }
    
    public boolean create(Client cli) {
        return repo.create(cli);
    }
    
    public boolean update(Client cli) {
        return repo.update(cli);
    }
    
    public boolean delete(String id) {
        return repo.delete(id);
    }
}
