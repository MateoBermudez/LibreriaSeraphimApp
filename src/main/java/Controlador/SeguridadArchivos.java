package Controlador;

public class SeguridadArchivos {
    public static void EncriptarArchivos() {
        Modelo.EncriptarArchivos encriptar = new Modelo.EncriptarArchivos();
        encriptar.Encriptar("data/json/facturaVentas.json");
        encriptar.Encriptar("data/json/usuarios.json");
        encriptar.Encriptar("data/json/inventario.json");
        encriptar.Encriptar("data/json/inventarioTemporal.json");
    }

    public static void DesencriptarArchivos() {
        Modelo.EncriptarArchivos desencriptar = new Modelo.EncriptarArchivos();
        desencriptar.Desencriptar("data/json/facturaVentas.json");
        desencriptar.Desencriptar("data/json/usuarios.json");
        desencriptar.Desencriptar("data/json/inventario.json");
        desencriptar.Desencriptar("data/json/inventarioTemporal.json");
    }
}
