package Algoritmos;

import Modelo.ModeloBCP;
import Modelo.Resultado;
import Utils.Utils;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Agustin Oviedo
 */
public class SJFNoDesalojo {

    public static Resultado ejecutar(List<ModeloBCP> procesos) {

        int tiempoActual = 0;
        int totalTiempoRespuesta = 0;
        int totalTiempoEspera = 0;

        // Crear una lista para mantener los procesos que aún no han llegado
        HashMap<ModeloBCP, Integer> pendientes = new HashMap<ModeloBCP, Integer>();

        for (int i = 0; i < procesos.size(); i++) {
            pendientes.put(procesos.get(i), (i));
        }

        // Crear matriz para representar el gráfico
        int tiempoTotal = Utils.obtenerTiempoTotal(procesos);
        String grafico[][] = Utils.dibujarTablaProcesos(procesos, tiempoTotal);

        // Buscar el proceso más corto que esté listo para ejecutarse
        ModeloBCP procesoEjecutar = null;

        while (tiempoActual < tiempoTotal) {

            if (procesoEjecutar == null) {
                for (ModeloBCP proceso : pendientes.keySet()) {
                    if (proceso.getTiempoLlegada() <= tiempoActual && (procesoEjecutar == null || proceso.getRafaga() < procesoEjecutar.getRafaga())) {
                        procesoEjecutar = proceso;
                    }
                }
            }

            // Ejecutar el proceso encontrado
            for (ModeloBCP process : pendientes.keySet()) {
                if (process == procesoEjecutar) {
                    grafico[pendientes.get(process)][tiempoActual] = " 1 ";
                    procesoEjecutar.setRafagasEjecutadas(procesoEjecutar.getRafagasEjecutadas() + 1);
                } else if (process.getTiempoLlegada() <= tiempoActual && process.getRafaga() != process.getRafagasEjecutadas()) {
                    grafico[pendientes.get(process)][tiempoActual] = " W ";
                } else {
                    grafico[pendientes.get(process)][tiempoActual] = " 0 ";
                }
            }

            // Calcular tiempos de espera y respuesta
            if (procesoEjecutar.getRafagasEjecutadas() == procesoEjecutar.getRafaga()) {
                totalTiempoEspera += tiempoActual + 1 - procesoEjecutar.getTiempoLlegada() - procesoEjecutar.getRafagasEjecutadas();
                totalTiempoRespuesta += tiempoActual + 1 - procesoEjecutar.getTiempoLlegada() - (procesoEjecutar.getRafagasEjecutadas() - 1);
                pendientes.remove(procesoEjecutar); // Eliminar el proceso de la lista de pendientes
                procesoEjecutar = null;
            }

            tiempoActual++;
        }

        // Calcular promedios
        double promedioEspera = (double) totalTiempoEspera / procesos.size();
        double promedioRespuesta = (double)  totalTiempoRespuesta / procesos.size();

        Resultado resultado = new Resultado(grafico, promedioEspera, promedioRespuesta);

        return resultado;
    }
}
