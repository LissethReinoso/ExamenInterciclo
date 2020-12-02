/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Usuario
 */
public class Actividad<T> {
    
    private Curso curso;
    private String nombre;
    private String descripción;
    private String link;

    public Actividad() {
    }

    public Actividad(Curso curso, String nombre, String descripción, String link) {
        this.curso = curso;
        this.nombre = nombre;
        this.descripción = descripción;
        this.link = link;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Actividad{" + "curso=" + curso + ", nombre=" + nombre + ", descripci\u00f3n=" + descripción + ", link=" + link + '}';
    }
    
    
    
    
    
    
    
}
