package Modelo;

public class mdFacturaVentas {

    private String fecha, factura;
    private int id, codigo;

    public mdFacturaVentas(int id, String fecha, String factura, int codigo) {
        this.id = id;
        this.fecha = fecha;
        this.factura = factura;
        this.codigo = codigo;
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
