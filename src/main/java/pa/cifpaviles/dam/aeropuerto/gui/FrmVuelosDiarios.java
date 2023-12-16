package pa.cifpaviles.dam.aeropuerto.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import pa.cifpaviles.dam.aeropuerto.componentes.DatosCompanya;
import pa.cifpaviles.dam.aeropuerto.componentes.DatosVueloBase;
import pa.cifpaviles.dam.aeropuerto.componentes.EditarCompanya;
import pa.cifpaviles.dam.aeropuerto.componentes.EditarVueloBase;
import pa.cifpaviles.dam.aeropuerto.dto.Companya;
import pa.cifpaviles.dam.aeropuerto.dto.VueloBase;
import pa.cifpaviles.dam.aeropuerto.dto.VueloDiario;
import pa.cifpaviles.dam.aeropuerto.logica.CompanyaTableModel;
import pa.cifpaviles.dam.aeropuerto.logica.LogicaNegocio;
import pa.cifpaviles.dam.aeropuerto.logica.ValidationResult;
import pa.cifpaviles.dam.aeropuerto.logica.VueloDiarioTableModel;
import pa.cifpaviles.dam.aeropuerto.logica.VuelosBaseTableModel;

public class FrmVuelosDiarios extends javax.swing.JFrame {

    private static final FrmVuelosDiarios INSTANCE = new FrmVuelosDiarios();

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase) 
    public static FrmVuelosDiarios getInstance() {
        return INSTANCE;
    }

    /**
     * Creates new form FrmCompanyas
     */
    private FrmVuelosDiarios() {
        initComponents();
        loadCompanies();
        agregarAyudaContextual();

    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVuelosDiarios = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tblVuelosDiarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVuelosDiarios);

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

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("¡PULSA F1 PARA OBTENER AYUDA!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(btnAlta)
                        .addGap(143, 143, 143)
                        .addComponent(btnEliminar)
                        .addGap(119, 119, 119))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed

        //DatosVueloDiario datos = new DatosVueloDiario(this); // Asume que tienes un formulario DatosVueloDiario
        JDialog dialog = new JDialog(this, "Datos del Vuelo Diario", true);
        //dialog.getContentPane().add(datos);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tblVuelosDiarios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String codigoVueloDiario = (String) tblVuelosDiarios.getValueAt(filaSeleccionada, 0);
            // Proceso de eliminación para vuelos diarios
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un vuelo diario para eliminar.");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        int filaSeleccionada = tblVuelosDiarios.getSelectedRow();

        if (filaSeleccionada >= 0) {
            String codigoVuelo = (String) tblVuelosDiarios.getValueAt(filaSeleccionada, 0);
            VueloDiario vueloDiario = LogicaNegocio.getVueloDiarioByCodigoVueloBase(codigoVuelo);

            if (vueloDiario != null) {
                //EditarVueloDiario editarVueloDiario = new EditarVueloDiario(this, vueloDiario);

                JDialog dialog = new JDialog(this, "Editar Vuelo Diario", true);
                //dialog.getContentPane().add(editarVueloDiario);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVuelosDiarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVuelosDiarios;
    // End of variables declaration//GEN-END:variables

    public void loadCompanies() {
        tblVuelosDiarios.setModel(new VueloDiarioTableModel(LogicaNegocio.getAllVuelosDiarios()));
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
                    + "Usa este botón para editar la información de un vuelo diario existente.");
        } else if (btnAlta.hasFocus()) {
            JOptionPane.showMessageDialog(this, "Botón 'Dar de Alta':\n"
                    + "Utiliza este botón para crear un nuevo vuelo diario.\n"
                    + "Rellena los campos necesarios en el formulario que aparece.");
        } else if (btnEliminar.hasFocus()) {
            JOptionPane.showMessageDialog(this, "Botón 'Eliminar':\n"
                    + "Selecciona un vuelo diario de la tabla y usa este botón para eliminarla.\n"
                    + "Se pedirá confirmación antes de completar la eliminación.");
        } else {
            JOptionPane.showMessageDialog(this, "Ayuda General del Formulario de Compañías:\n"
                    + "1. Usa 'Consultar/Editar' para modificar un vuelo diario existente.\n"
                    + "2. Usa el botón 'Dar de Alta' para agregar un nuevo vuelo diario.\n"
                    + "3.Usa 'Eliminar' para remover un vuelo diario de la lista."
            );
        }
    }

    public void loadVuelosBase() {
        tblVuelosDiarios.setModel(new VuelosBaseTableModel(LogicaNegocio.getAllVuelosBase()));
    }

}
