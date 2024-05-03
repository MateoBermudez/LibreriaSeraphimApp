/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.mdUsuario;
import Modelo.UsuarioCRUD;
import javax.swing.JOptionPane;


public class CtrlRegistro {
    public boolean CapturarDatos(String nombre, String apellidos, String id, String correo, String telefono, String Contrasena) {
        mdUsuario User = new mdUsuario(nombre, apellidos, id, correo, telefono, Contrasena);
        boolean vNombre, vApellidos, vID, vCorreo, vTelefono, vContrasena;
        vNombre = validarNombre(nombre);
        vApellidos = validarApellidos(apellidos);
        vCorreo = validarCorreo(correo);
        vTelefono = validarTelefono(telefono);
        vID = validarId(id);
        vContrasena = validarContrasena(Contrasena);
        if (vID && vContrasena && vNombre && vApellidos && vCorreo && vTelefono) {
            JOptionPane.showMessageDialog(null, "Validado correctamente - Verificar que el usuario si exista para iniciar sesion:");
        }
        return vID && vContrasena && vNombre && vApellidos && vCorreo && vTelefono;
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
            JOptionPane.showMessageDialog(null, """
                                                Ingrese una contraseña correcta y segura, con Mayusculas, minusculas, numeros y caracteres especiales.
                                                La contraseña debe tener minimo 8 caracteres. """);
        }
        return vAux;
    }

    public boolean validarCreacionUsuario(mdUsuario User) {
        //User contiene todos los datos iniciales del usuario.
        //Ver si el usuario no exite -> Crea al usuario y entra con su cuenta, si existe -> JOption mensaje, el usuario ya existe.
        /*
        if (El usuario NO existe) {
            //Devuelve true y abre la ventana dentro de la tienda en vista, se guarda al nuevo usuario y pasa a la siguiente ventana con el mismo
            return true;
        }
        JOptionPane.showMessageDialog(null, "El usuario ya existe, no se puede crear su usuario. ");
        return false;
        */
        if (CapturarDatos(User.getNombre(), User.getApellido(), User.getId(), User.getCorreo(), User.getTelefono(), User.getContrasena())) {
            UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
            usuarioCRUD.agregarUsuario(User);
            return true;
        }
      return false;
    }

    public static mdUsuario consultarUsuario(String id) {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        return usuarioCRUD.validarExistenciaUsuario(id);
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


}
