/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.mdUsuario;
import Modelo.UsuarioCRUD;
import javax.swing.JOptionPane;


public class CtrlRegistro {
    public boolean CapturarDatos(String nombre, String apellidos, String id, String correo, String telefono, String Contrasena, boolean admin) {
        mdUsuario User = new mdUsuario(nombre, apellidos, id, correo, telefono, Contrasena, admin);
        boolean vNombre, vApellidos, vID, vCorreo, vTelefono, vContrasena;
        vNombre = validarNombre(nombre);
        vApellidos = validarApellidos(apellidos);
        vCorreo = validarCorreo(correo);
        vTelefono = validarTelefono(telefono);
        vID = validarId(id);
        vContrasena = validarContrasena(Contrasena);
        return vID && vContrasena && vNombre && vApellidos && vCorreo && vTelefono;
    }
    
    public static boolean validarId(String id) {
        return CtrlInicio.validarId(id);
    }
    
    private static boolean validarContrasena(String contrasena) {
        boolean vAux = contrasena.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-_=+\\\\\\\\|<>?{}\\\\[\\\\]~]).{8,}");
        if (!vAux) {
            JOptionPane.showMessageDialog(null, """
                                                Ingrese una contraseña correcta y segura, con Mayusculas, minusculas, numeros y caracteres especiales.
                                                La contraseña debe tener minimo 8 caracteres. """);
        }
        return vAux;
    }

    public static mdUsuario consultarUsuario(String id) {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        return usuarioCRUD.validarExistenciaUsuario(id);
    }

    public static String[] FiltrarUsuario(String id, int index) {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        return usuarioCRUD.FiltrarUsuario(id, index);
    }

    private boolean validarNombre(String nombre) {
        boolean vAux = nombre.matches("[a-zA-Z ]{3,20}");
        if (!vAux) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre correcto.");
        }
        return vAux;
    }

    private boolean validarApellidos(String apellidos) {
        boolean vAux = apellidos.matches("[a-zA-Z ]{1,30}");
        if (!vAux) {
            JOptionPane.showMessageDialog(null, "Ingrese unos apellidos correctos.");
        }
        return vAux;
    }

    private boolean validarCorreo(String correo) {
        boolean vAux = correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");
        if (!vAux) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo correcto.");
        }
        return vAux;
    }

    private boolean validarTelefono(String telefono) {
        boolean vAux = telefono.matches("^\\d{7,10}$");
        if (!vAux) {
            JOptionPane.showMessageDialog(null, "Ingrese un telefono correcto (Sin prefijo (+57) y sin espacios).");
        }
        return vAux;
    }

    public static String TomarInformacionUsuario(String id) {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        return usuarioCRUD.TomarInformacionUsuario(id);
    }

    public static void EliminarUsuario(String documento) {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        usuarioCRUD.EliminarUsuario(documento);
    }


}