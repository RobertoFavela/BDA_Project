/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import ConexionBD.ConexionBD;
import ConexionBD.IConexionBD;
import DAOs.CuentaDAO;
import DAOs.OperacionDAO;
import DAOs.RetiroDAO;
import DAOs.TransferenciaDAO;
import Exepciones.PersistenciaException;
import IDAOs.ICuentaDAO;
import IDAOs.IOperacionDAO;
import IDAOs.IRetiroDAO;
import IDAOs.ITransferenciaDAO;
import dominio.Cliente;
import dominio.Cuenta;
import dominio.Operacion;
import dominio.Retiro;
import dominio.Transferencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que proporciona métodos para realizar operaciones relacionadas con
 * cuentas bancarias.
 *
 * @author favel
 * @version 1.0
 */
public class Operaciones {

    ConexionBD con = new ConexionBD();

    /**
     * Agrega saldo a una cuenta bancaria.
     *
     * @param cliente El cliente asociado a la cuenta.
     * @param saldo El saldo a agregar.
     * @param numCuenta El número de la cuenta a la que se agregará el saldo.
     * @return true si se agrega el saldo correctamente, false si ocurre un
     * error.
     */
    public boolean agregarSaldo(Cliente cliente, int saldo, int numCuenta) {
        Logger LOG = Logger.getLogger(Connection.class.getName());
        IConexionBD conexionBD = new ConexionBD();
        ICuentaDAO CuentaDAO = new CuentaDAO(conexionBD);
        Cuenta cuentaActualizada = new Cuenta(numCuenta, saldo);

        try {
            Cuenta cuentaGuardada = CuentaDAO.actualizar(cuentaActualizada);
            LOG.log(Level.INFO, cuentaGuardada.toString());
            JOptionPane.showMessageDialog(null, "El saldo se ha agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar", e);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar actualizar la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Obtiene el estado de una cuenta bancaria dado su número de cuenta.
     *
     * @param numeroCuenta El número de cuenta del cual se desea obtener el
     * estado.
     * @return El estado de la cuenta (activo o inactivo).
     * @throws PersistenciaException Si ocurre un error al obtener el estado de
     * la cuenta.
     */
    private String ObtenerEstadoCuenta(int numeroCuenta) throws PersistenciaException {
        String consultaEstadoCuenta = "SELECT estado FROM Cuentas WHERE numero_cuenta = ?";
        try (
                Connection conexion = this.con.crearConexion(); PreparedStatement consultaEstado = conexion.prepareStatement(consultaEstadoCuenta);) {
            consultaEstado.setInt(1, numeroCuenta);
            ResultSet resultadoEstado = consultaEstado.executeQuery();
            if (resultadoEstado.next()) {
                return resultadoEstado.getString("estado");
            } else {
                throw new PersistenciaException("No se encontró la cuenta destino.");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener el estado de la cuenta destino.", e);
        }
    }

    /**
     * Transfiere fondos entre dos cuentas bancarias.
     *
     * @param Saldo El monto a transferir.
     * @param seleccion El número de cuenta de origen.
     * @param destino El número de cuenta de destino.
     * @return true si la transferencia se realiza correctamente, false si
     * ocurre un error.
     */
    public boolean Transferir(int Saldo, int seleccion, int destino) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaApertura = dateFormat.format(new Date());

        Operacion op = new Operacion("Transferencia", fechaApertura, Saldo, seleccion);
        Transferencia transferencia = new Transferencia(destino);

        Logger LOG = Logger.getLogger(Connection.class.getName());
        IConexionBD conexionBD = new ConexionBD();
        IOperacionDAO OperacionDAO = new OperacionDAO(conexionBD);
        ITransferenciaDAO TransferenciaDAO = new TransferenciaDAO(conexionBD);

        try {
            String estadoCuentaDestino = ObtenerEstadoCuenta(destino);
            if (!estadoCuentaDestino.equals("Activa")) {
                JOptionPane.showMessageDialog(null, "La cuenta destino no está activa. La transferencia no se puede realizar.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            Operacion operacionGuardada = OperacionDAO.agregar(op);
            Transferencia transferenciaGuardada = TransferenciaDAO.agregar(operacionGuardada, transferencia);

            LOG.log(Level.INFO, op.toString());
            JOptionPane.showMessageDialog(null, "Operacion creada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (PersistenciaException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar", e);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Llena una tabla con el historial de operaciones de un cliente.
     *
     * @param cliente El cliente del cual se mostrará el historial de
     * operaciones.
     * @param tabla La tabla donde se mostrará el historial de operaciones.
     * @param tipoOperacion El tipo de operación a mostrar ("Todos" para mostrar
     * todas las operaciones).
     */
    public void llenarTablaHistorial(Cliente cliente, JTable tabla, String tipoOperacion) {
        try {
            OperacionDAO op = new OperacionDAO(con);
            List<Operacion> operaciones = op.consultar(cliente.getId());
            DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
            modeloTabla.setRowCount(0);

            operaciones.forEach(operacion -> {
                if (tipoOperacion.equalsIgnoreCase(operacion.getTipo()) || tipoOperacion.equalsIgnoreCase("Todos")) {
                    Object[] fila = new Object[4];
                    fila[0] = operacion.getTipo();
                    fila[1] = operacion.getId_Cuenta();
                    fila[2] = operacion.getFechaHora();
                    fila[3] = operacion.getMonto();
                    modeloTabla.addRow(fila);
                }
            });
        } catch (PersistenciaException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "No se pudo consultar la tabla", ex);
        }
    }

    /**
     * Genera un folio de retiro y una contraseña para realizar un retiro de
     * fondos.
     *
     * @param Saldo El saldo a retirar.
     * @param fechaApertura La fecha y hora de la operación.
     * @param seleccion El número de cuenta de la cual se retirarán los fondos.
     * @return true si se genera el folio y la contraseña correctamente, false
     * si ocurre un error.
     * @throws SQLException Si ocurre un error de SQL.
     * @throws PersistenciaException Si ocurre un error de persistencia.
     */
    public boolean generarFolio(int Saldo, String fechaApertura, int seleccion) throws SQLException, PersistenciaException {
        Logger LOG = Logger.getLogger(Connection.class.getName());
        IConexionBD conexionBD = new ConexionBD();
        Connection con = conexionBD.crearConexion();

        ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
        Operacion op = new Operacion("Retiro", fechaApertura, Saldo, seleccion);
        OperacionDAO operacionDAO = new OperacionDAO(conexionBD);
        op = operacionDAO.agregar(op);

        RetiroDAO retiroDAO = new RetiroDAO(conexionBD);

        try {
            CallableStatement comandoSQL = con.prepareCall("{CALL CrearRetiro(?, ?, ?)}");
            comandoSQL.setInt(1, op.getId());
            comandoSQL.registerOutParameter(2, Types.INTEGER);
            comandoSQL.registerOutParameter(3, Types.INTEGER);
            comandoSQL.execute();

            int folio = comandoSQL.getInt(2);
            int contrasena = comandoSQL.getInt(3);

            JOptionPane.showMessageDialog(null, "Folio: " + folio + "\nContraseña: " + contrasena, "Información de retiro", JOptionPane.INFORMATION_MESSAGE);

            LOG.log(Level.INFO, "Retiro guardado correctamente");

            return true;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo generar folio y contraseña", e);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar generar folio y contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Realiza un retiro de fondos utilizando un folio y una contraseña.
     *
     * @param folio El folio de retiro.
     * @param contraseña La contraseña de retiro.
     * @return true si se realiza el retiro correctamente, false si ocurre un
     * error.
     */
    public boolean Retirar(int folio, int contraseña) {
        List<String> camposVacios = new ArrayList<>();
        if (folio == 0) {
            camposVacios.add("Folio");
        }
        if (contraseña == 0) {
            camposVacios.add("Contraseña");
        }

        if (!camposVacios.isEmpty()) {
            StringBuilder mensaje = new StringBuilder("Los siguientes campos son obligatorios o tienen formato incorrecto:\n");
            for (String campo : camposVacios) {
                mensaje.append("- ").append(campo).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Logger LOG = Logger.getLogger(Connection.class.getName());
            IConexionBD conexionBD = new ConexionBD();
            IRetiroDAO retiroDAO = new RetiroDAO(conexionBD);

            try {
                Retiro re = new Retiro(folio, contraseña);
                Retiro retiro = retiroDAO.retirar(re);
                if (retiro != null) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Folio o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Ha ocurrido un error al intentar realizar el retiro.", e);
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar realizar el retiro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
}
