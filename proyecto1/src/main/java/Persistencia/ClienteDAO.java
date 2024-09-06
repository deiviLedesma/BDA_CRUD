/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String query = "INSERT INTO Cliente (nombre, apellidoPaterno, apellidoMaterno, estaEliminado) VALUES (?, ?, ?, ?)";
        //intenta establecer la conexion con la base de datos y ejecuta el query
        try(Connection con = conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(query)){
            //se establecen los datos del query
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setBoolean(4, cliente.isEstaEliminado());
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
    public void eliminar(Long id) throws PersistenciaException {
        //query de la base de datos
        String query = "DELETE FROM Cliente WHERE idcliente = ?";
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
        String query = "UPDATE Cliente SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, estaElimnado = ? WHERE idcliente = ?";
        try(Connection con = conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setBoolean(4, cliente.isEstaEliminado());
            ps.executeUpdate();
            
        }catch(SQLException e){
            throw new PersistenciaException("Error al actualizar el cliente");
        }
    }

    @Override
    public Cliente leer(Long idCliente) throws PersistenciaException {
        String query = "SELECT idcliente, nombre, apellidoPaterno, apellidoMaterno, estaEliminado, fechaHoraRegistro";
        ResultSet rs = null;
        try(Connection con = conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(query)){
            ps.setLong(1, idCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                 // Crear un objeto Cliente con los datos obtenidos
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getLong("idcliente"));
                cliente.setNombre(rs.getString("nombres"));
                cliente.setApellidoPaterno(rs.getString("apellidoPaterno"));
                cliente.setApellidoMaterno(rs.getString("apellidoMaterno"));
                cliente.setEstaEliminado(rs.getBoolean("estaEliminado"));
                cliente.setFechaHoraRegistro(rs.getTimestamp("fechaHoraRegistro").toLocalDateTime());

                return cliente; // Devolver el cliente encontrado
            }
            else{ 
                return null;
            }
        }catch(SQLException e){
            throw new PersistenciaException("Error al leer el cliente");
        }finally{
            try{
                if (rs != null) rs.close();
            }catch(SQLException e){
                throw new PersistenciaException("Error al cerrar la conexión");
            }
        }
    }

}
