/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class ControladorConexion {

    Connection conexion = null;

    public void conectar() {

        String url = "jdbc:mysql://localhost:3306/Asistencia";

        try {

            conexion = DriverManager.getConnection(url, "root", "root");
            System.out.println("conexion existosa");

        } catch (Exception e) {
            System.out.println("Problemas de Conexion" + e);
        }
    }
}
