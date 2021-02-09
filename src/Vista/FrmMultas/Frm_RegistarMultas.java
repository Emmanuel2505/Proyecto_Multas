/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.FrmMultas;

import Controlador.DAO.LicenciaDAO;
import Controlador.DAO.MarcaDAO;
import Controlador.DAO.MultaDAO;
import Controlador.DAO.NormativaDAO;
import Controlador.DAO.PersonaDAO;
import Controlador.DAO.VehiculoDAO;
import Controlador.ListaSimple;
import Controlador.Utilidades;
import Modelo.Licencia;
import Modelo.Normativa;
import Modelo.Persona;
import Modelo.Vehiculo;
import Vista.componentes.Componentes;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author timoa
 */
public class Frm_RegistarMultas extends javax.swing.JDialog {

    NormativaDAO normativaD = new NormativaDAO("Componentes");
    PersonaDAO personaD = new PersonaDAO("Datos");
    LicenciaDAO licenciaD = new LicenciaDAO("Datos");
    VehiculoDAO vehiculoD = new VehiculoDAO("Datos");
    MultaDAO multaD = new MultaDAO("Datos");
    SimpleDateFormat d = new SimpleDateFormat("dd/MM/yy");
    Date fecha = new Date();
    
    String mensaje = "";
    Persona persona;

