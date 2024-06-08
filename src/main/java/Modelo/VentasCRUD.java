package Modelo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VentasCRUD{
    private List<mdVentas> ventas;
    private final String archivoJSON = "data/json/ventas.json";

    public VentasCRUD() {
        this.ventas = cargarVentasDesdeJSON();
    }

    private List<mdVentas> cargarVentasDesdeJSON() {
        List<mdVentas> ventas = new ArrayList<>();
        try (Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            ventas = gson.fromJson(reader, new TypeToken<List<mdVentas>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ventas != null ? ventas : new ArrayList<>();
    }

    public void actualizarcantidad(String obra, int cantidad){
        for (mdVentas venta : ventas) {
            if (venta.getObra().equals(obra)) {
                venta.setCantidadvendida(venta.getCantidadvendida() + cantidad);
                venta.setPreciovendidos(venta.getCantidadvendida() * venta.getPreciobase());
                guardarVentasEnJSON();
                return;
            }
        }
    }

    private void guardarVentasEnJSON() {
        try (Writer writer = new FileWriter(archivoJSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(ventas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //agregar libro al archivo JSON
    public void agregarVenta(mdVentas venta) {
        this.ventas.add(venta);
        guardarVentasEnJSON();
    }

    /*public static void main(String[] args) {
        VentasCRUD ventasCRUD = new VentasCRUD();
        ventasCRUD.agregarVenta(new mdVentas(0, "Cien años de soledad", 60000, 0));
        ventasCRUD.agregarVenta(new mdVentas(0, "Orgullo y prejuicio", 50000, 0));
        ventasCRUD.agregarVenta(new mdVentas(0, "Dracula", 55000, 0));
        ventasCRUD.agregarVenta(new mdVentas(0, "1984", 45000, 0));
        ventasCRUD.agregarVenta(new mdVentas(0, "IT", 60000, 0));
        ventasCRUD.agregarVenta(new mdVentas(0, "Frankenstein", 50000, 0));
    }*/

    public List<mdVentas> getVentas() {
        return ventas;
    }


}