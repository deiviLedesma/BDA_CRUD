/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Dominio.Cliente;
import Persistencia.IClienteDAO;
import Persistencia.PersistenciaException;

/**
 *
 * @author SDavidLedesma
 */
public class ClienteNegocio implements IClienteNegocio {

    private IClienteDAO clienteDAO;

    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void insertarCliente(Cliente cliente) throws NegocioException {
        try {
            // Validaciones de negocio antes de la inserción
            if (cliente == null) {
                throw new NegocioException("El cliente no puede ser nulo");
            }
            if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
                throw new NegocioException("El nombre del cliente es obligatorio");
            }
            clienteDAO.insertar(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al insertar el cliente");
        }
    }

    @Override
    public void eliminarCliente(Long idCliente) throws NegocioException {
        try {
            // Lógica de negocio antes de eliminar
            if (idCliente == null || idCliente <= 0) {
                throw new NegocioException("El ID del cliente es inválido");
            }
            clienteDAO.eliminar(idCliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar el cliente");
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws NegocioException {
        try {
            // Validaciones de negocio antes de actualizar
            if (cliente == null || cliente.getIdCliente() <= 0) {
                throw new NegocioException("El cliente o su ID son inválidos");
            }

            clienteDAO.actualizar(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el cliente");
        }
    }

    @Override
    public Cliente leerCliente(Long idCliente) throws NegocioException {
        try {
            // Validación de negocio para la lectura
            if (idCliente == null || idCliente <= 0) {
                throw new NegocioException("El ID del cliente es inválido");
            }
            return clienteDAO.leer(idCliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al leer el cliente");
        }
    }

}
