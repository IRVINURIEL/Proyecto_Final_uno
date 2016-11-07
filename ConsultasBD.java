package proy;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultasBD {
    MySQLBD baseDatos = new MySQLBD().conectar("localhost", "Proy", "root", "");
    
    public ArrayList<usuario> consultarUsuarios(){
        ArrayList<usuario> result = new ArrayList();
        ResultSet rs = baseDatos.consultar("SELECT * FROM Usuarios");
        if(rs != null){
            try {
                while(rs.next()){
                    result.add(new usuario(rs.getString("Usuario"),
                        rs.getString("Contraseña")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public usuario buscarPorNombre(String nom){
        usuario pac = null;
        ResultSet rs = baseDatos.consultar("SELECT * FROM Usuarios where"+" usuario='" + nom+"'");
        if(rs != null){
            try {
                while(rs.next()){
                    pac = new usuario(rs.getString("Usuario"),
                        rs.getString("Contraseña"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else{
            
                    pac =new usuario("no","no");
                
            
            
        }
        
        return pac;
    }
    public usuario buscarPorNombreypunt(String nom){
      usuario pac = null;
        ResultSet rs = baseDatos.consultar("SELECT * FROM Avance where"+" Nombre='" + nom+"'");
        if(rs != null){
            try {
                while(rs.next()){
                    pac = new usuario(rs.getString("Nombre"),
                        rs.getInt("Puntaje"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pac;
        
    }
    
    public void insertarUsuario(String Usuario, String contraseña){
        if(baseDatos.ejecutar("INSERT INTO usuarios VALUES('"+ Usuario +"','"+contraseña+"')")){
            System.out.println("Ejecucion Correcta");
        } else {
            System.out.println("Ocurrio un problema al insertar");
        }
    }
    
    public void insertarPuntaje(String nombre, int puntaje){
        if(baseDatos.ejecutar("INSERT INTO avance VALUES('"+ nombre +"','"+puntaje+"')")){
            System.out.println("Ejecucion Correcta");
        } else {
            System.out.println("Ocurrio un problema al insertar");
        }
    }
    
    public void ActualizarPuntaje( String usuario,
            int Puntaje){
        String sql = "UPDATE avance SET Nombre= '" + usuario +
                "',Puntaje = '" + Puntaje+ "'WHERE Nombre='" +usuario+"'";
               if(baseDatos.ejecutar(sql)){
            System.out.println("Ejecucion Correcta");
        } else {
            System.out.println("Ocurrio un problema al modificar");
        }
    }
    
    public void borrar(String usu){
        if(baseDatos.ejecutar("DELETE FROM Usuarios WHERE " +
                "Usuario= " + usu)){
            System.out.println("Ejecucion correcta");
        } else {
            System.out.println("Ocurrio un problema al borrar");
        }
    }
}
