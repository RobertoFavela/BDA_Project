/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAOs;

import Exepciones.PersistenciaException;
import dominio.Operacion;
import java.util.List;

/**
 * Define las operaciones que pueden realizarse sobre la entidad Operacion en la capa de acceso a datos.
 * 
 * @author favel
 * @version 1.0
 */
public interface IOperacionDAO {
    /**
     * Agrega una nueva operación a la fuente de datos.
     * 
     * @param operacion La operación a agregar.
     * @return La operación agregada.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Operacion agregar(Operacion operacion) throws PersistenciaException;
    
    /**
     * Consulta todas las operaciones asociadas a un cliente en la fuente de datos.
     * 
     * @param idCliente El ID del cliente para el cual se desean consultar las operaciones.
     * @return Una lista de operaciones asociadas al cliente.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public List<Operacion> consultar(int idCliente) throws PersistenciaException;
}