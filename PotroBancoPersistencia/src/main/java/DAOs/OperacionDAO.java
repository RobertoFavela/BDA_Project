/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import ConexionBD.IConexionBD;
import Exepciones.PersistenciaException;
import IDAOs.IOperacionDAO;
import dominio.Operacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IOperacionDAO para realizar operaciones de acceso a datos relacionadas con la entidad Operacion.
 * 
 * @author favel
 * @version 1.0
 */
public class OperacionDAO implements IOperacionDAO {
    IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());
    
    /**
     * Constructor de la clase OperacionDAO.
     * 
     * @param conexion La conexión a la base de datos que se utilizará para realizar las operaciones.
     */
    public OperacionDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Operacion agregar(Operacion operacion) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Operaciones (tipo, fecha_hora, monto, numero_cuenta) VALUES (?, ?, ?, ?)";

        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            comandoSQL.setString(1, operacion.getTipo());
            comandoSQL.setString(2, operacion.getFechaHora());
            comandoSQL.setInt(3, operacion.getMonto());
            comandoSQL.setInt(4, operacion.getId_Cuenta());

            int res = comandoSQL.executeUpdate();

            ResultSet resultado = comandoSQL.getGeneratedKeys();
            resultado.next();
            Operacion Operacionnueva = new Operacion(resultado.getInt(1), operacion.getTipo(), operacion.getFechaHora(), operacion.getMonto(), operacion.getId_Cuenta());

            return Operacionnueva;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se creo la operacion", e);
            throw new PersistenciaException("No se agrego la operacion", e);
        }
    }

    @Override
    public List<Operacion> consultar(int idCliente) throws PersistenciaException {
        List<Operacion> operaciones = new ArrayList<>();

    String sentenciaSQL = "SELECT Operaciones.* FROM Operaciones "
                        + "INNER JOIN Cuentas ON Operaciones.numero_cuenta = Cuentas.numero_cuenta "
                        + "WHERE Cuentas.id_cliente = ?";

    try (
            Connection conexion = this.conexion.crearConexion(); 
            PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
        ) {
        comandoSQL.setInt(1, idCliente);
        ResultSet resultado = comandoSQL.executeQuery();
        while (resultado.next()) {
            String tipo = resultado.getString("tipo");
            String fecha = resultado.getString("fecha_hora");
            int monto = resultado.getInt("monto");
            int numeroCuenta = resultado.getInt("numero_cuenta");

            Operacion operacion = new Operacion(tipo, fecha, monto, numeroCuenta);
            operaciones.add(operacion);
        }
    } catch (SQLException e) {
        LOG.log(Level.SEVERE, "Error al consultar operaciones", e);
        throw new PersistenciaException("Error al consultar operaciones", e);
    }

    return operaciones;
    }
}
