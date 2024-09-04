/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author SDavidLedesma
 */
public class ClienteDAO implements IClienteDAO {

    private ConexionBD conexionBD;

    public ClienteDAO() {
        conexionBD = new ConexionBD();
    }

    /**
     * Método insertar, insertamos a través de un query
     * @param cliente
     * @throws PersistenciaException 
     */
    @Override
    public void insertar(Cliente cliente) throws PersistenciaException {
        //query de la base de datos
        String query = "INSERT INTO Clientes (nombre, apellidoP, apellidoM, telefono) VALUES (?, ?, ?, ?)";
        //intenta establecer la conexion con la base de datos y ejecuta el query
        try(Connection con = conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(query)){
            //se establecen los datos del query
           ps.setString(1, cliente.getNombre());
           ps.setString(2, cliente.getApellidoP());
           ps.setString(3, cliente.getApellidoM());
           ps.setString(4, cliente.getTelefono());
           ps.executeUpdate(); //manda y actualiza la informacion a la base de datos
            
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al crear el Cliente");
        }
            
    }

    /**
     * Método que elimina al cliente por su id a través del query
     * @param id
     * @throws PersistenciaException 
     */
    @Override
    public void eliminar(int id) throws PersistenciaException {
        //query de la base de datos
        String query = "DELETE FROM Clientes WHERE idCliente = ?";
        //intenta establecer la conexion con la base de datos y ejecuta el query
        try(Connection con = conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(query)){
            
            //establecemos al cliente que afectara
            ps.setLong(1, id);
            ps.executeUpdate(); //acutalizamos y mandamos la informacion a la base de datos
            
        }catch(SQLException e){
            throw new PersistenciaException("Error al eliminar el cliente");
        }
      }

    /**
     * Método actualizar el cual cambia algun dato acerca del cliente, lo realiza a través del query
     * @param cliente
     * @throws PersistenciaException 
     */
    @Override
    public void actualizar(Cliente cliente) throws PersistenciaException {
        String query = "UPDATE Clientes SET nombre = ?, apellidoP = ?, apellidoM = ?, telefono = ? WHERE idCliente = ?";
        try(Connection con = conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidoP());
            ps.setString(3, cliente.getApellidoM());
            ps.setString(4, cliente.getTelefono());
            ps.executeUpdate();
            
        }catch(SQLException e){
            throw new PersistenciaException("Error al actualizar el cliente");
        }
    }

    @Override
    public void leer() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
