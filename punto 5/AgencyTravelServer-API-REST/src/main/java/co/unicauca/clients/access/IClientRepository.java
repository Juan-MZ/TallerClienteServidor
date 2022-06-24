/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.clients.access;

import co.unicauca.clients.domain.entity.Client;
import java.util.List;
/**
 * Interface de los servicios del repositorio
 * 
 * @author JuanMZ
 */
public interface IClientRepository {
    
    List<Client> findAll();
    
    Client findById(String id);
    
    boolean create(Client newClient);
    
    boolean update(Client newClient);
    
    boolean delete(String id);
    
}
