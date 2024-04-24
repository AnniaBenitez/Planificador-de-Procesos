package Algoritmos;

import Modelo.ModeloBCP;
import Utils.Utils;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import Modelo.Resultado;

/**
 *
 * @author Agustin Oviedo
 */
public class HRRN {
    public static Resultado ejecutar(List<ModeloBCP> procesos) {

      int tiempoActual = 0;

      int totalTiempoRespuesta = 0;
      int totalTiempoEspera = 0;

      // Crear una lista para mantener los procesos que aún no han llegado
      HashMap<ModeloBCP, Integer> pendientes = new HashMap<ModeloBCP, Integer>();

      for(int i = 0; i < procesos.size(); i++){
        pendientes.put(procesos.get(i), (i));
      }

      // Crear matriz para representar el gráfico
      int tiempoTotal = Utils.obtenerTiempoTotal(procesos); 
      String grafico[][] = Utils.dibujarTablaProcesos(procesos, tiempoTotal);

      // Buscar el proceso más corto que esté listo para ejecutarse
      ModeloBCP procesoEjecutar = null;

      while (tiempoActual < tiempoTotal) {

        if(procesoEjecutar == null){
          List<ModeloBCP> pendientesListTemp = new ArrayList<>(pendientes.keySet());
          procesoEjecutar = Utils.calcularHRRN(pendientesListTemp, tiempoActual);
        }

        if(procesoEjecutar != null){

          procesoEjecutar.setRafagasEjecutadas(procesoEjecutar.getRafaga());

          for(int i=tiempoActual; i<tiempoActual + procesoEjecutar.getRafaga(); i++){
            // Ejecutar el proceso encontrado
            for(ModeloBCP process : pendientes.keySet()){
              if(process == procesoEjecutar){
                grafico[pendientes.get(process)][i] = " 1 ";
              }else if(process.getTiempoLlegada() <= tiempoActual && process.getRafaga() != process.getRafagasEjecutadas()){
                grafico[pendientes.get(process)][i] = " W ";
              }else{
                grafico[pendientes.get(process)][i] = " 0 ";
              }
            }
          }
          
          tiempoActual += procesoEjecutar.getRafaga();
        }
        totalTiempoEspera += tiempoActual - procesoEjecutar.getRafaga() - procesoEjecutar.getTiempoLlegada();
        totalTiempoRespuesta += tiempoActual - procesoEjecutar.getRafaga() + 1 - procesoEjecutar.getTiempoLlegada();
        pendientes.remove(procesoEjecutar); // Eliminar el proceso de la lista de pendientes
        procesoEjecutar = null;
      }

     
        double promedioEspera = (double) totalTiempoEspera / procesos.size();
        double promedioRespuesta = (double) totalTiempoRespuesta / procesos.size();

        Resultado resultado = new Resultado(grafico, promedioEspera, promedioRespuesta);

        return resultado;
    }
}
