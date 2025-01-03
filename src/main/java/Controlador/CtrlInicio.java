/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.mdUsuario;
import Modelo.UsuarioCRUD;
import javax.swing.JOptionPane;

public class CtrlInicio {
    public boolean CapturarDatos(String id, String contrasena) {
        mdUsuario User = new mdUsuario(id, contrasena);
        boolean vID, vContrasena;
        vID = validarId(id);
        vContrasena = validarContrasena(contrasena);
        return vID && vContrasena;
    }
    
    public static boolean validarId(String id) {
        boolean vAux = id.matches("\\d{8,10}");
        if (!vAux) {
            JOptionPane.showMessageDialog(null, "Ingrese una identificacion correcta, entre 8 y 10 digitos. ");
            return false;
        }
        return vAux;
    }
    
    private static boolean validarContrasena(String contrasena) {
        boolean vAux = contrasena.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-_=+\\\\\\\\|<>?{}\\\\[\\\\]~]).{8,}");
        if (!vAux) {
            JOptionPane.showMessageDialog(null, "Ingrese una contraseña correcta. ");
        }
        return vAux;
    }

    public static mdUsuario consultarUsuario(String id, String contrasena) {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        return usuarioCRUD.validarExistenciaUsuario(id, contrasena);
    }


    public boolean isAdmin(int id) {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        return usuarioCRUD.isAdmin(id);
    }
}