package Modelo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.io.*;
public class UsuarioCRUD {
    private List<mdUsuario> usuarios;
    private final String archivoJSON = "usuarios.json";
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

    public void agregarPersona(mdUsuario usuario) {
        usuarios.add(usuario);
        guardarUsuariosEnJSON();
    }

    private void guardarUsuariosEnJSON() {
        try (Writer writer = new FileWriter(archivoJSON)) {
            Gson gson = new Gson();
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
