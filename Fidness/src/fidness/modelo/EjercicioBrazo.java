package fidness.modelo;

//Subclase de Ejercicio.
public class EjercicioBrazo extends Ejercicio {

    public EjercicioBrazo(int id, String nombre, String instrucciones, String urlVideo) {
        super(id, nombre, instrucciones, urlVideo);
    }

    @Override
    public String getTipo() {
        return "Brazo";
    }

    @Override
    public String getMusculosTrabajados() {
        return "Bíceps, tríceps y antebrazos";
    }
}
