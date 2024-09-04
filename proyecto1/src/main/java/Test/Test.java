/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import com.mycompany.crudprimeraunidad.CRUDCliente;
import java.sql.SQLException;

/**
 *
 * @author SDavidLedesma
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        CRUDCliente cliente = new CRUDCliente();

        /*
        for (int i = 0; i < 3; i++) {
            cliente.insertar();
        }
         */
        cliente.leer();
    }

}
