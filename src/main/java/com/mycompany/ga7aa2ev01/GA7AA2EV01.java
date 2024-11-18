/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ga7aa2ev01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diaz
 */
public class GA7AA2EV01 {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/jdbaa2ev01";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Funcionalidad de inserción
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'Carlos');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Funcionalidad de actualizacion
            statement.execute("UPDATE `usuarios` SET `nombre` = 'MariaUpdate' WHERE `usuarios`.`id` = 4;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Funcionalidad de Eliminacion
            statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 5");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GA7AA2EV01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
