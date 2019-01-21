/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Alumno;
import entidades.AsistenciaPorFecha;
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

    public List<AsistenciaPorFecha> listaReportePorFecha(String fecha, int codigoMateria) {
        System.out.println("fecha: "+fecha+"codigo materia: "+codigoMateria);

        List<AsistenciaPorFecha> lista = new ArrayList<>();
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            String sql = "SELECT DISTINCT Asistencia.fecha, Alumno.nombres, Alumno.apellidos, Asistencia.estado FROM Asistencia,Alumno WHERE Asistencia.fecha='" + fecha + "' AND Asistencia.codigomateria=" + codigoMateria + " AND Alumno.codigo IN(select Asistencia.codigoalumno from Asistencia where Asistencia.fecha='" + fecha + "')";

            
            
            rs = s.executeQuery(sql);
            while (rs.next()) {
                AsistenciaPorFecha asistenciaPorFecha = new AsistenciaPorFecha();
                asistenciaPorFecha.setFecha(rs.getString("fecha"));
                asistenciaPorFecha.setNombres(rs.getString("nombres"));
                asistenciaPorFecha.setApellidos(rs.getString("apellidos"));
                asistenciaPorFecha.setEstado(rs.getString("estado"));

                lista.add(asistenciaPorFecha);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL ultima" + ex);
        }
        return lista;
    }

    public int buscarCodigoAlumno(String nombres, String apellidos) {

        int codigo = 0;
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT codigo FROM Alumno "
                    + "WHERE nombres='" + nombres + "' AND apellidos='" + apellidos + "'");

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
