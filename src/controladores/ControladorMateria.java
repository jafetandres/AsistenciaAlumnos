/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

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
public class ControladorMateria {

    private Statement s = null;
    private ResultSet rs = null;
    ControladorConexion controladorConexion = new ControladorConexion();

    public List<Materia> listarMaterias() {

        List<Materia> lista = new ArrayList<>();
        try {
            controladorConexion.conectar();
            s = controladorConexion.conexion.createStatement();
            String sql = "SELECT * FROM Materia ";
            rs = s.executeQuery(sql);
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setCodigo(rs.getInt("codigo"));
                materia.setNombre(rs.getString("nombre"));
                materia.setNumCreditos(rs.getInt("numcreditos"));

                lista.add(materia);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL" + ex);
        }
        return lista;
    }
    
    

}
