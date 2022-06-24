/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.clients.domain.entity;

/**
 * Representa un producto de la tienda
 *
 * @author JuanMZ
 */
public class Client {
    private String id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String celular;
    private String email;
    private String sexo;

    public Client(String id, String nombres, String apellidos, String direccion, String celular, String email, String sexo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
    }

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    @Override
    public String toString(){
        return "Client{" + "id=" + id + ", nombres=" + nombres + ", apelidos=" + apellidos +
               ", direccion=" + direccion + ", celular=" + celular +", email=" + email +", sexo=" + sexo +'}';
    }
}
