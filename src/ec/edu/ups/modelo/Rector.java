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
public class Rector<T> extends Persona{
    
    private Profesor profesor;
    private T correoElectronico;
    private T contrasenia;
    
    public Rector() {
    }

    public Rector(String cedula, String nombre, String apellido, String edad) {
        super(cedula, nombre, apellido, edad);
    }

    
    

    public Rector(Profesor profesor, T correoElectronico, T contrasenia, String cedula, String nombre, String apellido, String edad) {
        super(cedula, nombre, apellido, edad);
        this.profesor = profesor;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public Rector(T correoElectronico, T contrasenia, String cedula, String nombre, String apellido, String edad) {
        super(cedula, nombre, apellido, edad);
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public T getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(T correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public T getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(T contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Rector{" + "profesor=" + profesor + ", correoElectronico=" + correoElectronico + ", contrasenia=" + contrasenia + '}';
    }
    
    
   
    
}
