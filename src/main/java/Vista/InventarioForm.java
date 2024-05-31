/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.SeguridadArchivos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import Modelo.InventarioCRUD;
import Modelo.InventarioTemporalCRUD;
import Vista.libreriaForm;

/**
 *
 * @author E2112
 */
public class InventarioForm extends javax.swing.JFrame {
    public List<Double> precios = new ArrayList<>();
    private List<Map<String, Object>> libros;
    private DefaultTableModel modeloTabla;

    int id;

    /**
     * Creates new form InventarioForm
     */
    public InventarioForm() {
        initComponents();
        cargarDatos();
        configurarBusqueda();
        ajustarTamanioColumnas();
        configurarTabla(false);
        setTime();
    }
    
    public void InitInventario(int id) {
        this.id = id;
        this.setSize(1000, 800);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Codigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Modificar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NombreAg = new javax.swing.JTextField();
        AutorAg = new javax.swing.JTextField();
        PrecioAg = new javax.swing.JTextField();
        CantidadAg = new javax.swing.JTextField();
        CodigoAg = new javax.swing.JTextField();
        Agregar = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CodEliminar = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        jTxtime = new javax.swing.JLabel();
        jTxtDate = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Filtrar por Nombre:");

        jLabel2.setText("Filtrar por Codigo:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Obra", "Autor", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Short.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel3.setText("AGREGAR NUEVO LIBRO");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Autor:");

        jLabel6.setText("Precio:");

        jLabel7.setText("Cantidad:");

        jLabel8.setText("Codigo:");

        NombreAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreAgActionPerformed(evt);
            }
        });

        Agregar.setText("Agregar Libro");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jLabel9.setText("ELIMINAR UN LIBRO");

        jLabel10.setText("Código:");

        CodEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodEliminarActionPerformed(evt);
            }
        });

        Eliminar.setText("ELIMINAR LIBRO");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        jTxtime.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jTxtime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTxtDate.setFont(new java.awt.Font("Poppins", 1, 17)); // NOI18N
        jTxtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel11.setText("Librería");

        btnVolver.setText("Volver al Menu");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NombreAg, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AutorAg, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PrecioAg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(CodigoAg))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(CantidadAg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(620, 620, 620)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Eliminar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CodEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(232, 232, 232))))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(84, 751, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(203, 203, 203))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtime, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(NombreAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(AutorAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(PrecioAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CantidadAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(CodigoAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(Agregar)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Guardar)
                        .addComponent(Modificar)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(CodEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(Eliminar)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // Que la tabla sea editable
        jTable1.setDefaultEditor(Object.class, new javax.swing.DefaultCellEditor(new javax.swing.JTextField()));
    }//GEN-LAST:event_ModificarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        //Guardar todos los cambios hechos en la tabla y exportarlos al json
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Map<String, Object>> libros = new ArrayList<>();
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                Map<String, Object> libro = Map.of(
                    "cod", jTable1.getValueAt(i, 0),
                    "nombre", jTable1.getValueAt(i, 1),
                    "autor", jTable1.getValueAt(i, 2),
                    "precio", jTable1.getValueAt(i, 3),
                    "cantidad", jTable1.getValueAt(i, 4)
                );
                libros.add(libro);
            }
            //Crear un array con los precios
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                precios.add(Double.parseDouble(jTable1.getValueAt(i, 3).toString()));
            }
            Modelo.InventarioCRUD inventarioCRUD = new InventarioCRUD();
            inventarioCRUD.actualizarTabla((ArrayList) libros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void NombreAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreAgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreAgActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        // si alguno de los campos est vacio que el boton no haga nada y emita un mensaje
        if (NombreAg.getText().isEmpty() || AutorAg.getText().isEmpty() || PrecioAg.getText().isEmpty() || CantidadAg.getText().isEmpty() || CodigoAg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
            return;
        }
        else {
            String nombre = NombreAg.getText();
            String autor = AutorAg.getText();
            try {
                Double.parseDouble(PrecioAg.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numerico en el campo Precio");
                return;
            }
            try {
                Short.parseShort(CantidadAg.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor numerico en el campo Cantidad");
                return;
            }
            double precio = Double.parseDouble(PrecioAg.getText());
            short cantidad = Short.parseShort(CantidadAg.getText());
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (CodigoAg.getText().equals(jTable1.getValueAt(i, 0).toString())) {
                    JOptionPane.showMessageDialog(null, "El codigo ya existe, por favor ingrese uno diferente");
                    return;
                }
            }
            String cod = CodigoAg.getText();
            InventarioCRUD inventarioCRUD = new InventarioCRUD();
            InventarioTemporalCRUD inventarioTemporalCRUD = new InventarioTemporalCRUD();
            inventarioCRUD.agregarInventario(new Modelo.mdInventario(nombre, autor, precio, cantidad, cod));
            inventarioTemporalCRUD.agregarInventarioTemporal(new Modelo.mdInventario(nombre, autor, precio, cantidad, cod));
            JOptionPane.showMessageDialog(null, "Libro agregado exitosamente");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            cargarDatos();
            NombreAg.setText("");
            AutorAg.setText("");
            PrecioAg.setText("");
            CantidadAg.setText("");
            CodigoAg.setText("");
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        if (CodEliminar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el codigo del libro que desea eliminar");
        }else{
            String cod = CodEliminar.getText();
            boolean existe = false;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (cod.equals(jTable1.getValueAt(i, 0).toString())) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                JOptionPane.showMessageDialog(null, "El libro con el codigo " + cod + " no existe");
                return;
            } else {
                InventarioCRUD inventarioCRUD = new InventarioCRUD();
                InventarioTemporalCRUD inventarioTemporalCRUD = new InventarioTemporalCRUD();
                inventarioCRUD.eliminarInventario(cod);
                inventarioTemporalCRUD.eliminarInventarioTemporal(cod);
                JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente");
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                cargarDatos();
                CodEliminar.setText("");
            }
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void CodEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodEliminarActionPerformed

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        // TODO add your handling code here:
        dispose();
        MenuAdministradorForm menuAdmin = new MenuAdministradorForm();
        menuAdmin.InitMenuAdministrador(id);
    }//GEN-LAST:event_btnVolverMouseClicked

    
    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }

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
            java.util.logging.Logger.getLogger(InventarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarioForm().setVisible(true);
            }
        });
    }
    
    private void cargarDatos() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            libros = mapper.readValue(new File("data/json/inventario.json"), new TypeReference<List<Map<String, Object>>>() {});
            modeloTabla = (DefaultTableModel) jTable1.getModel();
            libros.forEach(libro -> modeloTabla.addRow(new Object[]{
                libro.get("cod"), 
                libro.get("nombre"), 
                libro.get("autor"), 
                libro.get("precio"), 
                libro.get("cantidad")
            }));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void configurarBusqueda() {
        Nombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });

        Codigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrarTabla();
            }
        });
    }

    private void filtrarTabla() {
        String textoCod = Codigo.getText().toLowerCase();
        String textoNombre = Nombre.getText().toLowerCase();
        List<Map<String, Object>> librosFiltrados = libros.stream()
            .filter(libro -> libro.get("cod").toString().toLowerCase().contains(textoCod) && 
                             libro.get("nombre").toString().toLowerCase().contains(textoNombre))
            .collect(Collectors.toList());

        modeloTabla.setRowCount(0);
        librosFiltrados.forEach(libro -> modeloTabla.addRow(new Object[]{
            libro.get("cod"), 
            libro.get("nombre"), 
            libro.get("autor"), 
            libro.get("precio"), 
            libro.get("cantidad")
        }));
    }

    private void ajustarTamanioColumnas() {
        TableColumn columnauno = jTable1.getColumnModel().getColumn(0);
        columnauno.setPreferredWidth(60); // Ancho preferido en píxeles

        TableColumn columnados = jTable1.getColumnModel().getColumn(1);
        columnados.setPreferredWidth(150);

        TableColumn columnatres = jTable1.getColumnModel().getColumn(2);
        columnatres.setPreferredWidth(170);

        TableColumn columnacuatro = jTable1.getColumnModel().getColumn(3);
        columnacuatro.setPreferredWidth(80);

        jTable1.setRowHeight(30);

        jTable1.repaint();
    }

    private void configurarTabla(boolean editable) {
        if (editable) {
            // Permitir la edición solo en las columnas de Precio y Cantidad
            jTable1.setDefaultEditor(Object.class, new javax.swing.DefaultCellEditor(new javax.swing.JTextField()));
        } else {
            jTable1.setDefaultEditor(Object.class, null);
        }
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
    private javax.swing.JToggleButton Agregar;
    private javax.swing.JTextField AutorAg;
    private javax.swing.JTextField CantidadAg;
    private javax.swing.JTextField CodEliminar;
    private javax.swing.JTextField Codigo;
    private javax.swing.JTextField CodigoAg;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Modificar;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField NombreAg;
    private javax.swing.JTextField PrecioAg;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTxtDate;
    private javax.swing.JLabel jTxtime;
    // End of variables declaration//GEN-END:variables
}
