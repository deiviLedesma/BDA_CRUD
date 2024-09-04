/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SDavidLedesma
 */
public class ConexionBD implements IConexion {

    // Definimos los parámetros de conexión a la base de datos
    private final String SERVER = "localhost";
    private final String BASE_DATOS = "practicabda";
    private final String CADENA_CONEXION = "jdbc:mysql://" + SERVER + "/" + BASE_DATOS;
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "Inunanash1";
    private Connection conexion;

    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexionBD = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASEÑA);
        return conexionBD;
    }

   
}
