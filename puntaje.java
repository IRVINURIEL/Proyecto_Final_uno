/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy;

/**
 *
 * @author irvin
 */
public class puntaje extends usuario {
    
    private String mensaje;

    public puntaje(String nombre, int puntaje, String mensaje) {
        super(nombre, puntaje);
        this.mensaje=mensaje;
        
    }

    public puntaje() {
        this("",0,"");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
    
}
