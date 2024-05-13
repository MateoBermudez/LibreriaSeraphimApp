package Modelo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.io.*;

public class InventarioCRUD {
    private List<mdInventario> inventario;
    private final String archivoJSON = "data/json/inventario.json";

    public InventarioCRUD() {
        this.inventario = cargarInventarioDesdeJSON();
    }

    private List<mdInventario> cargarInventarioDesdeJSON() {
        List<mdInventario> inventario = new ArrayList<>();
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            inventario = gson.fromJson(reader, new TypeToken<List<mdInventario>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventario != null ? inventario : new ArrayList<>();
    }

    public void agregarInventario(mdInventario inventario) {
        this.inventario.add(inventario);
        guardarInventarioEnJSON();
    }

    private void guardarInventarioEnJSON() {
        try(Writer writer = new FileWriter(archivoJSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(inventario, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public mdInventario obtenerInventario(String id) {
        for (mdInventario inventario : inventario) {
            if (inventario.getNombre().equals(id)) {
                return inventario;
            }
        }
        return null;
    }

    public void eliminarInventario(String nombre) {
        for (mdInventario inventario : inventario) {
            if (inventario.getNombre().equals(nombre)) {
                this.inventario.remove(inventario);
                guardarInventarioEnJSON();
                return;
            }
        }
    }


    public void ActualizarInventario() {
        try {
            File archivoTemporal = new File("data/json/inventarioTemporal.json");
            File archivo = new File("data/json/inventario.json");
            Scanner scanner = new Scanner(archivoTemporal);
            FileWriter writer = new FileWriter(archivo);
            while (scanner.hasNextLine()) {
                writer.write(scanner.nextLine() + "\n");
            }
            writer.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int obtenerCantidad(String id) {
        for (mdInventario inv : inventario) {
            if (inv.getCod().equals(id)) {
                return inv.getCantidad();
            }
        }
        return 0;
    }
    public boolean validarCantidad(String id, int cantidad) {
        for (mdInventario inv : inventario) {
            if (inv.getCod().equals(id)) {
                if (inv.getCantidad() >= cantidad) {
                    return true;
                }
            }
        }
        return false;
    }

    /*public static void main(String[] args) {
        InventarioCRUD inventarioCRUD = new InventarioCRUD();
        inventarioCRUD.agregarInventario(new mdInventario("Cien años de soledad", "Gabriel García Márquez", 60000, 10, "1"));
        inventarioCRUD.agregarInventario(new mdInventario("Orgullo y prejuicio", "Jane Austen", 50000, 15, "2"));
        inventarioCRUD.agregarInventario(new mdInventario("Dracula", "Bram Stoker", 55000, 9, "3"));
        inventarioCRUD.agregarInventario(new mdInventario("1984", "George Orwell", 45000, 11, "4"));
        inventarioCRUD.agregarInventario(new mdInventario("IT", "Stephen King", 60000, 13, "5"));
        inventarioCRUD.agregarInventario(new mdInventario("Frankenstein", "Mary Shelley", 50000, 8, "6"));
    }*/
}
