/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy;

import javax.swing.JOptionPane;
import static proy.login.consultasBD;

/**
 *
 * @author irvin
 */
public class usuario {
  
    private String nombre;
    private String contraseña;
    private int puntaje;
    
    
    public usuario(){
        this("","",0);
    }

    public usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
       
    }
    public usuario(String nombre, String contraseña,int puntaje) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.puntaje=puntaje;
       
    }
    public usuario(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
       
    }
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

  


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public static void victoria(){
        JOptionPane.showMessageDialog(null, "FELICIDADES GANASTE!!");
        int punt=Entrar.jugador.getPuntaje()+10;
        consultasBD.ActualizarPuntaje(Entrar.jugador.getNombre(),punt);
        Entrar.jugador.setPuntaje(punt);
        JOptionPane.showMessageDialog(null, "Puntaje obtenido="+punt);
        Menu.labelScore.setText("Nombre:   "+Entrar.jugador.getNombre()+"   Score:   "+Entrar.jugador.getPuntaje());
        
    }
    
    
    public static void perder(){
        JOptionPane.showMessageDialog(null, "LOSIENTO PERDISTE!!");
        int punt=Entrar.jugador.getPuntaje()-1;
        consultasBD.ActualizarPuntaje(Entrar.jugador.getNombre(),punt);
        Entrar.jugador.setPuntaje(punt);
        JOptionPane.showMessageDialog(null, "PERDISTE 1 PUNTO!");
        Menu.labelScore.setText("Nombre:   "+Entrar.jugador.getNombre()+"   Score:   "+Entrar.jugador.getPuntaje());
        
        
    }
    
    
    
    
    
}
