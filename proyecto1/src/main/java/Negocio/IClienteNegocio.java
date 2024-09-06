/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import Dominio.Cliente;

/**
 *
 * @author SDavidLedesma
 */
public interface IClienteNegocio {

    //Método para insertar un nuevo cliente
    void insertarCliente(Cliente cliente) throws NegocioException;

    //Método para eliminar un cliente por su ID
    void eliminarCliente(Long idCliente) throws NegocioException;

    //Método para actualizar un cliente existente
    void actualizarCliente(Cliente cliente) throws NegocioException;

    //Método para leer los datos de un cliente por su ID
    Cliente leerCliente(Long idCliente) throws NegocioException;

}
