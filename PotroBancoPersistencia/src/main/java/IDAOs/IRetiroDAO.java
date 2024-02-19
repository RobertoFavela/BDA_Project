/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAOs;

import Exepciones.PersistenciaException;
import dominio.Operacion;
import dominio.Retiro;
import java.util.List;

/**
 * Define las operaciones que pueden realizarse sobre la entidad Retiro en la capa de acceso a datos.
 * 
 * @author favel
 * @version 1.0
 */
public interface IRetiroDAO {
    /**
     * Agrega un nuevo retiro a la fuente de datos.
     * 
     * @param operacion La operación de retiro a agregar.
     * @return El retiro agregado.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Retiro agregar(Operacion operacion) throws PersistenciaException;
    
    /**
     * Consulta todos los retiros almacenados en la fuente de datos.
     * 
     * @return Una lista de todos los retiros almacenados.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public List<Retiro> consultar() throws PersistenciaException;
    
    /**
     * Realiza un retiro de fondos en la fuente de datos.
     * 
     * @param retiro El retiro a realizar.
     * @return El retiro realizado.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Retiro retirar(Retiro retiro) throws PersistenciaException;
}

