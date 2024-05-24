package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
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

    public String ObtenerFacturaporCodigo(int codigo) {
        StringBuilder factura = new StringBuilder();
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            facturaVentas = gson.fromJson(reader, new TypeToken<List<mdFacturaVentas>>(){}.getType());
            for (mdFacturaVentas facturaVenta : facturaVentas) {
                if (facturaVenta.getCodigo() == codigo) {
                    factura.append("ID: ").append(facturaVenta.getId()).append("\nFecha: ").append(facturaVenta.getFecha()).append("\nCodigo de la Factura: ").append(facturaVenta.getCodigo()).append("\nFactura: ").append(facturaVenta.getFactura()).append("\n\n\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factura.toString();
    }

    public String ObtenerFacturaporID(int id) {
        StringBuilder factura = new StringBuilder();
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            facturaVentas = gson.fromJson(reader, new TypeToken<List<mdFacturaVentas>>(){}.getType());
            for (mdFacturaVentas facturaVenta : facturaVentas) {
                if (facturaVenta.getId() == id) {
                    factura.append("ID: ").append(facturaVenta.getId()).append("\nFecha: ").append(facturaVenta.getFecha()).append("\nCodigo de la Factura: ").append(facturaVenta.getCodigo()).append("\nFactura: ").append(facturaVenta.getFactura()).append("\n\n\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factura.toString();
    }

    public void EliminarFactura(int cod) {
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            facturaVentas = gson.fromJson(reader, new TypeToken<List<mdFacturaVentas>>(){}.getType());
            for (mdFacturaVentas facturaVenta : facturaVentas) {
                if (facturaVenta.getCodigo() == cod) {
                    facturaVentas.remove(facturaVenta);
                    guardarFacturaVentasEnJSON();
                    JOptionPane.showMessageDialog(null, "Factura eliminada correctamente");
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "No se encontro la factura");
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

    public int LeerCodigo() {
        int codigo = 0;
        try(Reader reader = new FileReader(archivoJSON)) {
            Gson gson = new Gson();
            try {
                facturaVentas = gson.fromJson(reader, new TypeToken<List<mdFacturaVentas>>(){}.getType());
                for (mdFacturaVentas facturaVenta : facturaVentas) {
                    if (facturaVenta.getCodigo() > codigo) {
                        codigo = facturaVenta.getCodigo();
                    }
                }
            }
            catch (Exception e) {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return codigo;
    }

}
