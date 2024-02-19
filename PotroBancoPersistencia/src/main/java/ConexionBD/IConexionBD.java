/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Define un contrato para crear conexiones a una base de datos.
 * 
 * @author favel
 * @version 1.0
 */
public interface IConexionBD {
    /**
     * Crea y devuelve una conexión a la base de datos.
     * 
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error al crear la conexión.
     */
    public Connection crearConexion() throws SQLException;
}
