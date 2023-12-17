package Interfaces;

import Personas.Usuario;

public interface DAOUsuario {
    
    public void registrar(Usuario usuario);
    
    public void modificar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public void buscar(Usuario usuario);
    
}
