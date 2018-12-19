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
public class Alumno {

    private int codigo;
    private String nombres;
    private String apellidos;
    private String correoRepresentante;
    private ArrayList<Materia> listaMaterias;

    public Alumno(int codigo, String nombres, String apellidos, String correoRepresentante, ArrayList<Materia> listaMaterias) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoRepresentante = correoRepresentante;
        this.listaMaterias = listaMaterias;
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

    public String getCorreoRepresentante() {
        return correoRepresentante;
    }

    public void setCorreoRepresentante(String correoRepresentante) {
        this.correoRepresentante = correoRepresentante;
    }

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    @Override
    public String toString() {
        return "Alumno{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correoRepresentante=" + correoRepresentante + ", listaMaterias=" + listaMaterias + '}';
    }

}
