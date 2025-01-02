package Modelo;

public class mdVentas {
    private int cantidadvendida;
    private String Obra;
    private double preciobase;
    private double preciovendidos;

    public mdVentas(int cantidadvendida, String Obra, double preciobase, double preciovendidos) {
        this.cantidadvendida = cantidadvendida;
        this.Obra = Obra;
        this.preciobase = preciobase;
        this.preciovendidos = preciovendidos;
    }

    public int getCantidadvendida() {
        return cantidadvendida;
    }

    public void setCantidadvendida(int cantidadvendida) {
        this.cantidadvendida = cantidadvendida;
    }

    public String getObra() {
        return Obra;
    }

    public double getPreciovendidos() {
        return preciovendidos;
    }

    public void setPreciovendidos(double preciovendidos) {
        this.preciovendidos = preciovendidos;
    }

    public double getPreciobase() {
        return preciobase;
    }
}
