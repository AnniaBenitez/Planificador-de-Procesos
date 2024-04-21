package Utils;

/**
 *
 * @author Agustín Oviedo
 */
import java.util.List;
import Modelo.ModeloBCP;

public class Utils {
   
  // Obtener el tiempo total del grafico
   static public int obtenerTiempoTotal(List<ModeloBCP> procesos) {
    int tiempoTotal = 0;
    for (ModeloBCP proceso : procesos) {
        tiempoTotal += proceso.getRafaga();
    }
    return tiempoTotal;
   }

   // Crear matriz para representar el gráfico
   static public String[][] obtenerTiempoLlegadaTotal(List<ModeloBCP> procesos, int tiempoTotal) {
    String[][] grafico = new String[procesos.size()][tiempoTotal];
    for (String[] row : grafico) {
        for (int i = 0; i < row.length; i++) {
            row[i] = " 0 ";
        }
    }
    return grafico;
   }


   // Mostrar el gráfico
   static public void mostrarGrafico(String[][] grafico, List<ModeloBCP> p) {
    System.out.println("\nGráfico:");
    for (int i = 0; i < grafico.length; i++) {
        System.out.print("P" + p.get(i).getNombre() + ": ");
        for (String c : grafico[i]) {
            System.out.print(c);
        }
        System.out.println();
    }
   }

   //TODO: Funcion que ordene los procesos por tiempo de llegada
   
}