package fidness.modelo;

// Subclase de Ejercicio.
public class EjercicioEspalda extends Ejercicio {

    public EjercicioEspalda(int id, String nombre, String instrucciones, String urlVideo) {
        super(id, nombre, instrucciones, urlVideo);
    }

    @Override
    public String getTipo() {
        return "Espalda";
    }

    @Override
    public String getMusculosTrabajados() {
        return "Dorsales, trapecio y lumbares";
    }
}
