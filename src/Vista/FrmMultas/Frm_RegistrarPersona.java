/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.FrmMultas;

import Controlador.DAO.CuentaDAO;
import Controlador.DAO.LicenciaDAO;
import Controlador.DAO.PersonaDAO;
import Controlador.DAO.TipoLicenciaDAO;
import Controlador.ListaSimple;
import Vista.Tablas.TablaPersona;
import Vista.Tablas.TablaTipo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Controlador.Utilidades;
import Modelo.Cuenta;
import Modelo.Licencia;
import Modelo.Persona;
import Vista.Frame_Menu_Login;
import Vista.Tablas.TablaPersonaEstado;
import Vista.componentes.Componentes;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author ASUS
 */
public class Frm_RegistrarPersona extends javax.swing.JDialog {

    /**
     * Creates new form Frm_RegistrarPersona
     */
    ListaSimple ls = new ListaSimple();
    TablaTipo modeloTipo = new TablaTipo();
    TablaPersona modeloPersona = new TablaPersona();
    TablaPersonaEstado modeloPersonaEstado = new TablaPersonaEstado();
    PersonaDAO personaD = new PersonaDAO("Datos");
    LicenciaDAO licenciaD = new LicenciaDAO("Datos");
    CuentaDAO cuentaD = new CuentaDAO("Datos");
    TipoLicenciaDAO tipoLicenciaD = new TipoLicenciaDAO("Componentes");
    private ArrayList<String> tipos = new ArrayList<>();
    private int rol;
    private Persona persona;

