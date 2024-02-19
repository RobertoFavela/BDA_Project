/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author favel
 */
public class Cuenta {
    private int id; // Identificación de la cuenta
    private int Num_Cuenta; // Número de cuenta
    private String estado; // Estado de la cuenta
    private String fechaApertura; // Fecha de apertura de la cuenta
    private int Saldo; // Saldo de la cuenta
    private int ID_Cliente; // ID del cliente asociado a la cuenta

    /**
     * Constructor de Cuenta que inicializa todos los atributos.
     * 
     * @param id Identificación de la cuenta.
     * @param Num_Cuenta Número de cuenta.
     * @param estado Estado de la cuenta.
     * @param fechaApertura Fecha de apertura de la cuenta.
     * @param Saldo Saldo de la cuenta.
     * @param ID_Cliente ID del cliente asociado a la cuenta.
     */
    public Cuenta(int id, int Num_Cuenta, String estado, String fechaApertura, int Saldo, int ID_Cliente) {
        this.id = id;
        this.Num_Cuenta = Num_Cuenta;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.Saldo = Saldo;
        this.ID_Cliente = ID_Cliente;
    }

    /**
     * Constructor de Cuenta que no incluye la identificación.
     * 
     * @param Num_Cuenta Número de cuenta.
     * @param estado Estado de la cuenta.
     * @param fechaApertura Fecha de apertura de la cuenta.
     * @param Saldo Saldo de la cuenta.
     * @param ID_Cliente ID del cliente asociado a la cuenta.
     */
    public Cuenta(int Num_Cuenta, String estado, String fechaApertura, int Saldo, int ID_Cliente) {
        this.Num_Cuenta = Num_Cuenta;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.Saldo = Saldo;
        this.ID_Cliente = ID_Cliente;
    }

    /**
     * Constructor de Cuenta que solo incluye el número de cuenta y el saldo.
     * 
     * @param Num_Cuenta Número de cuenta.
     * @param Saldo Saldo de la cuenta.
     */
    public Cuenta(int Num_Cuenta, int Saldo) {
        this.Num_Cuenta = Num_Cuenta;
        this.Saldo = Saldo;
    }

    /**
     * Constructor de Cuenta que solo incluye el número de cuenta.
     * 
     * @param Num_Cuenta Número de cuenta.
     */
    public Cuenta(int Num_Cuenta) {
        this.Num_Cuenta = Num_Cuenta;
    }

    /**
     * Constructor por defecto de Cuenta.
     */
    public Cuenta() {
    }

    /**
     * Constructor de Cuenta que no incluye la identificación ni la fecha de apertura.
     * 
     * @param numeroCuenta Número de cuenta.
     * @param estado Estado de la cuenta.
     * @param saldo Saldo de la cuenta.
     * @param idCliente ID del cliente asociado a la cuenta.
     */
    public Cuenta(int numeroCuenta, String estado, int saldo, int idCliente) {
        this.Num_Cuenta = numeroCuenta;
        this.estado = estado;
        this.Saldo = saldo;
        this.ID_Cliente = idCliente;
    }

    // Métodos getters y setters para acceder y modificar los atributos de la cuenta

    /**
     * Obtiene la identificación de la cuenta.
     * 
     * @return La identificación de la cuenta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece la identificación de la cuenta.
     * 
     * @param id La nueva identificación de la cuenta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el número de cuenta.
     * 
     * @return El número de cuenta.
     */
    public int getNum_Cuenta() {
        return Num_Cuenta;
    }

    /**
     * Establece el número de cuenta.
     * 
     * @param Num_Cuenta El nuevo número de cuenta.
     */
    public void setNum_Cuenta(int Num_Cuenta) {
        this.Num_Cuenta = Num_Cuenta;
    }

    /**
     * Obtiene el estado de la cuenta.
     * 
     * @return El estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cuenta.
     * 
     * @param estado El nuevo estado de la cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de apertura de la cuenta.
     * 
     * @return La fecha de apertura de la cuenta.
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Establece la fecha de apertura de la cuenta.
     * 
     * @param fechaApertura La nueva fecha de apertura de la cuenta.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Obtiene el saldo de la cuenta.
     * 
     * @return El saldo de la cuenta.
     */
    public int getSaldo() {
        return Saldo;
    }

    /**
     * Establece el saldo de la cuenta.
     * 
     * @param Saldo El nuevo saldo de la cuenta.
     */
    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    /**
     * Obtiene el ID del cliente asociado a la cuenta.
     * 
     * @return El ID del cliente asociado a la cuenta.
     */
    public int getID_Cliente() {
        return ID_Cliente;
    }

    /**
     * Establece el ID del cliente asociado a la cuenta.
     * 
     * @param ID_Cliente El nuevo ID del cliente asociado a la cuenta.
     */
    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
}
