/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SDavidLedesma
 */
public class ClienteDAO implements IClienteDAO {

    private ConexionBD conexionBD;

    public ClienteDAO() {
        conexionBD = new ConexionBD();
    }

    @Override
    public void guardar() throws PersistenciaException {
        System.out.println("Se guardo el cliente");
    }

    @Override
    public void insertar(Cliente cliente) throws PersistenciaException {
        String query = "INSERT INTO Clientes (nombre, apellidoP, apellidoM, telefono) VALUES (?, ?, ?, ?)";
        
        try(Connection con = conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(query)){
          //  ps.setString(1, cliente.);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    public void eliminar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void leer() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
