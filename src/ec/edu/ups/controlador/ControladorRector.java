/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Rector;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.*;

/**
 *
 * @author Usuario
 */
public class ControladorRector {

    //Patron de diseño Singleton
    private static Rector rector;

    private Pattern patron;
    private Matcher corpus;
    private List<Rector> listaRectores;
    private int re;
    private int tam;
    private RandomAccessFile file;

    public ControladorRector() {
        listaRectores = new ArrayList<>();
        tam = 203;
        try {
            //C:\Users\Usuario\Desktop\ExamenApp.txt
            file = new RandomAccessFile("Desktop/ExamenApp.txt", "rw");
        } catch (IOException ex) {
            System.out.println("error de escritura y lectura");
            ex.printStackTrace();
        }

    }

    public boolean validar(String texto) {
        corpus = patron.matcher(texto);
        return corpus.find();
    }

    public void ingresarRegex(String regex) {
        patron = Pattern.compile(regex);
    }

    public void registrar(Rector r) {

        // return this.listaRectores.add(new Rector(r.getCedula(), r.getNombre(), r.getApellido(), r.getEdad(), r.getContrasenia(), r.getCorreoElectronico()));
        try {
            file.seek(file.length());
            file.writeUTF(r.getCedula());
            file.writeUTF(r.getNombre());
            file.writeUTF(r.getApellido());
            file.writeUTF(r.getEdad());
            file.writeUTF((String) r.getContrasenia());
            file.writeUTF((String) r.getCorreoElectronico());
            file.writeUTF(r.getProfesor().toString());

        } catch (IOException ex) {
            System.out.println("Error de creación");
        }

    }

    public Rector verRector(String cedula, String nombre, String apellido, String edad) throws IOException {
        int e = 0;
        for (Rector rec : listaRectores) {
            if (rec.getCedula().equals(cedula)) {
                file.seek(e);
                String f = file.readUTF().trim();
                if (cedula.trim().equals(f) && nombre.trim().equals(f) && apellido.trim().equals(f) && edad.trim().equals(f)) {
                    Rector r = new Rector(cedula, nombre, apellido, edad);
                    return r;

                }
                e += re;
                return rec;
            }
        }
        return null;

    }

    public void actualizar(Rector rector) throws IOException {

        int entrada = 0;
        String id = rector.getCedula();

        while (entrada < file.length()) {
            file.seek(entrada);
            String cedula = file.readUTF().trim();
            if (cedula.trim().equals(cedula)) {
                file.writeUTF(rector.getCedula());
                file.writeUTF(rector.getNombre());
                file.writeUTF(rector.getApellido());
                file.writeUTF((String) rector.getCorreoElectronico());
                file.writeUTF((String) rector.getContrasenia());
                break;
            }
            entrada += re;
        }

    }

    public void eliminar() throws IOException {

        String id = rector.getCedula();
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

    public List<String> obtenerLink(String l) {
        List<String> links = new ArrayList();
        corpus = patron.matcher(l);
        while (corpus.find()) {
            for (int i = 0; i < corpus.groupCount(); i++) {
                links.add(corpus.group(i));
            }
        }
        return links;
    }

    public Rector CorreoElectronico(String correoElectronico) throws IOException {
        int entrada = 66;

        for (Rector rec : listaRectores) {
            file.seek(entrada);

            String correo = file.readUTF();
            String contrasenia = file.readUTF();

            System.out.println(correo);

            if (correo.trim().equals(correoElectronico)) {

                file.seek(entrada - 66);
                rector = new Rector(rector.getCedula(), rector.getNombre(), rector.getApellido(), rector.getEdad());
                return rector;
            }
            entrada += re;

        }
        return null;
    }

    public Rector iniciarSesion(String correoElec, String contraseña) throws IOException {

        int entrada = 66;

        for (Rector rec : listaRectores) {
            file.seek(entrada);

            String correo = file.readUTF();
            String contrasenia = file.readUTF();

            System.out.println(correoElec + " " + contraseña);

            if (correoElec.equals(correo.trim()) && contraseña.equals(contrasenia.trim())) {

                file.seek(entrada - 66);
                rector = new Rector(rector.getCedula(), rector.getNombre(), rector.getApellido(), rector.getEdad());
                return rector;
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
