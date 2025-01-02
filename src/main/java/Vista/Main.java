/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.SeguridadArchivos;



public class Main {
    public static void main(String[] args) {
        SeguridadArchivos.DesencriptarArchivos();
        InicioUsuarioForm InicioUsuario = new InicioUsuarioForm();
        InicioUsuario.InitLogin();
    }
}