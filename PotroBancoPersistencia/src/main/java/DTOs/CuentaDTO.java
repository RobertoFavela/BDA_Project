/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para la entidad Cuenta.
 * 
 * @author favel
 * @version 1.0
 */
public class CuentaDTO {
    private int Num_Cuenta;
    private String estado;
    private String fechaApertura;
    private int Saldo;
    private int ID_Cliente;

    /**
     * Constructor de la clase CuentaDTO.
     * 
     * @param Num_Cuenta El número de cuenta.
     * @param estado El estado de la cuenta.
     * @param fechaApertura La fecha de apertura de la cuenta.
     * @param Saldo El saldo de la cuenta.
     * @param ID_Cliente El identificador del cliente asociado a la cuenta.
     */
    public CuentaDTO(int Num_Cuenta, String estado, String fechaApertura, int Saldo, int ID_Cliente) {
        this.Num_Cuenta = Num_Cuenta;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.Saldo = Saldo;
        this.ID_Cliente = ID_Cliente;
    }

    /**
     * Constructor por defecto de la clase CuentaDTO.
     */
    public CuentaDTO() {
    }

    /**
     * Método para obtener el número de cuenta.
     * 
     * @return El número de cuenta.
     */
    public int getNum_Cuenta() {
        return Num_Cuenta;
    }

    /**
     * Método para establecer el número de cuenta.
     * 
     * @param Num_Cuenta El número de cuenta a establecer.
     */
    public void setNum_Cuenta(int Num_Cuenta) {
        this.Num_Cuenta = Num_Cuenta;
    }

    /**
     * Método para obtener el estado de la cuenta.
     * 
     * @return El estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método para establecer el estado de la cuenta.
     * 
     * @param estado El estado de la cuenta a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener la fecha de apertura de la cuenta.
     * 
     * @return La fecha de apertura de la cuenta.
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Método para establecer la fecha de apertura de la cuenta.
     * 
     * @param fechaApertura La fecha de apertura de la cuenta a establecer.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Método para obtener el saldo de la cuenta.
     * 
     * @return El saldo de la cuenta.
     */
    public int getSaldo() {
        return Saldo;
    }

    /**
     * Método para establecer el saldo de la cuenta.
     * 
     * @param Saldo El saldo de la cuenta a establecer.
     */
    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    /**
     * Método para obtener el identificador del cliente asociado a la cuenta.
     * 
     * @return El identificador del cliente asociado a la cuenta.
     */
    public int getID_Cliente() {
        return ID_Cliente;
    }

    /**
     * Método para establecer el identificador del cliente asociado a la cuenta.
     * 
     * @param ID_Cliente El identificador del cliente asociado a la cuenta a establecer.
     */
    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
}
