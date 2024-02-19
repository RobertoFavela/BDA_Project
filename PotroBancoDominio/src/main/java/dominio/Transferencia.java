/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author favel
 */
public class Transferencia {
    private int idTransferencia; // Identificación de la transferencia
    private int cuentaEnvio; // Cuenta que envía la transferencia
    private int hora; // Hora de la transferencia

    /**
     * Constructor de Transferencia que inicializa todos los atributos.
     * 
     * @param idTransferencia Identificación de la transferencia.
     * @param cuentaEnvio Cuenta que envía la transferencia.
     * @param tipo Tipo de operación de la transferencia.
     * @param fechaHora Fecha y hora de la operación de la transferencia.
     * @param monto Monto de la operación de la transferencia.
     * @param id_Cuenta ID de la cuenta asociada a la operación de la transferencia.
     */
    public Transferencia(int idTransferencia, int cuentaEnvio, String tipo, String fechaHora, int monto, int id_Cuenta) {
        this.cuentaEnvio = cuentaEnvio;
        this.idTransferencia = idTransferencia;
    }

    /**
     * Constructor de Transferencia que solo incluye la cuenta de envío.
     * 
     * @param cuentaEnvio Cuenta que envía la transferencia.
     */
    public Transferencia(int cuentaEnvio) {
        this.cuentaEnvio = cuentaEnvio;
    }
    
    // Métodos getters y setters para acceder y modificar los atributos de la transferencia

    /**
     * Obtiene la identificación de la transferencia.
     * 
     * @return La identificación de la transferencia.
     */
    public int getIdTransferencia() {
        return idTransferencia;
    }

    /**
     * Establece la identificación de la transferencia.
     * 
     * @param idTransferencia La nueva identificación de la transferencia.
     */
    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    /**
     * Obtiene la hora de la transferencia.
     * 
     * @return La hora de la transferencia.
     */
    public int getHora() {
        return hora;
    }

    /**
     * Establece la hora de la transferencia.
     * 
     * @param hora La nueva hora de la transferencia.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la cuenta que envía la transferencia.
     * 
     * @return La cuenta que envía la transferencia.
     */
    public int getCuentaEnvio() {
        return cuentaEnvio;
    }

    /**
     * Establece la cuenta que envía la transferencia.
     * 
     * @param cuentaEnvio La nueva cuenta que envía la transferencia.
     */
    public void setCuentaEnvio(int cuentaEnvio) {
        this.cuentaEnvio = cuentaEnvio;
    }
}
