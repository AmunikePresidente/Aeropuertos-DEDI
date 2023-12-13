package pa.cifpaviles.dam.aeropuerto.componentes;

import java.awt.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import pa.cifpaviles.dam.aeropuerto.dto.Companya;
import pa.cifpaviles.dam.aeropuerto.logica.LogicaNegocio;
import pa.cifpaviles.dam.aeropuerto.dto.Municipio;
import pa.cifpaviles.dam.aeropuerto.dto.VueloBase;
import pa.cifpaviles.dam.aeropuerto.gui.FrmCompanyas;
import pa.cifpaviles.dam.aeropuerto.gui.FrmVuelosBase;

public class EditarVueloBase extends javax.swing.JPanel {

 private VueloBase vueloBase;
    private FrmVuelosBase frmVuelosBase;

    public VueloBase getVueloBase() {
        return vueloBase;
    }

    private boolean habilitado;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public void setVueloBase(VueloBase vueloBase) {
        this.vueloBase = vueloBase;
        if (vueloBase != null && !vueloBase.getCodigoVuelo().isBlank()) {
            txtCodVuelo.setText(vueloBase.getCodigoVuelo());
            txtNPlazas.setText(String.valueOf(vueloBase.getNumeroPlazas()));

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            if (vueloBase.getHoraSalida() != null) {
                txtHoraSalida.setText(dateFormat.format(vueloBase.getHoraSalida()));
            } else {
                txtHoraSalida.setText("");
            }

            if (vueloBase.getHoraLlegada() != null) {
                TxtHoraLlegada.setText(dateFormat.format(vueloBase.getHoraLlegada()));
            } else {
                TxtHoraLlegada.setText("");
            }

            txtDOperacion.setText(vueloBase.getDiasOperacion());
            txtCodAerOrigen.setText(vueloBase.getCodigoAeropuertoOrigen());
            txtCodAerDestino.setText(vueloBase.getCodigoAeropuertoDestino());
        }
    }

   public EditarVueloBase(FrmVuelosBase frmVuelosBase, VueloBase vueloBase1) {
    initComponents();
    this.frmVuelosBase = frmVuelosBase;
    this.vueloBase = vueloBase1;
    if (vueloBase1 != null && !vueloBase1.getCodigoVuelo().isBlank()) {
        txtCodVuelo.setText(vueloBase1.getCodigoVuelo());
        txtNPlazas.setText(String.valueOf(vueloBase1.getNumeroPlazas()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        if (vueloBase1.getHoraSalida() != null) {
            txtHoraSalida.setText(dateFormat.format(vueloBase1.getHoraSalida()));
        } else {
            txtHoraSalida.setText("");
        }

        if (vueloBase1.getHoraLlegada() != null) {
            TxtHoraLlegada.setText(dateFormat.format(vueloBase1.getHoraLlegada()));
        } else {
            TxtHoraLlegada.setText("");
        }

        txtDOperacion.setText(vueloBase1.getDiasOperacion());
        txtCodAerOrigen.setText(vueloBase1.getCodigoAeropuertoOrigen());
        txtCodAerDestino.setText(vueloBase1.getCodigoAeropuertoDestino());
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMunicipio = new javax.swing.JLabel();
        txtNPlazas = new javax.swing.JTextField();
        txtHoraSalida = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodVuelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtHoraLlegada = new javax.swing.JTextField();
        txtDOperacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodAerOrigen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodAerDestino = new javax.swing.JTextField();

        lblCodigo.setText("Nº plazas:");

        lblNombre.setText("Hora Salida:");

        lblMunicipio.setText("Dias operacion:");

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

        txtDOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDOperacionActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo Aeropuerto Origen:");

        txtCodAerOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodAerOrigenActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo Aeropuerto Destino");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(lblMunicipio)
                    .addComponent(lblNombre)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigo))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCodVuelo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNPlazas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtHoraLlegada)
                    .addComponent(txtDOperacion)
                    .addComponent(txtCodAerOrigen)
                    .addComponent(txtCodAerDestino))
                .addContainerGap(369, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtNPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMunicipio)
                    .addComponent(txtDOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodAerOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodAerDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
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

    private void txtDOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDOperacionActionPerformed

    private void txtCodAerOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodAerOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodAerOrigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtHoraLlegada;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblMunicipio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCodAerDestino;
    private javax.swing.JTextField txtCodAerOrigen;
    private javax.swing.JTextField txtCodVuelo;
    private javax.swing.JTextField txtDOperacion;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtNPlazas;
    // End of variables declaration//GEN-END:variables

    private void guardarVueloBase() {
        String codigoVuelo = txtCodVuelo.getText();
        int numeroPlazas = Integer.parseInt(txtNPlazas.getText());

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

        String diasOperacion = txtDOperacion.getText();
        String codigoAerOrigen = txtCodAerOrigen.getText();
        String codigoAerDestino = txtCodAerDestino.getText();

        VueloBase vueloBase = new VueloBase(codigoVuelo, numeroPlazas, horaSalida, horaLlegada, diasOperacion, codigoAerOrigen, codigoAerDestino);
        LogicaNegocio.addVueloBase(vueloBase);

        frmVuelosBase.loadVuelosBase();

    }

    private void cerrarComponente() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }

}
