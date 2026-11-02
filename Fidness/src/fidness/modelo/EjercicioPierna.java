package fidness.modelo;

// Subclase de Ejercicio.
public class EjercicioPierna extends Ejercicio {

    public EjercicioPierna(int id, String nombre, String instrucciones, String urlVideo) {
        super(id, nombre, instrucciones, urlVideo);
    }

    @Override
    public String getTipo() {
        return "Pierna";
    }

    @Override
    public String getMusculosTrabajados() {
        return "Cuádriceps, glúteos e isquiotibiales";
    }
}
