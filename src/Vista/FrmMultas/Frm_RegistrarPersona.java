/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.FrmMultas;

import Controlador.DAO.LicenciaDAO;
import Controlador.DAO.PersonaDAO;
import Controlador.DAO.TipoLicenciaDAO;
import Vista.Tablas.TablaPersona;
import Vista.Tablas.TablaTipo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Controlador.Utilidades;
import Vista.componentes.Componentes;

/**
 *
 * @author ASUS
 */
public class Frm_RegistrarPersona extends javax.swing.JDialog {

    /**
     * Creates new form Frm_RegistrarPersona
     */
    TablaTipo modeloTipo = new TablaTipo();
    TablaPersona modeloPersona = new TablaPersona();
    PersonaDAO personaD = new PersonaDAO("Datos");
    LicenciaDAO licenciaD = new LicenciaDAO("Datos");
    TipoLicenciaDAO tipoLicenciaD = new TipoLicenciaDAO("Componentes");
    private ArrayList<String> tipos = new ArrayList<>();
    public Frm_RegistrarPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Componentes.cargarCombo(jComboBoxTipoLicencia, tipoLicenciaD.listar(), "tipo");
        cargarTablaPersona();
        this.setLocationRelativeTo(null);
    }

    public void cargarTablaPersona(){
        modeloPersona.setListaPersona(personaD.listar());
        modeloPersona.setListaLicencia(licenciaD.listar());
        tbPersonas.setModel(modeloPersona);
        tbPersonas.updateUI();
        cargarTablaTipos();
    }
    
    public void cargarTablaTipos(){
        modeloTipo.setLista(tipos);
        tbTipos.setModel(modeloTipo);
        tbTipos.updateUI();
    }
    
    public void limpiar(){
        txfCedula.setText(null);
        txfNombre.setText(null);
        txfApellido.setText(null);
        txfDireccion.setText(null);
        txfTelefono.setText(null);
        txfNroLicencia.setText(null);
        txfFechaCaducidad.setText(null);
        tipos.clear();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfCedula = new javax.swing.JTextField();
        txfApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        txfDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfNroLicencia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txfFechaCaducidad = new javax.swing.JTextField();
        jButtonAgregarTipo = new javax.swing.JButton();
        jButtonEliminarTipo = new javax.swing.JButton();
        jComboBoxTipoLicencia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPersonas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTipos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("DATOS DE LA PERSONA");

        jLabel2.setText("Cédula:");

        txfCedula.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txfCedulaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txfCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfCedulaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfCedulaFocusLost(evt);
            }
        });
        txfCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCedulaActionPerformed(evt);
            }
        });
        txfCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCedulaKeyTyped(evt);
            }
        });

        jLabel5.setText("Apellido:");

        jLabel7.setText("Teléfono:");

        jLabel8.setText("DATOS DE LA LICENCIA");

        jLabel10.setText("Fecha Caducidad:");

        txfFechaCaducidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfFechaCaducidadActionPerformed(evt);
            }
        });

        jButtonAgregarTipo.setText("Agregar Tipo");
        jButtonAgregarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarTipoActionPerformed(evt);
            }
        });

        jButtonEliminarTipo.setText("Eliminar Tipo");
        jButtonEliminarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTipoActionPerformed(evt);
            }
        });

        jComboBoxTipoLicencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Tipo Licencia:");

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        tbPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbPersonas);

        jLabel3.setText("Nombre:");

        jLabel6.setText("Dirrección:");

        jLabel9.setText("Nro Licencia:");

        tbTipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tbTipos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(144, 144, 144)
                                        .addComponent(jButtonGuardar)
                                        .addGap(170, 170, 170)
                                        .addComponent(jButtonCancelar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(txfNroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(165, 165, 165)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 10, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(299, 299, 299)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(284, 284, 284)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonEliminarTipo)
                        .addComponent(jButtonAgregarTipo)))
                .addGap(18, 18, 18)
                .addComponent(txfFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfNroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txfFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAgregarTipo))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminarTipo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfCedulaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txfCedulaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaAncestorAdded

    private void txfCedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfCedulaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaFocusGained

    private void txfCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfCedulaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaFocusLost

    private void txfCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaActionPerformed

    private void txfCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCedulaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txfCedulaKeyTyped

    private void txfFechaCaducidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfFechaCaducidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfFechaCaducidadActionPerformed

    private void jButtonAgregarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarTipoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxTipoLicencia.getSelectedIndex() != 0) {
            String dato = (String)jComboBoxTipoLicencia.getSelectedItem();
            tipos.add(dato);
            cargarTablaTipos();
        }
    }//GEN-LAST:event_jButtonAgregarTipoActionPerformed

    private void jButtonEliminarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTipoActionPerformed
        // TODO add your handling code here:
        int fila = tbTipos.getSelectedRow();
        if (fila >= 0) {
            tipos.remove(fila);
            cargarTablaTipos();
        }else{
            JOptionPane.showConfirmDialog(null, "Seleccione el tipo de licencia que desea eliminar");
        }
    }//GEN-LAST:event_jButtonEliminarTipoActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        if (txfCedula.getText().length() > 0 && txfNombre.getText().length() > 0 && txfApellido.getText().length() > 0 && txfDireccion.getText().length() > 0 && txfTelefono.getText().length() > 0 && txfNroLicencia.getText().length() > 0 && txfFechaCaducidad.getText().length() > 0 && tipos.size() > 0) {
            if (!Utilidades.datoRepetido(personaD.listar(), "cedula", txfCedula.getText())) {
                personaD.setPersona(null);
                personaD.getPersona().setCedula(txfCedula.getText());
                personaD.getPersona().setNombre(txfNombre.getText());
                personaD.getPersona().setApellido(txfApellido.getText());
                personaD.getPersona().setDireccion(txfDireccion.getText());
                personaD.getPersona().setTelefono(txfTelefono.getText());
                licenciaD.setLicencia(null);
                licenciaD.getLicencia().setPropietario(txfCedula.getText());
                licenciaD.getLicencia().setNroLicencia(txfNroLicencia.getText());
                licenciaD.getLicencia().setPuntos(30);
                licenciaD.getLicencia().setFechaCaducidad(txfFechaCaducidad.getText());
                licenciaD.getLicencia().setTipos(tipos);
                if (personaD.guardar() && licenciaD.guardar()) {
                    JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                    limpiar();
                    cargarTablaPersona();
                }else{
                    JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                }
            }else{
                JOptionPane.showConfirmDialog(null, "Esa persona ya está registrada");
            }
        }else if(txfCedula.getText().length() > 0 && txfNombre.getText().length() > 0 && txfApellido.getText().length() > 0 && txfDireccion.getText().length() > 0 && txfTelefono.getText().length() > 0 && txfNroLicencia.getText().length() == 0 && txfFechaCaducidad.getText().length() == 0 && tipos.size() == 0){
            if (!Utilidades.datoRepetido(personaD.listar(), "cedula", txfCedula.getText())) {
                personaD.setPersona(null);
                personaD.getPersona().setCedula(txfCedula.getText());
                personaD.getPersona().setNombre(txfNombre.getText());
                personaD.getPersona().setApellido(txfApellido.getText());
                personaD.getPersona().setDireccion(txfDireccion.getText());
                personaD.getPersona().setTelefono(txfTelefono.getText());
                if (personaD.guardar()) {
                    JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                    limpiar();
                    cargarTablaPersona();
                }else{
                    JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                }
            }else{
                JOptionPane.showConfirmDialog(null, "Esa persona ya está registrada");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Llene todos los parametros o solo los de persona");
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_RegistrarPersona dialog = new Frm_RegistrarPersona(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarTipo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminarTipo;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBoxTipoLicencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbPersonas;
    private javax.swing.JTable tbTipos;
    private javax.swing.JTextField txfApellido;
    private javax.swing.JTextField txfCedula;
    private javax.swing.JTextField txfDireccion;
    private javax.swing.JTextField txfFechaCaducidad;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfNroLicencia;
    private javax.swing.JTextField txfTelefono;
    // End of variables declaration//GEN-END:variables
}
