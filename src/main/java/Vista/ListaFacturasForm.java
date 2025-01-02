/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CtrlFacturaVentas;
import Controlador.CtrlRegistro;
import Controlador.SeguridadArchivos;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author user
 */
public class ListaFacturasForm extends javax.swing.JFrame {

    /**
     * Creates new form ListaFacturasForm
     */
    int xMouse, yMouse;
    int id;

    public ListaFacturasForm() {
        initComponents();
        setTime();
        setDocumentos();
    }
    
    public void InitListaFacturas(int id) {
        this.id = id;
        this.setSize(929, 786);
        this.setMaximumSize(this.getSize());
        this.setMinimumSize(this.getSize());
        this.setPreferredSize(this.getSize());
        this.setLocationRelativeTo(null);
        this.setCloseOperation();
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    }

    private void setCloseOperation() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SeguridadArchivos.EncriptarArchivos();
                System.exit(0);
            }
        });
    }
    
    private void setDocumentos() {
        AreaFacturas.setText("");
        DefaultListModel<String> model = new DefaultListModel<>();
        String[] documentos = CtrlFacturaVentas.LeerDocumentos();
        int i = 0;
        for (String documento : documentos) {
            model.add(i++, documento);
        }
        ListaDocumentos.setModel(model);
        ListaDocumentos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) { // Doble-clic detectado
                    int index = list.locationToIndex(evt.getPoint());
                    // Aquí puedes manejar el evento de doble clic.
                    try {
                        Object item = model.getElementAt(index);
                        String txtFin = "";
                        String txt = CtrlFacturaVentas.leerFacturaporID(item.toString());
                        String infoUsuario = CtrlRegistro.TomarInformacionUsuario(item.toString());
                        if (!infoUsuario.isEmpty()) {
                            txtFin = "Información del usuario: \n" + infoUsuario + "\n\n" + txt;
                        }
                        else {
                            txtFin = "Información del usuario: \nEl usuario ha sido eliminado." + "\n\n" + txt;
                        }
                        if (txt.isEmpty()) {
                            AreaFacturas.setText("Información del usuario: \n" + infoUsuario + "\n\nEl usuario no ha comprado nada.");
                        } else {
                            AreaFacturas.setText(txtFin);
                        }
                        //Inicia el scroll desde el inicio
                        AreaFacturas.setCaretPosition(0);
                    }catch (Exception ignored) {}
                }
            }
        });
    }

    private void setDocumentos(String[] documentos) {
        AreaFacturas.setText("");
        String txtFin = "";
        DefaultListModel<String> model = new DefaultListModel<>();
        int i = 0;
        for (String documento : documentos) {
            model.add(i++, documento);
        }
        ListaDocumentos.setModel(model);
        if (documentos.length == 1) {
            String txt = CtrlFacturaVentas.leerFacturaporID(documentos[0]);
            String infoUsuario = CtrlRegistro.TomarInformacionUsuario(documentos[0]);
            if (!infoUsuario.isEmpty()) {
                txtFin = "Información del usuario: \n" + infoUsuario + "\n\n" + txt;
            }
            else {
                txtFin = "Información del usuario: \nEl usuario ha sido eliminado." + "\n\n" + txt;
            }
            if (txt.isEmpty()) {
                AreaFacturas.setText("Información del usuario: \n" + infoUsuario + "\n\nEl usuario no ha comprado nada.");
            } else {
                AreaFacturas.setText(txtFin);
            }
            //Inicia el scroll desde el inicio
            AreaFacturas.setCaretPosition(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerfacturas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inventory = new javax.swing.JLabel();
        Xexit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaDocumentos = new javax.swing.JList<>();
        lblIDañadirFactura = new javax.swing.JLabel();
        IDAnadirFacturaField = new javax.swing.JTextField();
        btnInsertarFactura = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        documentoField = new javax.swing.JTextField();
        btnBuscarDocumento = new javax.swing.JButton();
        lblBuscarUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEliminarUser = new javax.swing.JLabel();
        eliminarUsuarioField = new javax.swing.JTextField();
        btnEliminarUsuario = new javax.swing.JButton();
        codigoField = new javax.swing.JTextField();
        Codigo = new javax.swing.JLabel();
        btnEliminarFactura = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaFacturas = new javax.swing.JTextArea();
        btnRefrescar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        buscarField = new javax.swing.JTextField();
        jTxtDate = new javax.swing.JLabel();
        jTxtime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerfacturas.setBackground(new java.awt.Color(51, 51, 51));
        headerfacturas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerfacturasMouseDragged(evt);
            }
        });
        headerfacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerfacturasMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FACTURAS");

        inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura32.png"))); // NOI18N

        Xexit.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 16)); // NOI18N
        Xexit.setForeground(new java.awt.Color(255, 255, 255));
        Xexit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Xexit.setText("Cerrar");
        Xexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Xexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XexitMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                XexitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerfacturasLayout = new javax.swing.GroupLayout(headerfacturas);
        headerfacturas.setLayout(headerfacturasLayout);
        headerfacturasLayout.setHorizontalGroup(
            headerfacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerfacturasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Xexit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 598, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inventory)
                .addGap(207, 207, 207))
        );
        headerfacturasLayout.setVerticalGroup(
            headerfacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerfacturasLayout.createSequentialGroup()
                .addGroup(headerfacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerfacturasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(headerfacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(headerfacturasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Xexit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(headerfacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(51, 51, 51));
        btnVolver.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER AL MENÚ\n");
        btnVolver.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 330, 120, 40));

        ListaDocumentos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(76, 76, 76), 1, true));
        ListaDocumentos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListaDocumentos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 300, 510));

        lblIDañadirFactura.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        lblIDañadirFactura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIDañadirFactura.setText("ID del usuario a añadir factura: ");
        jPanel1.add(lblIDañadirFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 300, -1));

        IDAnadirFacturaField.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        IDAnadirFacturaField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        IDAnadirFacturaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IDAnadirFacturaFieldKeyReleased(evt);
            }
        });
        jPanel1.add(IDAnadirFacturaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 140, 30));

        btnInsertarFactura.setBackground(new java.awt.Color(51, 51, 51));
        btnInsertarFactura.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 20)); // NOI18N
        btnInsertarFactura.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarFactura.setText("+");
        btnInsertarFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnInsertarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarFacturaMouseClicked(evt);
            }
        });
        btnInsertarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 640, 30, 30));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        documentoField.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        documentoField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(76, 76, 76)));
        documentoField.setPreferredSize(new java.awt.Dimension(64, 22));
        documentoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                documentoFieldKeyReleased(evt);
            }
        });
        jPanel3.add(documentoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 20));

        btnBuscarDocumento.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        btnBuscarDocumento.setText("BUSCAR");
        btnBuscarDocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarDocumentoMouseClicked(evt);
            }
        });
        btnBuscarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDocumentoActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, 20));

        lblBuscarUsuario.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        lblBuscarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscarUsuario.setText("Buscar usuario por documento: ");
        jPanel3.add(lblBuscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 300, 60));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(72, 72, 72));
        jLabel3.setText("(Si no existe, se agregará)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 160, 20));

        lblEliminarUser.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        lblEliminarUser.setText("ID de usuario a eliminar: ");
        jPanel1.add(lblEliminarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, 140, 20));

        eliminarUsuarioField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 75, 75), 1, true));
        eliminarUsuarioField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eliminarUsuarioFieldKeyReleased(evt);
            }
        });
        jPanel1.add(eliminarUsuarioField, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 640, 135, 30));

        btnEliminarUsuario.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar-usuario.png"))); // NOI18N
        btnEliminarUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnEliminarUsuario.setPreferredSize(new java.awt.Dimension(30, 30));
        btnEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarUsuarioMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 640, 30, 30));

        codigoField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 75, 75), 1, true));
        codigoField.setPreferredSize(new java.awt.Dimension(64, 18));
        codigoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoFieldKeyReleased(evt);
            }
        });
        jPanel1.add(codigoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 640, 135, 30));

        Codigo.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        Codigo.setText("Codigo: ");
        jPanel1.add(Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, -1, -1));

        btnEliminarFactura.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarfact.png"))); // NOI18N
        btnEliminarFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnEliminarFactura.setPreferredSize(new java.awt.Dimension(30, 30));
        btnEliminarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarFacturaMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 640, 30, 30));

        AreaFacturas.setEditable(false);
        AreaFacturas.setBackground(new java.awt.Color(255, 255, 255));
        AreaFacturas.setColumns(20);
        AreaFacturas.setRows(5);
        AreaFacturas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(76, 76, 76), 1, true));
        jScrollPane1.setViewportView(AreaFacturas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 340, 510));

        btnRefrescar.setBackground(new java.awt.Color(51, 51, 51));
        btnRefrescar.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 16)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setText("REFRESCAR");
        btnRefrescar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefrescarMouseClicked(evt);
            }
        });
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 110, 40));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, 20));

        lblBuscar.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscar.setText("Buscar Factura por Codigo: ");
        jPanel4.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        buscarField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(76, 76, 76), 1, true));
        buscarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFieldActionPerformed(evt);
            }
        });
        buscarField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarFieldKeyReleased(evt);
            }
        });
        jPanel4.add(buscarField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, 20));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 340, 60));

        jTxtDate.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        jTxtDate.setForeground(new java.awt.Color(51, 51, 51));
        jTxtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jTxtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 180, 41));

        jTxtime.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        jTxtime.setForeground(new java.awt.Color(51, 51, 51));
        jTxtime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jTxtime, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 430, 123, 39));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarFacturaMouseClicked
        // TODO add your handling code here:
        String codigo = codigoField.getText();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código de factura");
            return;
        }
        int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la factura?", "Eliminar Factura", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            CtrlFacturaVentas.EliminarFactura(codigo);
            codigoField.setText("");
            setDocumentos();
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }
    }//GEN-LAST:event_btnEliminarFacturaMouseClicked

    private void btnInsertarFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarFacturaMouseClicked
        // TODO add your handling code here:
        String id = IDAnadirFacturaField.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un ID");
            return;
        }
        boolean valID = CtrlRegistro.validarId(id);
        if (!valID) {
            return;
        }
        boolean existe = CtrlRegistro.consultarUsuario(id) != null;
        if (!existe) {
            int res = JOptionPane.showConfirmDialog(null, "El usuario no existe. Debera ser registrado: \n" +
                    "¿Registrar al usuario como Admin?", "Agregar Factura", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                dispose();
                RegistroUsuarioForm registroUsuario = new RegistroUsuarioForm();
                registroUsuario.InitRegister(true, id, true);
            } else if (res == JOptionPane.NO_OPTION) {
                dispose();
                RegistroUsuarioForm registroUsuario = new RegistroUsuarioForm();
                registroUsuario.InitRegister(false, id, true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
            }
        }
        else {
            dispose();
            libreriaForm libreria = new libreriaForm();
            libreria.InitLibreria(Integer.parseInt(id), true);
        }
    }//GEN-LAST:event_btnInsertarFacturaMouseClicked

    private void LimpiarCampos() {
        AreaFacturas.setText("");
        codigoField.setText("");
        buscarField.setText("");
        documentoField.setText("");
        IDAnadirFacturaField.setText("");
    }

    private void documentoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_documentoFieldKeyReleased
        // TODO add your handling code here:
        String documento = documentoField.getText();
        String[] docsFiltrados;
        docsFiltrados = CtrlRegistro.FiltrarUsuario(documento, documento.length());
        setDocumentos(docsFiltrados);
    }//GEN-LAST:event_documentoFieldKeyReleased

    private void btnBuscarDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarDocumentoMouseClicked
        // TODO add your handling code here:
        String documento = documentoField.getText();
        String[] doc = new String[1];
        if (CtrlRegistro.consultarUsuario(documento) != null) {
            doc[0] = CtrlRegistro.consultarUsuario(documento).getId();
            setDocumentos(doc);
        }
    }//GEN-LAST:event_btnBuscarDocumentoMouseClicked

    private void buscarFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFieldKeyReleased
        // TODO add your handling code here:
        FiltrarCodigo(buscarField);
    }//GEN-LAST:event_buscarFieldKeyReleased

    private void FiltrarCodigo(JTextField Field) {
        String codigo = Field.getText();
        String txt = CtrlFacturaVentas.leerFacturaporCodigo(codigo);
        String infoUsuario = CtrlRegistro.TomarInformacionUsuario(TomarID(txt));
        if (infoUsuario.isEmpty()) {
            infoUsuario = "El usuario ha sido eliminado del sistema.";
        }
        else {
            infoUsuario = "Información del usuario: \n" + infoUsuario;
        }
        if (txt.isEmpty()) {
            AreaFacturas.setText("No se encontró la factura");
        } else {
            AreaFacturas.setText(infoUsuario + "\n\n" + txt);
        }
    }


    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        String codigo = buscarField.getText();
        String txt = CtrlFacturaVentas.leerFacturaporCodigo(codigo);
        if (txt.isEmpty()) {
            AreaFacturas.setText("No se encontró la factura");
        } else {
            AreaFacturas.setText(txt);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void codigoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoFieldKeyReleased
        // TODO add your handling code here:
        FiltrarCodigo(codigoField);
    }//GEN-LAST:event_codigoFieldKeyReleased

    private String TomarID(String txt) {
        String[] lines = txt.split("\n");
        for (String line : lines) {
            if (line.contains("ID:")) {
                return line.split(" ")[1];
            }
        }
        return "";
    }


    private void IDAnadirFacturaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDAnadirFacturaFieldKeyReleased
        // TODO add your handling code here:
        String documento = IDAnadirFacturaField.getText();
        String[] docsFiltrados;
        docsFiltrados = CtrlRegistro.FiltrarUsuario(documento, documento.length());
        setDocumentos(docsFiltrados);
    }//GEN-LAST:event_IDAnadirFacturaFieldKeyReleased

    private void btnRefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefrescarMouseClicked
        // TODO add your handling code here:
        LimpiarCampos();
        setDocumentos();
    }//GEN-LAST:event_btnRefrescarMouseClicked

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        // TODO add your handling code here:
        dispose();
        MenuAdministradorForm menuAdmin = new MenuAdministradorForm();
        menuAdmin.InitMenuAdministrador(this.id);
    }//GEN-LAST:event_btnVolverMouseClicked

    private void eliminarUsuarioFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eliminarUsuarioFieldKeyReleased
        // TODO add your handling code here:
        String documento = eliminarUsuarioField.getText();
        String[] docsFiltrados;
        docsFiltrados = CtrlRegistro.FiltrarUsuario(documento, documento.length());
        setDocumentos(docsFiltrados);
    }//GEN-LAST:event_eliminarUsuarioFieldKeyReleased

    private void btnEliminarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioMouseClicked
        // TODO add your handling code here:
        String documento = eliminarUsuarioField.getText();
        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un documento");
            return;
        }
        int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el usuario?", "Eliminar Usuario", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            CtrlRegistro.EliminarUsuario(documento);
            LimpiarCampos();
            eliminarUsuarioField.setText("");
            setDocumentos();
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }
    }//GEN-LAST:event_btnEliminarUsuarioMouseClicked

    private void btnBuscarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarDocumentoActionPerformed

    private void btnInsertarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertarFacturaActionPerformed

    private void buscarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarFieldActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void XexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XexitMouseClicked
        SeguridadArchivos.EncriptarArchivos();
        System.exit(0);
    }//GEN-LAST:event_XexitMouseClicked

    private void XexitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XexitMousePressed

    }//GEN-LAST:event_XexitMousePressed

    private void headerfacturasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerfacturasMousePressed
        xMouse =evt.getX();
        yMouse =evt.getY();
    }//GEN-LAST:event_headerfacturasMousePressed

    private void headerfacturasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerfacturasMouseDragged
        int x= evt.getXOnScreen();
        int y= evt.getYOnScreen();
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_headerfacturasMouseDragged

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
            java.util.logging.Logger.getLogger(ListaFacturasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFacturasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFacturasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFacturasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaFacturasForm().setVisible(true);
            }
        });
    }
    
    
    public void setTime(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException ex){
                        Logger.getLogger(libreriaForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss a");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    jTxtime.setText(time.split(" ")[0]+" " + time.split(" ")[1]);
                    jTxtDate.setText(df.format(date));
                }
            }
        }).start();
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaFacturas;
    private javax.swing.JLabel Codigo;
    private javax.swing.JTextField IDAnadirFacturaField;
    private javax.swing.JList<String> ListaDocumentos;
    private javax.swing.JLabel Xexit;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarDocumento;
    private javax.swing.JButton btnEliminarFactura;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnInsertarFactura;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField buscarField;
    private javax.swing.JTextField codigoField;
    private javax.swing.JTextField documentoField;
    private javax.swing.JTextField eliminarUsuarioField;
    private javax.swing.JPanel headerfacturas;
    private javax.swing.JLabel inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jTxtDate;
    private javax.swing.JLabel jTxtime;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscarUsuario;
    private javax.swing.JLabel lblEliminarUser;
    private javax.swing.JLabel lblIDañadirFactura;
    // End of variables declaration//GEN-END:variables
}
