/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.clients.access;

import co.unicauca.clients.domain.entity.Client;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Default;


/**
 * Implementación por defecto. El framewok contenedor de CDI (Contexts and
 * Dependency Injection) carga la implementación por defecto.
 *
 * @author JuanMZ
 */
@Default
public class IClientRepositoryImplArrays implements IClientRepository {
    
    /**
     * Por simplicidad los datos se cargan en un array.
     */
    public static List<Client> clients;

    public IClientRepositoryImplArrays() {
        if (clients == null){
            clients = new ArrayList<>();
            initialize();
        }
    }
    
    private void initialize() {
        clients.add(new Client("98000001", "Andrea", "Sanchez", "Calle 14 No 11-12 Popayan", "3145878752", "andrea@hotmail.com", "Femenino"));
        clients.add(new Client("98000002", "Libardo", "Pantoja", "Santa Barbar Popayan", "3141257845", "libardo@gmail.com", "Masculino"));
        clients.add(new Client("98000003", "Carlos", "Pantoja", "Santa Barbar Popayan", "3141257846", "carlos@gmail.com", "Masculino"));
        clients.add(new Client("98000004", "Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan", "3154562133", "fercha@hotmail.com", "Femenino"));
        clients.add(new Client("98000005", "Manuel", "Perez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        clients.add(new Client("98000006", "Alejandro", "Mosquera", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        clients.add(new Client("98000007", "Cesar", "Gutierres Sanchez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        clients.add(new Client("98000008", "Julio", "Bravo Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        clients.add(new Client("98000009", "Alberto", "Mendez Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        clients.add(new Client("98000010", "Alexander", "Ponce Yepes", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
    }
    
    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public Client findById(String id) {
        for (Client cliente : clients) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
    
    @Override
    public boolean create(Client newClient) {
        Client cli = this.findById(newClient.getId());
        if (cli != null) {
            //Ya existe
            return false;
        }
        clients.add(newClient);
        return true;
    }
    @Override
    public boolean update(Client cliente) {
        Client cli = this.findById(cliente.getId());
        if (cli != null) {
            cli.setNombres(cliente.getNombres());
            cli.setApellidos(cliente.getApellidos());
            cli.setDireccion(cliente.getDireccion());
            cli.setCelular(cliente.getCelular());
            cli.setEmail(cliente.getEmail());
            cli.setSexo(cliente.getSexo());
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(String id) {
        int i = 0;
        for (Client cli : clients) {
            if (cli.getId() == id) {
                clients.remove(i++);
                return true;
            }
        }
        return false;
    }

}
