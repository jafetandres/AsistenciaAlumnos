/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class ControladorAdministrador {

    private Statement s = null;
    private ResultSet rs = null;
    ControladorConexion controladorConexion = new ControladorConexion();

    public void registrarMateria( String nombre, int numCreditos) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO materia (nombre,numcreditos)"
                    + " VALUES ("
                    + "'" + nombre + "'," + numCreditos + ")");

            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");

            }
        } catch (Exception e) {

            System.out.println("Error de SQL" + e);

        }

    }

}
