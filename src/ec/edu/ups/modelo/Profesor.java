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
public class Profesor extends Persona{
    
     public Alumno alumno;
   public Curso curso;
   private String correoElectronico;
   private String contrasenia;

    public Profesor() {
    }

    public Profesor(Alumno alumno, Curso curso, String correoElectronico, String contrasenia) {
        this.alumno = alumno;
        this.curso = curso;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public Profesor(String cedula, String nombre, String apellido, String edad) {
        super(cedula, nombre, apellido, edad);
    }

    
    
    public Profesor(Alumno alumno, Curso curso, String correoElectronico, String contrasenia, String cedula, String nombre, String apellido, String edad) {
        super(cedula, nombre, apellido, edad);
        this.alumno = alumno;
        this.curso = curso;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Profesor{" + "alumno=" + alumno + ", curso=" + curso + ", correoElectronico=" + correoElectronico + ", contrasenia=" + contrasenia + '}';
    }
   
    
    
    
    
}
