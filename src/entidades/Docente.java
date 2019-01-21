/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class Docente {

    private int codigo;
    private String nombres;
    private String apellidos;
    private String correo;
    private ArrayList<Materia> listaMaterias;

    public Docente(int codigo, String nombres, String apellidos, String correo, ArrayList<Materia> listaMaterias) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.listaMaterias = listaMaterias;
    }

    public void tomarAsistencia(ArrayList<Alumno> listaAlumnos) {

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

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    @Override
    public String toString() {
        return "Docente{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", listaMaterias=" + listaMaterias + '}';
    }

}
