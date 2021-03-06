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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * Autores: Eutimio Arévalo, James Romero
 */
public class Frm_RegistarMultas extends javax.swing.JDialog {

    NormativaDAO normativaD = new NormativaDAO("Componentes");
    PersonaDAO personaD = new PersonaDAO("Datos");
    LicenciaDAO licenciaD = new LicenciaDAO("Datos");
    VehiculoDAO vehiculoD = new VehiculoDAO("Datos");
    MultaDAO multaD = new MultaDAO("Datos");
    ListaSimple lista;
    String mensaje = "";
    Persona agente;
    Persona persona;
    SimpleDateFormat d = new SimpleDateFormat("dd/MM/yy");
    String fecha;

    /**
     * Creates new form Frm_RegistarMultas
     */
    public Frm_RegistarMultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Calendar c =  new GregorianCalendar();
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH) + 1;
        int anio = c.get(Calendar.YEAR);
        fecha = dia + "/" + mes + "/" + anio;
        lbFecha.setText(fecha);
        lista = personaD.obtenerListaPersona();
        Componentes.cargarCombo(cbCedula, lista, "cedula");
        Componentes.cargarCombo(jComboBoxRubro, normativaD.listar(), "rubro");
        Componentes.cargarCombo(cbTipoVehiculo);
        this.setLocationRelativeTo(null);
        listener();
    }

    public Frm_RegistarMultas(java.awt.Frame parent, boolean modal, long idPersona) {
        super(parent, modal);
        initComponents();
        agente = (Persona) personaD.obtenerPersona(idPersona);
        Calendar c =  new GregorianCalendar();
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH) + 1;
        int anio = c.get(Calendar.YEAR);
        fecha = dia + "/" + mes + "/" + anio;
        lbFecha.setText(fecha);
        lista = personaD.obtenerListaPersona();
        Componentes.cargarComboRestriccion(cbCedula, lista, "cedula", agente.getCedula());
        Componentes.cargarCombo(jComboBoxRubro, normativaD.listar(), "rubro");
        Componentes.cargarCombo(cbTipoVehiculo);
        lbAgente.setText(agente.getNombre() + " " + agente.getApellido());
        this.setLocationRelativeTo(null);
        listener();
    }
    
    /**
     * El siguiente método permite limpiar los campos para registrar una nueva multa.
     */
    public void limpiar(){
        cbCedula.setSelectedIndex(0);
        cbPlaca.setSelectedIndex(0);
        jComboBoxRubro.setSelectedIndex(0);
        cbTipoVehiculo.setSelectedIndex(0);
        taObservaciones.setText("");
    }

    /**
     * El siguiete método permite abrir el frame de la persona
     */
    public void FrmPersona() {
        new Frm_RegistrarPersona(null, true, agente.getIdPersona()).setVisible(true);
    }

    /**
     * El siguiete método permite mostrar el contenido de las cedulas mientras se va escribiendo
     */
    public void listener() {
        cbCedula.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar()) || Character.isLetter(e.getKeyChar())) {
                    if ((mensaje.length() + 1) < 11) {
                        mensaje = mensaje + (e.getKeyChar());
                        ListaSimple tmp = Utilidades.obtenerSubLista(lista, "cedula", mensaje);
                        Componentes.cargarComboRestriccion(cbCedula, tmp, "cedula", agente.getCedula(), mensaje);
                    } else {
                        persona = (Persona) Utilidades.obtenerDato(lista, "cedula", mensaje);
                        Licencia lic = (Licencia) Utilidades.obtenerDato(licenciaD.listar(), "idPersona", String.valueOf(persona.getIdPersona()));
                        lbNombre.setText(persona.getNombre());
                        lbApellido.setText(persona.getApellido());
                        lbNroLicencia.setText(lic.getNroLicencia());
                    }

                } else {
                    if ((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) && mensaje.length() > 0) {
                        mensaje = mensaje.substring(0, mensaje.length() - 1);
                        if (mensaje.length() == 0) {
                            Componentes.cargarComboRestriccion(cbCedula, lista, "cedula", agente.getCedula());
                        } else {
                            ListaSimple tmp = Utilidades.obtenerSubLista(lista, "cedula", mensaje);
                            Componentes.cargarComboRestriccion(cbCedula, tmp, "cedula", agente.getCedula(), mensaje);
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxRubro = new javax.swing.JComboBox<>();
        jButtonAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRubro = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbTipoVehiculo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbCedula = new javax.swing.JComboBox<>();
        cbPlaca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        btIngresarPersona = new javax.swing.JButton();
        lbModelo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbNroLicencia = new javax.swing.JLabel();
        jButtonVehiculo = new javax.swing.JButton();
        lbMonto = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbGravedad = new javax.swing.JLabel();
        lbPuntosDesc = new javax.swing.JLabel();
        lbPuntosAct = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbAgente = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taObservaciones = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(153, 153, 255));
        jPanel2.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Registrar Multa");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Licencia:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Puntos Actuales:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Placa Vehicular");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Observaciones:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Rubro");

        jComboBoxRubro.setEditable(true);
        jComboBoxRubro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "Nro de placa" }));
        jComboBoxRubro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRubroItemStateChanged(evt);
            }
        });
        jComboBoxRubro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBoxRubroKeyTyped(evt);
            }
        });

        jButtonAgregar.setText("AGREGAR");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jTextAreaRubro.setColumns(20);
        jTextAreaRubro.setRows(5);
        jScrollPane1.setViewportView(jTextAreaRubro);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Nombre del Agente");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Fecha de multa");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Tipo de Vehiculo");

        cbTipoVehiculo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camion", "Bus", "Moto", "Auto", "Camioneta" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Marca:");

        cbCedula.setEditable(true);
        cbCedula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCedula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCedulaItemStateChanged(evt);
            }
        });

        cbPlaca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPlacaItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        lbNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Apellido");

        lbApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btIngresarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/47.png"))); // NOI18N
        btIngresarPersona.setText(" Ingresar Persona");
        btIngresarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarPersonaActionPerformed(evt);
            }
        });

        lbModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Cedula");

        lbNroLicencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/110.png"))); // NOI18N
        jButtonVehiculo.setText(" Ingresar Vehículo");
        jButtonVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVehiculoActionPerformed(evt);
            }
        });

        lbMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Monto a Pagar:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Descuento de puntos:");

        lbGravedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbPuntosDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbPuntosAct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbAgente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        taObservaciones.setColumns(20);
        taObservaciones.setRows(5);
        jScrollPane2.setViewportView(taObservaciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(lbAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)
                        .addGap(19, 19, 19)
                        .addComponent(lbNroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13)
                        .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel13)
                        .addGap(13, 13, 13)
                        .addComponent(lbApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(cbCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btIngresarPersona)
                        .addGap(298, 298, 298)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(lbGravedad, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(lbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cbTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButtonVehiculo)
                        .addGap(347, 347, 347)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(lbPuntosAct, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel10)
                        .addGap(372, 372, 372)
                        .addComponent(jLabel16)
                        .addGap(14, 14, 14)
                        .addComponent(lbPuntosDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296)
                        .addComponent(jLabel14)
                        .addGap(19, 19, 19)
                        .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lbNroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(lbApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(cbCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btIngresarPersona))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBoxRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbGravedad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(cbPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addComponent(lbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(cbTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVehiculo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addComponent(lbPuntosAct, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel16))
                    .addComponent(lbPuntosDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * El siguiete método permite presentar toda la información correspondiente al rubro al momento de seleccionar un rubro
     * @param evt 
     */
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

    /**
     * El siguiete método permite mostrar la información que se va escribiendo
     * @param evt 
     */
    private void jComboBoxRubroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxRubroKeyTyped
        // TODO add your handling code here:
        char valiar = evt.getKeyChar();
        if (Character.isLetter(valiar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jComboBoxRubroKeyTyped

    /**
     * El siguiete método permite abrir el frame de la persona
     * @param evt 
     */
    private void btIngresarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarPersonaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        FrmPersona();

    }//GEN-LAST:event_btIngresarPersonaActionPerformed

    /**
     * El siguiete método permite abrir el frame del veículo y envía el lugin de la persona
     * @param evt 
     */
    private void jButtonVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVehiculoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Frm_RegistrarAuto fip;
        fip = new Frm_RegistrarAuto((Frame) SwingUtilities.getWindowAncestor(this), true, agente.getIdPersona());
        fip.setVisible(true);

    }//GEN-LAST:event_jButtonVehiculoActionPerformed

    /**
     * El siguiete método permite mostrar, escribir  y seleccionar la cédula correspondiente a la persona
     * @param evt 
     */
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
                    persona = (Persona) personaD.obtenerPersona(cbCedula.getSelectedItem().toString());
                    lbNombre.setText(persona.getNombre());
                    lbApellido.setText(persona.getApellido());
                    Licencia licencia = (Licencia) licenciaD.obtenerPersona(persona.getIdPersona());
                    if (licencia == null) {
                        licencia = new Licencia("", 0, 0, "");
                    }
                    lbNroLicencia.setText(licencia.getNroLicencia());
                    lbPuntosAct.setText(String.valueOf(licencia.getPuntos()));
                    //Persona dat = (Persona) Utilidades.obtenerDato(personaD.listar(), "idPersona", cbCedula.getSelectedItem().toString());
                    Componentes.cargarCombo(cbPlaca, vehiculoD.obtenerListaPersona(persona.getIdPersona(), true), "placa");
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_cbCedulaItemStateChanged

    /**
     *  El siguiete método permite mostrar y seleccionar la placa correspondiente al vehículo de la persona
     * @param evt 
     */
    private void cbPlacaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPlacaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cbPlaca.getSelectedIndex() == 0) {
                lbModelo.setText("");
            } else {
                try {
                    Vehiculo dato = (Vehiculo) (Utilidades.obtenerDato(vehiculoD.listar(), "placa", cbPlaca.getSelectedItem().toString()));
                    lbModelo.setText(dato.getModelo());
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_cbPlacaItemStateChanged

    /**
     *  El siguiete método permite agregar todos los datos correspondiente a la multa
     * @param evt 
     */
    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
        Persona per = (Persona) personaD.obtenerPersona(cbCedula.getSelectedItem().toString());
        Licencia lic = (Licencia) licenciaD.obtenerPersona(per.getIdPersona());
        Vehiculo veh = (Vehiculo) vehiculoD.obtenerVehiculo(cbPlaca.getSelectedItem().toString());
        if (lbNombre.getText().length() > 0 && jTextAreaRubro.getText().length() > 0 && taObservaciones.getText().length() > 0) {
            multaD.setMulta(null);
            multaD.getMulta().setIdAgente(agente.getIdPersona());
            multaD.getMulta().setFecha(fecha);
            multaD.getMulta().setTipoMulta(jComboBoxRubro.getSelectedItem().toString());
            multaD.getMulta().setIdPersona(per.getIdPersona());
            multaD.getMulta().setIdVehiculo(veh.getIdVehiculo());
            multaD.getMulta().setValorMulta(Double.valueOf(lbMonto.getText()));
            double puntoAct = Double.parseDouble(lbPuntosAct.getText());
            double puntoDes = Double.parseDouble(lbPuntosDesc.getText());
            multaD.getMulta().setTotalPuntos(puntoDes);
            multaD.getMulta().setObservaciones(taObservaciones.getText());

            if (multaD.guardar()) {
                JOptionPane.showMessageDialog(null, "La multa se ha registrado con exito");
                float pa = Float.parseFloat(lbPuntosAct.getText());
                float pD = Float.parseFloat(lbPuntosDesc.getText());
                float total = (pa - pD);
                if (total < 0) {
                    lic.setPuntos(0);
                    JOptionPane.showMessageDialog(null, "Los puntos de licencia");
                } else {
                    lic.setPuntos(total);
                }
                limpiar();
             
            } else {
                JOptionPane.showMessageDialog(null, "La multa NO se ha registrado");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese datos");
        }
        
    }//GEN-LAST:event_jButtonAgregarActionPerformed

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
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonVehiculo;
    private javax.swing.JComboBox<String> jComboBoxRubro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaRubro;
    private javax.swing.JLabel lbAgente;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbGravedad;
    private javax.swing.JLabel lbModelo;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNroLicencia;
    private javax.swing.JLabel lbPuntosAct;
    private javax.swing.JLabel lbPuntosDesc;
    private javax.swing.JTextArea taObservaciones;
    // End of variables declaration//GEN-END:variables
}
