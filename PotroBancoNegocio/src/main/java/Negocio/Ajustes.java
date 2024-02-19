/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import ConexionBD.ConexionBD;
import ConexionBD.IConexionBD;
import DAOs.CuentaDAO;
import DTOs.CuentaDTO;
import IDAOs.ICuentaDAO;
import dominio.Cliente;
import dominio.Cuenta;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que proporciona métodos para realizar ajustes en las cuentas de los clientes.
 * 
 * @author favel
 * @version 1.0
 */
public class Ajustes {
    
    /**
     * Genera un número de cuenta aleatorio de 8 dígitos.
     * 
     * @return Un número de cuenta aleatorio de 8 dígitos.
     */
    private int generateRandomAccountNumber() {
        Random random = new Random();
        int min = 10000000; // Mínimo número de cuenta de 8 dígitos
        int max = 99999999; // Máximo número de cuenta de 8 dígitos
        return random.nextInt(max - min + 1) + min;
    }
    
    /**
     * Crea una nueva cuenta para el cliente especificado.
     * 
     * @param cliente El cliente para el cual se va a crear la cuenta.
     * @return true si la cuenta se crea correctamente, false en caso contrario.
     */
    public boolean crearCuenta(Cliente cliente) {
        Logger LOG = Logger.getLogger(Connection.class.getName());
        IConexionBD conexionBD = new ConexionBD();
        ICuentaDAO CuentaDAO = new CuentaDAO(conexionBD);

        int numeroCuenta = generateRandomAccountNumber();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaApertura = dateFormat.format(new Date());

        CuentaDTO cuentaNueva = new CuentaDTO(numeroCuenta, "Activa", fechaApertura, 0, cliente.getId());

        try {
            Cuenta cuentaGuardada = CuentaDAO.agregar(cuentaNueva);
            LOG.log(Level.INFO, cuentaGuardada.toString());
            JOptionPane.showMessageDialog(null, "Cuenta creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar", e);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar crear la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    /**
     * Elimina la cuenta seleccionada del cliente especificado.
     * 
     * @param cliente El cliente al que pertenece la cuenta a eliminar.
     * @param seleccion El número de cuenta seleccionado para eliminar.
     * @return true si la cuenta se elimina correctamente, false en caso contrario.
     */
    public boolean eliminarCuenta(Cliente cliente, int seleccion) {

        Logger LOG = Logger.getLogger(Connection.class.getName());
        IConexionBD conexionBD = new ConexionBD();
        ICuentaDAO CuentaDAO = new CuentaDAO(conexionBD);
        Cuenta cuentaActualizada = new Cuenta(seleccion);

        try {
            Cuenta cuentaGuardada = CuentaDAO.eliminar(cuentaActualizada);
            LOG.log(Level.INFO, cuentaGuardada.toString());
            JOptionPane.showMessageDialog(null, "La cuenta se ha borrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo borrar", e);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar borrar la cuenta.\nNo se pueden borrar cuentas con saldo activo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}

