/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class ControladorDocente {
    private Statement s = null;
    private ResultSet rs = null;
    ControladorConexion controladorConexion = new ControladorConexion();
    
    
    public int buscarCodigoDocente(String nombres,String apellidos) {

        int codigo = 0;
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT codigo FROM Docente "
                    + "WHERE nombres ='"+nombres+"' AND apellidos='"+apellidos+"'");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }

        int cod;

        try {
            while (rs.next()) {
                cod = rs.getInt(1);
                codigo = cod;

            }

        } catch (Exception e) {
            System.out.println("Problema al imprimir la información en buscarCodigoDocente.");
        }
        return codigo;

    }
}