    /**
     * Creates new form Frm_RegistarMultas
     */
    public Frm_RegistarMultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yy");
        lbFecha.setText(String.valueOf(d.format(new Date())));
        Componentes.cargarCombo(cbCedula, personaD.listar(), "cedula");
        Componentes.cargarCombo(jComboBoxRubro, normativaD.listar(), "rubro");
        Componentes.cargarCombo(cbTipoVehiculo);
        this.setLocationRelativeTo(null);
        listener();
    }

    public Frm_RegistarMultas(java.awt.Frame parent, boolean modal, long idPersona) {
        super(parent, modal);  
        initComponents();
        persona = (Persona)personaD.obtenerPersona(idPersona);
        lbFecha.setText(String.valueOf(d.format(fecha)));
        Componentes.cargarComboRestriccion(cbCedula, personaD.listar(), "cedula",persona.getCedula());
        Componentes.cargarCombo(jComboBoxRubro, normativaD.listar(), "rubro");
        Componentes.cargarCombo(cbTipoVehiculo);
        lbAgente.setText(persona.getNombre()+" "+persona.getApellido());
        this.setLocationRelativeTo(null);
        listener();
    }
    
    public void FrmPersona(){
        new Frm_RegistrarPersona(null, true, persona.getIdPersona()).setVisible(true);
    }
    
    public void FrmAuto(){
        new Frm_RegistrarAuto(null, true, persona.getIdPersona()).setVisible(true);
    }

    public void listener() {
        cbCedula.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar()) || Character.isLetter(e.getKeyChar())) {
                    System.out.println(mensaje.length());
                    if ((mensaje.length() + 1) < 11) {
                        mensaje = mensaje + (e.getKeyChar());
                        ListaSimple tmp = Utilidades.obtenerSubLista(personaD.listar(), "cedula", mensaje);
                        Componentes.cargarComboRestriccion(cbCedula, tmp, "cedula", persona.getCedula(),mensaje);
                    } else {
                        System.out.println(mensaje);
                        Persona dato = (Persona) Utilidades.obtenerDato(personaD.listar(), "cedula", mensaje);
                        Licencia lic = (Licencia) Utilidades.obtenerDato(licenciaD.listar(), "idPersona", String.valueOf(dato.getIdPersona()));
                        lbNombre.setText(dato.getNombre());
                        lbApellido.setText(dato.getApellido());
                        lbNroLicencia.setText(lic.getNroLicencia());
                    }

                } else {
                    if ((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) && mensaje.length() > 0) {
                        mensaje = mensaje.substring(0, mensaje.length() - 1);
                        if (mensaje.length() == 0) {
                            Componentes.cargarComboRestriccion(cbCedula, personaD.listar(),persona.getCedula(), "cedula");
                        } else {
                            ListaSimple tmp = Utilidades.obtenerSubLista(personaD.listar(), "cedula", mensaje);
                            Componentes.cargarComboRestriccion(cbCedula, tmp, "cedula", persona.getCedula(),mensaje);
                        }
                    }
                    e.consume();

                }

            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lplaca = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxRubro = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRubro = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lTipoVehiculo = new javax.swing.JLabel();
        cbTipoVehiculo = new javax.swing.JComboBox<>();
        lMarca = new javax.swing.JLabel();
        cbCedula = new javax.swing.JComboBox<>();
        cbPlaca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        btIngresarPersona = new javax.swing.JButton();
        lbMarca = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbNroLicencia = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbMonto = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbGravedad = new javax.swing.JLabel();
        lbPuntosDesc = new javax.swing.JLabel();
        lbPuntosAct = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbAgente = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taobservaciones = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(153, 153, 255));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Registrar Multa");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 2, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Licencia:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Puntos Actuales:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        lplaca.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lplaca.setText("Placa Vehicular");
        jPanel2.add(lplaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 175, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Observaciones:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 406, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Rubro");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 109, -1, -1));

        jComboBoxRubro.setEditable(true);
        jComboBoxRubro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "Nro de placa" }));
        jComboBoxRubro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRubroItemStateChanged(evt);
            }
        });
        jComboBoxRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRubroActionPerformed(evt);
            }
        });
        jComboBoxRubro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxRubroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBoxRubroKeyTyped(evt);
            }
        });
        jPanel2.add(jComboBoxRubro, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 132, 143, -1));

        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 511, 390, 40));

        jTextAreaRubro.setColumns(20);
        jTextAreaRubro.setRows(5);
        jScrollPane1.setViewportView(jTextAreaRubro);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 169, 420, 63));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Nombre del Agente");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 405, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Fecha de multa");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 329, -1, -1));

        lTipoVehiculo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lTipoVehiculo.setText("Tipo de Vehiculo");
        jPanel2.add(lTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 215, -1, -1));

        cbTipoVehiculo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camion", "Bus", "Moto", "Auto", "Camioneta" }));
        jPanel2.add(cbTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 207, 270, 24));

        lMarca.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lMarca.setText("Marca:");
        jPanel2.add(lMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 175, -1, -1));

        cbCedula.setEditable(true);
        cbCedula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCedula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCedulaItemStateChanged(evt);
            }
        });
        cbCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCedulaActionPerformed(evt);
            }
        });
        jPanel2.add(cbCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 81, 156, -1));

        cbPlaca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPlacaItemStateChanged(evt);
            }
        });
        cbPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlacaActionPerformed(evt);
            }
        });
        jPanel2.add(cbPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 174, 106, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        lbNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 194, 26));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Apellido");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        lbApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 190, 26));

        btIngresarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/47.png"))); // NOI18N
        btIngresarPersona.setText(" Ingresar Persona");
        btIngresarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(btIngresarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 118, -1, -1));

        lbMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 169, 95, 26));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Cedula");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 81, -1, -1));

        lbNroLicencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbNroLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 150, 26));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/110.png"))); // NOI18N
        jButton2.setText(" Ingresar Vehículo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 264, -1, -1));

        lbMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 352, 194, 26));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Monto a Pagar:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Descuento de puntos:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        lbGravedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbGravedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 260, 26));

        lbPuntosDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbPuntosDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 308, 194, 26));

        lbPuntosAct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbPuntosAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 264, 194, 26));

        lbFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 194, 26));

        lbAgente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbAgente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 390, 40));

        taobservaciones.setColumns(20);
        taobservaciones.setRows(5);
        jScrollPane2.setViewportView(taobservaciones);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 430, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxRubroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRubroItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (jComboBoxRubro.getSelectedIndex() == 0) {
                jTextAreaRubro.setText("");
                lbGravedad.setText("");
            } else {
                try {
                    //lbGravedad.setEnabled(true);
                    jTextAreaRubro.setEnabled(true);
                    Normativa dato = (Normativa) normativaD.listar().obtenerPorPosicion(jComboBoxRubro.getSelectedIndex() - 1);
                    jTextAreaRubro.setText(dato.getDescripcion());
                    lbGravedad.setText(dato.getTipoFalta());
                    lbMonto.setText(String.valueOf(Utilidades.montoMulta(lbGravedad.getText())));
                    lbPuntosDesc.setText(String.valueOf(Utilidades.puntosQuitar(lbGravedad.getText())));

                    //jTextFieldGravedad.setEnabled(false);
                    jTextAreaRubro.setEditable(false);
                } catch (Exception e) {

                }
            }
        }
    }//GEN-LAST:event_jComboBoxRubroItemStateChanged

    private void jComboBoxRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRubroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxRubroActionPerformed

    private void jComboBoxRubroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxRubroKeyTyped
        // TODO add your handling code here:
        char valiar = evt.getKeyChar();
        if (Character.isLetter(valiar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jComboBoxRubroKeyTyped

    private void jComboBoxRubroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxRubroKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxRubroKeyReleased

    private void btIngresarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarPersonaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        FrmPersona();

    }//GEN-LAST:event_btIngresarPersonaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Frm_RegistrarAuto fip;
        fip = new Frm_RegistrarAuto((Frame) SwingUtilities.getWindowAncestor(this), true);
        fip.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbCedulaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCedulaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cbCedula.getSelectedIndex() == 0) {
                lbNombre.setText("");
                lbApellido.setText("");
                lbNroLicencia.setText("");
                Componentes.cargarCombo(cbPlaca, new ListaSimple(), "");
            } else {
                try {
                    Persona dato = (Persona) personaD.obtenerPersona(cbCedula.getSelectedItem().toString());
                    System.out.println(dato.getNombre());
                    System.out.println(dato.getIdPersona());
                    lbNombre.setText(dato.getNombre());
                    lbApellido.setText(dato.getApellido());
                    Licencia licencia = (Licencia) licenciaD.obtenerPersona(dato.getIdPersona());
                    if (licencia == null) {
                        licencia = new Licencia("", 0, 0, "");
                    }
                    lbNroLicencia.setText(licencia.getNroLicencia());
                    lbPuntosAct.setText(String.valueOf(licencia.getPuntos()));
                    //Persona dat = (Persona) Utilidades.obtenerDato(personaD.listar(), "idPersona", cbCedula.getSelectedItem().toString());
                    Componentes.cargarCombo(cbPlaca, vehiculoD.obtenerListaPersona(dato.getIdPersona()), "placa");
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_cbCedulaItemStateChanged

    private void cbPlacaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPlacaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cbPlaca.getSelectedIndex() == 0) {
                lbMarca.setText("");
            } else {
                try {
                    Vehiculo dato = (Vehiculo) vehiculoD.listar().obtenerPorPosicion(cbPlaca.getSelectedIndex() - 1);
                    lbMarca.setText(dato.getModelo());
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_cbPlacaItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Persona per = (Persona)personaD.obtenerPersona(cbCedula.getSelectedItem().toString());
        Licencia lic = (Licencia) licenciaD.obtenerPersona(per.getIdPersona());
        if(lbNombre.getText().length() > 0 && jTextAreaRubro.getText().length() > 0 && taobservaciones.getText().length() > 0){
            multaD.setMulta(null);
            multaD.getMulta().setAgente(lbAgente.getText());
            multaD.getMulta().setFecha(fecha);
            multaD.getMulta().setTipoMulta(jComboBoxRubro.getSelectedItem().toString());
            multaD.getMulta().setIdPersona(per.getIdPersona());
            multaD.getMulta().setPlaca(cbPlaca.getSelectedItem().toString());
            multaD.getMulta().setValorMulta(Double.valueOf(lbMonto.getText()));
            double puntoAct = Double.valueOf(lbPuntosAct.getText());
            double puntoDes = Double.valueOf(lbPuntosDesc.getText());
            multaD.getMulta().setTotalPuntos(puntoDes);
            
            if(multaD.guardar()){
                JOptionPane.showMessageDialog(null, "La multa se ha registrado con exito");
                lic.setPuntos(puntoAct-puntoDes);
            }else{
                JOptionPane.showMessageDialog(null, "La multa NO se ha registrado");
                
            }        
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese datos");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlacaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbPlacaActionPerformed

    private void cbCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCedulaActionPerformed
        // TODO add your handling code here:
        if(!(lbNroLicencia.getText().length() > 0)){
            lMarca.setEnabled(false);
            lbMarca.setEnabled(false);
            lTipoVehiculo.setEnabled(false);
            lplaca.setEnabled(false);
            cbPlaca.setEnabled(false);
            cbTipoVehiculo.setEnabled(false);
        }else{
            lMarca.setEnabled(true);
            lbMarca.setEnabled(true);
            lTipoVehiculo.setEnabled(true);
            lplaca.setEnabled(true);
            cbPlaca.setEnabled(true);
            cbTipoVehiculo.setEnabled(true);
        }
    }//GEN-LAST:event_cbCedulaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_RegistarMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistarMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistarMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_RegistarMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_RegistarMultas dialog = new Frm_RegistarMultas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btIngresarPersona;
    private javax.swing.JComboBox<String> cbCedula;
    private javax.swing.JComboBox<String> cbPlaca;
    private javax.swing.JComboBox<String> cbTipoVehiculo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxRubro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaRubro;
    private javax.swing.JLabel lMarca;
    private javax.swing.JLabel lTipoVehiculo;
    private javax.swing.JLabel lbAgente;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbGravedad;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNroLicencia;
    private javax.swing.JLabel lbPuntosAct;
    private javax.swing.JLabel lbPuntosDesc;
    private javax.swing.JLabel lplaca;
    private javax.swing.JTextArea taobservaciones;
    // End of variables declaration//GEN-END:variables
}
