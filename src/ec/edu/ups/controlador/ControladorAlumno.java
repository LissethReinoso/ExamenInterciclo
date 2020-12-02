/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Profesor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class ControladorAlumno {
    
    private Alumno alumno;

    private Pattern patron;
    private Matcher corpus;
    private List<Alumno> listaAlumnos;
    private int re;
    private int tam;
    private RandomAccessFile file;
    
    
    
    public void registrar(Alumno a) {

      
        try {
            file.seek(file.length());
            file.writeUTF(a.getCedula());
            file.writeUTF(a.getNombre());
            file.writeUTF(a.getApellido());
            file.writeUTF(a.getEdad());
            file.writeUTF(a.getCurso().getNivel());
            file.writeUTF(a.getCurso().getParalelo());
            
        } catch (IOException ex) {
            System.out.println("Error de creación");
        }
        
    }
    
    
    public Alumno verAlumno(String cedula,String nombre,String apellido,String edad) throws IOException {
        int e = 0;
       for (Alumno al : listaAlumnos) {
            if (al.getCedula().equals(cedula)) {
                file.seek(e);
                String f = file.readUTF().trim();
                if (cedula.trim().equals(f)&& nombre.trim().equals(f)&& apellido.trim().equals(f) && edad.trim().equals(f)) {
                    Alumno alum = new Alumno(cedula,nombre,apellido,edad);
                    return al;
                   
                }
                e += re;
                return al;
            }
        }
        return null;
        
    }
    
    
    public void eliminar() throws IOException {
      
        
      
            String id = alumno.getCedula();
            int entrada = 0;
            while (entrada < file.length()) {
                file.seek(entrada);
                String cedulaArchivo = file.readUTF();
                if (id.trim().equals(cedulaArchivo.trim())) {
                    file.writeUTF(espCompletos(0));
                    file.writeUTF(espCompletos(0));
                    file.writeUTF(espCompletos(0));
                    file.writeUTF(espCompletos(0));
                    file.writeUTF(espCompletos(0));
                    break;
                }
                entrada += re;
            }
     }
    
    
    public void actualizar(Alumno alum) throws IOException {
      
       
        int entrada= 0;
        String id = alum.getCedula();
        
            while (entrada < file.length()) {
                file.seek(entrada);
                String cedula = file.readUTF().trim();
                if (cedula.trim().equals(cedula)) {
                    file.writeUTF(alum.getCedula());
                    file.writeUTF(alum.getNombre());
                    file.writeUTF(alum.getApellido());
                    
                    break;
                }
                entrada += re;
            }
       
    }
    
    
    
    public String espCompletos(int esp) {
       String cad="";
        return String.format("%-" + esp + "s", cad);
    }

    public String espPequeños(String cadena, int esp) {
        
        return cadena.substring(0, esp);
    }
    
    
}
