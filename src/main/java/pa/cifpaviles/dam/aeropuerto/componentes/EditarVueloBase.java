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

public class EditarVueloBase extends javax.swing.JPanel {

    private VueloBase vueloBase = this.vueloBase;
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
            cbAeroDestino.setSelectedItem(vueloBase.getCodigoAeropuertoDestino());
            cbAeroOrigen.setSelectedItem(vueloBase.getCodigoAeropuertoOrigen());
        }
    }

    public EditarVueloBase(FrmVuelosBase frmVuelosBase, VueloBase vueloBase1) {
        initComponents();
        this.frmVuelosBase = frmVuelosBase;
        this.vueloBase = vueloBase1;
        inicializarComboboxAeropuertos();
        
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
            cbAeroDestino.setSelectedItem(vueloBase1.getCodigoAeropuertoDestino());
            cbAeroOrigen.setSelectedItem(vueloBase1.getCodigoAeropuertoOrigen());
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
        jLabel4 = new javax.swing.JLabel();
        cbAeroOrigen = new javax.swing.JComboBox<>();
        cbAeroDestino = new javax.swing.JComboBox<>();

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

        jLabel4.setText("Codigo Aeropuerto Destino");

        cbAeroOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAeroOrigenActionPerformed(evt);
            }
        });

        cbAeroDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAeroDestinoActionPerformed(evt);
            }
        });

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
                    .addComponent(cbAeroOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbAeroDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(cbAeroOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbAeroDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cbAeroOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAeroOrigenActionPerformed
        String codigoIATAOrigen = (String) cbAeroOrigen.getSelectedItem();
    }//GEN-LAST:event_cbAeroOrigenActionPerformed

    private void cbAeroDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAeroDestinoActionPerformed
        String codigoIATADestino = (String) cbAeroDestino.getSelectedItem();
    }//GEN-LAST:event_cbAeroDestinoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtHoraLlegada;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbAeroDestino;
    private javax.swing.JComboBox<String> cbAeroOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblMunicipio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCodVuelo;
    private javax.swing.JTextField txtDOperacion;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtNPlazas;
    // End of variables declaration//GEN-END:variables

    private void guardarVueloBase() {
    // Verificar si el VueloBase es nulo
    if (vueloBase == null) {
        return; // O manejar de alguna manera que no haya un VueloBase para editar
    }

    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date horaSalida = dateFormat.parse(txtHoraSalida.getText());
        Date horaLlegada = dateFormat.parse(TxtHoraLlegada.getText());

        // Crear una copia del VueloBase existente con los campos actualizados
        VueloBase updatedVueloBase = new VueloBase(
            txtCodVuelo.getText(),
            Integer.parseInt(txtNPlazas.getText()),
            horaSalida,
            horaLlegada,
            txtDOperacion.getText(),
            (String) cbAeroOrigen.getSelectedItem(),
            (String) cbAeroDestino.getSelectedItem()
        );

        // Actualizar el VueloBase en la lógica de negocio
        LogicaNegocio.updateVueloBaseByCodigo(vueloBase.getCodigoVuelo(), updatedVueloBase);

        // Recargar los datos de vuelos base en FrmVuelosBase
        frmVuelosBase.loadVuelosBase();

    } catch (ParseException e) {
        e.printStackTrace(); // Manejar la excepción como sea apropiado
    }

    }

    private void inicializarComboboxAeropuertos() {
        List<Aeropuerto> aeropuertos = LogicaNegocio.getAllAeropuertos();
        for (Aeropuerto aeropuerto : aeropuertos) {
            cbAeroDestino.addItem(aeropuerto.getCodigoIATA());
            cbAeroOrigen.addItem(aeropuerto.getCodigoIATA());
        }
    }

    private void cerrarComponente() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }

}
