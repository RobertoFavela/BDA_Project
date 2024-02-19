/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import ConexionBD.IConexionBD;
import Exepciones.PersistenciaException;
import IDAOs.IRetiroDAO;
import dominio.Operacion;
import dominio.Retiro;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que implementa la interfaz IRetiroDAO para realizar operaciones de acceso a datos relacionadas con la entidad Retiro.
 * 
 * @author favel
 * @version 1.0
 */
public class RetiroDAO implements IRetiroDAO {
    IConexionBD conexion;
    public static final Logger LOG = Logger.getLogger(Connection.class.getName());

    /**
     * Constructor de la clase RetiroDAO.
     * 
     * @param conexion La conexión a la base de datos que se utilizará para realizar las operaciones.
     */
    public RetiroDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Retiro agregar(Operacion operacion) throws PersistenciaException {
        String sentenciaSQL = "{CALL CrearRetiro(?, ?, ?)}";
        int folio;
        int contrasena;

        try (
                Connection conexion = this.conexion.crearConexion(); CallableStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            comandoSQL.setInt(1, operacion.getId());
            comandoSQL.registerOutParameter(2, Types.INTEGER);
            comandoSQL.registerOutParameter(3, Types.INTEGER);
            comandoSQL.execute();
            folio = comandoSQL.getInt(2);
            contrasena = comandoSQL.getInt(3);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se agrego el retiro", e);
            throw new PersistenciaException("No se agrego el retiro", e);
        }

        // Aquí puedes crear y devolver un objeto Retiro con el folio y la contraseña
        // Por ejemplo:
        Retiro retiro = new Retiro();
        retiro.setFolio(folio);
        retiro.setContraseña(contrasena);
        return retiro;
    }

    @Override
    public List<Retiro> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retiro retirar(Retiro retiro) throws PersistenciaException {
        String callProcedureSQL = "{CALL RealizarRetiro(?, ?, ?)}";
        try (Connection conexion = this.conexion.crearConexion(); CallableStatement callableStatement = conexion.prepareCall(callProcedureSQL)) {
            callableStatement.setInt(1, retiro.getFolio());
            callableStatement.setInt(2, retiro.getContraseña());
            callableStatement.registerOutParameter(3, Types.FLOAT);
            callableStatement.execute();
            float monto = callableStatement.getFloat(3);
            if (monto != 0) {
                JOptionPane.showMessageDialog(null, "Retiro cobrado: " + monto);
                return retiro;  // Retiro exitoso
            } else {
                JOptionPane.showMessageDialog(null, "Folio o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo realizar el retiro", e);
            throw new PersistenciaException("No se pudo realizar el retiro", e);
        }
        return null;  // Retiro no exitoso
    }
}
