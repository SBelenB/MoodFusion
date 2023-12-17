package Interfaces;

import Dao.Main;
import Personas.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class DAOUsuarioImp implements DAOUsuario {

    Main main = new Main();

    public DAOUsuarioImp() {
    }

    @Override
    public void registrar(Usuario usuario) {
        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO usuarios (id, nombre, telefono) VALUES(?, ?, ?)");

            insertar.setInt(1, usuario.getId());
            insertar.setString(2, usuario.getUsuario());
            insertar.setString(3, usuario.getTelefono());
            insertar.executeUpdate();

            conectar.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar(Usuario usuario) {
        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement modificar = conectar.prepareStatement("UPDATE usuarios set nombre = ?, telefono = ? where id = ?");

            modificar.setString(1, usuario.getUsuario());
            modificar.setInt(2, usuario.getId());
            modificar.setString(3, usuario.getTelefono());
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
                usuario.setTelefono(consulta.getString("telefono"));

                conectar.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public DefaultTableModel mostrar() {
        // Definir la sentencia SQL para seleccionar todos los registros de la tabla usuarios
        String sql = "SELECT * FROM usuarios";

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
