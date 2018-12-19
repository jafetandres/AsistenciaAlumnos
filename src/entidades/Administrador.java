/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import controladores.ControladorConexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class Administrador {
    
    private int codigo;
    private String nombres;
    private String apellidos;
    private String correo;


    
    public Alumno registrarAlumno(int codigo, String nombres, String apellidos,String correoRepresentante,ArrayList<Materia> listaMaterias){
        
        Alumno alumno=new Alumno(codigo, nombres, apellidos, correoRepresentante, listaMaterias);
        return alumno;
    }
    
   
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Administrador{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + '}';
    }
    
    
    
}
