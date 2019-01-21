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

    public int buscarCodigoDocente(String nombres, String apellidos) {

        int codigo = 0;
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT codigo FROM Docente "
                    + "WHERE nombres ='" + nombres + "' AND apellidos='" + apellidos + "'");

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

    public int buscarCodigoDocenteLogin(String correo) {

        int codigo = 0;
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT codigo FROM Docente "
                    + "WHERE correo='" + correo + "'");

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
    
    

    public String buscarCorreoDocenteLogin(String correo) {

        String correoDocente = "";
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT correo FROM Docente "
                    + "WHERE correo='" + correo + "'");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }

        String cod;

        try {
            while (rs.next()) {
                cod = rs.getString(1);
                correoDocente = cod;

            }

        } catch (Exception e) {
            System.out.println("Problema al imprimir la información en buscarCodigoDocente.");
        }
        return correoDocente;

    }
    

    public String buscarContrasenaDocenteLogin(String correo) {

        String contrasenaDocente = "";
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT contrasena FROM Docente "
                    + "WHERE correo='" + correo + "'");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }

        String cod;

        try {
            while (rs.next()) {
                cod = rs.getString(1);
                contrasenaDocente = cod;

            }

        } catch (Exception e) {
            System.out.println("Problema al imprimir la información en buscarCodigoDocente.");
        }
        return contrasenaDocente;

    }

    public String[] buscarNombreDocenteLogin(String correo) {

        String[] nombresCompletos = new String[2];
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT nombres,apellidos FROM Docente "
                    + "WHERE correo='" + correo + "'");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }

        String cod1;
        String cod2;

        try {
            while (rs.next()) {
                cod1 = rs.getString(1);
                cod2 = rs.getString(2);

                nombresCompletos[0] = cod1 + " ";
                nombresCompletos[1] = cod2;

            }

        } catch (Exception e) {
            System.out.println("Problema al imprimir la información en buscarCodigoDocente.");
        }
        return nombresCompletos;

    }
}
