package Controlador;

import Modelo.FacturaVentasCRUD;
import Modelo.UsuarioCRUD;
import Modelo.mdFacturaVentas;

public class CtrlFacturaVentas {

    public void CrearFactura(int id, String fecha, String factura) {
        FacturaVentasCRUD facturaVentasCRUD = new FacturaVentasCRUD();
        int cod = facturaVentasCRUD.LeerCodigo()+1;
        mdFacturaVentas Factura = new mdFacturaVentas(id, fecha, factura, cod);
        agregarFacturaVentas(Factura);
    }

    private void agregarFacturaVentas(mdFacturaVentas facturaVenta) {
        FacturaVentasCRUD facturaVentasCRUD = new FacturaVentasCRUD();
        facturaVentasCRUD.agregarFacturaVentas(facturaVenta);
    }

    public static String[] LeerDocumentos() {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
        return usuarioCRUD.ObtenerDocumentos();
    }

    public static String leerFacturaporCodigo(String codigo) {
        try {
            Integer.parseInt(codigo);
        }
        catch (NumberFormatException e) {
            return "";
        }
        FacturaVentasCRUD facturaVentasCRUD = new FacturaVentasCRUD();
        return facturaVentasCRUD.ObtenerFacturaporCodigo(Integer.parseInt(codigo));
    }

    public static String leerFacturaporID(String id) {
        try {
            Integer.parseInt(id);
        }
        catch (NumberFormatException e) {
            return "";
        }
        FacturaVentasCRUD facturaVentasCRUD = new FacturaVentasCRUD();
        return facturaVentasCRUD.ObtenerFacturaporID(Integer.parseInt(id));
    }

    public static void EliminarFactura(String cod) {
        try {
            Integer.parseInt(cod);
        }
        catch (NumberFormatException e) {
            return;
        }
        FacturaVentasCRUD facturaVentasCRUD = new FacturaVentasCRUD();
        facturaVentasCRUD.EliminarFactura(Integer.parseInt(cod));
    }

}
