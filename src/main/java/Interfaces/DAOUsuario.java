package Interfaces;

import Personas.Usuario;
import javax.swing.table.DefaultTableModel;

public interface DAOUsuario {
    
    public void registrar(Usuario usuario);
    
    public void modificar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public void buscar(Usuario usuario);
    
    public DefaultTableModel mostrar();
    
}