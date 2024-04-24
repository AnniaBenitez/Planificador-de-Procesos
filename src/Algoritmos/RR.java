package Algoritmos;

/**
 * Algoritmo RR
 *
 * @author Agustin Oviedo
 */
import Modelo.ModeloBCP;
import Utils.Utils;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import Modelo.Resultado;

// Clase para implementar el algoritmo FCFS
public class RR {

    public static Resultado ejecutar(List<ModeloBCP> procesos, int quantum) {

        int tiempoActual = 0;
        int totalTiempoRespuesta = 0;
        int totalTiempoEspera = 0;
        
        for(ModeloBCP proceso: procesos){
            System.out.println(proceso);
        }

        // Lista de Cola de procesos
        Queue<ModeloBCP> colaProcesos = new LinkedList<>();

        // Crear matriz para representar el gráfico
        int tiempoTotal = Utils.obtenerTiempoTotal(procesos);
        String grafico[][] = Utils.dibujarTablaProcesos(procesos, tiempoTotal);

        // Buscar el proceso más corto que esté listo para ejecutarse
        ModeloBCP currentProcess = null;

        while (tiempoActual < tiempoTotal) {

            // Buscar el proceso que esté listo para ejecutarse
            for (ModeloBCP proceso : procesos) {
                if (proceso.getTiempoLlegada() <= tiempoActual && proceso.getRafagasEjecutadas() != proceso.getRafaga() && !colaProcesos.contains(proceso)) {
                    colaProcesos.add(proceso);
                }
            }

            if (currentProcess == null) {

                currentProcess = colaProcesos.poll();
                int rafagasPorEjecutar = currentProcess.getRafaga() - currentProcess.getRafagasEjecutadas();
                int tiempoDeEjecucion = 0;

                if (currentProcess.getRafagasEjecutadas() == 0) {
                    totalTiempoRespuesta += tiempoActual - currentProcess.getTiempoLlegada() + 1;
                }

                if (rafagasPorEjecutar > quantum) {

                    currentProcess.setRafagasEjecutadas(currentProcess.getRafagasEjecutadas() + quantum);
                    tiempoDeEjecucion = quantum;
                    colaProcesos.add(currentProcess);

                } else {

                    currentProcess.setRafagasEjecutadas(currentProcess.getRafagasEjecutadas() + rafagasPorEjecutar);
                    tiempoDeEjecucion = rafagasPorEjecutar;

                }

                for (ModeloBCP p : procesos) {
                    for (int i = tiempoActual; i < tiempoActual + tiempoDeEjecucion; i++) {
                        if (p == currentProcess) {
                            grafico[procesos.indexOf(currentProcess)][i] = " 1 ";
                        } else if (p.getRafagasEjecutadas() < p.getRafaga() && p.getTiempoLlegada() <= i) {
                            grafico[procesos.indexOf(p)][i] = " W ";
                            totalTiempoEspera++;
                        }
                    }
                }

                currentProcess = null;
                tiempoActual += tiempoDeEjecucion;
            }

        }
        
        double promedioEspera = (double) totalTiempoEspera / procesos.size();
        double promedioRespuesta = (double) totalTiempoRespuesta / procesos.size();
        
        Resultado resultado = new Resultado(grafico, promedioEspera, promedioRespuesta);
        
        return resultado;
    }
}
