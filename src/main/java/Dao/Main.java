package Dao;

import Personas.Disenio;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    
    //Atributos de conexión
    private Connection conectar = null;
    private final String contrasena = "Marco@2016#";
    private final String usuario = "root";
    private final String db = "pacientes";
    private final String ip = "localhost";
    private final String puerto = "3306";
    private final String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;
    
    public Connection establecerConeccion(){
        try {
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Se conectó correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar" + e.toString());
        }
        return conectar;
    }
    
    public static void main(String[] args) {
    Main app = new Main();
    Connection connection = app.establecerConeccion();
    
    if (connection != null) {
        SwingUtilities.invokeLater(() -> {
            new Disenio().setVisible(true);
        });
    }
}
}