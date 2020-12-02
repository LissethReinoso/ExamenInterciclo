/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Actividad;
import ec.edu.ups.modelo.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladorCurso {
    
    private List <Actividad> act;
    
    
    public ControladorCurso() {
        act= new ArrayList<>();
    }
    
    
    
    
    
   public void registrar( Actividad acti) {
       
        act.add(acti);
    }
   
    
}
