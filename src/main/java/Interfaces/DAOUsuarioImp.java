package Interfaces;

import Dao.Main;
import Personas.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOUsuarioImp implements DAOUsuario{
    Main main = new Main();
    
    public DAOUsuarioImp(){
    }
    
    @Override
    public void registrar(Usuario usuario){
        try{
            Connection conectar = main.establecerConeccion();
            
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO usuarios (id, nombre) VALUES(?, ?)");
            
            insertar.setInt(1, usuario.getId());
            insertar.setString(2, usuario.getUsuario());
            insertar.executeUpdate();
            
            conectar.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void modificar(Usuario usuario){
        try {
            Connection conectar = main.establecerConeccion();
            
            PreparedStatement modificar = conectar.prepareStatement("UPDATE usuarios set nombre = ? where id = ?");
            
            modificar.setString(1, usuario.getUsuario());
            modificar.setInt(2, usuario.getId());
            modificar.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void eliminar(Usuario usuario) {
        try {
            Connection conectar = main.establecerConeccion();
            
            PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            
            eliminar.setInt(1, usuario.getId());
            eliminar.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void buscar(Usuario usuario) {
        try {
            
            Connection conectar = main.establecerConeccion();
            
            PreparedStatement buscar = conectar.prepareStatement("select * from usuarios where id = ?");
            
            buscar.setInt(1, usuario.getId());
            
            ResultSet consulta = buscar.executeQuery();
            if (consulta.next()) {
                usuario.setId(Integer.parseInt(consulta.getString("id")));
                usuario.setUsuario(consulta.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}