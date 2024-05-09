/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        InicioUsuarioForm InicioUsuario = new InicioUsuarioForm();
        InicioUsuario.InitLogin();
        libreriaForm libreria = new libreriaForm();
        libreria.setVisible(true);
    }
}
