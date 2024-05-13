package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventarioTemporalCRUD{
private List<mdInventario> inventarioTemporal;
    private final String archivoJSON = "data/json/inventarioTemporal.json";

    public InventarioTemporalCRUD() {
        this.inventarioTemporal = cargarInventarioTemporalDesdeJSON();
    }

    private List<mdInventario> cargarInventarioTemporalDesdeJSON() {
        List<mdInventario> inventarioTemporal = new ArrayList<>();
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            inventarioTemporal = gson.fromJson(reader, new TypeToken<List<mdInventario>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventarioTemporal != null ? inventarioTemporal : new ArrayList<>();
    }

    public void agregarInventarioTemporal(mdInventario inventarioTemporal) {
        this.inventarioTemporal.add(inventarioTemporal);
        guardarInventarioTemporalEnJSON();
    }

    private void guardarInventarioTemporalEnJSON() {
        try(Writer writer = new FileWriter(archivoJSON)) {
            Gson gson = new Gson();
            gson.toJson(inventarioTemporal, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void actualizarCantidad(String id, int cantidad){
        for (mdInventario inventario : inventarioTemporal) {
            if (inventario.getCod().equals(id)) {
                inventario.setCantidad(inventario.getCantidad() - cantidad);
                guardarInventarioTemporalEnJSON();
                return;
            }
        }
    }

    public void ActualizarInventarioTemporal() {
        try {
            File archivoTemporal = new File("data/json/inventario.json");
            File archivo = new File("data/json/inventarioTemporal.json");
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


}
