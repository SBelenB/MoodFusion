package Interfaces;

import Personas.Paciente;
import javax.swing.table.DefaultTableModel;

public interface DAOPaciente {
    
    public void registrar(Paciente paciente);
    
    public void modificar(Paciente paciente);
    
    public void eliminar(Paciente paciente);
    
    public void buscar(Paciente paciente);
    
    public DefaultTableModel mostrar();
    
}