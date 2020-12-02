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
public class Alumno extends Persona {
    
    private Curso curso;

    public Alumno() {
    }

    public Alumno(String cedula, String nombre, String apellido, String edad) {
        super(cedula, nombre, apellido, edad);
    }

    public Alumno(Curso curso, String cedula, String nombre, String apellido, String edad) {
        super(cedula, nombre, apellido, edad);
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "curso=" + curso + '}';
    }
    
    
}
