/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author favel
 */
public class Cliente {
    private int id; // Identificación del cliente
    private String nombre; // Nombre del cliente
    private String usuario; // Nombre de usuario del cliente
    private String contraseña; // Contraseña del cliente
    private String fechaNacimiento; // Fecha de nacimiento del cliente
    private String domicilio; // Domicilio del cliente

    /**
     * Constructor de Cliente que inicializa todos los atributos.
     * 
     * @param id Identificación del cliente.
     * @param nombre Nombre del cliente.
     * @param usuario Nombre de usuario del cliente.
     * @param contraseña Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param domicilio Domicilio del cliente.
     */
    public Cliente(int id, String nombre, String usuario, String contraseña, String fechaNacimiento, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    /**
     * Constructor de Cliente que no incluye el id.
     * 
     * @param nombre Nombre del cliente.
     * @param usuario Nombre de usuario del cliente.
     * @param contraseña Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param domicilio Domicilio del cliente.
     */
    public Cliente(String nombre, String usuario, String contraseña, String fechaNacimiento, String domicilio) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    /**
     * Constructor de Cliente que solo incluye usuario y contraseña.
     * 
     * @param usuario Nombre de usuario del cliente.
     * @param contraseña Contraseña del cliente.
     */
    public Cliente(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Constructor de Cliente que no incluye la contraseña.
     * 
     * @param id Identificación del cliente.
     * @param nombre Nombre del cliente.
     * @param usuario Nombre de usuario del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param domicilio Domicilio del cliente.
     */
    public Cliente(int id, String nombre, String usuario, String fechaNacimiento, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }
    
    /**
     * Constructor por defecto de Cliente.
     */
    public Cliente() {
    }

    // Métodos getters y setters para acceder y modificar los atributos del cliente

    /**
     * Obtiene la identificación del cliente.
     * 
     * @return La identificación del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece la identificación del cliente.
     * 
     * @param id La nueva identificación del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de usuario del cliente.
     * 
     * @return El nombre de usuario del cliente.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del cliente.
     * 
     * @param usuario El nuevo nombre de usuario del cliente.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return La contraseña del cliente.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del cliente.
     * 
     * @param contraseña La nueva contraseña del cliente.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return La fecha de nacimiento del cliente.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento La nueva fecha de nacimiento del cliente.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el domicilio del cliente.
     * 
     * @return El domicilio del cliente.
     */
    public String getDomilicio() {
        return domicilio;
    }

    /**
     * Establece el domicilio del cliente.
     * 
     * @param domicilio El nuevo domicilio del cliente.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}