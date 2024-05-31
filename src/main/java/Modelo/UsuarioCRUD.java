package Modelo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.util.*;
import java.io.*;
public class UsuarioCRUD {
    private List<mdUsuario> usuarios;
    private final String archivoJSON = "data/json/usuarios.json";
    // Constructor
    public UsuarioCRUD() {
        this.usuarios = cargarUsuariosDesdeJSON();
    }

    private List<mdUsuario> cargarUsuariosDesdeJSON() {
        List<mdUsuario> usuarios = new ArrayList<>();

        try (Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            usuarios = gson.fromJson(reader, new TypeToken<List<mdUsuario>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios != null ? usuarios : new ArrayList<>();
    }

    public void agregarUsuario(mdUsuario usuario) {
        usuarios.add(usuario);
        guardarUsuariosEnJSON();
    }

    private void guardarUsuariosEnJSON() {
        try (Writer writer = new FileWriter(archivoJSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public mdUsuario validarExistenciaUsuario(String id, String contrasena) {
        for (mdUsuario usuario : usuarios) {
            if (usuario.getId().equals(id) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    public mdUsuario validarExistenciaUsuario(String id) {
        for (mdUsuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public String[] ObtenerDocumentos() {
        int tam = usuarios.size();
        String[] documentos = new String[tam];
        int i = 0;
        for (mdUsuario usuario : usuarios) {
            documentos[i++] = String.valueOf(usuario.getId());
        }
        return EliminarDocumentosDuplicados(documentos, tam);
    }

    private String[] EliminarDocumentosDuplicados(String[] documentos, int i) {
        int duplicados = 0;
        for (int j = 0; j < i; j++) {
            for (int k = j + 1; k < i; k++) {
                if (documentos[j].equals(documentos[k]) && !documentos[j].isEmpty()) {
                    documentos[k] = "";
                    duplicados++;
                }
            }
        }
        String[] documentosSinDuplicados = new String[i - duplicados];
        for (int j = 0, k = 0; j < i; j++) {
            if (!documentos[j].isEmpty()) {
                documentosSinDuplicados[k++] = documentos[j];
            }
        }
        return documentosSinDuplicados;
    }

    public String[] FiltrarUsuario(String id, int index) {
        int i = 0, j = 0;
        boolean igualdad;
        String[] documentosFiltrados = new String[usuarios.size()];
        char[] idFiltrado = id.toCharArray();
        try {
            for (mdUsuario usuario : usuarios) {
                char[] idUsuario = usuario.getId().toCharArray();
                igualdad = true;
                for (i = 0; i < index; i++) {
                    if (idFiltrado[i] != idUsuario[i]) {
                        igualdad = false;
                        break;
                    }
                }
                if (igualdad) {
                    documentosFiltrados[j++] = usuario.getId();
                }
            }
            return EliminarDocumentosDuplicados(documentosFiltrados, j);
        }
        catch (Exception ignored) {
            return new String[0];
        }
    }

    public boolean isAdmin(int id) {
        for (mdUsuario usuario : usuarios) {
            if (usuario.getId().equals(String.valueOf(id)) && usuario.getAdmin()) {
                return true;
            }
        }
        return false;
    }

    public String TomarInformacionUsuario(String id) {
        for (mdUsuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return  "Nombre: " + usuario.getNombre() + "\n" +
                        "Apellidos: " + usuario.getApellido() + "\n" +
                        "Correo: " + usuario.getCorreo() + "\n" +
                        "Telefono: " + usuario.getTelefono() + "\n" +
                        "ID: " + usuario.getId() + "\n" +
                        "Admin: " + usuario.getAdmin() + "\n";
            }
        }
        return "";
    }

    public void EliminarUsuario(String documento) {
        boolean eliminado = false;
        for (mdUsuario usuario : usuarios) {
            if (usuario.getId().equals(documento)) {
                usuarios.remove(usuario);
                eliminado = true;
                break;
            }
        }
        if (!eliminado) {
            JOptionPane.showMessageDialog(null, "No se encontro el usuario con el documento: " + documento);
        }
        else {
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.\nSe eliminó el usuario con el documento: " + documento +
                    "\n\nPero no se eliminaron sus respectivas facturas. \n\nPor favor, elimine las facturas manualmente si desea hacerlo(O si las mismas aun existen). ");
        }
        guardarUsuariosEnJSON();
    }
}
