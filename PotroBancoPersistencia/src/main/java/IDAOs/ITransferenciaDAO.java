/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAOs;

import Exepciones.PersistenciaException;
import dominio.Operacion;
import dominio.Transferencia;
import java.util.List;

/**
 * Define las operaciones que pueden realizarse sobre la entidad Transferencia en la capa de acceso a datos.
 * 
 * @author favel
 * @version 1.0
 */
public interface ITransferenciaDAO {
    /**
     * Agrega una nueva transferencia a la fuente de datos.
     * 
     * @param operacion La operación asociada a la transferencia.
     * @param transferencia La transferencia a agregar.
     * @return La transferencia agregada.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Transferencia agregar(Operacion operacion, Transferencia transferencia) throws PersistenciaException;
    
    /**
     * Consulta todas las transferencias almacenadas en la fuente de datos.
     * 
     * @return Una lista de todas las transferencias almacenadas.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public List<Transferencia> consultar() throws PersistenciaException;
}

