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
public class AsistenciaPorFecha {
    
    String fecha;
    String nombres;
    String apellidos;
    String estado;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "AsistenciaPorAlumno{" + "fecha=" + fecha + ", nombres=" + nombres + ", apellidos=" + apellidos + ", estado=" + estado + '}';
    }
    
    
    
}
