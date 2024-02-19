/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAOs;

import DTOs.CuentaDTO;
import Exepciones.PersistenciaException;
import dominio.Cuenta;
import java.util.List;

/**
 * Define las operaciones que pueden realizarse sobre la entidad Cuenta en la capa de acceso a datos.
 * 
 * @author favel
 * @version 1.0
 */
public interface ICuentaDAO {
    /**
     * Agrega una nueva cuenta a la fuente de datos.
     * 
     * @param cuenta La cuenta a agregar, representada como un objeto CuentaDTO.
     * @return La cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Cuenta agregar(CuentaDTO cuenta) throws PersistenciaException;
    
    /**
     * Actualiza la información de una cuenta en la fuente de datos.
     * 
     * @param cuenta La cuenta con la información actualizada.
     * @return La cuenta actualizada.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Cuenta actualizar(Cuenta cuenta) throws PersistenciaException;
    
    /**
     * Elimina una cuenta de la fuente de datos.
     * 
     * @param cuenta La cuenta a eliminar.
     * @return La cuenta eliminada.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public Cuenta eliminar(Cuenta cuenta) throws PersistenciaException;
    
    /**
     * Consulta todas las cuentas almacenadas en la fuente de datos.
     * 
     * @return Una lista de todas las cuentas almacenadas.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public List<Cuenta> consultar() throws PersistenciaException;
}