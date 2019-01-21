/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 * @author jafetandresgalvezquezada
 * @author Katherine Gonzalez
 * @author Jonathan Uzhca
 */
public class Usuario {

    private int codigo;
    private String tipo;
    private Administrador administrador;
    private Docente docente;
    private String contrasena;

    public Usuario(int codigo, String tipo, Administrador administrador, Docente docente, String contrasena) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.administrador = administrador;
        this.docente = docente;
        this.contrasena = contrasena;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", tipo=" + tipo + ", administrador=" + administrador + ", docente=" + docente + ", contrasena=" + contrasena + '}';
    }

}
