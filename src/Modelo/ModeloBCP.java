package Modelo;

/**
 *
 * @author Agustin Oviedo
 */
public class ModeloBCP {

    private String nombre = null;
    private int tiempoLlegada = 0;
    private int rafaga = 0;
    private int prioridad = 0;
    private int estado = 0;

    public ModeloBCP(String nombre, int tiempoLlegada, int rafaga, int prioridad, int estado) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.rafaga = rafaga;
        this.prioridad = prioridad;
        this.estado = 0;
    }

    //Constructor para procesos que no tengan prioridad
    public ModeloBCP(String nombre, int tiempoLlegada, int rafaga) {
        this(nombre, tiempoLlegada, rafaga, 0, 0);
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getTiempoLlegada() {
        return this.tiempoLlegada;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }

    public int getRafaga() {
        return this.rafaga;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String toString() {
        return this.getNombre() + " | " + this.getTiempoLlegada() + " | " + this.getRafaga() + " | " + this.getPrioridad() + " | " + this.getEstado();
    }
}
