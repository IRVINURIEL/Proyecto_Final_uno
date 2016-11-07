package proy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MySQLBD {
    public Connection conexion;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
    
    public MySQLBD conectar(String host, String bd, String user, String pass){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String BaseDeDatos = "jdbc:mysql://" + host + "/" +
                    bd + "?user=" + user + "&password=" + pass;
            setConexion(DriverManager.getConnection(BaseDeDatos));
            if(getConexion() != null){
                System.out.println("Conexion Exitosa");
            } else {
                System.out.println("Conexion Fallida");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    
    public ResultSet consultar(String sql){
        ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement(
                ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar");
            e.printStackTrace();
            return null;
        }
        return resultado;
    }
    
    public boolean ejecutar(String sql){
        try {
            Statement sentencia = getConexion().createStatement(
                ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
