/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.cliente;

/**
 *
 * @author JuanMZ
 */
public class ClienteMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CREANDO UN ESTUDIANTE
        NewJerseyClient jersey = new NewJerseyClient();
        String rta = jersey.create_JSON(new Product(5, "Nevera Lg", 4000000d));
        System.out.println("Rta " + rta);
        // BUSCANDO UN PRODUCTO
        Product product = jersey.findById(Product.class, "1");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        // PROBAR LOS DEMAS SERVICIOS
    }

}
