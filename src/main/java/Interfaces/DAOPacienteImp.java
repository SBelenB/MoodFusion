package Interfaces;

import Dao.Main;
import Personas.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class DAOPacienteImp implements DAOPaciente {

    Main main = new Main();

    public DAOPacienteImp() {
    }

    @Override
    public void registrar(Paciente paciente) {
        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO paciente (id, nombre, telefono) VALUES(?, ?, ?)");

            insertar.setInt(1, paciente.getId());
            insertar.setString(2, paciente.getPaciente());
            insertar.setString(3, paciente.getTelefono());
            insertar.executeUpdate();

            conectar.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar(Paciente paciente) {
        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement modificar = conectar.prepareStatement("UPDATE paciente set nombre = ?, telefono = ? where id = ?");

            modificar.setString(1, paciente.getPaciente());
            modificar.setInt(2, paciente.getId());
            modificar.setString(3, paciente.getTelefono());
            modificar.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(Paciente paciente) {
        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM paciente WHERE id = ?");

            eliminar.setInt(1, paciente.getId());
            eliminar.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void buscar(Paciente paciente) {
        try {

            Connection conectar = main.establecerConeccion();

            PreparedStatement buscar = conectar.prepareStatement("select * from paciente where id = ?");

            buscar.setInt(1, paciente.getId());

            ResultSet consulta = buscar.executeQuery();
            if (consulta.next()) {
                paciente.setId(Integer.parseInt(consulta.getString("id")));
                paciente.setPaciente(consulta.getString("nombre"));
                paciente.setTelefono(consulta.getString("telefono"));

                conectar.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public DefaultTableModel mostrar() {
        // Definir la sentencia SQL para seleccionar todos los registros de la tabla pacientes
        String sql = "SELECT * FROM paciente";

        // Crear un modelo para almacenar los registros dentro de la tabla
        DefaultTableModel model = new DefaultTableModel();

        try {
            // Obtener la conexión a la base de datos
            Connection conectar = main.establecerConeccion();

            // Crear una declaración para ejecutar la consulta SQL
            PreparedStatement statement = conectar.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet rs = statement.executeQuery();

            // Obtener la información de las columnas de la consulta
            int numColumnas = rs.getMetaData().getColumnCount();

            // Agregar las columnas al modelo de la tabla sólo si no existen
            for (int column = 1; column <= numColumnas; column++) {
                model.addColumn(rs.getMetaData().getColumnName(column));
            }

            // Agregar las filas al modelo de la tabla
            while (rs.next()) {
                Object[] rowData = new Object[numColumnas];
                for (int i = 0; i < numColumnas; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}
