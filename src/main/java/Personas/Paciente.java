package Personas;

public class Paciente {
    private int id;
    private String paciente;
    private String telefono;
    
    public Paciente(){}
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getPaciente(){
        return paciente;
    }
    
    public void setPaciente(String paciente){
        this.paciente = paciente;
    }    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }   
}
