/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import ConexionBD.IConexionBD;
import DTOs.CuentaDTO;
import Exepciones.PersistenciaException;
import IDAOs.ICuentaDAO;
import dominio.Cuenta;
import java.sql.CallableStatement;
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
 * Clase que implementa la interfaz ICuentaDAO para realizar operaciones de acceso a datos relacionadas con la entidad Cuenta.
 * 
 * @author favel
 * @version 1.0
 */
public class CuentaDAO implements ICuentaDAO {
    IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    /**
     * Constructor de la clase CuentaDAO.
     * 
     * @param conexion La conexión a la base de datos que se utilizará para realizar las operaciones.
     */
    public CuentaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cuenta agregar(CuentaDTO Cuenta) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Cuentas (numero_cuenta, estado, fecha_apertura, saldo, id_cliente) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {

            comandoSQL.setInt(1, Cuenta.getNum_Cuenta());
            comandoSQL.setString(2, Cuenta.getEstado());
            comandoSQL.setString(3, Cuenta.getFechaApertura());
            comandoSQL.setInt(4, Cuenta.getSaldo());
            comandoSQL.setInt(5, Cuenta.getID_Cliente());

            int res = comandoSQL.executeUpdate();

            ResultSet resultado = comandoSQL.getGeneratedKeys();
            resultado.next();
            Cuenta Cuentanueva = new Cuenta(resultado.getInt(1), Cuenta.getNum_Cuenta(), Cuenta.getEstado(), Cuenta.getFechaApertura(), Cuenta.getSaldo(), Cuenta.getID_Cliente());

            return Cuentanueva;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se creo la cuenta", e);
            throw new PersistenciaException("No se agrego la cuenta", e);
        }
    }

    @Override
    public Cuenta actualizar(Cuenta Cuenta) throws PersistenciaException {
        String sentenciaSQL = "{CALL ActualizarSaldo(?, ?)}";

        try (
                Connection conexion = this.conexion.crearConexion(); CallableStatement comandoSQL = conexion.prepareCall(sentenciaSQL);) {
            comandoSQL.setInt(1, Cuenta.getNum_Cuenta());
            comandoSQL.setFloat(2, Cuenta.getSaldo());

            int res = comandoSQL.executeUpdate();

            if (res > 0) {
                LOG.log(Level.INFO, "Saldo actualizado con éxito");
                return Cuenta;
            } else {
                LOG.log(Level.SEVERE, "No se actualizó el saldo");
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se agrego el saldo", e);
            throw new PersistenciaException("No se agrego el saldo", e);
        }
        return null;
    }

    @Override
    public Cuenta eliminar(Cuenta cuenta) throws PersistenciaException {
        String sentenciaSQL = "UPDATE Cuentas SET estado = 'Inactiva' WHERE numero_cuenta = ? AND saldo = 0";

        try (Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL)) {

            comandoSQL.setInt(1, cuenta.getNum_Cuenta());

            int res = comandoSQL.executeUpdate();

            if (res > 0) {
                LOG.log(Level.INFO, "Cuenta borrada con éxito");
                return cuenta;
            } else {
                LOG.log(Level.SEVERE, "No se puede borrar una cuenta con saldo activo");
                throw new PersistenciaException("No se pudo borrar la cuenta porque el saldo no es cero");
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se borró la cuenta", e);
            throw new PersistenciaException("No se pudo borrar la cuenta", e);
        }
    }

    @Override
    public List<Cuenta> consultar() throws PersistenciaException {
        List<Cuenta> cuentas = new ArrayList<>();

        String sentenciaSQL = "SELECT * FROM Cuentas";

        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL); ResultSet resultado = comandoSQL.executeQuery();) {
            while (resultado.next()) {
                int numeroCuenta = resultado.getInt("numero_cuenta");
                String estado = resultado.getString("estado");
                int saldo = resultado.getInt("saldo");
                int idCliente = resultado.getInt("id_cliente");

                Cuenta cuenta = new Cuenta(numeroCuenta, estado, saldo, idCliente);
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al consultar cuentas", e);
            throw new PersistenciaException("Error al consultar cuentas", e);
        }

        return cuentas;
    }
}
