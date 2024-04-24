package Modelo;

/**
 *
 * @author Annia Benítez
 */
public class Resultado {
    // Campos (variables)
    public String[][] grafico;
    public double promedioEspera;
    public double promedioRespuesta;

    // Constructor (opcional)
    public Resultado(String[][] grafico, double promedioEspera, double promedioRespuesta) {
        this.grafico = grafico;
        this.promedioEspera = promedioEspera;
        this.promedioRespuesta = promedioRespuesta;
    }
}
