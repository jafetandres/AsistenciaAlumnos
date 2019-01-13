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

    public int ultimoCodigo(String nomTabla) {

        int codigo = 0;
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT MAX(codigo) FROM " + nomTabla);

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
            System.out.println("Problema al imprimir la información.");
        }
        return codigo;

    }

    public void registrarMateria(int codigo, String nombre, int numCreditos) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO Materia (codigo,nombre,numcreditos)"
                    + " VALUES ("
                    + "" + codigo + ",'" + nombre + "'," + numCreditos + ")");

            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");

            }
        } catch (Exception e) {

            System.out.println("Error de SQL" + e);

        }

    }

    public void registrarAlumno(int codigo, String nombres, String apellidos, String correoRepresentante) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO Alumno (codigo,nombres,apellidos,correorepresentante)"
                    + " VALUES ("
                    + "" + codigo + ",'" + nombres + "','" + apellidos + "','" + correoRepresentante + "')");

            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");

            }
        } catch (Exception e) {

            System.out.println("Error de SQL" + e);

        }

    }

    public void registrarAlumnoMateria(int codigo, int codigoAlumno, int codigoMateria) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO AlumnoMateria (codigo,codigoalumno,codigomateria)"
                    + " VALUES ("
                    + "" + codigo + "," + codigoAlumno + "," + codigoMateria + ")");

            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");

            }
        } catch (Exception e) {

            System.out.println("Error de SQL" + e);

        }

    }

    public void registrarDocente(int codigo, String nombres, String apellidos, String correo) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO Docente (codigo,nombres,apellidos,correo)"
                    + " VALUES ("
                    + "" + codigo + ",'" + nombres + "','" + apellidos + "','" + correo + "')");

            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");

            }
        } catch (Exception e) {

            System.out.println("Error de SQL" + e);

        }
    }

    public void registrarDocenteMateria(int codigo, int codigoDocente, int codigoMateria) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO DocenteMateria (codigo,codigodocente,codigomateria)"
                    + " VALUES ("
                    + "" + codigo + "," + codigoDocente + "," + codigoMateria + ")");

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
