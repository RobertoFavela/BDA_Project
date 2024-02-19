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
 * La clase Registro se encarga de manejar las operaciones relacionadas con el registro y edición de clientes en el sistema.
 * 
 * @author favel
 */
public class Registro {

    IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    /**
     * Realiza el registro de un nuevo cliente en el sistema.
     *
     * @param nombre El nombre completo del cliente.
     * @param usuario El nombre de usuario del cliente.
     * @param contraseña La contraseña del cliente.
     * @param domicilio El domicilio del cliente.
     * @param fechaNacimiento La fecha de nacimiento del cliente en formato
     * YYYY-MM-DD.
     * @return true si el registro se completó con éxito, false en caso
     * contrario.
     */
    public boolean Registrar(String nombre, String usuario, String contraseña, String domicilio, String fechaNacimiento) {
        String formatoFecha = "\\d{4}-\\d{2}-\\d{2}";

        List<String> camposVacios = new ArrayList<>();
        if (nombre.isEmpty()) {
            camposVacios.add("Nombre");
        }
        if (contraseña.isEmpty()) {
            camposVacios.add("Contraseña");
        }
        if (domicilio.isEmpty()) {
            camposVacios.add("Domicilio");
        }
        if (fechaNacimiento.isEmpty()) {
            camposVacios.add("Fecha de Nacimiento");
        }
        if (!fechaNacimiento.matches(formatoFecha)) {
            camposVacios.add("Formato de Fecha Incorrecto (debe ser YYYY-MM-DD)");
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
            IClienteDAO ClienteDAO = new ClienteDAO(conexionBD);
            ClienteDTO clienteNuevo = new ClienteDTO(nombre, usuario, contraseña, fechaNacimiento, domicilio);

            try {
                Cliente clienteGuardado = ClienteDAO.agregar(clienteNuevo);
                LOG.log(Level.INFO, clienteGuardado.toString());

                JOptionPane.showMessageDialog(null, "El cliente se ha registrado correctamente.\nYa puede iniciar sesión", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "No se pudo agregar", e);
                JOptionPane.showMessageDialog(null, "Nombre de usuario ya registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }

    /**
     * Permite editar la información de un cliente registrado en el sistema.
     *
     * @param cliente El objeto Cliente que se desea editar.
     * @param nombre El nuevo nombre completo del cliente.
     * @param usuario El nuevo nombre de usuario del cliente.
     * @param domicilio El nuevo domicilio del cliente.
     * @param fechaNacimiento La nueva fecha de nacimiento del cliente en
     * formato YYYY-MM-DD.
     * @return true si la edición se completó con éxito, false en caso
     * contrario.
     */
    public boolean EditarRegistro(Cliente cliente, String nombre, String usuario, String domicilio, String fechaNacimiento) {
        String formatoFecha = "\\d{4}-\\d{2}-\\d{2}";

        List<String> camposVacios = new ArrayList<>();
        if (nombre.isEmpty()) {
            camposVacios.add("Nombre");
        }
        if (usuario.isEmpty()) {
            camposVacios.add("Usuario");
        }
        if (domicilio.isEmpty()) {
            camposVacios.add("Domicilio");
        }
        if (fechaNacimiento.isEmpty()) {
            camposVacios.add("Fecha de Nacimiento");
        }
        if (!fechaNacimiento.matches(formatoFecha)) {
            camposVacios.add("Formato de Fecha Incorrecto (debe ser YYYY-MM-DD)");
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
            IClienteDAO ClienteDAO = new ClienteDAO(conexionBD);
            Cliente clienteActualizado = new Cliente(cliente.getId(), nombre, usuario, fechaNacimiento, domicilio);

            try {
                System.out.println(usuario);
                System.out.println(clienteActualizado.getUsuario());
                Cliente clienteGuardado = ClienteDAO.actualizar(clienteActualizado);
                LOG.log(Level.INFO, clienteGuardado.toString());
//                dispose();
//                new Menu_Principal(cliente).setVisible(true);
                JOptionPane.showMessageDialog(null, "El cliente se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "No se pudo agregar", e);
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar actualizar al cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

}
