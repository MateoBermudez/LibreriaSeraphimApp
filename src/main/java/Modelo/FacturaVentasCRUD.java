package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;

public class FacturaVentasCRUD {
    private List<mdFacturaVentas> facturaVentas;
    private final String archivoJSON = "data/json/facturaVentas.json";

    public FacturaVentasCRUD() {
        this.facturaVentas = cargarFacturaVentasDesdeJSON();
    }

    private List<mdFacturaVentas> cargarFacturaVentasDesdeJSON() {
        List<mdFacturaVentas> facturaVentas = new ArrayList<>();

        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            facturaVentas = gson.fromJson(reader, new TypeToken<List<mdFacturaVentas>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facturaVentas != null ? facturaVentas : new ArrayList<>();
    }

    public void agregarFacturaVentas(mdFacturaVentas facturaVenta) {
        facturaVentas.add(facturaVenta);
        guardarFacturaVentasEnJSON();
    }

    private void guardarFacturaVentasEnJSON() {
        try(Writer writer = new FileWriter(archivoJSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(facturaVentas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String ObtenerFactura(int id) {
        String factura = "";
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            facturaVentas = gson.fromJson(reader, new TypeToken<List<mdFacturaVentas>>(){}.getType());
            for (mdFacturaVentas facturaVenta : facturaVentas) {
                if (facturaVenta.getId() == id) {
                    factura = "ID: " + facturaVenta.getId() + "\nFecha: " + facturaVenta.getFecha() + "\nFactura: " + facturaVenta.getFactura();
                    return factura;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void EliminarFactura(int id) {
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            facturaVentas = gson.fromJson(reader, new TypeToken<List<mdFacturaVentas>>(){}.getType());
            for (mdFacturaVentas facturaVenta : facturaVentas) {
                if (facturaVenta.getId() == id) {
                    facturaVentas.remove(facturaVenta);
                    guardarFacturaVentasEnJSON();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ActualizarID(int viejoID, int nuevoID) {
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            facturaVentas = gson.fromJson(reader, new TypeToken<List<mdFacturaVentas>>(){}.getType());
            for (mdFacturaVentas facturaVenta : facturaVentas) {
                if (facturaVenta.getId() == viejoID) {
                    facturaVenta.setId(nuevoID);
                    guardarFacturaVentasEnJSON();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
