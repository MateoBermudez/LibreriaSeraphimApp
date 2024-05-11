package Modelo;

public class mdFacturaVentas {

    private String fecha, factura;
    private int id;

    public mdFacturaVentas(int id, String fecha, String factura) {
        this.id = id;
        this.fecha = fecha;
        this.factura = factura;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
