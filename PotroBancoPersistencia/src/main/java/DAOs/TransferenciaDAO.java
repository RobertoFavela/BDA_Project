/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import ConexionBD.IConexionBD;
import Exepciones.PersistenciaException;
import IDAOs.ITransferenciaDAO;
import dominio.Operacion;
import dominio.Transferencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz ITransferenciaDAO para realizar operaciones de acceso a datos relacionadas con la entidad Transferencia.
 * 
 * @author favel
 * @version 1.0
 */
public class TransferenciaDAO implements ITransferenciaDAO {
    IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    /**
     * Constructor de la clase TransferenciaDAO.
     * 
     * @param conexion La conexión a la base de datos que se utilizará para realizar las operaciones.
     */
    public TransferenciaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Transferencia agregar(Operacion operacion, Transferencia transferencia) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Transferencias (id_operacion, cuenta_envio) VALUES (?, ?)";

        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            // Verificar el estado de la cuenta destino
            String consultaEstadoCuentaDestino = "SELECT estado FROM Cuentas WHERE numero_cuenta = ?";
            try (PreparedStatement consultaEstado = conexion.prepareStatement(consultaEstadoCuentaDestino)) {
                consultaEstado.setInt(1, transferencia.getCuentaEnvio());
                ResultSet resultadoEstado = consultaEstado.executeQuery();
                if (resultadoEstado.next()) {
                    String estadoCuenta = resultadoEstado.getString("estado");
                    if (!estadoCuenta.equals("Activa")) {
                        throw new PersistenciaException("La cuenta destino no está activa. La transferencia no se puede realizar.");
                    }
                } else {
                    throw new PersistenciaException("No se encontró la cuenta destino.");
                }
            }

            comandoSQL.setInt(1, operacion.getId());
            comandoSQL.setInt(2, transferencia.getCuentaEnvio());

            int res = comandoSQL.executeUpdate();

            ResultSet resultado = comandoSQL.getGeneratedKeys();
            resultado.next();
            Transferencia Transferencianueva = new Transferencia(resultado.getInt(1), transferencia.getCuentaEnvio(), operacion.getTipo(), operacion.getFechaHora(), operacion.getMonto(), operacion.getId_Cuenta());

            return Transferencianueva;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se creo la transferencia", e);
            throw new PersistenciaException("No se agrego la transferencia", e);
        }
    }

    @Override
    public List<Transferencia> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
