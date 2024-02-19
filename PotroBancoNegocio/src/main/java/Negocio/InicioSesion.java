/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import ConexionBD.ConexionBD;
import ConexionBD.IConexionBD;
import DAOs.ClienteDAO;
import DTOs.ClienteDTO;
import IDAOs.IClienteDAO;
import dominio.Cliente;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que proporciona métodos para iniciar sesión de usuarios en el sistema.
 * 
 * @author favel
 * @version 1.0
 */
public class InicioSesion {

    IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    /**
     * Realiza el inicio de sesión para el usuario especificado.
     * 
     * @param usuario El nombre de usuario proporcionado.
     * @param contraseña La contraseña proporcionada.
     * @return El objeto Cliente correspondiente al usuario que inició sesión, o null si las credenciales son incorrectas.
     */
    public Cliente inicioSesion(String usuario, String contraseña) {

        List<String> camposVacios = new ArrayList<>();
        if (usuario.isEmpty()) {
            camposVacios.add("Nombre");
        }
        if (contraseña.isEmpty()) {
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
            IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
            ClienteDTO clienteNuevo = new ClienteDTO(usuario, contraseña);

            try {
                Cliente clienteLogueado = clienteDAO.iniciarSesion(clienteNuevo);
                if (clienteLogueado != null) {
                    return clienteLogueado;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Ha ocurrido un error al intentar iniciar sesión.", e);
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar iniciar sesión.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
    
}

