/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import entidades.Materia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class ControladorAlumno {

    private Statement s = null;
    private ResultSet rs = null;
    ControladorConexion controladorConexion = new ControladorConexion();

    public List<Alumno> listarAlumnos(String nombreMateria) {

        List<Alumno> lista = new ArrayList<>();
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            String sql = "SELECT Alumno.codigo,Alumno.apellidos,Alumno.nombres FROM Alumno "
                    + "WHERE Alumno.codigo IN (SELECT AlumnoMateria.codigoalumno FROM AlumnoMateria "
                    + "WHERE AlumnoMateria.codigomateria=(SELECT Materia.codigo FROM Materia "
                    + "WHERE Materia.nombre='" + nombreMateria + "'));";

            rs = s.executeQuery(sql);
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setCodigo(rs.getInt("codigo"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setNombres(rs.getString("nombres"));

                lista.add(alumno);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL" + ex);
        }
        return lista;
    }

    public String listarCorreos(int codigoAlumno) {
        String correoRepresentante = "";
        System.out.println("codigo alumno: " + codigoAlumno);
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT correorepresentante FROM Alumno WHERE codigo=" + codigoAlumno + "");

            while (rs.next()) {
                correoRepresentante = rs.getString(1);

            }
        } catch (Exception e) {
            System.out.println("Error de SQL" + e);

        }
        return correoRepresentante;

    }
}