    public Frm_RegistrarPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(new Dimension(800, 700));
        Componentes.cargarCombo(jComboBoxTipoLicencia, tipoLicenciaD.listar(), "tipo");
        ls = personaD.listar();
        mostrarCheck();
        tfUser.setVisible(false);
        tfClave.setVisible(false);
        tfVeriClave.setVisible(false);
        lUser.setVisible(false);
        lbClave.setVisible(false);
        lcVeriClave.setVisible(false);
        chbtodos.setSelected(true);
        chbtodos.setEnabled(false);
        this.setLocationRelativeTo(null);
    }

    public Frm_RegistrarPersona(java.awt.Frame parent, boolean modal, long idPersona) {
        super(parent, modal);
        initComponents();
        this.setSize(new Dimension(800, 700));
        chbtodos.setSelected(true);
        chbtodos.setEnabled(false);
        persona = (Persona) personaD.obtenerPersona(idPersona);
        if (idPersona == -1) {
            this.rol = 1;
        } else {
            this.rol = persona.getIdRol();
            lbDatosCuenta.setVisible(false);
            tfUser.setVisible(false);
            tfClave.setVisible(false);
            tfVeriClave.setVisible(false);
            lUser.setVisible(false);
            lbClave.setVisible(false);
            lcVeriClave.setVisible(false);
            lbRol.setVisible(false);
            cbRol.setVisible(false);
            jButtonEditar.setVisible(false);
            jButtonEliminar.setVisible(false);
        }

        Componentes.cargarCombo(jComboBoxTipoLicencia, tipoLicenciaD.listar(), "tipo");
        mostrarCheck();
        this.setLocationRelativeTo(null);

    }

    public void cargarTablaPersona() {
        if (rol == 1) {
            modeloPersonaEstado.setListaPersona(ls);
            modeloPersonaEstado.setListaLicencia(licenciaD);
            modeloPersonaEstado.setListaCuenta(cuentaD);
            tbPersonas.setModel(modeloPersonaEstado);
            tbPersonas.updateUI();
        } else if (rol == 2) {
            modeloPersona.setListaPersona(ls);
            modeloPersona.setListaLicencia(licenciaD);
            tbPersonas.setModel(modeloPersona);
            tbPersonas.updateUI();
        }
        cargarTablaTipos();
    }

    public void cargarTablaTipos() {
        modeloTipo.setLista(tipos);
        tbTipos.setModel(modeloTipo);
        tbTipos.updateUI();
    }

    public void limpiar() {
        txfCedula.setText(null);
        txfNombre.setText(null);
        txfApellido.setText(null);
        txfDireccion.setText(null);
        txfTelefono.setText(null);
        txfNroLicencia.setText(null);
        txfFechaCaducidad.setText(null);
        tfUser.setText(null);
        tfClave.setText(null);
        tfVeriClave.setText(null);
        tipos.clear();
    }

    public void mostrarCheck() {
        if (chbtodos.isSelected()) {
            if (rol == 1) {
                ls = personaD.listar();
            } else if (rol == 2) {
                ls = personaD.obtenerListaPersona();
            }
        } else if (chbagentes.isSelected()) {
            if (rol == 1) {
                ls = personaD.obtenerListaPersona(2);
            } else if (rol == 2) {
                ls = personaD.obtenerListaPersona(2, true);
            }
        } else if (chbparticulares.isSelected()) {
            if (rol == 1) {
                ls = personaD.obtenerListaPersona(3);
            } else if (rol == 2) {
                ls = personaD.obtenerListaPersona(3, true);
            }
        }
        cargarTablaPersona();
    }

    public void FrameMultas() {
        Frm_RegistarMultas fm = new Frm_RegistarMultas(null, true, persona.getIdPersona());
        fm.setVisible(true);
    }

    public void FrameMenu() {
        Frame_Menu_Login fm = new Frame_Menu_Login(-1);
        fm.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPersonas = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTipos = new javax.swing.JTable();
        lUser = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        lbClave = new javax.swing.JLabel();
        lcVeriClave = new javax.swing.JLabel();
        tfClave = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfNroLicencia = new javax.swing.JTextField();
        tfVeriClave = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        chbtodos = new javax.swing.JCheckBox();
        txfFechaCaducidad = new javax.swing.JTextField();
        chbagentes = new javax.swing.JCheckBox();
        jButtonAgregarTipo = new javax.swing.JButton();
        chbparticulares = new javax.swing.JCheckBox();
        jButtonEliminarTipo = new javax.swing.JButton();
        jComboBoxTipoLicencia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        lbDatosCuenta = new javax.swing.JLabel();
        lbDatosPersona = new javax.swing.JLabel();
        lbCedula = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        txfDireccion = new javax.swing.JTextField();
        txfTelefono = new javax.swing.JTextField();
        txfApellido = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        txfCedula = new javax.swing.JTextField();
        txfNombre = new javax.swing.JTextField();
        cbRol = new javax.swing.JComboBox<>();
        lbRol = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/56.png"))); // NOI18N
        jButtonGuardar.setText(" Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/114.png"))); // NOI18N
        jButtonCancelar.setText("Salir");
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
        tbPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPersonasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbPersonas);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Nro Licencia:");

        tbTipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tbTipos);

        lUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lUser.setText("Usuario:");

        lbClave.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbClave.setText("Contraseña:");

        lcVeriClave.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lcVeriClave.setText("Verificar Contaseña:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("DATOS DE LA LICENCIA");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("MOSTRAR PERSONAS");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Fecha Caducidad:");

        chbtodos.setText("TODOS");
        chbtodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbtodosActionPerformed(evt);
            }
        });

        chbagentes.setText("AGENTES");
        chbagentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbagentesActionPerformed(evt);
            }
        });

        jButtonAgregarTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/110.png"))); // NOI18N
        jButtonAgregarTipo.setText(" Agregar Tipo");
        jButtonAgregarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarTipoActionPerformed(evt);
            }
        });

        chbparticulares.setText("PARTICULARES");
        chbparticulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbparticularesActionPerformed(evt);
            }
        });

        jButtonEliminarTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/boton-x.png"))); // NOI18N
        jButtonEliminarTipo.setText(" Eliminar Tipo");
        jButtonEliminarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTipoActionPerformed(evt);
            }
        });

        jComboBoxTipoLicencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Tipo Licencia:");

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        lbDatosCuenta.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbDatosCuenta.setText("DATOS DE LA CUENTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txfNroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(lbDatosCuenta)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonGuardar)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(167, 167, 167)
                                            .addComponent(jButtonEditar)
                                            .addGap(46, 46, 46)
                                            .addComponent(jButtonEliminar)
                                            .addGap(60, 60, 60)
                                            .addComponent(jButtonCancelar)))
                                    .addComponent(jButtonEliminarTipo)
                                    .addComponent(jButtonAgregarTipo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(lUser)
                                                .addGap(23, 23, 23))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbClave)
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfClave, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(61, 61, 61)
                                                .addComponent(lcVeriClave)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfVeriClave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 145, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(jLabel11)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(chbtodos)
                .addGap(55, 55, 55)
                .addComponent(chbagentes)
                .addGap(83, 83, 83)
                .addComponent(chbparticulares)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbDatosCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lUser)
                    .addComponent(lcVeriClave)
                    .addComponent(tfVeriClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txfNroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(txfFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAgregarTipo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminarTipo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbtodos)
                    .addComponent(chbagentes)
                    .addComponent(chbparticulares))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbDatosPersona.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbDatosPersona.setText("DATOS DE LA PERSONA");

        lbCedula.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbCedula.setText("Cédula:");

        lbNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbNombre.setText("Nombre:");

        lbDireccion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbDireccion.setText("Dirrección:");

        txfApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfApellidoActionPerformed(evt);
            }
        });

        lbApellido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbApellido.setText("Apellido:");

        lbTelefono.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbTelefono.setText("Teléfono:");

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Agente", "Particular" }));

        lbRol.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbRol.setText("Rol:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(lbDatosPersona))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCedula)
                            .addComponent(lbNombre)
                            .addComponent(lbDireccion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbApellido)
                            .addComponent(lbTelefono)
                            .addComponent(lbRol))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbDatosPersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCedula)
                            .addComponent(txfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbRol))
                            .addComponent(lbDireccion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTelefono)
                            .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        int fila = tbPersonas.getSelectedRow();
        if (fila >= 0) {

            Persona temp = (Persona) ls.obtenerPorPosicion(fila);
            Cuenta cuentaTmp = (Cuenta) cuentaD.obtenerPersona(temp.getIdPersona());
            Licencia licenciaTmp = (Licencia) licenciaD.obtenerPersona(temp.getIdPersona());

            if (txfCedula.getText().length() > 0 && txfNombre.getText().length() > 0 && txfApellido.getText().length() > 0 && txfDireccion.getText().length() > 0 && txfTelefono.getText().length() > 0 && txfNroLicencia.getText().length() > 0 && txfFechaCaducidad.getText().length() > 0 && tipos.size() > 0 && cbRol.getSelectedIndex() > 0) {
                if (!txfCedula.getText().equals(temp.getCedula()) || !txfNombre.getText().equals(temp.getNombre()) || !txfApellido.getText().equals(temp.getApellido()) || !txfDireccion.getText().equals(temp.getDireccion()) || !txfTelefono.getText().equals(temp.getTelefono()) || !txfNroLicencia.getText().equals(licenciaTmp.getNroLicencia()) || !txfFechaCaducidad.getText().equals(licenciaTmp.getFechaCaducidad()) || !tipos.toString().equals(licenciaTmp.getTipos().toString()) || cbRol.getSelectedIndex() != (temp.getIdRol() - 1)) {
                    if (!Utilidades.datoRepetido(personaD.listar(), "cedula", txfCedula.getText())) {

                        personaD.setPersona(null);

                        if (rol == 2) {
                            personaD.getPersona().setIdRol(3);
                        } else if (rol == 1) {
                            if (cbRol.getSelectedIndex() == 1) {
                                personaD.getPersona().setIdRol(2);
                            } else if (cbRol.getSelectedIndex() == 2) {
                                personaD.getPersona().setIdRol(3);
                            }
                        }

                        personaD.getPersona().setCedula(txfCedula.getText());
                        personaD.getPersona().setNombre(txfNombre.getText());
                        personaD.getPersona().setApellido(txfApellido.getText());
                        personaD.getPersona().setDireccion(txfDireccion.getText());
                        personaD.getPersona().setTelefono(txfTelefono.getText());

                        licenciaD.setLicencia(null);
                        licenciaD.getLicencia().setIdPersona(personaD.listar().tamanio() + 1);
                        licenciaD.getLicencia().setNroLicencia(txfNroLicencia.getText());
                        licenciaD.getLicencia().setPuntos(30);
                        licenciaD.getLicencia().setFechaCaducidad(txfFechaCaducidad.getText());
                        licenciaD.getLicencia().setTipos(tipos);

                        if (rol == 2 || (rol == 1 && cbRol.getSelectedIndex() == 2)) {
                            if (personaD.guardar() && licenciaD.guardar()) {
                                JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                                limpiar();
                                mostrarCheck();

                            } else {
                                JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                            }
                        } else if (rol == 1 && cbRol.getSelectedIndex() == 1) {

                            if (tfUser.getText().length() > 0 && tfClave.getText().length() > 0 && tfVeriClave.getText().length() > 0) {
                                System.out.println(tfUser.getText() + " " + tfVeriClave.getText());
                                if (tfClave.getText().equals(tfVeriClave.getText())) {
                                    cuentaD.setCuenta(null);
                                    cuentaD.getCuenta().setUsuario(tfUser.getText());
                                    cuentaD.getCuenta().setContrasenia(tfClave.getText());
                                    cuentaD.getCuenta().setIdPersona(personaD.listar().tamanio() + 1);
                                    if (personaD.guardar() && cuentaD.guardar() && licenciaD.guardar()) {
                                        JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                                        limpiar();
                                        mostrarCheck();
                                    } else {
                                        JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Llene todos los parametros");
                            }
                        }

                    } else {
                        JOptionPane.showConfirmDialog(null, "Esa persona ya está registrada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No realizo cambios");
                }
            } else if (txfCedula.getText().length() > 0 && txfNombre.getText().length() > 0 && txfApellido.getText().length() > 0 && txfDireccion.getText().length() > 0 && txfTelefono.getText().length() > 0 && cbRol.getSelectedIndex() > 0) {
                if (!txfCedula.getText().equals(temp.getCedula()) || !txfNombre.getText().equals(temp.getNombre()) || !txfApellido.getText().equals(temp.getApellido()) || !txfDireccion.getText().equals(temp.getDireccion()) || !txfTelefono.getText().equals(temp.getTelefono()) || cbRol.getSelectedIndex() != (temp.getIdRol() - 1)) {
                    if (!Utilidades.datoRepetido(personaD.listar(), "cedula", txfCedula.getText())) {
                        personaD.setPersona(null);
                        if (rol == 2) {
                            personaD.getPersona().setIdRol(3);
                        } else if (rol == 1) {
                            if (cbRol.getSelectedIndex() == 1) {
                                personaD.getPersona().setIdRol(2);
                            } else if (cbRol.getSelectedIndex() == 2) {
                                personaD.getPersona().setIdRol(3);
                            }
                        }

                        personaD.getPersona().setCedula(txfCedula.getText());
                        personaD.getPersona().setNombre(txfNombre.getText());
                        personaD.getPersona().setApellido(txfApellido.getText());
                        personaD.getPersona().setDireccion(txfDireccion.getText());
                        personaD.getPersona().setTelefono(txfTelefono.getText());

                        if (rol == 2 || (rol == 1 && cbRol.getSelectedIndex() == 2)) {
                            if (personaD.guardar()) {
                                JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                                limpiar();
                                mostrarCheck();
                            } else {
                                JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                            }
                        } else if (rol == 1 && cbRol.getSelectedIndex() == 1) {

                            if (tfUser.getText().length() > 0 && tfClave.getText().length() > 0 && tfVeriClave.getText().length() > 0) {
                                System.out.println(tfUser.getText() + " " + tfVeriClave.getText());
                                if (tfClave.getText().equals(tfVeriClave.getText())) {
                                    cuentaD.setCuenta(null);
                                    cuentaD.getCuenta().setUsuario(tfUser.getText());
                                    cuentaD.getCuenta().setContrasenia(tfClave.getText());
                                    cuentaD.getCuenta().setIdPersona(personaD.listar().tamanio() + 1);
                                    if (personaD.guardar() && cuentaD.guardar()) {
                                        JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                                        limpiar();
                                        mostrarCheck();
                                    } else {
                                        JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Llene todos los parametros");
                            }
                        }

                    } else {
                        JOptionPane.showConfirmDialog(null, "Esa persona ya está registrada");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los parametros o solo los de persona");
            }
            mostrarCheck();
        } else {
            JOptionPane.showConfirmDialog(null, "Seleccione la persona que desea editar");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonEliminarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTipoActionPerformed
        // TODO add your handling code here:
        int fila = tbTipos.getSelectedRow();
        if (fila >= 0) {
            tipos.remove(fila);
            cargarTablaTipos();
        } else {
            JOptionPane.showConfirmDialog(null, "Seleccione el tipo de licencia que desea eliminar");
        }
    }//GEN-LAST:event_jButtonEliminarTipoActionPerformed

    private void chbparticularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbparticularesActionPerformed
        // TODO add your handling code here:
        if (chbparticulares.isSelected()) {
            chbtodos.setEnabled(true);
            chbagentes.setEnabled(true);
            chbtodos.setSelected(false);
            chbagentes.setSelected(false);
            chbparticulares.setEnabled(false);
        }
        mostrarCheck();
    }//GEN-LAST:event_chbparticularesActionPerformed

    private void jButtonAgregarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarTipoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxTipoLicencia.getSelectedIndex() != 0) {
            String dato = (String) jComboBoxTipoLicencia.getSelectedItem();
            tipos.add(dato);
            cargarTablaTipos();
        }
    }//GEN-LAST:event_jButtonAgregarTipoActionPerformed

    private void chbagentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbagentesActionPerformed
        // TODO add your handling code here:
        if (chbagentes.isSelected()) {
            chbtodos.setEnabled(true);
            chbparticulares.setEnabled(true);
            chbtodos.setSelected(false);
            chbparticulares.setSelected(false);
            chbagentes.setEnabled(false);
        }
        mostrarCheck();
    }//GEN-LAST:event_chbagentesActionPerformed

    private void chbtodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbtodosActionPerformed
        // TODO add your handling code here:
        if (chbtodos.isSelected()) {
            chbagentes.setEnabled(true);
            chbparticulares.setEnabled(true);
            chbagentes.setSelected(false);
            chbparticulares.setSelected(false);
            chbtodos.setEnabled(false);
        }
        mostrarCheck();
    }//GEN-LAST:event_chbtodosActionPerformed

    private void txfApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfApellidoActionPerformed

    private void tbPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPersonasMouseClicked
        // TODO add your handling code here:
        int fila = tbPersonas.getSelectedRow();
        if (fila >= 0) {
            Persona temp = (Persona) ls.obtenerPorPosicion(fila);
            txfCedula.setText(temp.getCedula());
            txfNombre.setText(temp.getNombre());
            txfApellido.setText(temp.getApellido());
            txfDireccion.setText(temp.getDireccion());
            txfTelefono.setText(temp.getTelefono());
            cbRol.setSelectedIndex(temp.getIdRol() - 1);
            Cuenta cuentaTmp = (Cuenta) cuentaD.obtenerPersona(temp.getIdPersona());
            Licencia licenciaTmp = (Licencia) licenciaD.obtenerPersona(temp.getIdPersona());
            if (cuentaTmp != null) {
                tfUser.setText(cuentaTmp.getUsuario());
                tfClave.setText(cuentaTmp.getContrasenia());
                tfVeriClave.setText(cuentaTmp.getContrasenia());
            }
            if (licenciaTmp != null) {
                txfNroLicencia.setText(licenciaTmp.getNroLicencia());
                txfFechaCaducidad.setText(licenciaTmp.getFechaCaducidad());
                tipos = licenciaTmp.getTipos();
                cargarTablaTipos();
            }
        }
    }//GEN-LAST:event_tbPersonasMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        if (rol != 1) {
            this.dispose();
            FrameMultas();
        } else {
            this.dispose();
            FrameMenu();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tbPersonas.getSelectedRow();
        if (fila >= 0) {
            Persona temp = (Persona) ls.obtenerPorPosicion(fila);
            personaD.cambiarEstado(temp.getIdPersona(), "Datos/Persona.json");
            Cuenta cuentaTmp = (Cuenta) cuentaD.obtenerPersona(temp.getIdPersona());
            Licencia licenciaTmp = (Licencia) licenciaD.obtenerPersona(temp.getIdPersona());
            if (cuentaTmp != null) {
                cuentaD.cambiarEstado(temp.getIdPersona(), "Datos/Cuenta.json");
            }
            if (licenciaTmp != null) {
                licenciaD.cambiarEstado(temp.getIdPersona(), "Datos/Licencia.json");
            }
            mostrarCheck();
        } else {
            JOptionPane.showConfirmDialog(null, "Seleccione la persona que desea eliminar");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        if (txfCedula.getText().length() > 0 && txfNombre.getText().length() > 0 && txfApellido.getText().length() > 0 && txfDireccion.getText().length() > 0 && txfTelefono.getText().length() > 0 && txfNroLicencia.getText().length() > 0 && txfFechaCaducidad.getText().length() > 0 && tipos.size() > 0 && cbRol.getSelectedIndex() > 0) {
            if (!Utilidades.datoRepetido(personaD.listar(), "cedula", txfCedula.getText())) {

                personaD.setPersona(null);

                if (rol == 2) {
                    personaD.getPersona().setIdRol(3);
                } else if (rol == 1) {
                    if (cbRol.getSelectedIndex() == 1) {
                        personaD.getPersona().setIdRol(2);
                    } else if (cbRol.getSelectedIndex() == 2) {
                        personaD.getPersona().setIdRol(3);
                    }
                }

                personaD.getPersona().setCedula(txfCedula.getText());
                personaD.getPersona().setNombre(txfNombre.getText());
                personaD.getPersona().setApellido(txfApellido.getText());
                personaD.getPersona().setDireccion(txfDireccion.getText());
                personaD.getPersona().setTelefono(txfTelefono.getText());

                licenciaD.setLicencia(null);
                licenciaD.getLicencia().setIdPersona(personaD.listar().tamanio() + 1);
                licenciaD.getLicencia().setNroLicencia(txfNroLicencia.getText());
                licenciaD.getLicencia().setPuntos(30);
                licenciaD.getLicencia().setFechaCaducidad(txfFechaCaducidad.getText());
                licenciaD.getLicencia().setTipos(tipos);

                if (rol == 2 || (rol == 1 && cbRol.getSelectedIndex() == 2)) {
                    if (personaD.guardar() && licenciaD.guardar()) {
                        JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                        limpiar();
                        mostrarCheck();

                    } else {
                        JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                    }
                } else if (rol == 1 && cbRol.getSelectedIndex() == 1) {

                    if (tfUser.getText().length() > 0 && tfClave.getText().length() > 0 && tfVeriClave.getText().length() > 0) {
                        System.out.println(tfUser.getText() + " " + tfVeriClave.getText());
                        if (tfClave.getText().equals(tfVeriClave.getText())) {
                            cuentaD.setCuenta(null);
                            cuentaD.getCuenta().setUsuario(tfUser.getText());
                            cuentaD.getCuenta().setContrasenia(tfClave.getText());
                            cuentaD.getCuenta().setIdPersona(personaD.listar().tamanio() + 1);
                            if (personaD.guardar() && cuentaD.guardar() && licenciaD.guardar()) {
                                JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                                limpiar();
                                mostrarCheck();
                            } else {
                                JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Llene todos los parametros");
                    }
                }

            } else {
                JOptionPane.showConfirmDialog(null, "Esa persona ya está registrada");
            }
        } else if (txfCedula.getText().length() > 0 && txfNombre.getText().length() > 0 && txfApellido.getText().length() > 0 && txfDireccion.getText().length() > 0 && txfTelefono.getText().length() > 0 && cbRol.getSelectedIndex() > 0) {
            if (!Utilidades.datoRepetido(personaD.listar(), "cedula", txfCedula.getText())) {
                personaD.setPersona(null);
                if (rol == 2) {
                    personaD.getPersona().setIdRol(3);
                } else if (rol == 1) {
                    if (cbRol.getSelectedIndex() == 1) {
                        personaD.getPersona().setIdRol(2);
                    } else if (cbRol.getSelectedIndex() == 2) {
                        personaD.getPersona().setIdRol(3);
                    }
                }

                personaD.getPersona().setCedula(txfCedula.getText());
                personaD.getPersona().setNombre(txfNombre.getText());
                personaD.getPersona().setApellido(txfApellido.getText());
                personaD.getPersona().setDireccion(txfDireccion.getText());
                personaD.getPersona().setTelefono(txfTelefono.getText());

                if (rol == 2 || (rol == 1 && cbRol.getSelectedIndex() == 2)) {
                    if (personaD.guardar()) {
                        JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                        limpiar();
                        mostrarCheck();
                    } else {
                        JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                    }
                } else if (rol == 1 && cbRol.getSelectedIndex() == 1) {

                    if (tfUser.getText().length() > 0 && tfClave.getText().length() > 0 && tfVeriClave.getText().length() > 0) {
                        System.out.println(tfUser.getText() + " " + tfVeriClave.getText());
                        if (tfClave.getText().equals(tfVeriClave.getText())) {
                            cuentaD.setCuenta(null);
                            cuentaD.getCuenta().setUsuario(tfUser.getText());
                            cuentaD.getCuenta().setContrasenia(tfClave.getText());
                            cuentaD.getCuenta().setIdPersona(personaD.listar().tamanio() + 1);
                            if (personaD.guardar() && cuentaD.guardar()) {
                                JOptionPane.showConfirmDialog(null, "Se guardo correctamente");
                                limpiar();
                                mostrarCheck();
                            } else {
                                JOptionPane.showConfirmDialog(null, "No se pudo guardar");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Las claves no coinciden");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Llene todos los parametros");
                    }
                }

            } else {
                JOptionPane.showConfirmDialog(null, "Esa persona ya está registrada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los parametros o solo los de persona");
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

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
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JCheckBox chbagentes;
    private javax.swing.JCheckBox chbparticulares;
    private javax.swing.JCheckBox chbtodos;
    private javax.swing.JButton jButtonAgregarTipo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonEliminarTipo;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBoxTipoLicencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lUser;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbCedula;
    private javax.swing.JLabel lbClave;
    private javax.swing.JLabel lbDatosCuenta;
    private javax.swing.JLabel lbDatosPersona;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRol;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lcVeriClave;
    private javax.swing.JTable tbPersonas;
    private javax.swing.JTable tbTipos;
    private javax.swing.JTextField tfClave;
    private javax.swing.JTextField tfUser;
    private javax.swing.JTextField tfVeriClave;
    private javax.swing.JTextField txfApellido;
    private javax.swing.JTextField txfCedula;
    private javax.swing.JTextField txfDireccion;
    private javax.swing.JTextField txfFechaCaducidad;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfNroLicencia;
    private javax.swing.JTextField txfTelefono;
    // End of variables declaration//GEN-END:variables
}
