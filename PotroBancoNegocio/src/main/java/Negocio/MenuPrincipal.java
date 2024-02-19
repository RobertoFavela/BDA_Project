/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import ConexionBD.ConexionBD;
import DAOs.CuentaDAO;
import Exepciones.PersistenciaException;
import dominio.Cliente;
import dominio.Cuenta;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que proporciona métodos para llenar una tabla en el menú principal con información de cuentas de un cliente.
 * 
 * @author favel
 * @version 1.0
 */
public class MenuPrincipal {
    
    ConexionBD con = new ConexionBD();
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());
    
    /**
     * Llena la tabla con información de cuentas activas del cliente especificado.
     * 
     * @param cliente El cliente del cual se mostrarán las cuentas activas en la tabla.
     * @param tabla La tabla donde se mostrará la información de las cuentas.
     * @throws PersistenciaException Si ocurre un error al consultar las cuentas desde la base de datos.
     */
    public void llenarTabla(Cliente cliente, JTable tabla) throws PersistenciaException {
        CuentaDAO c = new CuentaDAO(con);
        List<Cuenta> cuentas = c.consultar();
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);
        cuentas.stream()
                .filter(Cuenta -> Cuenta.getID_Cliente() == cliente.getId())
                .filter(Cuenta -> "Activa".equals(Cuenta.getEstado()))
                .forEach(Cuenta -> {
                    Object[] filas = new Object[2];
                    filas[0] = Cuenta.getNum_Cuenta();
                    filas[1] = Cuenta.getSaldo();
                    modeloTabla.addRow(filas);
                });
    }
}

