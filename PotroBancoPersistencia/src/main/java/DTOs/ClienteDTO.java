/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para la entidad Cliente.
 * 
 * @author favel
 * @version 1.0
 */
public class ClienteDTO {
    private String nombre;
    private String usuario;
    private String contraseña;
    private String fechaNacimiento;
    private String Domilicio;

    /**
     * Constructor de la clase ClienteDTO.
     * 
     * @param nombre El nombre del cliente.
     * @param usuario El nombre de usuario del cliente.
     * @param contraseña La contraseña del cliente.
     * @param fechaNacimiento La fecha de nacimiento del cliente.
     * @param Domilicio El domicilio del cliente.
     */
    public ClienteDTO(String nombre, String usuario, String contraseña, String fechaNacimiento, String Domilicio) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.Domilicio = Domilicio;
    }

    /**
     * Constructor de la clase ClienteDTO.
     * 
     * @param usuario El nombre de usuario del cliente.
     * @param contraseña La contraseña del cliente.
     */
    public ClienteDTO(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Método para obtener el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del cliente.
     * 
     * @param nombre El nombre del cliente a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el nombre de usuario del cliente.
     * 
     * @return El nombre de usuario del cliente.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método para establecer el nombre de usuario del cliente.
     * 
     * @param usuario El nombre de usuario del cliente a establecer.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método para obtener la contraseña del cliente.
     * 
     * @return La contraseña del cliente.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Método para establecer la contraseña del cliente.
     * 
     * @param contraseña La contraseña del cliente a establecer.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Método para obtener la fecha de nacimiento del cliente.
     * 
     * @return La fecha de nacimiento del cliente.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para establecer la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento La fecha de nacimiento del cliente a establecer.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método para obtener el domicilio del cliente.
     * 
     * @return El domicilio del cliente.
     */
    public String getDomilicio() {
        return Domilicio;
    }

    /**
     * Método para establecer el domicilio del cliente.
     * 
     * @param Domilicio El domicilio del cliente a establecer.
     */
    public void setDomilicio(String Domilicio) {
        this.Domilicio = Domilicio;
    }
}

