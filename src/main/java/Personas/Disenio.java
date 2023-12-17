package Personas;

import Interfaces.DAOUsuarioImp;
import javax.swing.JOptionPane;

public class Disenio extends javax.swing.JFrame {

    public Disenio() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void limpiar() {
        cajaTextoId.setText("");
        cajaTextoNombre.setText("");
    }
    
    //Crear un nuevo registro
    public void registrar(){
        DAOUsuarioImp usuario_dao = new DAOUsuarioImp();
        
        Usuario usuario = new Usuario();
        
        if (cajaTextoId.getText().isEmpty() || cajaTextoNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor ingrese el registro correctamente");
        } else {
            int id = Integer.parseInt(cajaTextoId.getText());
            String nombre = cajaTextoNombre.getText();
            
            usuario.setId(id);
            usuario.setUsuario(nombre);
            
            usuario_dao.registrar(usuario);
            JOptionPane.showMessageDialog(null, "Registro ingresado correctamente");
        }
    }
    
    //Método para buscar
    public void buscar() {
        DAOUsuarioImp usuario_dao = new DAOUsuarioImp();
        
        Usuario usuario = new Usuario();
        
        if (cajaTextoId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor digite el id a buscar");
        } else {
            int id = Integer.parseInt(cajaTextoId.getText());

            usuario.setId(id);

            usuario_dao.buscar(usuario);

            cajaTextoId.setText(String.valueOf(usuario.getId()));
            cajaTextoNombre.setText(usuario.getUsuario());

            JOptionPane.showMessageDialog(null, "Registro encontrado con éxito");
        }
    }
    
    //Modificar un registro
    public void actualizar() {
        DAOUsuarioImp usuario_dao = new DAOUsuarioImp();

        Usuario usuario = new Usuario();

        if (cajaTextoId.getText().isEmpty() || cajaTextoNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el registro que desea modificar");
        } else {
            int id = Integer.parseInt(cajaTextoId.getText());

            String nombre = cajaTextoNombre.getText();

            usuario.setId(id);
            usuario.setUsuario(nombre);
            
            usuario_dao.modificar(usuario);

            JOptionPane.showMessageDialog(null, "Registro modificado exitosamente");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cajaTextoNombre = new javax.swing.JTextField();
        cajaTextoId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registro de Pacientes");

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nombre y Apellido:");

        cajaTextoNombre.setBackground(new java.awt.Color(153, 153, 255));

        cajaTextoId.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(199, 199, 199))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cajaTextoId, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaTextoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cajaTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        btnRegistrar.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(102, 102, 102));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(102, 102, 102));
        btnConsultar.setText("BUSCAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(102, 102, 102));
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(102, 102, 102));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnRegistrar)
                .addGap(34, 34, 34)
                .addComponent(btnConsultar)
                .addGap(35, 35, 35)
                .addComponent(btnModificar)
                .addGap(31, 31, 31)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrar();
        limpiar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        buscar();
        limpiar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        actualizar();
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DAOUsuarioImp usuario_dao = new DAOUsuarioImp();
        
        Usuario usuario = new Usuario();
        
        if (cajaTextoId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el registro que desea modificar");
        } else {
            //Obtenemos el id y el nombre de la caja de texto
            int id = Integer.parseInt(cajaTextoId.getText());
            usuario.setId(id);
            //Seteamos la eliminación y se la pasamos al objeto usuario
            usuario_dao.eliminar(usuario);
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Disenio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField cajaTextoId;
    private javax.swing.JTextField cajaTextoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
