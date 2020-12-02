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
public class Curso {
    
    private String nivel;
    private String paralelo;

    public Curso() {
    }

    public Curso(String nivel, String paralelo) {
        this.nivel = nivel;
        this.paralelo = paralelo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    @Override
    public String toString() {
        return "Curso{" + "nivel=" + nivel + ", paralelo=" + paralelo + '}';
    }
    
    
}
