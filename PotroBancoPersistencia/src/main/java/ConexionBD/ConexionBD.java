/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementa la interfaz IConexionBD para crear conexiones a una base de datos.
 * 
 * Utiliza el framework de logging de Java para registrar información sobre las conexiones creadas.
 * 
 * @author favel
 * @version 1.0
 */
public class ConexionBD implements IConexionBD {
    // Cadena de conexión a la base de datos MySQL
    final String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    // Nombre de usuario de la base de datos
    final String usuario = "root";
    // Contraseña de la base de datos
    final String contra = "lamparacool14";

    // Logger para registrar información de las conexiones
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());

    /**
     * Crea y devuelve una conexión a la base de datos.
     * 
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al crear la conexión.
     */
    @Override
    public Connection crearConexion() throws SQLException {
        // Intenta establecer la conexión con la base de datos
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra);

        // Registra un mensaje de información sobre la conexión creada
        LOG.log(Level.INFO, "Conexión creada para el usuario: " + usuario, this);

        // Devuelve la conexión establecida
        return conexion;
    }
}
