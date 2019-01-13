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

    public int codigo;
    public String nombres;
    public String apellidos;
    public String correoRepresentante;

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

    @Override
    public String toString() {
        return "Alumno{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correoRepresentante=" + correoRepresentante + '}';
    }

}
