/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.clients;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Clase que indice el Path base desde el cual estará respondiendo la API Rest.
 * Este path corresponde a la URL a partir de la cual se expondrá nuestros
 * servicios. Para lograr esto, será necesario crear una clase que extienda de
 * “Application”, esta clase puede llamarse como sea y puede colocarse en
 * cualquier paquete.
 * 
 * @author JuanMZ
 */
@ApplicationPath("client-service")
public class AppConfiguration extends Application{
    
}
