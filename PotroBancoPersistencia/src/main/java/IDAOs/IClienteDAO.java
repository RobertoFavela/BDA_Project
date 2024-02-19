/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAOs;

import DTOs.ClienteDTO;
import Exepciones.PersistenciaException;
import dominio.Cliente;
import dominio.Cuenta;
import java.util.List;

/**
 * Define las operaciones que pueden realizarse sobre la entidad Cliente en la capa de acceso a datos.
 * 
 * @author favel
 * @version 1.0
 */
public interface IClienteDAO {
    /**
     * Agrega un nuevo cliente a la fuente de datos.
     * 
     * @param cliente El cliente a agregar, representado como un objeto ClienteDTO.
     * @return El cliente agregado.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Cliente agregar(ClienteDTO cliente) throws PersistenciaException;
    
    /**
     * Actualiza la información de un cliente en la fuente de datos.
     * 
     * @param cliente El cliente con la información actualizada.
     * @return El cliente actualizado.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Cliente actualizar(Cliente cliente) throws PersistenciaException;
    
    /**
     * Inicia sesión de un cliente en el sistema.
     * 
     * @param cliente El cliente que intenta iniciar sesión, representado como un objeto ClienteDTO.
     * @return El cliente que inició sesión.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Cliente iniciarSesion(ClienteDTO cliente) throws PersistenciaException;
    
    /**
     * Consulta las cuentas asociadas a un cliente en la fuente de datos.
     * 
     * @param cliente El cliente para el cual se desean consultar las cuentas.
     * @return Una lista de cuentas asociadas al cliente.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public List<Cuenta> consultar(Cliente cliente) throws PersistenciaException;
}