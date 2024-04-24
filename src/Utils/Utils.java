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
   
   // Crear matriz para representar el gráfico
   static public String[][] dibujarTablaProcesos(List<ModeloBCP> procesos, int tiempoTotal) {
    String[][] grafico = new String[procesos.size()][tiempoTotal];
    for (String[] row : grafico) {
        for (int i = 0; i < row.length; i++) {
            row[i] = " 0 ";
        }
    }
    return grafico;
   }
 
   static public boolean reiniciarRafagasEjecutadas(List<ModeloBCP> procesos){
    for(ModeloBCP p : procesos){
        try{
            p.setRafagasEjecutadas(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    return true;
   }
   
   static public ModeloBCP calcularHRRN(List<ModeloBCP> procesos, int tiempoActual) {
    double bestHrrn = Double.MIN_VALUE;
    ModeloBCP processToReturn = null;

    for (ModeloBCP proceso : procesos) {
        if (proceso.getTiempoLlegada() <= tiempoActual && proceso.getRafaga() != proceso.getRafagasEjecutadas()) {
            int tiempoEspera = tiempoActual - proceso.getTiempoLlegada();
            double hrrn = (double) (proceso.getRafaga() + tiempoEspera) / proceso.getRafaga();
            if (hrrn > bestHrrn) {
                // System.out.println("El Proceso con mejor HRRN es: " + hrrn);
                bestHrrn = hrrn;
                processToReturn = proceso;
            }
        }
    }

    return processToReturn;
}
   
}