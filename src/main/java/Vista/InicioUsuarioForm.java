/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CtrlInicio;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class InicioUsuarioForm extends javax.swing.JFrame {

    /**
     * Creates new form InicioUsuarioForm
     */
    InicioUsuarioForm inicioUsuario;
    
    public InicioUsuarioForm() {
        initComponents();
    }
    
    public void InitLogin() {
        inicioUsuario = new InicioUsuarioForm();
        inicioUsuario.setSize(1000, 800);
        inicioUsuario.setMaximumSize(inicioUsuario.getSize());
        inicioUsuario.setMinimumSize(inicioUsuario.getSize());
        inicioUsuario.setPreferredSize(inicioUsuario.getSize());
        inicioUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicioUsuario.setLocationRelativeTo(null);
        inicioUsuario.getContentPane().setBackground(Color.GRAY);
        inicioUsuario.setVisible(true);
    }                                      

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LeftSide = new javax.swing.JPanel();
        RightSide = new javax.swing.JPanel();
        ingresar = new javax.swing.JLabel();
        registrarse = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        noAcc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LeftSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(LeftSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 530, 590));

        RightSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ingresar.setText("Ingresar");
        RightSide.add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        registrarse.setText("Registrarse");
        registrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarseMouseClicked(evt);
            }
        });
        RightSide.add(registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        id.setText("Ingrese su ID");
        RightSide.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        idField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idFieldKeyPressed(evt);
            }
        });
        RightSide.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 170, -1));

        password.setText("Ingrese su contraseña");
        RightSide.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });
        RightSide.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 330, 170, -1));

        btnIngresar.setText("Ingresar");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
        });
        RightSide.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        noAcc.setText("No tengo una cuenta");
        noAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noAccMouseClicked(evt);
            }
        });
        RightSide.add(noAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, -1, -1));

        getContentPane().add(RightSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 290, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarseMouseClicked
        // TODO add your handling code here:
        dispose();
        RegistroUsuarioForm registroUsuario = new RegistroUsuarioForm();
        registroUsuario.InitRegister();
    }//GEN-LAST:event_registrarseMouseClicked

    private void noAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noAccMouseClicked
        // TODO add your handling code here:
        dispose();
        RegistroUsuarioForm registroUsuario = new RegistroUsuarioForm();
        registroUsuario.InitRegister();
    }//GEN-LAST:event_noAccMouseClicked

    private void idFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            idField.setEnabled(false);
            ValidarRegistro();
        }
    }//GEN-LAST:event_idFieldKeyPressed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            passwordField.setEnabled(false);
            ValidarRegistro();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        // TODO add your handling code here:
        ValidarRegistro();
    }//GEN-LAST:event_btnIngresarMouseClicked

    private void ValidarRegistro() {
        boolean sesionIniciada;
        CtrlInicio controladorInicioUsuario = new CtrlInicio();
        String Contrasena = capturarContrasena();
        sesionIniciada = controladorInicioUsuario.CapturarDatos(idField.getText(), Contrasena);
        if (sesionIniciada) {
            dispose();
            //Llamar a la ventana que sigue del inicio de sesion con este formato
            /*
            RegistroUsuarioForm registroUsuario = new RegistroUsuarioForm();
            registroUsuario.InitRegister();
            */
        }
        //No se valida si los datos son incorrectos o si el usuario no existe, ya que se le avisa al usuario desde controlador
        HabilitarCampos();
    }
    
    private String capturarContrasena() {
        String Contrasena = "";
        for (int i = 0; i < passwordField.getPassword().length; i++) {
            Contrasena += passwordField.getPassword()[i];
        }
        return Contrasena;
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
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel ingresar;
    private javax.swing.JLabel noAcc;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel registrarse;
    // End of variables declaration//GEN-END:variables

    private void HabilitarCampos() {
        passwordField.setEnabled(true);
        idField.setEnabled(true);
    }
}
