package Controlador;

import Modelo.FacturaVentasCRUD;
import Modelo.mdFacturaVentas;

import javax.swing.*;

public class CtrlFacturaVentas {

    public void CrearFactura(int id, String fecha, String factura) {
        mdFacturaVentas Factura = new mdFacturaVentas(id, fecha, factura);
        agregarFacturaVentas(Factura);
    }

    private void agregarFacturaVentas(mdFacturaVentas facturaVenta) {
        FacturaVentasCRUD facturaVentasCRUD = new FacturaVentasCRUD();
        facturaVentasCRUD.agregarFacturaVentas(facturaVenta);
    }

}
