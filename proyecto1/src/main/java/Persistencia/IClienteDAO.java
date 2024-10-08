/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Dominio.Cliente;

/**
 *
 * @author SDavidLedesma
 */
public interface IClienteDAO {


    void insertar(Cliente cliente) throws PersistenciaException;

    void eliminar(Long id) throws PersistenciaException;

    void actualizar(Cliente cliente) throws PersistenciaException;

    Cliente leer(Long idCliente) throws PersistenciaException;
}
