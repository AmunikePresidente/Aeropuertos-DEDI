package pa.cifpaviles.dam.aeropuerto.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import pa.cifpaviles.dam.aeropuerto.componentes.DatosCompanya;
import pa.cifpaviles.dam.aeropuerto.componentes.EditarCompanya;
import pa.cifpaviles.dam.aeropuerto.dto.Companya;
import pa.cifpaviles.dam.aeropuerto.logica.CompanyaTableModel;
import pa.cifpaviles.dam.aeropuerto.logica.LogicaNegocio;
import pa.cifpaviles.dam.aeropuerto.logica.ValidationResult;

public class FrmCompanyas extends javax.swing.JFrame {

    private static final FrmCompanyas INSTANCE = new FrmCompanyas();

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase) 
    public static FrmCompanyas getInstance() {
        return INSTANCE;
    }

    /**
     * Creates new form FrmCompanyas
     */
    private FrmCompanyas() {
        initComponents();
        loadCompanies();
        agregarAyudaContextual();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompanyas = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        tblCompanyas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCompanyas);

        btnConsultar.setText("Consultar / Editar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnAlta.setText("Dar de alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnEliminar.setText("Dar de baja");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlta)
                .addGap(143, 143, 143)
                .addComponent(btnEliminar)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnAlta)
                    .addComponent(btnEliminar))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        DatosCompanya datos = new DatosCompanya(this);

        // Crear un JDialog para mostrar los datos de la compañía
        JDialog dialog = new JDialog(this, "Datos de la Compañía", true); // 'this' se refiere a FrmCompanyas
        dialog.getContentPane().add(datos);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tblCompanyas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String codigo = (String) tblCompanyas.getValueAt(filaSeleccionada, 1);

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta compañía?", "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                ValidationResult result = LogicaNegocio.eliminarCompanya(codigo);
                if (result.isValid()) {
                    JOptionPane.showMessageDialog(this, "Compañía eliminada correctamente.");
                    loadCompanies(); // Vuelve a cargar la tabla después de eliminar
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar la compañía: " + result.getValidationErrorMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una compañía para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        int filaSeleccionada = tblCompanyas.getSelectedRow();

        if (filaSeleccionada >= 0) {
            // Obtener el código de la compañía seleccionada en la fila
            String codigo = (String) tblCompanyas.getValueAt(filaSeleccionada, 1);

            // Buscar la compañía en tu lista de compañías (sustituye 'tuMetodoParaObtenerCompanyaPorCodigo' por el nombre correcto)
            Companya companya = LogicaNegocio.getCompanyaByCodigo(codigo);

            if (companya != null) {
                // Crear una instancia de EditarCompanya y pasarle la compañía como parámetro
                EditarCompanya editarCompanya = new EditarCompanya(this, companya);

                // Crear un JDialog para mostrar el panel de edición
                JDialog dialog = new JDialog(this, "Editar Compañía", true);
                dialog.getContentPane().add(editarCompanya);
                dialog.pack();
                dialog.setLocationRelativeTo(this);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCompanyas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCompanyas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCompanyas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCompanyas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCompanyas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCompanyas;
    // End of variables declaration//GEN-END:variables

    public void loadCompanies() {
        tblCompanyas.setModel(new CompanyaTableModel(LogicaNegocio.getAllCompanyas()));
    }

    private void agregarAyudaContextual() {
        // Agrega KeyListener para detectar la tecla F1
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    mostrarAyuda();
                }
            }
        });

        // Asegúrate de que el formulario pueda detectar los eventos de teclado
        this.setFocusable(true);
    }

    private void mostrarAyuda() {
        if (btnConsultar.hasFocus()) {
            JOptionPane.showMessageDialog(this, "Botón 'Consultar/Editar':\n"
                    + "Solo funciona si seleccionas un campo en la tabla.\n"
                    + "Usa este botón para editar la información de una compañía existente.");
        } else if (btnAlta.hasFocus()) {
            JOptionPane.showMessageDialog(this, "Botón 'Dar de Alta':\n"
                    + "Utiliza este botón para crear una nueva compañía.\n"
                    + "Rellena los campos necesarios en el formulario que aparece.");
        } else if (btnEliminar.hasFocus()) {
            JOptionPane.showMessageDialog(this, "Botón 'Eliminar':\n"
                    + "Selecciona una compañía de la tabla y usa este botón para eliminarla.\n"
                    + "Se pedirá confirmación antes de completar la eliminación.");
        } else {
            JOptionPane.showMessageDialog(this, "Ayuda General del Formulario de Compañías:\n"
                    + "1. Usa 'Consultar/Editar' para modificar una compañía existente.\n"
                    + "2. Usa el botón 'Dar de Alta' para agregar una nueva compañía.\n"
                    + "3.Usa 'Eliminar' para remover una compañía de la lista."
            );
        }
    }

}
