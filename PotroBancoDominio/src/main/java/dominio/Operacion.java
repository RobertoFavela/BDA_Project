/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author favel
 */
public class Operacion {
    private int id; // Identificación de la operación
    private String tipo; // Tipo de operación
    private String fechaHora; // Fecha y hora de la operación
    private int monto; // Monto de la operación
    private int id_Cuenta; // ID de la cuenta asociada a la operación

    /**
     * Constructor de Operacion que inicializa todos los atributos.
     * 
     * @param id Identificación de la operación.
     * @param tipo Tipo de operación.
     * @param fechaHora Fecha y hora de la operación.
     * @param monto Monto de la operación.
     * @param id_Cuenta ID de la cuenta asociada a la operación.
     */
    public Operacion(int id, String tipo, String fechaHora, int monto, int id_Cuenta) {
        this.id = id;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.id_Cuenta = id_Cuenta;
    }
    
    /**
     * Constructor de Operacion que no incluye la identificación.
     * 
     * @param tipo Tipo de operación.
     * @param fechaHora Fecha y hora de la operación.
     * @param monto Monto de la operación.
     * @param id_Cuenta ID de la cuenta asociada a la operación.
     */
    public Operacion(String tipo, String fechaHora, int monto, int id_Cuenta) {
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.id_Cuenta = id_Cuenta;
    }

    // Métodos getters y setters para acceder y modificar los atributos de la operación

    /**
     * Obtiene la identificación de la operación.
     * 
     * @return La identificación de la operación.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece la identificación de la operación.
     * 
     * @param id La nueva identificación de la operación.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el tipo de operación.
     * 
     * @return El tipo de operación.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de operación.
     * 
     * @param tipo El nuevo tipo de operación.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la fecha y hora de la operación.
     * 
     * @return La fecha y hora de la operación.
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la operación.
     * 
     * @param fechaHora La nueva fecha y hora de la operación.
     */
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el monto de la operación.
     * 
     * @return El monto de la operación.
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la operación.
     * 
     * @param monto El nuevo monto de la operación.
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el ID de la cuenta asociada a la operación.
     * 
     * @return El ID de la cuenta asociada a la operación.
     */
    public int getId_Cuenta() {
        return id_Cuenta;
    }

    /**
     * Establece el ID de la cuenta asociada a la operación.
     * 
     * @param id_Cuenta El nuevo ID de la cuenta asociada a la operación.
     */
    public void setId_Cuenta(int id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }
}
