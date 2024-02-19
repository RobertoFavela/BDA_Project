/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author favel
 */
public class Retiro {
    private int Id_operacion; // Identificación de la operación de retiro
    private int folio; // Folio de la solicitud de retiro
    private int contraseña; // Contraseña asociada a la solicitud de retiro
    private String fechaHoraLimite; // Fecha y hora límite para realizar el retiro
    private String estado; // Estado de la solicitud de retiro

    /**
     * Constructor de Retiro que inicializa todos los atributos.
     * 
     * @param folio Folio de la solicitud de retiro.
     * @param contraseña Contraseña asociada a la solicitud de retiro.
     * @param fechaHoraLimite Fecha y hora límite para realizar el retiro.
     * @param estado Estado de la solicitud de retiro.
     * @param tipo Tipo de operación de retiro.
     * @param fechaHora Fecha y hora de la operación de retiro.
     * @param monto Monto de la operación de retiro.
     * @param id_Cuenta ID de la cuenta asociada a la operación de retiro.
     */
    public Retiro(int folio, int contraseña, String fechaHoraLimite, String estado, String tipo, String fechaHora, int monto, int id_Cuenta) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.fechaHoraLimite = fechaHoraLimite;
        this.estado = estado;
    }

    /**
     * Constructor por defecto de Retiro.
     */
    public Retiro() {
    }

    /**
     * Constructor de Retiro que solo incluye el folio y la contraseña.
     * 
     * @param folio Folio de la solicitud de retiro.
     * @param contraseña Contraseña asociada a la solicitud de retiro.
     */
    public Retiro(int folio, int contraseña) {
        this.folio = folio;
        this.contraseña = contraseña;
    }

    // Métodos getters y setters para acceder y modificar los atributos de la solicitud de retiro

    /**
     * Obtiene la identificación de la operación de retiro.
     * 
     * @return La identificación de la operación de retiro.
     */
    public int getId_operacion() {
        return Id_operacion;
    }

    /**
     * Establece la identificación de la operación de retiro.
     * 
     * @param Id_operacion La nueva identificación de la operación de retiro.
     */
    public void setId_operacion(int Id_operacion) {
        this.Id_operacion = Id_operacion;
    }

    /**
     * Obtiene el folio de la solicitud de retiro.
     * 
     * @return El folio de la solicitud de retiro.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Establece el folio de la solicitud de retiro.
     * 
     * @param folio El nuevo folio de la solicitud de retiro.
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la contraseña asociada a la solicitud de retiro.
     * 
     * @return La contraseña asociada a la solicitud de retiro.
     */
    public int getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña asociada a la solicitud de retiro.
     * 
     * @param contraseña La nueva contraseña asociada a la solicitud de retiro.
     */
    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene la fecha y hora límite para realizar el retiro.
     * 
     * @return La fecha y hora límite para realizar el retiro.
     */
    public String getFechaHoraLimite() {
        return fechaHoraLimite;
    }

    /**
     * Establece la fecha y hora límite para realizar el retiro.
     * 
     * @param fechaHoraLimite La nueva fecha y hora límite para realizar el retiro.
     */
    public void setFechaHoraLimite(String fechaHoraLimite) {
        this.fechaHoraLimite = fechaHoraLimite;
    }

    /**
     * Obtiene el estado de la solicitud de retiro.
     * 
     * @return El estado de la solicitud de retiro.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la solicitud de retiro.
     * 
     * @param estado El nuevo estado de la solicitud de retiro.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
