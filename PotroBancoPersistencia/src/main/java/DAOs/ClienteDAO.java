/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import ConexionBD.IConexionBD;
import DTOs.ClienteDTO;
import Exepciones.PersistenciaException;
import IDAOs.IClienteDAO;
import dominio.Cliente;
import dominio.Cuenta;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
 * Clase que implementa la interfaz IClienteDAO para realizar operaciones de acceso a datos relacionadas con la entidad Cliente.
 * 
 * @author favel
 * @version 1.0
 */
public class ClienteDAO implements IClienteDAO {

    private int clienteID;
    IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());
    private static final String ALGORITHM = "SHA-256";

    /**
     * Constructor de la clase ClienteDAO.
     * 
     * @param conexion La conexión a la base de datos que se utilizará para realizar las operaciones.
     */
    public ClienteDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    public Cliente agregar(ClienteDTO cliente) throws PersistenciaException {
        String sentenciaConsulta = "SELECT COUNT(*) AS contador FROM Clientes WHERE usuario = ?";
        String sentenciaInsercion = "INSERT INTO Clientes (nombre, usuario, contraseña_hash, fecha_nacimiento, domicilio) VALUES (?, ?, ?, ?, ?)";
        try (
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement consulta = conexion.prepareStatement(sentenciaConsulta);
            PreparedStatement insercion = conexion.prepareStatement(sentenciaInsercion, Statement.RETURN_GENERATED_KEYS);
        ) {
            // Verificar si ya existe un cliente con el mismo usuario
            consulta.setString(1, cliente.getUsuario());
            ResultSet resultadoConsulta = consulta.executeQuery();
            resultadoConsulta.next();
            int contador = resultadoConsulta.getInt("contador");

            if (contador > 0) {
                // Ya existe un cliente con el mismo usuario, toma un null
                return null;
            }

            // Calcular el hash de la contraseña
            String contraseñaHash = calcularHash(cliente.getContraseña());

            // Insertar el nuevo cliente si todo sale bien
            insercion.setString(1, cliente.getNombre());
            insercion.setString(2, cliente.getUsuario());
            insercion.setString(3, contraseñaHash); // Almacenar el hash en la base de datos
            insercion.setString(4, cliente.getFechaNacimiento());
            insercion.setString(5, cliente.getDomilicio());
            int res = insercion.executeUpdate();
            ResultSet resultado = insercion.getGeneratedKeys();
            resultado.next();
            Cliente clienteNuevo = new Cliente(resultado.getInt(1), cliente.getNombre(), cliente.getUsuario(), cliente.getContraseña(), cliente.getFechaNacimiento(), cliente.getDomilicio());
            return clienteNuevo;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al agregar el cliente", e);
            throw new PersistenciaException("Error al agregar el cliente", e);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método privado para calcular el hash SHA-256 de una contraseña.
     * 
     * @param contraseña La contraseña de la cual se calculará el hash.
     * @return El hash SHA-256 de la contraseña.
     * @throws NoSuchAlgorithmException Si no se encuentra el algoritmo de hash.
     */
    private String calcularHash(String contraseña) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
        byte[] hashBytes = digest.digest(contraseña.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte hashByte : hashBytes) {
            stringBuilder.append(String.format("%02x", hashByte)); // Convertir cada byte del hash a su representación hexadecimal
        }
        return stringBuilder.toString();
    }

    @Override
    public Cliente actualizar(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = "UPDATE Clientes SET domicilio = ?, usuario = ?, fecha_nacimiento = ?, nombre = ? WHERE id_cliente = ?";
        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);) {
            comandoSQL.setString(1, cliente.getDomilicio());
            comandoSQL.setString(2, cliente.getUsuario());
            comandoSQL.setString(3, cliente.getFechaNacimiento());
            comandoSQL.setString(4, cliente.getNombre());
            comandoSQL.setInt(5, cliente.getId());
            int res = comandoSQL.executeUpdate();
            if (res > 0) {
                LOG.log(Level.INFO, "Cliente actualizado con éxito");
                return cliente;
            } else {
                LOG.log(Level.SEVERE, "No se actualizó el cliente");
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se actualizo el cliente", e);
            throw new PersistenciaException("No se actualizo el cliente", e);
        }
        return null;
    }

    public Cliente iniciarSesion(ClienteDTO cliente) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Clientes WHERE usuario = ?";
        Cliente clienteLogueado = null;
        try (
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
        ) {
            comandoSQL.setString(1, cliente.getUsuario());
            ResultSet resultado = comandoSQL.executeQuery();
            if (resultado.next()) {
                String contraseñaAlmacenada = resultado.getString("contraseña_hash");
                String contraseñaIngresada = cliente.getContraseña();
                // Calcular el hash de la contraseña ingresada
                String contraseñaIngresadaHash = calcularHash(cliente.getContraseña());
                // Comparar el hash de la contraseña ingresada con el hash almacenado en la base de datos
                if (contraseñaAlmacenada.equals(contraseñaIngresadaHash)) {
                    LOG.log(Level.INFO, "Inicio de sesion realizado con éxito");
                    int id = resultado.getInt("id_cliente");
                    String nombre = resultado.getString("nombre");
                    String usuario = resultado.getString("usuario");
                    String fecha_nacimiento = resultado.getString("fecha_nacimiento");
                    String domicilio = resultado.getString("domicilio");
                    clienteLogueado = new Cliente(id, nombre, usuario, fecha_nacimiento, domicilio);
                } else {
                    LOG.log(Level.SEVERE, "Contraseña incorrecta");
                }
            } else {
                LOG.log(Level.SEVERE, "Usuario no encontrado");
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al iniciar sesión", e);
            throw new PersistenciaException("Error al iniciar sesión", e);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "La verdad ni se que paso pero no funciono", ex);
        }
        return clienteLogueado;
    }

    @Override
    public List<Cuenta> consultar(Cliente cliente) throws PersistenciaException {
        List<Cuenta> cuentas = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM Cuentas WHERE id_cliente = ?";

        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);) {
            comandoSQL.setInt(1, cliente.getId());
            ResultSet resultado = comandoSQL.executeQuery();

            while (resultado.next()) {
                int id_cuenta = resultado.getInt("id_cuenta");
                int numero_cuenta = resultado.getInt("numero_cuenta");
                String estado = resultado.getString("estado");
                String fecha_apertura = resultado.getString("fecha_apertura");
                int saldo = resultado.getInt("saldo");
                int id_cliente = resultado.getInt("id_cliente");

                Cuenta cuenta = new Cuenta(id_cuenta, numero_cuenta, estado, fecha_apertura, saldo, id_cliente);
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo consultar las cuentas", e);
            throw new PersistenciaException("No se pudo consultar las cuentas", e);
        }

        return cuentas;
    }
}
