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
            System.out.println("Problema al imprimir la información en ultimoCodigo.");
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

    public void registrarDocente(int codigo, String nombres, String apellidos, String correo, String contrasena) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO Docente (codigo,nombres,apellidos,correo,contrasena)"
                    + " VALUES ("
                    + "" + codigo + ",'" + nombres + "','" + apellidos + "','" + correo + "','" + contrasena + "')");

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

    public void registrarAsistencia(int codigo, String fecha, int codigoMateria, int codigoDocente, int codigoAlumno, String estado) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO Asistencia (codigo,fecha,codigomateria,codigodocente,codigoalumno,estado)"
                    + " VALUES ("
                    + "" + codigo + ",'" + fecha + "'," + codigoMateria + "," + codigoDocente + "," + codigoAlumno + ",'" + estado + "')");

            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");

            }
        } catch (Exception e) {

            System.out.println("Error de SQL en registrar asistencia" + e);

        }

    }

    public void registrarUsuario(int codigo, int codigoDocente, int codigoAdministrador, String tipoUsuario) {

        try {
            controladorConexion.conectar();

            s = controladorConexion.conexion.createStatement();

            int z = s.executeUpdate("INSERT INTO Usuario (codigo,codigodocente,codigoadministrador,tipousuario)"
                    + " VALUES ("
                    + "" + codigo + "," + codigoDocente + "," + codigoAdministrador + ",'" + tipoUsuario + "')");

            if (z == 1) {
                System.out.println("Se agregó el registro de manera exitosa");
            } else {
                System.out.println("Ocurrio un problema al agregar el registro");

            }
        } catch (Exception e) {

            System.out.println("Error de SQL en registrar asistencia" + e);

        }

    }

    public String compararUsuarioDocente(int codigoDocente) {

        String tipo = "";
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT tipousuario FROM Usuario "
                    + "WHERE codigodocente ='" + codigoDocente + "' ");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }

        String tip;

        try {
            while (rs.next()) {
                tip = rs.getString(1);
                tipo = tip;

            }

        } catch (Exception e) {
            System.out.println("Problema al imprimir la información en buscarCodigoDocente.");
        }
        return tipo;

    }

    public String compararUsuarioAdministrador(int codigoAdministrador) {

        String tipo = "";
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT tipousuario FROM Usuario "
                    + "WHERE codigoadministrador ='" + codigoAdministrador + "' ");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }

        String tip;

        try {
            while (rs.next()) {
                tip = rs.getString(1);
                tipo = tip;

            }

        } catch (Exception e) {
            System.out.println("Problema al imprimir la información en buscarCodigoDocente.");
        }
        return tipo;

    }

    public String buscarCorreoAdministradorLogin(String correo) {

        String correoAdministrador = "";
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT correo FROM Administrador "
                    + "WHERE correo='" + correo + "'");

        } catch (Exception e) {
            System.out.println("Error de conexion" + e);
        }

        String cod;

        try {
            while (rs.next()) {
                cod = rs.getString(1);
                correoAdministrador = cod;

            }

        } catch (Exception e) {
            System.out.println("Problema al imprimir la información en buscarCodigoDocente.");
        }
        return correoAdministrador;

    }

    public int buscarCodigoAdministradorLogin(String correo) {

        int codigo = 0;
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT codigo FROM Administrador "
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

    public String buscarContrasenaAdministradorLogin(String correo) {

        String contrasenaDocente = "";
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            rs = s.executeQuery("SELECT contrasena FROM Administrador "
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

}
