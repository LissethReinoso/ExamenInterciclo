/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Actividad;
import ec.edu.ups.modelo.Curso;
import ec.edu.ups.modelo.Rector;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class ControladorActividad {

    private List<Curso> curso;

    private Pattern patron;
    private Matcher corpus;
    private List<Rector> listaRectores;
    private int re;
    private int tam;
    private RandomAccessFile file;

    public ControladorActividad() {
        curso = new ArrayList<>();

    }

    public boolean validar(String texto) {
        corpus = patron.matcher(texto);
        return corpus.find();
    }

    public void ingresarRegex(String regex) {
        patron = Pattern.compile(regex);
    }

    public List<String> obtenerActividades(String texto) {
        List<String> ac = new ArrayList();
        corpus = patron.matcher(texto);
        while (corpus.find()) {
            for (int i = 1; i < corpus.groupCount(); i++) {
                ac.add(corpus.group(i));
            }
        }
        return ac;
    }

   
}
