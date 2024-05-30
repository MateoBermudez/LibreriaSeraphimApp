/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CtrlInicio;
import Controlador.SeguridadArchivos;
import Modelo.mdUsuario;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author user
 */
public class InicioUsuarioForm extends javax.swing.JFrame {

    int xMouse, yMouse;
    /**
     * Creates new form InicioUsuarioForm
     */

    public InicioUsuarioForm() {
        initComponents();
    }
    
    public void InitLogin() {
        this.setSize(820, 590);
        this.setMaximumSize(this.getSize());
        this.setMinimumSize(this.getSize());
        this.setPreferredSize(this.getSize());
        this.setLocationRelativeTo(null);
        this.setCloseOperation();
        this.getContentPane().setBackground(Color.GRAY);
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

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LeftSide = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        Xexit = new javax.swing.JLabel();
        imginit = new javax.swing.JLabel();
        RightSide = new javax.swing.JPanel();
        ingresar = new javax.swing.JLabel();
        registrarse = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        noAcc = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LeftSide.setBackground(new java.awt.Color(51, 51, 51));
        LeftSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(51, 51, 51));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        header.add(Xexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        LeftSide.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        imginit.setBackground(new java.awt.Color(255, 255, 255));
        imginit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imgfontregistro.png"))); // NOI18N
        LeftSide.add(imginit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 450, 500));

        getContentPane().add(LeftSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 590));

        RightSide.setBackground(new java.awt.Color(255, 255, 255));
        RightSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ingresar.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        ingresar.setForeground(new java.awt.Color(255, 255, 255));
        ingresar.setText("Ingresar");
        ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RightSide.add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        registrarse.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        registrarse.setForeground(new java.awt.Color(255, 255, 255));
        registrarse.setText("Registrarse");
        registrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarseMouseClicked(evt);
            }
        });
        RightSide.add(registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        id.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        id.setForeground(new java.awt.Color(51, 51, 51));
        id.setText("ID");
        RightSide.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        idField.setForeground(new java.awt.Color(204, 204, 204));
        idField.setText("Ingrese su ID");
        idField.setBorder(null);
        idField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                idFieldMousePressed(evt);
            }
        });
        idField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idFieldKeyPressed(evt);
            }
        });
        RightSide.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 150, 30));

        password.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(51, 51, 51));
        password.setText("Contraseña");
        RightSide.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        passwordField.setForeground(new java.awt.Color(204, 204, 204));
        passwordField.setText("Ingresesucontrasela");
        passwordField.setBorder(null);
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordFieldMousePressed(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });
        RightSide.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 150, 30));

        btnIngresar.setBackground(new java.awt.Color(51, 51, 51));
        btnIngresar.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setBorderPainted(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });
        RightSide.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 110, 30));

        noAcc.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        noAcc.setForeground(new java.awt.Color(51, 51, 51));
        noAcc.setText("No tengo una cuenta");
        noAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        noAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noAccMouseClicked(evt);
            }
        });
        RightSide.add(noAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 470, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoserafin.png"))); // NOI18N
        RightSide.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSeparator1.setMinimumSize(new java.awt.Dimension(10, 20));
        RightSide.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 190, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSeparator2.setMinimumSize(new java.awt.Dimension(10, 20));
        RightSide.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 190, 10));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LIBRERIA");
        RightSide.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 100, -1));

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SERAPHIM");
        RightSide.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, -1));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setOpaque(true);
        RightSide.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 170));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_account_icon_145918.png"))); // NOI18N
        RightSide.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lock_secure_security_protection_password_icon_196493.png"))); // NOI18N
        jLabel3.setToolTipText("");
        RightSide.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        getContentPane().add(RightSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 290, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseMouseClicked
        dispose();
        RegistroUsuarioForm registroUsuario = new RegistroUsuarioForm();
        registroUsuario.InitRegister(false, "", false);
    }//GEN-LAST:event_registrarseMouseClicked

    private void noAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noAccMouseClicked
        dispose();
        RegistroUsuarioForm registroUsuario = new RegistroUsuarioForm();
        registroUsuario.InitRegister(false, "", false);
    }//GEN-LAST:event_noAccMouseClicked

    private void idFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idFieldKeyPressed
        if (idField.getText().equals("Ingrese su ID")) {
            idField.setText("");
        }
        idField.setForeground(Color.BLACK);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            idField.setEnabled(false);
            ValidarRegistro();
        }
    }//GEN-LAST:event_idFieldKeyPressed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if (passwordField.getText().equals("Ingrese su contraseña")) {
            passwordField.setText("");
        }

        passwordField.setForeground(Color.BLACK);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            passwordField.setEnabled(false);
            ValidarRegistro();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        ValidarRegistro();
    }//GEN-LAST:event_btnIngresarMouseClicked

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void XexitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XexitMousePressed

    }//GEN-LAST:event_XexitMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x= evt.getXOnScreen();
        int y= evt.getYOnScreen();
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void XexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XexitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_XexitMouseClicked

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse =evt.getX();
        yMouse =evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void passwordFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMousePressed
        passwordField.setText("");
    }//GEN-LAST:event_passwordFieldMousePressed

    private void idFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idFieldMousePressed
        idField.setText("");
    }//GEN-LAST:event_idFieldMousePressed

    private void ValidarRegistro() {
        int id;
        boolean validarDatos, sesionIniciada;
        CtrlInicio controladorInicioUsuario = new CtrlInicio();
        String Contrasena = capturarContrasena();
        validarDatos = controladorInicioUsuario.CapturarDatos(idField.getText(), Contrasena);
        if (validarDatos) {
            sesionIniciada = inicioUsuario();
            if (sesionIniciada) {
                id = Integer.parseInt(idField.getText());
                dispose();
                libreriaForm libreria = new libreriaForm();
                libreria.InitLibreria(id, false);
            }
        }
        HabilitarCampos();
    }
    
    private String capturarContrasena() {
        StringBuilder Contrasena = new StringBuilder();
        for (int i = 0; i < passwordField.getPassword().length; i++) {
            Contrasena.append(passwordField.getPassword()[i]);
        }
        return Contrasena.toString();
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
            java.util.logging.Logger.getLogger(InicioUsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioUsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioUsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioUsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioUsuarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftSide;
    private javax.swing.JPanel RightSide;
    private javax.swing.JLabel Xexit;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JPanel header;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel imginit;
    private javax.swing.JLabel ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel noAcc;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel registrarse;
    // End of variables declaration//GEN-END:variables

    private void HabilitarCampos() {
        passwordField.setEnabled(true);
        idField.setEnabled(true);
    }

    private boolean inicioUsuario(){
        String id = idField.getText();
        mdUsuario usuarioExistente = CtrlInicio.consultarUsuario(id, capturarContrasena());
        if (usuarioExistente != null) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "El usuario no existe");
        return false;
    }

    public void setImage(){
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/imagenes/imgfontregistro.png"));
        Image img= icon2.getImage().getScaledInstance(imginit.getWidth(), imginit.getHeight(), Image.SCALE_SMOOTH);
        imginit.setIcon(new ImageIcon(img));

    }

}
