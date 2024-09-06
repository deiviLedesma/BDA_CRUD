/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Dominio.Cliente;
import Negocio.ClienteNegocio;
import Negocio.IClienteNegocio;
import Negocio.NegocioException;
import Persistencia.ClienteDAO;

/**
 *
 * @author SDavidLedesma
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos una instancia de ClienteDAO para la capa de persistencia
        ClienteDAO clienteDAO = new ClienteDAO();
        
        //Creamos una instancia de ClienteNegocio con el DAO de persistencia
        IClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);
        
        
        try{
            //insertamos un nuevo cliente
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setNombre("David");
            nuevoCliente.setApellidoPaterno("Ledesma");
            nuevoCliente.setApellidoMaterno("Sanchez");
            nuevoCliente.setEstaEliminado(false);
            clienteNegocio.insertarCliente(nuevoCliente);
            System.out.println("Cliente insertado exitosamente");
            
            
            
        }catch(NegocioException e){
            System.out.println("Error en la operacion");
        }
    }

}
