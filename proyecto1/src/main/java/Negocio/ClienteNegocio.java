/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Persistencia.IClienteDAO;

/**
 *
 * @author SDavidLedesma
 */
public class ClienteNegocio implements IClienteNegocio {

    private IClienteDAO clienteDAO;

    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /**
     * @Override public void guardar() throws NegocioException { try {
     * System.out.println("Paso por negocio del cliente" + LocalDateTime.now());
     * this.clienteDAO.guardar(); } catch (PersistenciaException ex) { throw new
     * NegocioException(ex.getMessage()); }
     *
     *
     * }
     * //
     *
     *
     * }
     *
     */
}
