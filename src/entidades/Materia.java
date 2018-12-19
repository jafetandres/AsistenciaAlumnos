/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jafetandresgalvezquezada
 */
public class Materia {
    private int codigo;
    private String nombre;
    private int numCreditos;

    public Materia(int codigo, String nombre, int numCreditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numCreditos = numCreditos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }

    @Override
    public String toString() {
        return "Materia{" + "codigo=" + codigo + ", nombre=" + nombre + ", numCreditos=" + numCreditos + '}';
    }
}