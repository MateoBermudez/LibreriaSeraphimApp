package Controlador;
import Modelo.InventarioCRUD;
import Modelo.InventarioTemporalCRUD;
import Modelo.mdInventario;
import javax.swing.JOptionPane;

public class CtrlLibreria {

    public static boolean CantidadLibros(String id, int cantidad){
        InventarioCRUD inventarioCRUD = new InventarioCRUD();
        boolean b = inventarioCRUD.validarCantidad(id, cantidad);
        int cantidadActual = inventarioCRUD.obtenerCantidad(id);

        if (!b) {
            JOptionPane.showMessageDialog(null, "No hay suficientes libros en inventario, solo hay " + cantidadActual + " disponibles.");
            return false;
        }
        return true;
    }

    public static void ActualizarInventarioTemporal(String id, int cantidad){
        InventarioTemporalCRUD inventarioCRUD = new InventarioTemporalCRUD();
        inventarioCRUD.actualizarCantidad(id, cantidad);
    }


}
