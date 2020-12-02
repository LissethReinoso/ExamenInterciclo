/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class ControladorProfesor {

    private static Profesor profe;

    private Pattern patron;
    private Matcher corpus;
    private List<Profesor> listaProfesores;
    private int re;
    private int tam;
    private RandomAccessFile file;

    public ControladorProfesor() {
        listaProfesores = new ArrayList<>();
        tam = 203;
        try {
            //C:\Users\Usuario\Desktop\ExamenApp.txt
            file = new RandomAccessFile("Desktop/ExamenApp.txt", "rw");
        } catch (IOException ex) {
            System.out.println("error de escritura y lectura");
            ex.printStackTrace();
        }

    }

    public void registrar(Profesor p) {

        try {
            file.seek(file.length());
            file.writeUTF(p.getCedula());
            file.writeUTF(p.getNombre());
            file.writeUTF(p.getApellido());
            file.writeUTF(p.getEdad());
            file.writeUTF((String) p.getContrasenia());
            file.writeUTF((String) p.getCorreoElectronico());
            file.writeUTF(p.getAlumno().toString());
            file.writeUTF(p.getCurso().toString());

        } catch (IOException ex) {
            System.out.println("Error de creación");
        }

    }

    public Profesor verProfesor(String cedula, String nombre, String apellido, String edad) throws IOException {
        int e = 0;
        for (Profesor p : listaProfesores) {
            if (p.getCedula().equals(cedula)) {
                file.seek(e);
                String f = file.readUTF().trim();
                if (cedula.trim().equals(f) && nombre.trim().equals(f) && apellido.trim().equals(f) && edad.trim().equals(f)) {
                    Profesor prof = new Profesor(cedula, nombre, apellido, edad);
                    return p;

                }
                e += re;
                return p;
            }
        }
        return null;

    }

    public void eliminar() throws IOException {

        String id = profe.getCedula();
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

    public void actualizar(Profesor prof) throws IOException {

        int entrada = 0;
        String id = prof.getCedula();

        while (entrada < file.length()) {
            file.seek(entrada);
            String cedula = file.readUTF().trim();
            if (cedula.trim().equals(cedula)) {
                file.writeUTF(prof.getCedula());
                file.writeUTF(prof.getNombre());
                file.writeUTF(prof.getApellido());
                file.writeUTF((String) prof.getCorreoElectronico());
                file.writeUTF((String) prof.getContrasenia());
                break;
            }
            entrada += re;
        }

    }

    public Profesor CorreoElectronico(String correoElectronico) throws IOException {
        int entrada = 66;

        for (Profesor prof : listaProfesores) {
            file.seek(entrada);

            String correo = file.readUTF();
            String contrasenia = file.readUTF();

            System.out.println(correo);

            if (correo.trim().equals(correoElectronico)) {

                file.seek(entrada - 66);
                profe = new Profesor(profe.getCedula(), profe.getNombre(), profe.getApellido(), profe.getEdad());
                return profe;
            }
            entrada += re;

        }
        return null;
    }

    public String espCompletos(int esp) {
        String cad = "";
        return String.format("%-" + esp + "s", cad);
    }

    public String espPequeños(String cadena, int esp) {

        return cadena.substring(0, esp);
    }

}
