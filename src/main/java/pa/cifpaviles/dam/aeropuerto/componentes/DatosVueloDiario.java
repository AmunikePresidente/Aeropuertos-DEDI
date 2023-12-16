package pa.cifpaviles.dam.aeropuerto.componentes;

import java.awt.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.SwingUtilities;
import pa.cifpaviles.dam.aeropuerto.dto.Aeropuerto;
import pa.cifpaviles.dam.aeropuerto.dto.Companya;
import pa.cifpaviles.dam.aeropuerto.logica.LogicaNegocio;
import pa.cifpaviles.dam.aeropuerto.dto.Municipio;
import pa.cifpaviles.dam.aeropuerto.dto.VueloBase;
import pa.cifpaviles.dam.aeropuerto.gui.FrmCompanyas;
import pa.cifpaviles.dam.aeropuerto.gui.FrmVuelosBase;

public class DatosVueloDiario extends javax.swing.JPanel {

    private VueloBase vueloB;
    private FrmVuelosBase frmVuelosBase;

    public VueloBase getVueloBase() {
        return vueloB;
    }

    private boolean habilitado;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public void setVueloBase(VueloBase vueloB) {
        this.vueloB = vueloB;
        if (vueloB != null && !vueloB.getCodigoVuelo().isBlank()) {
            txtCodVuelo.setText(vueloB.getCodigoVuelo());
            txtFechaVuelo.setText(String.valueOf(vueloB.getNumeroPlazas()));

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            if (vueloB.getHoraSalida() != null) {
                txtHoraSalida.setText(dateFormat.format(vueloB.getHoraSalida()));
            } else {
                txtHoraSalida.setText("");
            }

            if (vueloB.getHoraLlegada() != null) {
                TxtHoraLlegada.setText(dateFormat.format(vueloB.getHoraLlegada()));
            } else {
                TxtHoraLlegada.setText("");
            }

            txtPlazasOcupadas.setText(vueloB.getDiasOperacion());

            if (vueloB.getCodigoAeropuertoOrigen() != null) {
                //cbAeroOrigen.setSelectedItem(vueloB.getCodigoAeropuertoOrigen());
            } else {
                //cbAeroOrigen.setSelectedIndex(-1);
            }

            // Establecer el aeropuerto de destino seleccionado en el combobox
            if (vueloB.getCodigoAeropuertoDestino() != null) {
                //cbAeroDestino.setSelectedItem(vueloB.getCodigoAeropuertoDestino());
            } else {
                //cbAeroDestino.setSelectedIndex(-1);
            }
        }
    }

    public DatosVueloDiario(FrmVuelosBase frmVuelosBase) {
        initComponents();
        inicializarComboboxAeropuertos();
        this.frmVuelosBase = frmVuelosBase;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtFechaVuelo = new javax.swing.JTextField();
        txtHoraSalida = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodVuelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtHoraLlegada = new javax.swing.JTextField();
        txtPlazasOcupadas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioVuelo = new javax.swing.JTextField();

        lblCodigo.setText("Fecha Vuelo");

        lblNombre.setText("Hora Salida:");

        txtHoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraSalidaActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("CodVuelo:");

        jLabel2.setText("Hora Llegada:");

        TxtHoraLlegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtHoraLlegadaActionPerformed(evt);
            }
        });

        txtPlazasOcupadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlazasOcupadasActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero PlazasOcupadas");

        jLabel6.setText("Precio Vuelo");

        txtPrecioVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel2)
                        .addComponent(lblNombre)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblCodigo)))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCodVuelo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addComponent(txtHoraSalida, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TxtHoraLlegada)
                        .addComponent(txtPlazasOcupadas)
                        .addComponent(txtPrecioVuelo))
                    .addComponent(txtFechaVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(369, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtCodVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(TxtHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtPlazasOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarVueloBase();
        cerrarComponente();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtHoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraSalidaActionPerformed

    private void TxtHoraLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtHoraLlegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtHoraLlegadaActionPerformed

    private void txtPlazasOcupadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlazasOcupadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlazasOcupadasActionPerformed

    private void txtPrecioVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVueloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVueloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtHoraLlegada;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCodVuelo;
    private javax.swing.JTextField txtFechaVuelo;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtPlazasOcupadas;
    private javax.swing.JTextField txtPrecioVuelo;
    // End of variables declaration//GEN-END:variables

    private void guardarVueloBase() {
        String codigoVuelo = txtCodVuelo.getText();
        int numeroPlazas = Integer.parseInt(txtFechaVuelo.getText());

        Date horaSalida = null;
        Date horaLlegada = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        try {
            horaSalida = dateFormat.parse(txtHoraSalida.getText());
            horaLlegada = dateFormat.parse(TxtHoraLlegada.getText());
        } catch (ParseException e) {
            // Maneja la excepción en caso de que la conversión falle.
            e.printStackTrace();
        }

        String diasOperacion = txtPlazasOcupadas.getText();
        // Obtener el código IATA del aeropuerto de origen seleccionado en el combobox
        //String codigoAerOrigen = (String) cbAeroOrigen.getSelectedItem();
        // Obtener el código IATA del aeropuerto de destino seleccionado en el combobox
        //String codigoAerDestino = (String) cbAeroDestino.getSelectedItem();
        
        //VueloBase vueloBase = new VueloBase(codigoVuelo, numeroPlazas, horaSalida, horaLlegada, diasOperacion, codigoAerOrigen, codigoAerDestino);
        //LogicaNegocio.addVueloBase(vueloBase);

        frmVuelosBase.loadVuelosBase();

    }

    private void inicializarComboboxAeropuertos() {
        List<Aeropuerto> aeropuertos = LogicaNegocio.getAllAeropuertos();
        for (Aeropuerto aeropuerto : aeropuertos) {
            //cbAeroOrigen.addItem(aeropuerto.getCodigoIATA());
            //cbAeroDestino.addItem(aeropuerto.getCodigoIATA());
        }
    }

    private void cerrarComponente() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }

}
