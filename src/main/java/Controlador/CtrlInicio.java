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
        boolean vID, vContrasena, inicioCorrecto = false;
        vID = validarId(id);
        vContrasena = validarContrasena(contrasena);
        if (vID && vContrasena) {
            JOptionPane.showMessageDialog(null, "Validado correctamente - Verificar que el usuario si exista para iniciar sesion:"); 
            inicioCorrecto = validarExistenciaUsuario(User);
        }
        return vID && vContrasena && inicioCorrecto;
    }
    
    private static boolean validarId(String id) {
        boolean vAux = id.matches("\\d{5,14}");
        if (!vAux) {
            JOptionPane.showMessageDialog(null, "Ingrese una identificacion correcta, entre 5 y 14 digitos. ");
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

    private boolean validarExistenciaUsuario(mdUsuario User) {
        //User contiene el ID y la contraseña del usuario. 
        //Ver si el usuario exite -> Inicia sesion, si no existe -> JOption mensaje, el usuario no existe.
        /*
        if (Usuario SI existe) {
            //Devuelve true y abre la ventana dentro de la tienda en vista
            return true;
        }
        JOptionPane.showMessageDialog(null, "El usuario no existe. ");
        return false;
        */
        return false;
    }
}